package org.java.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.java.entity.BookManage;
import org.java.service.BookManageService;
import org.java.service.impl.BookManageServiceImpl;

public class AddServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置字符集
		req.setCharacterEncoding("UTF-8");
		//获值
		String bName=req.getParameter("bName");
		String bAuthor=req.getParameter("bAuthor");
		String bTime=req.getParameter("bTime");
		SimpleDateFormat date=new SimpleDateFormat("yyyy-MM-dd");
		String bType=req.getParameter("bType");
		//调用后台
		BookManage bm=new BookManage();
		bm.setbName(bName);
		bm.setbAuthor(bAuthor);
		try {
			bm.setbTime(date.parse(bTime));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bm.setbType(Integer.parseInt(bType));
		BookManageService bs=new BookManageServiceImpl();
		boolean falg=bs.addBookManage(bm);
		String flag="faile";
		if(falg){
			//转发
			flag="success";
			req.getRequestDispatcher("bookServlet?falg="+flag).forward(req, resp);
		}else{
			//重定向
			resp.sendRedirect("add.jsp");
		}
		
		
		
	}
	
	

}
