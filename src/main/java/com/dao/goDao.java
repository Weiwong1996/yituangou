package com.dao;

import java.util.List;


import com.entity.GoodsAndOrders;

public interface goDao {
	/**
	 * 查询所有的商品
	 * @return 商品的数据
	 */
	public List<GoodsAndOrders> getAllByUid(int uid);
}
