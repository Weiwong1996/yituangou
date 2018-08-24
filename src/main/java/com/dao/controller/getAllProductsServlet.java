package com.dao.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.impl.GoodsDaoImpl;
import com.entity.Goods;
import com.google.gson.Gson;

/**
 * 注解WebServlet用来描述一个Servlet<br/>
 * 属性name描述Servlet的名字,可选<br/>
 * 属性initParams 描述Servlet的init参数,可选<br/>
 * 属性urlPatterns定义访问的URL,或者使用属性value定义访问的URL.(定义访问的URL是必选属性)<br/>
 */
@WebServlet(name = "getAllProductsServlet", urlPatterns = "/getAllProductsServlet", initParams = {
		@WebInitParam(name = "xxx", value = "xx") })
public class getAllProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GoodsDaoImpl gDao = new GoodsDaoImpl();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public getAllProductsServlet() {
		super();
	}

	/**
	 * 初始化方法
	 */
	public void init() throws ServletException {

		super.init();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取数据字符串格式设置
		request.setCharacterEncoding("utf-8");
		// 服务器端响应编码格式设置
		response.setContentType("text/html;charset=utf-8");
		//获得打印输出流  用于响应数据到客户端
		PrintWriter out = response.getWriter();
		
		//查询所有的商品
		String op = request.getParameter("op");
		if(op.equals("all")){
		List<Goods> glist = gDao.getAll();
		//将得到的List转为Json格式
		Gson gson = new Gson();
		String productList = gson.toJson(glist);
		out.print(productList);
		//通过brand查询
		}else if(op.equals("brand")) {
			String gbrand = request.getParameter("for_brand");
			List<Goods> blist = gDao.getByGbrand(gbrand);
			
			Gson gson = new Gson();
			String brandlist = gson.toJson(blist);
			out.print(brandlist);
		}else if(op.equals("delete")){
			int gid = Integer.valueOf(request.getParameter("gid"));		
			boolean flag = gDao.dodelete(gid);
			
			if(flag) {
				response.getWriter().print("<script>alert('成功删除');location='goodsList.jsp';</script>");
			}else
				response.getWriter().print("<script>alert('删除失败');location='goodsList.jsp';</script>");
	
		}
		
		
		out.flush();// 将流刷新
		out.close();// 将流关闭
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
