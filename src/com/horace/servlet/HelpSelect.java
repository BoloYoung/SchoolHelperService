package com.horace.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelpSelect extends HttpServlet
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

		String sqlstr = "Select * from Help where help_status = 'Œ¥¥¶¿Ì' order by help_time DESC";
		DataBaseController dbc = new DataBaseController();
		dbc.DataBaseExcute(sqlstr);
		
		ArrayList<SHHelp> arl = new ArrayList<SHHelp>();
		arl = (new SHHelp()).toArray(dbc.getRs());
		String json = (new JSONExchange()).JSONFromArray(arl);
		
		out.print(json);
		response.setStatus(200);
		
		out.flush();
		out.close();
	}

}
