package com.horace.servlet;

import java.sql.ResultSet;
import java.util.ArrayList;

public class SHHelp
{
	private String help_id;
	private String help_position;
	private String help_title;
	private String help_comment;
	private String help_time;
	private String help_status;
	private String user_id;
	public String getHelp_id()
	{
		return help_id;
	}
	public void setHelp_id(String help_id)
	{
		this.help_id = help_id;
	}
	public String getHelp_position()
	{
		return help_position;
	}
	public void setHelp_position(String help_position)
	{
		this.help_position = help_position;
	}
	public String getHelp_title()
	{
		return help_title;
	}
	public void setHelp_title(String help_title)
	{
		this.help_title = help_title;
	}
	public String getHelp_comment()
	{
		return help_comment;
	}
	public void setHelp_comment(String help_comment)
	{
		this.help_comment = help_comment;
	}
	public String getHelp_time()
	{
		return help_time;
	}
	public void setHelp_time(String help_time)
	{
		this.help_time = help_time;
	}
	public String getHelp_status()
	{
		return help_status;
	}
	public void setHelp_status(String help_status)
	{
		this.help_status = help_status;
	}
	public String getUser_id()
	{
		return user_id;
	}
	public void setUser_id(String user_id)
	{
		this.user_id = user_id;
	}
	
	public String toString()
	{
		return  this.help_id + "#" + this.help_position + "#" + this.help_title + "#" + 
				this.help_comment + "#" + this.help_time + "#" +  this.help_status + "#" + 
				this.user_id + "#";
	}
	
	public ArrayList<SHHelp> toArray(ResultSet rs)
	{
		ArrayList<SHHelp> arl = new ArrayList<SHHelp>();
		try
		{
			while(rs.next())
			{
				SHHelp help = new SHHelp();
				help.setHelp_comment(rs.getString(help_comment));
				help.setHelp_id(rs.getString(help_id));
				help.setHelp_position(rs.getString(help_position));
				help.setHelp_status(rs.getString(help_status));
				help.setHelp_time(rs.getString(help_time));
				help.setHelp_title(rs.getString(help_title));
				help.setUser_id(rs.getString(user_id));
			
				arl.add(help);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return arl;
	}
}
