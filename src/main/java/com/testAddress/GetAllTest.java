package com.testAddress;

import java.util.ArrayList;
import java.util.List;

import com.dao.AddressDao;
import com.dao.UsersDao;
import com.dao.impl.AddressDaoImpl;
import com.dao.impl.UsersDaoImpl;
import com.entity.Address;
import com.entity.Users;

public class GetAllTest {

	public static void main(String[] args) {
		AddressDao adao=new AddressDaoImpl();
		List<Address> alist = new ArrayList<>();
		alist = adao.getAll();
		for(Address a : alist) {
			System.out.println(a);
		}
	}

}
