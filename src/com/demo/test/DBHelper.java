package com.demo.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Java��ʹ��JDBC�������ݿ� 
 *  1�� �������� 2�� �������ݿ�����
 *  3�� ����ִ��sql����� 4�� ִ����� 5�� ����ִ�н�� 6�� �ͷ���Դ 
 * @author liu.hb
 *
 */
public class DBHelper {
	/**
	 * Statement �� PreparedStatement֮��Ĺ�ϵ������.
	    ��ϵ��PreparedStatement�̳���Statement,���ǽӿ�
	    ����PreparedStatement����ʹ��ռλ������Ԥ����ģ��������StatementЧ�ʸ�  
	 */
	public static void conn() {
		String URL = "jdbc:mysql://127.0.0.1:3306/Supermarket?characterEncoding=utf-8";
		String USER = "root";
		String PASSWORD = "123";
		// 1.������������
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// 2.������ݿ�����
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			// 3.ͨ�����ݿ�����Ӳ������ݿ⣬ʵ����ɾ�Ĳ飨ʹ��Statement�ࣩ
			String name="����";
			//Ԥ����
			String sql="select * from userinfo where UserName=?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, name);
			ResultSet rs = statement.executeQuery();
//			String sql="select * from userinfo where UserName='"+name+"'";
//			Statement statement = conn.createStatement();			
//			ResultSet rs = statement.executeQuery(sql);
			// 4.�������ݿ�ķ��ؽ��(ʹ��ResultSet��)
			while (rs.next()) {
				System.out.println(rs.getString("UserName") + " " + rs.getString("Password"));
			}

			// �ر���Դ
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
			//1 ��������
			Class.forName("com.mysql.jdbc.Driver");
			//2 �������ݿ�����    	
			String url="jdbc:mysql://localhost:3306/SuperMarket?characterEncoding=utf-8";
			String user="root";
			String password="123";
			Connection connection =DriverManager.getConnection(url, user, password);
			String sql="select * from userinfo where UserName=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,"��С��");
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
