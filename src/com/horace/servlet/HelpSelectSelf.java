package com.horace.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelpSelectSelf extends HttpServlet
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
		
		String sqlstr = "Select * from Help where user_id = '" + user_id + "' order by help_time DESC";
		DataBaseController dbc = new DataBaseController();
		dbc.DataBaseExcute(sqlstr);
		
		ArrayList<SHHelp> arl = (new SHHelp()).toArray(dbc.getRs());
		String json = (new JSONExchange()).JSONFromArray(arl);
		
		out.print(json);
		response.setStatus(200);
		
		out.flush();
		out.close();
	}

}
