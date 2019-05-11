package com.gbicc.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * 简单 url 访问器
 * @author wangshaoping
 *
 */
public class SimpleCurl {
	/**
	 * 访问 url,并以 UTF-8 编码返回 url 响应字符串
	 * @param url url地址
	 * @return UTF-8 编码返回 url 响应字符串
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public static String get(String url) throws MalformedURLException,IOException{
		return get(url,"UTF-8");
	}
	
	/**
	 * 访问 url,并以指定编码返回 url 响应字符串
	 * @param url url地址
	 * @param encoding 编码
	 * @return 指定编码返回 url 响应字符串
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public static String get(String url,String encoding) throws MalformedURLException,IOException{
		URL getUrl =null;
		URLConnection conn=null;
		BufferedReader reader =null;
		
		try {
			getUrl = new URL(url);
			conn = getUrl.openConnection();
			reader = new BufferedReader(new InputStreamReader(conn.getInputStream(),encoding));
			String line;
			StringBuilder sb = new StringBuilder();
			while ((line = reader.readLine()) != null) {
				sb.append(line).append("\n");
			}
			return sb.toString();
		} catch (MalformedURLException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		} finally {
			if(reader!=null){
				try {reader.close();} catch (IOException e) {e.printStackTrace();}
			}
		}
	}
}
