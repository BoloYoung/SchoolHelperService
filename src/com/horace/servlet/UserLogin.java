package com.horace.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserLogin extends HttpServlet
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
		String user_password = request.getParameter("user_password");
		
		String sqlstr = "Select * from Users where user_id = '" + user_id + "' and user_password = '" + user_password + "'";
		
		DataBaseController dbc = new DataBaseController();
		dbc.DataBaseExcute(sqlstr);
		
		try
		{
			if(!dbc.getRs().next())
			{// ��������Ϊ�գ����¼ʧ��
				response.setStatus(400);	// ��Ӧ״̬��Ϊ400����¼ʧ��
				out.print("��¼ʧ�ܣ�");
			}
			else
			{
				dbc.getRs().beforeFirst();	
				ArrayList<SHUser> arl = (new SHUser()).ToArray(dbc.getRs());
				String json = (new JSONExchange()).JSONFromArray(arl);
				
				response.setStatus(200);
				out.print(json);
				System.out.println("�û���" + user_id + "����¼");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		dbc.Close();
		out.flush();
		out.close();
	}

}
