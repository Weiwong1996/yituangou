package com.testUsers;

import com.dao.UsersDao;
import com.dao.impl.UsersDaoImpl;
import com.entity.Users;

public class AddUsersTest {

	public static void main(String[] args) {
		UsersDao udao = new UsersDaoImpl();
		Users users = new Users("asd", "dsada", "dasd", "dsad", "dasd");
		boolean flag = udao.addUsers(users);
		System.out.println(flag?"添加成功！！！":"添加失败！！！");
	}

}
