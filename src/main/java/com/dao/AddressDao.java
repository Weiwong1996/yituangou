package com.dao;

import java.util.List;

import com.entity.Address;

/**
 * 地址接口类
 * @author Administrator
 *
 */
public interface AddressDao {
	/**
	 * 添加地址
	 * @param address 所添加的地址
	 * @return	true 添加成功  false 添加失败
	 */
	public boolean addAddress(Address address);
	/**
	 * 修改地址
	 * @param address 所修改的地址
	 * @return true 修改成功  false 修改失败 
	 */
	public boolean aditAddress(Address address);
	/**
	 * 查询所有地址
	 * @return 所有地址信息
	 */
	public List<Address> getAll();
	/**
	 * 删除某条地址
	 * @param aid 所要删除的地址编号
	 * @return true 删除成功  false 删除失败
	 */
	public boolean deleteAddress(int aid);
	/**
	 * 根据uid查询所有地址
	 * @return 所有地址信息
	 */
	public List<Address> getAddressByUid(int uid);
	
}
