package org.java.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.java.entity.BookManage;
import org.java.service.BookManageService;
import org.java.service.impl.BookManageServiceImpl;

public class BookManageServlet extends HttpServlet{

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
		//调用后台
		BookManageService bs=new BookManageServiceImpl();
		List<BookManage> list=bs.getList();
		String falg=req.getParameter("falg");
		if(list.size()>0){
			//放在request域中
			req.setAttribute("list",list);
			//转发
			if(falg!=null){
				System.out.println("111111111111111111111111111111");
				req.getRequestDispatcher("index.jsp?flag="+falg).forward(req, resp);
			}else{
				req.getRequestDispatcher("index.jsp").forward(req, resp);
			}
		}
		
	}
	
	

}
