/*------------------------------------------------------------------------- 
* 版权所有：北京光宇在线科技有限责任公司 
* 作者：zhaozhu 
* 联系方式：zhaozhu@gyyx.cn 
* 创建时间： 2014年11月17日 下午9:00:02 
* 版本号：v1.0 
* 本类主要用途描述： 
* 
-------------------------------------------------------------------------*/ 

package cn.gyyx.test.zhaozhu.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cn.gyyx.test.zhaozhu.beans.User;

public class AccountDao {
	
	private SqlSessionFactory sqlSessionFactory;
	
	public AccountDao() {
		sqlSessionFactory = MyBatisConnectionFactory.getSqlAccountSessionFactory();
	}
	/**
	 * 使用账号查询用户数据
	 * @param account
	 * @return UserInfo
	 */
	public User getUser(String account) {
		SqlSession session = sqlSessionFactory.openSession();
		//session.getConfiguration().addMapper(IUser.class);
		try {
			IUser userDao = session.getMapper(IUser.class);
			return userDao.selectByAccount(account);
		} finally {
			session.close();
		}
	}	
	
	public int addUser(User user) {
		SqlSession session = sqlSessionFactory.openSession();
		//session.getConfiguration().addMapper(IUser.class);
		try {
			IUser userDao = session.getMapper(IUser.class);
			return userDao.add(user);
		} finally {
			//插入数据后要提交事务；或者将sqlSessionFactory.openSession(true);设置为ture，表示自动提交
			session.commit();
			session.close();
		}
	}
	
	public List<User> getAllUser(){
		SqlSession session = sqlSessionFactory.openSession();
		try{
			IUser userDao = session.getMapper(IUser.class);
			//测试取值知否成功
			//System.out.println(userDao.selectAllUser());
			return userDao.selectAllUser();
		}finally{
			session.close();
		}
	}
	
	
	
	
}
