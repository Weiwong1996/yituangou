package com.dao;
/**
 * 订单接口类
 * @author Administrator
 *
 */

import java.util.List;

import com.entity.GoodsAndOrders;
import com.entity.Orders;

public interface OrdersDao {
	/**
	 * 查询所有的订单
	 * @return 订单的数据
	 */
	public List<Orders> getAll();
	/**
	 * 删除订单
	 * @param oid 所要删除的订单编号
	 * @return	
	 */
	public boolean deleteOrder(int oid);
	/**
	 * 按姓名查找订单
	 * @param uname
	 * @return 订单集合
	 */
	public List<Orders> getByUname(String uname);
	/**
	 * 添加订单
	 * @param orders 所添加的订单
	 * @return true 添加成功  false 添加失败
	 */
	public boolean addOrder(GoodsAndOrders gAndO,int uid);
}
