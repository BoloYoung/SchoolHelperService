package com.horace.servlet;

import java.sql.ResultSet;
import java.util.ArrayList;

public class SHUser
{
	private String user_id;
	private String user_name;
	private String user_sex;
	private String user_birth;
	private String user_num;
	private String user_phone;
	private String user_xueyuan;
	private String user_class;
	private String user_sushe;
	private String user_degree;
	private String user_password;
	public String getUser_id()
	{
		return user_id;
	}
	public void setUser_id(String user_id)
	{
		this.user_id = user_id;
	}
	public String getUser_name()
	{
		return user_name;
	}
	public void setUser_name(String user_name)
	{
		this.user_name = user_name;
	}
	public String getUser_sex()
	{
		return user_sex;
	}
	public void setUser_sex(String user_sex)
	{
		this.user_sex = user_sex;
	}
	public String getUser_birth()
	{
		return user_birth;
	}
	public void setUser_birth(String user_birth)
	{
		this.user_birth = user_birth;
	}
	public String getUser_num()
	{
		return user_num;
	}
	public void setUser_num(String user_num)
	{
		this.user_num = user_num;
	}
	public String getUser_phone()
	{
		return user_phone;
	}
	public void setUser_phone(String user_phone)
	{
		this.user_phone = user_phone;
	}
	public String getUser_xueyuan()
	{
		return user_xueyuan;
	}
	public void setUser_xueyuan(String user_xueyuan)
	{
		this.user_xueyuan = user_xueyuan;
	}
	public String getUser_class()
	{
		return user_class;
	}
	public void setUser_class(String user_class)
	{
		this.user_class = user_class;
	}
	public String getUser_sushe()
	{
		return user_sushe;
	}
	public void setUser_sushe(String user_sushe)
	{
		this.user_sushe = user_sushe;
	}
	public String getUser_degree()
	{
		return user_degree;
	}
	public void setUser_degree(String user_degeree)
	{
		this.user_degree = user_degeree;
	}
	public String getUser_password()
	{
		return user_password;
	}
	public void setUser_password(String user_password)
	{
		this.user_password = user_password;
	}
	
	
	public String toString()
	{
		return 	this.user_id + "#" + this.user_name + "#" + this.user_sex + "#" + this.user_birth + "#" +
				this.user_num + "#" + this.user_phone + "#" + this.user_xueyuan + "#" + this.user_class + "#" + this.user_sushe + "#" + 
				this.user_degree + "#" + this.user_password + "#";
		
	}
	
	public ArrayList<SHUser> ToArray(ResultSet rs)
	{// 从数据库结果集转成本类的数组链表
		ArrayList<SHUser> arl = new ArrayList<SHUser>();
		try
		{
			while(rs.next())
		    {
				SHUser user = new SHUser();
				user.setUser_id(rs.getString(user_id));
				user.setUser_birth(rs.getString(user_birth));
				user.setUser_class(rs.getString(user_class));
				user.setUser_degree(rs.getString(user_degree));
				user.setUser_name(rs.getString(user_name));
				user.setUser_num(rs.getString(user_num));
				user.setUser_password(rs.getString(user_password));
				user.setUser_phone(rs.getString(user_phone));
				user.setUser_sex(rs.getString(user_sex));
				user.setUser_sushe(rs.getString(user_sushe));
				user.setUser_xueyuan(rs.getString(user_xueyuan));
			
				// 将该元组存放到数组中
				arl.add(user);
		    }
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return arl;
		// 返回数组
	}
	
}
