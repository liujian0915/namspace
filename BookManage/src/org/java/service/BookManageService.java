package org.java.service;

import java.util.List;

import org.java.entity.BookManage;

public interface BookManageService {

	/**
	 * 查询所有的图书信息
	 * @return  图书集合
	 */
	List<BookManage> getList();
	
	/**
	 * 新增图书信息
	 * @param 图书信息
	 * @return  布尔值
	 */
	boolean addBookManage(BookManage bm);
	
	/**
	 * 删除图书信息
	 * @param bm
	 * @return
	 */
	boolean deleteBookManage(BookManage bm);
	
	
	
}
