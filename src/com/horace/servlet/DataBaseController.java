package com.horace.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseController
{
	// ����ʵ��
	private Connection con;
	// ���ִ��ʵ��
	private Statement stmt;
	// �����
	private ResultSet rs; 
	
	public ResultSet getRs()
	{
		return rs;
	}

	public DataBaseController()
	{
		try
		{
			// ��������
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// ��������ʵ��
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=SchoolHelper","sa","sa");
			// ��ȡ������sql���������statement
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
			// �����
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
		
		
		// ������Ӱ������
		return statu;
	}
	
	void Close()
	{
		try
		{
			// ���ִ����
			stmt.close();
			// �Ͽ�����
			con.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	
}