package com.horace.servlet;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONExchange
{
	// ת����ʵ��
	private ObjectMapper mapper;
	// �ַ��������
	private StringWriter sw;
	// Json������
	private JsonGenerator gen;
	
	public JSONExchange()
	{
		// ʵ����ʼ������
		mapper = new ObjectMapper();
		sw = new StringWriter();
		try
		{
			gen = mapper.getFactory().createGenerator(sw);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	// ����������ת����Json�ַ���
	public String JSONFromArray(ArrayList<?> array)
	{	
		try
		{	
			mapper.writeValue(gen, array);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return sw.toString();
		// �����������toString������ȡת�����Json�ַ���
	}
	
	public <T> T ObjectFromJson(String str, Class<T> classname)
	{
		try
		{
			return (T)mapper.readValue(str, classname);
		}
		catch (JsonParseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (JsonMappingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
}