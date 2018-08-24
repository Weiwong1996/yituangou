package com.testAddress;

import com.dao.AddressDao;
import com.dao.UsersDao;
import com.dao.impl.AddressDaoImpl;
import com.dao.impl.UsersDaoImpl;

public class DeleteUsersTest {

	public static void main(String[] args) {
		AddressDao adao = new AddressDaoImpl();
		boolean flag=adao.deleteAddress(1);
		System.out.println(flag?"删除成功！！！":"删除失败！！！");
	}

}
