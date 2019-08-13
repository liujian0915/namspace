package org.java.service.impl;

import java.util.List;

import org.java.dao.BookManageDao;
import org.java.dao.impl.BookManageDaoImpl;
import org.java.entity.BookManage;
import org.java.service.BookManageService;

public class BookManageServiceImpl implements BookManageService{

	private BookManageDao bd;
	
	public BookManageServiceImpl(){
		bd=new BookManageDaoImpl();
	}
	
	
	
	@Override
	public List<BookManage> getList() {
		return bd.getList();
	}

	@Override
	public boolean addBookManage(BookManage bm) {
		return bd.addBookManage(bm);
	}

	@Override
	public boolean deleteBookManage(BookManage bm) {
		return bd.deleteBookManage(bm);
	}

}
