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
import com.dao.impl.UsersDaoImpl;
import com.entity.Users;
import com.google.gson.Gson;

/**
 * 注解WebServlet用来描述一个Servlet<br/>
 * 属性name描述Servlet的名字,可选<br/>
 * 属性initParams 描述Servlet的init参数,可选<br/>
 * 属性urlPatterns定义访问的URL,或者使用属性value定义访问的URL.(定义访问的URL是必选属性)<br/>
 */
@WebServlet(name = "getAllUsersServlet", urlPatterns = "/getAllUsersServlet", initParams = {
		@WebInitParam(name = "xxx", value = "xx") })
public class getAllUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsersDaoImpl uDao = new UsersDaoImpl();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public getAllUsersServlet() {
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
	
		String op = request.getParameter("op");
		if(op.equals("all")){
			List<Users> ulist = uDao.getAll();
			//將集合轉換爲Json字符串
			Gson gson = new Gson();
			String userlist = gson.toJson(ulist);	
			out.print(userlist);
			//按ID查询的代码
		}else if(op.equals("sb_ID")) {
			//从jsp界面得到值传递给uid
			int uid =Integer.valueOf(request.getParameter("for_id"));
			Users user = uDao.getUserByUid(uid);
			Gson gson = new Gson();
			String user1 = gson.toJson(user);	
			//输出查询到的对象
			out.print(user1);
		}
		

		out.flush();// 将流刷新
		out.close();// 将流关闭
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
