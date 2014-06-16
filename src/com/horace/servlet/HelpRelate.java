package com.horace.servlet;

import java.sql.ResultSet;
import java.util.ArrayList;

public class HelpRelate
{
	private String relate_id;
	private String relate_time;
	private String help_id;
	private String user_id;
	public String getRelate_id()
	{
		return relate_id;
	}
	public void setRelate_id(String relate_id)
	{
		this.relate_id = relate_id;
	}
	public String getRelate_time()
	{
		return relate_time;
	}
	public void setRelate_time(String relate_time)
	{
		this.relate_time = relate_time;
	}
	public String getHelp_id()
	{
		return help_id;
	}
	public void setHelp_id(String help_id)
	{
		this.help_id = help_id;
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
		return this.relate_id + "#" + this.relate_time + "#" + this.help_id + "#" + this.user_id + "#";
	}

	public ArrayList<HelpRelate> toArray(ResultSet rs)
	{
		ArrayList<HelpRelate> arl = new ArrayList<HelpRelate>();
		try
		{
			while(rs.next())
			{
				HelpRelate helpRe = new HelpRelate();
				
				helpRe.setHelp_id(rs.getString(help_id));
				helpRe.setRelate_id(rs.getString(relate_id));
				helpRe.setRelate_time(rs.getString(relate_time));
				helpRe.setUser_id(rs.getString(user_id));
				
				arl.add(helpRe);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();	
		}
		return arl;
	}
}
