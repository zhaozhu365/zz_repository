/*------------------------------------------------------------------------- 
* 版权所有：北京光宇在线科技有限责任公司 
* 作者：zhaozhu 
* 联系方式：zhaozhu@gyyx.cn 
* 创建时间： 2014年11月17日 下午8:55:07 
* 版本号：v1.0 
* 本类主要用途描述： 
* 
-------------------------------------------------------------------------*/ 

package cn.gyyx.test.zhaozhu.beans;

/**
 * 用户实体类
 * @author Administrator
 *
 */
public class User {
	private int userId;
	private String account;
	private String password;
	private String seed;
	private String name;
	private String sex;
	private String tel;
	private String registerTime;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int userId, String account, String password, String seed,
			String name, String sex, String tel, String registerTime) {
		super();
		this.userId = userId;
		this.account = account;
		this.password = password;
		this.seed = seed;
		this.name = name;
		this.sex = sex;
		this.tel = tel;
		this.registerTime = registerTime;
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSeed() {
		return seed;
	}
	public void setSeed(String seed) {
		this.seed = seed;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", account=" + account
				+ ", password=" + password + ", seed=" + seed + ", name="
				+ name + ", sex=" + sex + ", tel=" + tel + ", registerTime="
				+ registerTime + "]";
	}
	

}
	