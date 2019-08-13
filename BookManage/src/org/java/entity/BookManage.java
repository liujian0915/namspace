package org.java.entity;

import java.util.Date;

/**
 * 图书类
 * @author Hasee
 *
 */
public class BookManage {
	private int bId;
	
	private String bName;
	
	private String bAuthor;
	
	private Date bTime;
	
	private int bType;

	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getbAuthor() {
		return bAuthor;
	}

	public void setbAuthor(String bAuthor) {
		this.bAuthor = bAuthor;
	}

	public Date getbTime() {
		return bTime;
	}

	public void setbTime(Date bTime) {
		this.bTime = bTime;
	}

	public int getbType() {
		return bType;
	}

	public void setbType(int bType) {
		this.bType = bType;
	}

	public BookManage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookManage(int bId, String bName, String bAuthor, Date bTime,
			int bType) {
		super();
		this.bId = bId;
		this.bName = bName;
		this.bAuthor = bAuthor;
		this.bTime = bTime;
		this.bType = bType;
	}
	
	
	
	

}
