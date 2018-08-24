package com.dao.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AddressDao;
import com.dao.impl.AddressDaoImpl;
import com.dao.impl.GoodsDaoImpl;
import com.dao.impl.OrdersDaoImpl;
import com.dao.impl.UsersDaoImpl;
import com.dao.impl.goDaoImpl;
import com.entity.Address;
import com.entity.Goods;
import com.entity.GoodsAndOrders;
import com.entity.Orders;
import com.entity.Users;

/**
 * Servlet implementation class UsersServlet
 */
@WebServlet("/UsersServlet")
public class UsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		UsersDaoImpl udao = new UsersDaoImpl();
		GoodsDaoImpl gdao=new GoodsDaoImpl();
		OrdersDaoImpl odao=new OrdersDaoImpl();
		goDaoImpl godao=new goDaoImpl();
		AddressDaoImpl adao=new AddressDaoImpl();
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String op = request.getParameter("op");
		UsersDaoImpl udi=new UsersDaoImpl();
	     if(op.equals("login")) {
			String uname=request.getParameter("uname");
			String upwd=request.getParameter("upwd");
			Users user=udao.GetUidByUname(uname);
		    int uid = user.getUid();
			session.setAttribute("uname", uname);
			session.setAttribute("uid", uid);
			boolean flag=udi.doLogin(uname, upwd);
			if(flag) {
				if(uname.equals("admin")) {
					response.getWriter().print("<script>alert('登陆成功!');location='nav.jsp';</script>");
				}else {
					response.getWriter().print("<script>alert('登陆成功!');location='IndexServlet?op=allGoods2';</script>");
				}
				
			}else {
				response.getWriter().print("<script>alert('登陆失败!');location='login.jsp';</script>");
			}
			
		}else if(op.equals("signUp")){
			String uname=request.getParameter("username");
			String upwd = request.getParameter("userpwd");
			String urealname = request.getParameter("userrealname");
			String useridentity = request.getParameter("useridentity");
			String userphone = request.getParameter("userphone");
			Users user = new Users(uname, upwd, urealname, useridentity, userphone);
			boolean flag = udao.addUsers(user);
			if (flag) {
				response.getWriter().print("<script>alert('注册成功!');location='index.jsp';</script>");
			} else {
				response.getWriter().print("<script>alert('注册失败!');location='index.jsp';</script>");
			}
		} else if (op.equals("myOder")) {
			int uid = Integer.parseInt(request.getParameter("uid"));
			List<GoodsAndOrders> golist = godao.getAllByUid(uid);
			List<Address> alist=adao.getAddressByUid(uid);
			request.setAttribute("golist", golist);
			request.setAttribute("alist", alist);
			request.getRequestDispatcher("myOrder.jsp").forward(request, response);
		} else if (op.equals("delete")) {
			int uid = Integer.valueOf(request.getParameter("uid"));
			System.out.println(uid);
			boolean flag = udao.deleteUsers(uid);

			if (flag) {
				response.getWriter().print("<script>alert('成功删除');location='userList.jsp';</script>");
			} else
				response.getWriter().print("<script>alert('删除失败');location='userList.jsp';</script>");
		} else if (op.equals("edit")) {
			int uid = Integer.parseInt(request.getParameter("uid"));
			request.setAttribute("uid", uid);
			request.getRequestDispatcher("edit.jsp").forward(request, response);
		} else if (op.equals("doedit")) {
			int uid = Integer.parseInt(request.getParameter("uid"));
			String upwd = request.getParameter("upwd");
			String uphone = request.getParameter("uphone");
			Users user = new Users(upwd, uphone, uid);
			boolean flag = udao.editUsers(user);
			if (flag) {
				response.getWriter()
						.print("<script>alert('修改成功');location='UsersServlet?op=myOder&uid=" + uid + "';</script>");
			} else
				response.getWriter()
						.print("<script>alert('修改失败');location='UsersServlet?op=myOder&uid=" + uid + "';</script>");

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
