package com.dao.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.GoodsDao;
import com.dao.OrdersDao;
import com.dao.impl.AddressDaoImpl;
import com.dao.impl.GoodsDaoImpl;
import com.dao.impl.OrdersDaoImpl;
import com.entity.Address;
import com.entity.Goods;
import com.entity.GoodsAndOrders;

/**
 * 注解WebServlet用来描述一个Servlet<br/>
 * 属性name描述Servlet的名字,可选<br/>
 * 属性initParams 描述Servlet的init参数,可选<br/>
 * 属性urlPatterns定义访问的URL,或者使用属性value定义访问的URL.(定义访问的URL是必选属性)<br/>
 */
@WebServlet(name = "IndexServlet", urlPatterns = "/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GoodsDao gd=new GoodsDaoImpl();
	private List<Goods> glist = new ArrayList<>();
	private String column = null;
	private String gtype = null;
	private AddressDaoImpl adao=new AddressDaoImpl();
	private OrdersDao odao = new OrdersDaoImpl();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IndexServlet() {
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
		// 获取数据字符串格式设置
		request.setCharacterEncoding("utf-8");
		// 服务器端响应编码格式设置
		response.setContentType("text/html;charset=utf-8");
		// 获得打印输出流 用于响应数据到客户端
		PrintWriter out = response.getWriter();
		// 获取HttpSession对象
		HttpSession session = request.getSession();

		String op = request.getParameter("op");
		if (op.equals("allGoods")) {
			column = "gid";
			session.setAttribute("op", "allGoods");		
			session.setAttribute("gtype"," ");
			index(request, response,6,column);
			request.getRequestDispatcher("index.jsp").forward(request, response);
			//allGoods(request, response);
		}else if (op.equals("allGoods2")) {
			column = "gid";
			session.setAttribute("op", "allGoods2");		
			session.setAttribute("gtype"," ");
			index(request, response,6,column);
			request.getRequestDispatcher("index2.jsp").forward(request, response);
			//allGoods(request, response);
		}else if(op.equals("byType")) {
			String gtype = request.getParameter("type");
			session.setAttribute("gtype", gtype);
			glist = gd.getByGtype(gtype);
			session.setAttribute("glist", glist);
			response.sendRedirect("index.jsp");
		}else if(op.equals("byBrand")) {
			gtype = request.getParameter("type");
			String gbrand = request.getParameter("brand");
			if(!gtype.equals(" ")) {
				glist = gd.getByTypeAndBrand(gtype, gbrand);
			}else {		
				glist = gd.getByGbrand(gbrand);
			}
			session.setAttribute("glist", glist);
			response.sendRedirect("index.jsp");
		}else if(op.equals("byType2")) {
			String gtype = request.getParameter("type");
			session.setAttribute("gtype", gtype);
			glist = gd.getByGtype(gtype);
			session.setAttribute("glist", glist);
			response.sendRedirect("index2.jsp");
		}else if(op.equals("byBrand2")) {
			gtype = request.getParameter("type");
			String gbrand = request.getParameter("brand");
			if(!gtype.equals(" ")) {
				glist = gd.getByTypeAndBrand(gtype, gbrand);
			}else {		
				glist = gd.getByGbrand(gbrand);
			}
			session.setAttribute("glist", glist);
			response.sendRedirect("index2.jsp");
		}else if (op.equals("price")) {
			column = "gnowprice";
			session.setAttribute("op", "price");
			index(request, response,6,column);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else if (op.equals("discount")) {
			column = "gdiscount";
			session.setAttribute("op", "discount");
			index(request, response,6,column);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else if (op.equals("price2")) {
			column = "gnowprice";
			session.setAttribute("op", "price2");
			index(request, response,6,column);
			request.getRequestDispatcher("index2.jsp").forward(request, response);
		}else if (op.equals("discount2")) {
			column = "gdiscount";
			session.setAttribute("op", "discount2");
			index(request, response,6,column);
			request.getRequestDispatcher("index2.jsp").forward(request, response);
		}else if(op.equals("buy")) {
			String gpic =request.getParameter("gpic");
			session.setAttribute("gpic", gpic);
			session.setAttribute("gpic1", gpic.replaceAll(".jpg", "1.png"));
			session.setAttribute("gpic2", gpic.replaceAll(".jpg", "2.png"));
			response.sendRedirect("goodSingle.jsp");
		}
		else if(op.equals("buy2")) {
			int uid = Integer.parseInt(request.getParameter("uid"));
			int gid = Integer.parseInt(request.getParameter("gid"));
			String gname = request.getParameter("gname");
			String gprice = request.getParameter("gprice");
			String gbrand = request.getParameter("gbrand");
			List<Address> alist=adao.getAddressByUid(uid);
			String gpic =request.getParameter("gpic");
			session.setAttribute("gname", gname);
			session.setAttribute("gid", gid);
			session.setAttribute("gprice", gprice);
			session.setAttribute("gbrand", gbrand);
			session.setAttribute("gpic", gpic);
			session.setAttribute("gpic1", gpic.replaceAll(".jpg", "1.png"));
			session.setAttribute("gpic2", gpic.replaceAll(".jpg", "2.png"));
			session.setAttribute("alist", alist);
			response.sendRedirect("goodSingle2.jsp");
		}else if(op.equals("addOrder")) {
			int gid = Integer.parseInt(request.getParameter("gid"));
			int aid = Integer.parseInt(request.getParameter("aid"));
			int uid = Integer.parseInt(request.getParameter("uid"));
			Date otime=new Date();    
			GoodsAndOrders gAndO = new GoodsAndOrders(otime, gid, aid);
			boolean flag = odao.addOrder(gAndO,uid);
			if(flag) {
				response.getWriter().print("<script>alert('购买成功!');location='IndexServlet?op=allGoods2&uid="+uid+"';</script>");
			}
		}else if(op.equals("a")) {
			response.getWriter().print("<script>alert('请先登录!');location='IndexServlet?op=allGoods';</script>");
		}
		out.flush();// 将流刷新
		out.close();// 将流关闭
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * 查询所有主题
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void allGoods(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Goods> glist = gd.getAll();
		request.setAttribute("glist", glist);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}


	private void index(HttpServletRequest request, HttpServletResponse response,int pageSize,String column) throws ServletException, IOException {
		// 每页显示的记录数 pageSize
		// 获取总记录数 totalCount 计算总页码
		int totalCount = gd.getGoodsCount(); // 22
		int totalPage = (totalCount % pageSize == 0) ? totalCount / pageSize : totalCount / pageSize + 1;
		// 获取当前页码 currentIndex
		int currentIndex = 1;
		// 如果currentIndex有值 就重新赋值
		if (request.getParameter("currentIndex") != null) {
			currentIndex = Integer.valueOf(request.getParameter("currentIndex"));
			if (currentIndex <= 1) { // 再小不能比首页还小
				currentIndex = 1;
			} else if (currentIndex >= totalPage) {// 再大不能大过总页码
				currentIndex = totalPage;
			}
		}
		// 获取所有分页的新闻
		// 分页的第一个参数 开始
		
		int pageStart = (currentIndex - 1) * pageSize;
		List<Goods> glist = gd.getAllGoodsPageSize(pageStart, pageSize,column);
		// 保存分页的数据
		request.setAttribute("glist", glist);
		// 保存当前页码
		request.setAttribute("currentIndex", currentIndex);
		request.setAttribute("totalPage", totalPage);
	}

}
