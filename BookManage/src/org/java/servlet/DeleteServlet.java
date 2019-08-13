package org.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.java.entity.BookManage;
import org.java.service.BookManageService;
import org.java.service.impl.BookManageServiceImpl;

import com.google.gson.Gson;

public class DeleteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
		req.setCharacterEncoding("UTF-8");
		//获取ID
		String bId=req.getParameter("id");
		System.out.println(bId+"--------------------");
		//调用后台
		BookManageService bs=new BookManageServiceImpl();
		BookManage bm=new BookManage();
		bm.setbId(Integer.parseInt(bId));
		boolean falg=bs.deleteBookManage(bm);
		//通过json数据转化为String
		Gson gson=new Gson();
		String flag=gson.toJson(falg);
		PrintWriter out=resp.getWriter();
		out.print(flag);
		System.out.println(flag);
		
	}
	
	

}
