package com.horace.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelpRelateBuild extends HttpServlet
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
		String help_id = request.getParameter("help_id");
		
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		String relate_time = sdf.format(now);
		
		String sqlstr = "Insert into HelpRelate Set relate_time = '" + relate_time + "', user_id = '" +
						user_id + "', help_id = '" + help_id + "'";
		DataBaseController dbc = new DataBaseController();
		dbc.DataBaseExcute(sqlstr);
		
		ArrayList<HelpRelate> arl = (new HelpRelate()).toArray(dbc.getRs());
		String json = (new JSONExchange()).JSONFromArray(arl);
		
		out.print(json);
		response.setStatus(200);
		
		out.flush();
		out.close();
	}

}
