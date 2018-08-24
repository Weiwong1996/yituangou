package com.testAddress;

import com.dao.AddressDao;
import com.dao.UsersDao;
import com.dao.impl.AddressDaoImpl;
import com.dao.impl.UsersDaoImpl;
import com.entity.Address;
import com.entity.Users;

public class AddUsersTest {

	public static void main(String[] args) {
		AddressDao adao=new AddressDaoImpl();
		Address address=new Address("dadasda", "aname", "userphone", "aidentify", "amail");
		boolean flag = adao.addAddress(address);
		System.out.println(flag?"添加成功！！！":"添加失败！！！");
	}

}
