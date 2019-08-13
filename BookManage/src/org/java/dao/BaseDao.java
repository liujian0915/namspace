package org.java.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 操作数据库的 基类
 * @author Hasee
 *
 */
public class BaseDao {
	
	private Connection conn;
	private PreparedStatement  ps;
	private ResultSet rs;
	
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	
	//加载静态代码块
	static{
		initial();
	}
	
	//加载配置文件
	public static void initial(){
		//1.创建properties的对象
		Properties properties=new Properties();
		InputStream is=BaseDao.class.getClassLoader().getResourceAsStream("database.properties");
		try {
			properties.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver=properties.getProperty("driver");
		url=properties.getProperty("url");
		username=properties.getProperty("username");
		password=properties.getProperty("password");
		
	}
	
	//连接数据库
	public boolean getConnection(){
		//1.加载驱动
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,username,password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	//关闭数据库
	public void closeConnection(){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(ps!=null){
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
	
	//增删改
	public int executeUpdate(String sql,Object[] params){
		int count=0;
		if(getConnection()){
		
			try {
				ps=conn.prepareStatement(sql);
				if(params!=null){
					for(int i=0;i<params.length;i++){
						ps.setObject(i+1,params[i]);
					}
				}
				count=ps.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return count;
		
	}
	
	
	
	//查询
	public ResultSet executeSQL(String sql,Object[] params){
		if(getConnection()){
			try {
				ps=conn.prepareStatement(sql);
				if(params!=null){
					for(int i=0;i<params.length;i++){
						ps.setObject(i+1,params[i]);
					}
				}
				rs=ps.executeQuery();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rs;
	}
	
	
	
	
	
	
	
	
	

}
