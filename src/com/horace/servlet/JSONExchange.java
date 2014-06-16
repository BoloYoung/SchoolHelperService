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
	// 转换器实例
	private ObjectMapper mapper;
	// 字符串输出器
	private StringWriter sw;
	// Json产生器
	private JsonGenerator gen;
	
	public JSONExchange()
	{
		// 实例初始化方法
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
	
	// 将泛型数组转换成Json字符串
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
		// 调用输出器的toString方法获取转换后的Json字符串
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