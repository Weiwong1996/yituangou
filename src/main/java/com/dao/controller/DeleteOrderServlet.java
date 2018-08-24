package com.dao.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.OrdersDao;
import com.dao.impl.OrdersDaoImpl;

/**
 * Servlet implementation class DeleteOrderServlet
 */
public class DeleteOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private OrdersDao odao=new OrdersDaoImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 获取数据字符串格式设置
		request.setCharacterEncoding("utf-8");
		// 服务器端响应编码格式设置
		response.setContentType("text/html;charset=utf-8");
		// 获得打印输出流 用于响应数据到客户端
		PrintWriter out = response.getWriter();
		// 获取HttpSession对象
		HttpSession session = request.getSession();
		System.out.println("----------------------------------ss");
		String op = request.getParameter("op");
		if(op.equals("delete")) {
			int uid=Integer.parseInt(request.getParameter("uid"));
			int oid=Integer.parseInt(request.getParameter("oid"));
			boolean flag=odao.deleteOrder(oid);
			if (flag){
				response.getWriter().print("<script>alert('删除成功!');location='UsersServlet?op=myOder&uid="+uid+"';</script>");
			}else {
				response.getWriter().print("<script>alert('删除失败!');location='UsersServlet?op=myOder&uid="+uid+"';</script>");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
