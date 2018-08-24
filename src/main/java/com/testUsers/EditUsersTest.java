package com.testUsers;

import com.dao.UsersDao;
import com.dao.impl.UsersDaoImpl;
import com.entity.Users;

public class EditUsersTest {

	public static void main(String[] args) {
		UsersDao udao=new UsersDaoImpl();
		Users users=new Users(3,"556s","sasad","sadas","dasda","dasdas");
		boolean flag=udao.editUsers(users);
		System.out.println(flag?"编辑成功！！！":"编辑失败！！！");
	}

}
