package cn.gyyx.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import cn.gyyx.core.utility.MD5;
import cn.gyyx.test.zhaozhu.beans.User;
import cn.gyyx.test.zhaozhu.dao.IUser;

public class TestDate {
	
	//日期格式测试
	@Test
	public void testDate(){
		String date = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date());  
		System.out.println(date);
	}
	
	//将long型数据转成String类型数据
	@Test
	public void testSeed(){
		//注意如何将long型数据转成String类型数据
		//用Long.toString(val);
		String time = Long.toString(new Date().getTime());
		String seed = time.substring(time.length()-4);
		System.out.println(seed);
	}
	
	//MD5测试
	@Test
	public void testMD5(){
		String password = "zhaozhu";
		//password = MD5.encode(password);
		System.out.println(MD5.encode(password));
		
	}
	
	
}
