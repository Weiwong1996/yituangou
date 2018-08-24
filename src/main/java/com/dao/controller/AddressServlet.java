package com.dao.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AddressDao;
import com.dao.impl.AddressDaoImpl;
import com.entity.Address;

/**
 * Servlet implementation class AddressServlet
 */
public class AddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private AddressDao adao=new AddressDaoImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddressServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取数据字符串格式设置
		request.setCharacterEncoding("utf-8");
		// 服务器端响应编码格式设置
		response.setContentType("text/html;charset=utf-8");
		// 获得打印输出流 用于响应数据到客户端
		PrintWriter out = response.getWriter();
		// 获取HttpSession对象
		HttpSession session = request.getSession();
		String op = request.getParameter("op");
		if (op.equals("add")) {
			int uid=Integer.parseInt(request.getParameter("uid"));
			String aname=request.getParameter("aname");
			String aidentify=request.getParameter("aidentify");
			String amail=request.getParameter("amail");
			String userphone=request.getParameter("aphone");
			String aaddress=request.getParameter("aaddress");
			Address address=new Address(aaddress, aname, userphone, aidentify, amail,uid);
			boolean flag=adao.addAddress(address);
			System.out.println(flag);
			if(flag) {
				response.getWriter().print("<script>alert('地址保存成功!');location='AddressServlet?op=DoAddress&uid="+uid+"';</script>");
			}else {
				response.getWriter().print("<script>alert('保存失败!');location='AddressServlet?op=DoAddress&uid="+uid+"';</script>");
			}
		}else if(op.equals("DoAddress")) {
			int uid=Integer.parseInt(request.getParameter("uid"));
			List<Address> alist=adao.getAddressByUid(uid);
			request.setAttribute("alist", alist);
			request.getRequestDispatcher("address.jsp").forward(request, response);
		}else if(op.equals("delete")) {
			int aid=Integer.parseInt(request.getParameter("aid"));
			int uid=Integer.parseInt(request.getParameter("uid"));
			boolean flag=adao.deleteAddress(aid);
			if(flag) {
				response.getWriter().print("<script>alert('删除成功!');location='AddressServlet?op=DoAddress&uid="+uid+"';</script>");
			}else {
				response.getWriter().print("<script>alert('删除失败!');location='AddressServlet?op=DoAddress&uid="+uid+"';</script>");
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
