package cn.gyyx.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.gyyx.test.zhaozhu.beans.User;
import cn.gyyx.test.zhaozhu.dao.AccountDao;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/zzzz", method = RequestMethod.POST)
	public String home(@ModelAttribute User user,Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		/*Number num = new Number();
		logger.info("add :" + num.add(1, 2));*/
//		User user = new AccountDao().getUser("zhaozhu");
//		logger.info("select:" + new AccountDao().getUser("zhaozhu").getUserId());
		System.out.println(user.getName());
		model.addAttribute("account", user.getAccount() );
		model.addAttribute("password", user.getPassword() );
		model.addAttribute("seed", user.getSeed() );
		model.addAttribute("name", user.getName() );
		model.addAttribute("sex", user.getSex() );
		model.addAttribute("tel", user.getTel() );
		model.addAttribute("registerTime", user.getRegisterTime() );
		return "home";
	}
	
/************************test********************************/	
	
	//注解多个参数@RequestMapping(value="/test1",method=RequestMethod.post)
	//注解只有一个参数@RequestMapping("/test1")
	//return "";指定返回的位置比如 return "user/index.jsp" ，返回到user下的index.jsp页面
	
	/***接收参数的几种方法****/
	//http://localhost:8080/test/test1?name=zhaozhu
	@RequestMapping("/test1")
	public String test1(HttpServletRequest request){
		String name = request.getParameter("name");
		logger.info("test1 name:" + name);
		return "home";
	}
	
	//http://localhost:8080/test/test2?name=zhaozhu
	@RequestMapping("/test2")
	public String test1(String name){
		logger.info("test2 name:" + name);
		return "home";
	}
	
	//http://localhost:8080/test/test3?name=zhaozhu&sex=m&age=10
	@RequestMapping("/test3")
	public String test1(String name, String sex, Integer age){
		logger.info("test3 name:" + name + "sex:" + sex + "age:" + age);
		return "home";
	}
	
	/*参数用int与Integer的区别
	 * int时，参数不能为空，为空报错
	 * Integer时，参数可以为空，为空时后台显示null
	 * public String test1(String name, String sex,  age){
		logger.info("test3 name:" + name + "sex:" + sex + "age:" + age);
		return "home";
	}*/
	
	//http://localhost:8080/test/test4?name=zhaozhu&age=20&id=1
	@RequestMapping("/test4")
	public String test4(User user){
		logger.info("test4 user:" + user);
		return "home";
	}
	
	//http://localhost:8080/test/test5?name=zhaozhu&name=zhouzhongkai
	@RequestMapping("/test5")
	public String test5(String[] name){
		//这种情况需要判断name参数是否为空，否则会报错
		for(String tmp : name){
			logger.info("test5 name:" + tmp);
		}
		return "home";
	}
	
	//http://localhost:8080/test/test6?birthday=1991-11-7
	@RequestMapping("/test6")
	public String test6(Date birthday){
			logger.info("test6 birthday:" + birthday);
		return "home";
	}
	
	//InitBinder为初始化标签，initBinder为自定义日期格式方法，自定义在test6中使用的日期格式
	@InitBinder
	public void initBinder(ServletRequestDataBinder binder){
											  //new CustomDateEditor(dateFormat, allowEmpty)
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),true));
		                                        
	}
	
	//通过导入4个json包，向前端绑定数据
	//用json向前端绑定数据，与ajax在前端交互，向前台的ajax返回一个json串
	//这个页面要在浏览器里打开，不能用这里的VMserver
	@RequestMapping("/test7")
	@ResponseBody
	public User test7(){
		User user = new User();
		user.setTel("17");
		return user;
	}
	
	//response.setStatus(202);设定返回时的状态值
	//在360浏览器中，按F12，中的Network查看状态值
	@RequestMapping("/test8")
	@ResponseBody
	public User test8(HttpServletResponse response){
		User user = new User();
		user.setTel("17");
		//设定返回时的状态值
		response.setStatus(202);
		return user;
	}
	
	//ModelAndView方法向前台页面绑定数据，return new ModelAndView("home",map);方式
	@RequestMapping("/test9")
	public ModelAndView test9(){
		User user = new User();
		user.setTel("17");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("u", user);
		return new ModelAndView("home",map);
	}
	//map方法向前台页面绑定数据，map.put方式,return "home";
	@RequestMapping("/test10")
	public String test10(Map<String, Object> map){
		User user = new User();
		user.setTel("17");
		map.put("u", user);
		return "home";
	}
	//Attibute方法向前台页面绑定数据，model.Attibute方式,return "home";
	@RequestMapping("/test11")
	public String test11(Model model){
		User user = new User();
		user.setTel("17");
		User user2 = new User();
		user2.setTel("99");
		model.addAttribute("u", user);
		model.addAttribute("u2", user2);
		return "home";
	}
	
	//页面跳转：绝对URL
	@RequestMapping("/test12")
	public String test12(){
		return "redirect:http://www.baidu.com";
	}
	
	//http://localhost:8080/test/test6
	//页面跳转：本Controller内方法
	@RequestMapping("/test13")
	public String test13(){
		return "redirect:test5";
	}
	
	//页面跳转：其他Controller内方法
	/*@RequestMapping("/test14")
	public String test14(){
		return "redirect:test13";
	}*/
	
	@RequestMapping("/register")
	public String register(){
		return "register";
	}
	
/************************test********************************/		
}
