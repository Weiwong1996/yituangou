package com.testUsers;

import com.dao.UsersDao;
import com.dao.impl.UsersDaoImpl;
import com.entity.Users;

public class GetByUidTest {
	public static void main(String[] args) {
		UsersDao udao = new UsersDaoImpl();
		Users users = udao.GetUidByUname("程力东");
			System.out.println(users);		
	}
}
