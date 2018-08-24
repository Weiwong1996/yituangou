package com.testGoods;

import java.util.List;

import com.dao.GoodsDao;
import com.dao.impl.GoodsDaoImpl;
import com.entity.Goods;

public class GetAllTest {

	public static void main(String[] args) {
		GoodsDao gdao = new GoodsDaoImpl();
		List<Goods> glist = gdao.getAll();
		for(Goods goods:glist) {
			System.out.println(goods);
		}
	}

}
