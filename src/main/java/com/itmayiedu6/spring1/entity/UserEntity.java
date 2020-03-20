package com.itmayiedu6.spring1.entity;


/**
 * 
 * @classDesc: 功能描述:(用户实体类)
 * @author: 余胜军
 * @createTime: 2017年8月25日 下午10:21:08
 * @version: v1.0
 * @copyright:上海每特教育科技有限公司
 */
public class UserEntity {
	private String userId;
	private String userName;
	public UserEntity(){
		System.out.println("使用反射技术 ，执行无参数构造 函数");
	}
	public UserEntity(String userId) {
	  System.out.println("使用反射技术 执行 有参构造函数 userId:"+userId);
	}

	public String getUserId() {

		return userId;
	}

	public void setUserId(String userId) {

		this.userId = userId;
	}

	public String getUserName() {

		return userName;
	}

	public void setUserName(String userName) {

		this.userName = userName;
	}

}
