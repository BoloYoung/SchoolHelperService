package com.horace.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseController
{
	// 连接实例
	private Connection con;
	// 语句执行实例
	private Statement stmt;
	// 结果集
	private ResultSet rs; 
	
	public ResultSet getRs()
	{
		return rs;
	}

	public DataBaseController()
	{
		try
		{
			// 加载驱动
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// 创建连接实例
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=SchoolHelper","sa","sa");
			// 获取用于向sql发送命令的statement
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		}
		catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void DataBaseExcute(String sqlstr)
	{
		try
		{
			// 结果集
			rs = stmt.executeQuery(sqlstr);
		}		
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int DataBaseUpdate(String sqlstr)
	{

		int statu = 0;

		try
		{
			statu = stmt.executeUpdate(sqlstr);
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// 返回受影响行数
		return statu;
	}
	
	void Close()
	{
		try
		{
			// 语句执行器
			stmt.close();
			// 断开连接
			con.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	
}