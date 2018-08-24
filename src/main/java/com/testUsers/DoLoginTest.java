package com.testUsers;

import com.dao.impl.UsersDaoImpl;

public class DoLoginTest {

	public static void main(String[] args) {
		UsersDaoImpl udao = new UsersDaoImpl();
		boolean flag = udao.doLogin("admin", "admin");
		System.out.println(flag?"登录成功！！！":"登录失败！！！");
	}

}
