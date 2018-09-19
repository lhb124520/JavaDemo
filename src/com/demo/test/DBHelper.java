package com.demo.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Java中使用JDBC连接数据库 
 *  1） 加载驱动 2） 创建数据库连接
 *  3） 创建执行sql的语句 4） 执行语句 5） 处理执行结果 6） 释放资源 
 * @author liu.hb
 *
 */
public class DBHelper {
	/**
	 * Statement 和 PreparedStatement之间的关系和区别.
	    关系：PreparedStatement继承自Statement,都是接口
	    区别：PreparedStatement可以使用占位符，是预编译的，批处理比Statement效率高  
	 */
	public static void conn() {
		String URL = "jdbc:mysql://127.0.0.1:3306/Supermarket?characterEncoding=utf-8";
		String USER = "root";
		String PASSWORD = "123";
		// 1.加载驱动程序
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// 2.获得数据库链接
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			// 3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
			String name="张三";
			//预编译
			String sql="select * from userinfo where UserName=?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, name);
			ResultSet rs = statement.executeQuery();
//			String sql="select * from userinfo where UserName='"+name+"'";
//			Statement statement = conn.createStatement();			
//			ResultSet rs = statement.executeQuery(sql);
			// 4.处理数据库的返回结果(使用ResultSet类)
			while (rs.next()) {
				System.out.println(rs.getString("UserName") + " " + rs.getString("Password"));
			}

			// 关闭资源
			conn.close();
			rs.close();
			statement.close();			
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		}catch (SQLException e) {			
			e.printStackTrace();
		}	
		}


    private static void getConn() {
		try {
			//1 加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//2 创建数据库连接    	
			String url="jdbc:mysql://localhost:3306/SuperMarket?characterEncoding=utf-8";
			String user="root";
			String password="123";
			Connection connection =DriverManager.getConnection(url, user, password);
			String sql="select * from userinfo where UserName=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,"高小姐");
			ResultSet resultSet=preparedStatement.executeQuery();
			while (resultSet.next()) {
				System.out.println(resultSet.getString("UserName")+"   "+resultSet.getString("Password"));
			}
			connection.close();
			preparedStatement.close();
			resultSet.close();
		} catch (SQLException e) {			
			e.printStackTrace();
		}catch (ClassNotFoundException e1) {		
			e1.printStackTrace();
		}
	}
	public static void main(String[] args) {
		DBHelper [] arr=new DBHelper[50];
		System.out.println(arr.length);
		conn();
		getConn();
	}
}
