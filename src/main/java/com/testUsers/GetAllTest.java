package com.testUsers;

import java.util.ArrayList;
import java.util.List;

import com.dao.UsersDao;
import com.dao.impl.UsersDaoImpl;
import com.entity.Users;

public class GetAllTest {

	public static void main(String[] args) {
		UsersDao udao = new UsersDaoImpl();
		List<Users> ulist = new ArrayList<>();
		ulist = udao.getAll();
		for(Users users : ulist) {
			System.out.println(users);
		}
	}

}
