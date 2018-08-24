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
import javax.servlet.http.HttpSession;

import com.dao.impl.OrdersDaoImpl;
import com.entity.Orders;
import com.google.gson.Gson;

/**
 * 注解WebServlet用来描述一个Servlet<br/>
 * 属性name描述Servlet的名字,可选<br/>
 * 属性initParams 描述Servlet的init参数,可选<br/>
 * 属性urlPatterns定义访问的URL,或者使用属性value定义访问的URL.(定义访问的URL是必选属性)<br/>
 */
@WebServlet(name = "getAllOrdersServlet", urlPatterns = "/getAllOrdersServlet", initParams = {
		@WebInitParam(name = "xxx", value = "xx") })
public class getAllOrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrdersDaoImpl oDao = new OrdersDaoImpl();
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public getAllOrdersServlet() {
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
		//获取HttpSession对象
		HttpSession session = request.getSession();
		
		String op = request.getParameter("op");
		
		if(op.equals("all")){
		List<Orders> olist =oDao.getAll();
		Gson gson = new Gson();
		String orderlist = gson.toJson(olist);
		out.println(orderlist);
		}else if(op.equals("uname")) {
			String uname = request.getParameter("uname");
			List<Orders> olist1 =oDao.getByUname(uname);
			Gson gson = new Gson();
			String orderlist1 = gson.toJson(olist1);
			out.println(orderlist1);
		}else if(op.equals("delete")) {
			int oid = Integer.valueOf(request.getParameter("oid"));
			boolean flag = oDao.deleteOrder(oid);
			if(flag) {
				response.getWriter().print("<script>alert('成功删除');location='orderlist.jsp';</script>");
			}else
				response.getWriter().print("<script>alert('删除失败');location='orderlist.jsp';</script>");			
		}
		
		out.flush();// 将流刷新
		out.close();// 将流关闭
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}