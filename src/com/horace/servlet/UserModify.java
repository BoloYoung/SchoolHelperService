package com.horace.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserModify extends HttpServlet
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
//		PrintWriter out = response.getWriter();

		String json = request.getReader().readLine();
		SHUser user = (new JSONExchange()).ObjectFromJson(json, SHUser.class);
		
		String sqlstr = "Update Users  Set user_name = '" + user.getUser_name() + "', user_sex = '" + 
						user.getUser_sex() + "', user_birth = '" + user.getUser_birth() + "', user_num = '"+ 
						user.getUser_num() + "', user_phone = '" + user.getUser_phone() + "', user_xueyuan = '" +
						user.getUser_xueyuan() + "', user_class = '" + user.getUser_class() + "', user_sushe = '" + 
						user.getUser_sushe() + "' ,user_password = '" + user.getUser_password() + "'"; 
						
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
	}

}
