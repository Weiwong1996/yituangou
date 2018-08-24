package com.testUsers;

import com.dao.UsersDao;
import com.dao.impl.UsersDaoImpl;

public class DeleteUsersTest {

	public static void main(String[] args) {
		UsersDao udao = new UsersDaoImpl();
		boolean flag=udao.deleteUsers(2);
		System.out.println(flag?"删除成功！！！":"删除失败！！！");
	}

}
