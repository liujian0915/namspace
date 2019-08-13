package org.java.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.java.dao.BaseDao;
import org.java.dao.BookManageDao;
import org.java.entity.BookManage;


/**
 * 图书信息的实现类
 * @author Hasee
 *
 */
public class BookManageDaoImpl extends BaseDao implements BookManageDao{

	
	//查询
	@Override
	public List<BookManage> getList() {
		List<BookManage> list=new ArrayList<BookManage>();
		String  sql="SELECT * FROM BookManage ORDER BY b_time DESC";
		Object[] params={};
		ResultSet rs=this.executeSQL(sql, params);
		try {
			while(rs.next()){
				BookManage bm=new BookManage();
				bm.setbId(rs.getInt(1));
				bm.setbName(rs.getString(2));
				bm.setbAuthor(rs.getString(3));
				bm.setbTime(rs.getDate(4));
				bm.setbType(rs.getInt(5));
				list.add(bm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.closeConnection();
		}
		return list;
	}

	//新增
	@Override
	public boolean addBookManage(BookManage bm) {
		boolean falg=false;
		String sql="INSERT INTO bookmanage(b_name,b_author,b_time,b_type)VALUES(?,?,?,?)";
		Object[] params={bm.getbName(),bm.getbAuthor(),bm.getbTime(),bm.getbType()};
		int i=this.executeUpdate(sql, params);
		if(i>0){
			System.out.println("新增成功");
			falg=true;
		}else{
			System.out.println("新增失败");
			falg=false;
		}
		return falg;
	}

	//删除
	@Override
	public boolean deleteBookManage(BookManage bm) {
		boolean falg=false;
		String sql="DELETE FROM BookManage WHERE b_id=?";
		Object[] params={bm.getbId()};
		int i=this.executeUpdate(sql, params);
		if(i>0){
			System.out.println("删除成功");
			falg=true;
		}else{
			System.out.println("删除失败");
			falg=false;
		}
		return falg;
	}

}
