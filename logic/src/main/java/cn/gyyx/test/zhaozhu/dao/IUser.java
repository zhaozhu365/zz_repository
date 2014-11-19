/*------------------------------------------------------------------------- 
* 版权所有：北京光宇在线科技有限责任公司 
* 作者：zhaozhu 
* 联系方式：zhaozhu@gyyx.cn 
* 创建时间： 2014年11月17日 下午8:58:38 
* 版本号：v1.0 
* 本类主要用途描述： 
* 
-------------------------------------------------------------------------*/ 

package cn.gyyx.test.zhaozhu.dao;

import java.util.List;

import cn.gyyx.test.zhaozhu.beans.User;

public interface IUser {
	/**
	 * 根据用户账号查询用户信息
	 * @param account
	 * @return
	 */
	//根据账户查询用户信息
	public User selectByAccount(String account);
	//注册用户
	public int add(User user);
	//删除
	public int deleteById(int userId);
	//更新
	public int update(User user);
	//列表
	public List<User> selectAllUser();

}
