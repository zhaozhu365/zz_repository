/*------------------------------------------------------------------------- 
* 版权所有：北京光宇在线科技有限责任公司 
* 作者：zhaozhu 
* 联系方式：zhaozhu@gyyx.cn 
* 创建时间： 2014年11月17日 下午9:01:21 
* 版本号：v1.0 
* 本类主要用途描述： 
* 
-------------------------------------------------------------------------*/ 

package cn.gyyx.test.zhaozhu.dao;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisConnectionFactory {
	private static SqlSessionFactory sqlAccountSessionFactory;
	static {
		try {
			//xxxxMapper.xml配置文件路径
			String resource = "mybatis/config.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			if (sqlAccountSessionFactory == null) {
				sqlAccountSessionFactory = new SqlSessionFactoryBuilder()
						.build(reader, "account");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}
	/**
	 * 获取数据库工厂实例
	 * @return 工厂实例
	 */
	public static SqlSessionFactory getSqlAccountSessionFactory(){
		return sqlAccountSessionFactory;
	}
}
