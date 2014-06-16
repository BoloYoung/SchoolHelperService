package com.horace.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelpAdd extends HttpServlet
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

		String json = request.getReader().readLine();
		SHHelp help = (new JSONExchange()).ObjectFromJson(json, SHHelp.class);
		
		String sqlstr = "Insert into Help (help_position, help_title, help_comment, help_time, help_status, user_id)" + 
						"Values('" + help.getHelp_position() + "', '" + help.getHelp_title() + "', '" + help.getHelp_comment() + "', '" + 
						help.getHelp_time() + "', '" + help.getHelp_status() + "', '" + help.getUser_id() + "')";
		DataBaseController dbc = new DataBaseController();
		int Num = dbc.DataBaseUpdate(sqlstr);
		
		if (Num > 0)
		{
			response.setStatus(200);
		}
		else
		{
			response.setStatus(400);
		}
		
		
		out.flush();
		out.close();
	}

}
