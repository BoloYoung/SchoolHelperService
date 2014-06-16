package com.horace.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserSelect extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String user_id = request.getParameter("user_id");
		String sqlstr = "Select user_id, user_name, user_sex, user_phone, user_degree from Users where user_id = '" + user_id + "'";
		DataBaseController dbc = new DataBaseController();
		dbc.DataBaseExcute(sqlstr);		
		
		ArrayList<Map<String, String>> arl = this.GetArrayList(dbc.getRs());
		String json = (new JSONExchange()).JSONFromArray(arl);
		
		out.print(json);
		response.setStatus(200);
		
		out.flush();
		out.close();
	}
	
	private ArrayList<Map<String, String>> GetArrayList(ResultSet rs)
	{
		ArrayList<Map<String, String>> arl = new ArrayList<Map<String,String>>();
		
		try
		{
			while(rs.next())
			{
				Map<String, String> map = new HashMap<String, String>();
				
				map.put("user_id", rs.getString("user_id"));
				map.put("user_name", rs.getString("user_name"));
				map.put("user_sex", rs.getString("user_sex"));
				map.put("user_phone", rs.getString("user_phone"));
				map.put("user_degree", rs.getString("user_degree"));
				
				arl.add(map);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	
		return arl;
	}

}
