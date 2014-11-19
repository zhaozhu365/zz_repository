package cn.gyyx.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.gyyx.core.utility.MD5;
import cn.gyyx.test.zhaozhu.beans.User;
import cn.gyyx.test.zhaozhu.dao.AccountDao;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	//注册处理
	@RequestMapping("/register")
	public String register(@ModelAttribute User user){
		//添加seed
		String time = Long.toString(new Date().getTime());
		String seed = time.substring(time.length()-4);
		user.setSeed(seed);
		//MD5加密---password+seed
		String password = user.getPassword() + seed;
		password = MD5.encode(password);
		user.setPassword(password);
		//添加注册日期
		String date = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()); 
		user.setRegisterTime(date);
		//测试，
		//logger.info(user.getAccount() + "&" + user.getRegisterTime());
		int result = new AccountDao().addUser(user);
		//测试，
		//System.out.println(result);
		if(result == 1){
			return "register_success";
			//return "success/register_success";表示success下的register_success页面
			//return "redirect：register_success"；表示重定向到register_success页面
		}else{
			return "register";
		}
	}
	
	//登录页面
	@RequestMapping("/login")
	public String login(String account,String password){
		//测试
		//System.out.println("1--"+password);
		//System.out.println("2--"+new AccountDao().getUser(account).getPassword());
		//登录账户密码匹配验证
		User user = new AccountDao().getUser(account);
		String seed = user.getSeed();
		String passwordMD5 = user.getPassword();
		password = MD5.encode(password + seed);
		//测试MD5密码
		//System.out.println(password);
		//System.out.println(passwordMD5);
		if(password.equals(passwordMD5)){
			return "login_success";
		}else{
			return "login_failure";
		}
	}
	
	//显示用户列表
	@RequestMapping("/allUser")
	public String allUser(Model model){
		model.addAttribute("userList",new AccountDao().getAllUser());
		return "all_user";
	}
	
	
}
