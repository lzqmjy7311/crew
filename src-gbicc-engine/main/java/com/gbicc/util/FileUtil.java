package com.gbicc.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FileUtil {
	private static final String NEW_LINE ="\n";
	private static final String DEFAULT_ENCODING ="UTF-8";
	
	/**
	 * 向一个文本文件追加文本内容，采用默认字符编码
	 * @param fileName 文件名
	 * @param content 追加的内容
	 * @throws Exception 违例
	 */
	public static synchronized void append(String fileName,String content) throws Exception{
		append(fileName,content,DEFAULT_ENCODING);
	}
	
	/**
	 * 向一个文本文件追加文本内容，采用指定的字符编码
	 * @param fileName 文件名
	 * @param content 追加的内容
	 * @param encoding 追加内容字符编码
	 * @throws Exception 违例
	 */
	public static synchronized void append(String fileName,String content,String encoding) throws Exception{
		RandomAccessFile raf =null;
		FileChannel fc =null;
		try {
			raf =new RandomAccessFile(fileName,"rw");
			fc =raf.getChannel();
			ByteBuffer bb =ByteBuffer.wrap(content.getBytes(encoding));
			fc.position(fc.size());
			fc.write(bb);
		} catch (Exception e) {
			throw e;
		}finally{
			if(fc!=null){
				fc.close();
			}
			if(raf!=null){
				raf.close();
			}
			fc =null;
			raf =null;
		}
	}
	
	/**
	 * 向一个文本文件追加文本内容,采用默认字符编码
	 * @param fileName 文件名
	 * @param content 追加的内容
	 * @param header 文件头内容
	 * @param tail 文件尾内容
	 * @throws Exception 违例
	 */
	public static synchronized void append(String fileName,String content,String header,String tail) throws Exception{
		append(fileName,content,header,tail,DEFAULT_ENCODING);
	}
	
	/**
	 * 向一个文本文件追加文本内容
	 * @param fileName 文件名
	 * @param content 追加的内容
	 * @param header 文件头内容
	 * @param tail 文件尾内容
	 * @param encoding 追加内容字符编码
	 * @throws Exception 违例
	 */
	public static synchronized void append(String fileName,String content,String header,String tail,String encoding) throws Exception{
		RandomAccessFile raf =null;
		FileChannel fc =null;
		boolean isNewFile =false;
		try {
			raf =new RandomAccessFile(fileName,"rw");
			fc =raf.getChannel();
			if(fc.size()==0){
				isNewFile =true;
			}
			ByteBuffer bb =ByteBuffer.wrap((content+tail).getBytes(encoding));
			if(isNewFile){
				fc.write(ByteBuffer.wrap(header.getBytes(encoding)));
				fc.write(bb);
			}else{
				fc.position(fc.size()-tail.getBytes(encoding).length);
				fc.write(bb);
			}
			
		} catch (Exception e) {
			throw e;
		}finally{
			if(fc!=null){
				fc.close();
			}
			if(raf!=null){
				raf.close();
			}
			fc =null;
			raf =null;
		}
	}
	
	/**
	 * 读取一个文本文件的字符内容
	 * @param file 文件名
	 * @return 文件内容
	 * @throws FileNotFoundException 
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	public static String readString(String file) throws FileNotFoundException,UnsupportedEncodingException,IOException{
		return readString(file,DEFAULT_ENCODING);
	}
	
	/**
	 * 读取一个文本文件的字符内容
	 * @param file 文件名
	 * @param encoding 文件字符编码
	 * @return 文件内容
	 * @throws FileNotFoundException 
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	public static String readString(String file,String encoding) throws FileNotFoundException,UnsupportedEncodingException,IOException{
		return readString(new File(file),encoding);
	}
	
	/**
	 * 从文本文件中读取所有文本
	 * @param file 文件对象
	 * @return 文件内容
	 * @throws FileNotFoundException 
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	public static String readString(File file) throws FileNotFoundException,UnsupportedEncodingException,IOException{
		return readString(new FileInputStream(file),DEFAULT_ENCODING);
	}
	
	/**
	 * 读取一个文本文件的字符内容
	 * @param file 文件名
	 * @param encoding 文件字符编码
	 * @param newLine 文本换行符
	 * @return 文件内容
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	public static String readString(String file,String encoding,String newLine) throws FileNotFoundException,UnsupportedEncodingException,IOException{
		return readString(new File(file),encoding,newLine);
	}
	
	/**
	 * 从文本文件中读取所有文本
	 * @param file 文件对象
	 * @param encoding 文件字符编码
	 * @return 文件内容
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	public static String readString(File file,String encoding) throws FileNotFoundException,UnsupportedEncodingException,IOException{
		return readString(new FileInputStream(file),encoding);
	}
	
	/**
	 * 从文本文件中读取所有文本
	 * @param file 文件对象
	 * @param encoding 文件字符编码
	 * @param newLine 换行符
	 * @return 文件内容
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	public static String readString(File file,String encoding,String newLine) throws UnsupportedEncodingException,IOException{
		return readString(new FileInputStream(file),encoding,newLine);
	}
	
	/**
	 * 从文本输入流中读取所有文本
	 * @param inputstream 文本输入流
	 * @return 输入流中文本内容
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	public static String readString(InputStream inputstream) throws UnsupportedEncodingException,IOException{
		return readString(inputstream,DEFAULT_ENCODING,NEW_LINE);
	}
	
	/**
	 * 从文本输入流中读取所有文本
	 * @param inputstream 文本输入流
	 * @param encoding 文件字符编码
	 * @return 输入流中文本内容
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	public static String readString(InputStream inputstream,String encoding) throws UnsupportedEncodingException,IOException{
		return readString(inputstream,encoding,NEW_LINE);
	}
	
	/**
	 * 从文本输入流中读取所有文本
	 * @param inputstream 文本输入流
	 * @param encoding 文件字符编码
	 * @param newLine 换行符
	 * @return 输入流中文本内容
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	public static String readString(InputStream inputstream,String encoding,String newLine) throws UnsupportedEncodingException,IOException{
		return readString(inputstream,encoding,NEW_LINE,true);
	}
	
	/**
	 * 从文本输入流中读取所有文本
	 * @param inputstream 文本输入流
	 * @param encoding 文件字符编码
	 * @param newLine 换行符
	 * @param isCloseInputStream 读取完毕后是否关闭输入流
	 * @return 输入流中文本内容
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	public static String readString(InputStream inputstream,String encoding,String newLine,boolean isCloseInputStream) throws UnsupportedEncodingException,IOException{
		StringBuilder sb = new StringBuilder();
		BufferedReader br =null;
		try {
			br = new BufferedReader(new InputStreamReader(inputstream,encoding));
			String dataLine = "";
			while (null != (dataLine = br.readLine())){
			    sb.append(dataLine);
			    sb.append(newLine==null?NEW_LINE:newLine);
			}
			return sb.toString();
		} catch (UnsupportedEncodingException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		}finally{
			sb =null;
			if(isCloseInputStream){
				if(br!=null){
					try {
						br.close();
					} catch (IOException e) {}
				}
			}
		}
	}
	
	/**
	 * 采用默认字符编码从文件中读取所有文本列表，列表中每个元素为一行
	 * @param file 文件名
	 * @return 所有文本列表
	 * @throws IOException
	 */
	public static List<String> readStringAsList(String file) throws IOException{
		return readStringAsList(new File(file),DEFAULT_ENCODING);
	}
	
	/**
	 * 采用指定字符编码从文件中读取所有文本列表，列表中每个元素为一行
	 * @param file 文件名
	 * @param encoding 字符编码
	 * @return 所有文本列表
	 * @throws IOException
	 */
	public static List<String> readStringAsList(String file,String encoding) throws IOException{
		return readStringAsList(new File(file),encoding);
	}
	
	/**
	 * 采用默认字符编码从文件中读取所有文本列表，列表中每个元素为一行
	 * @param file 文件对象
	 * @return 所有文本列表
	 * @throws IOException
	 */
	public static List<String> readStringAsList(File file) throws IOException{
		return readStringAsList(new FileInputStream(file),DEFAULT_ENCODING);
	}
	
	/**
	 * 采用指定字符编码从文件中读取所有文本列表，列表中每个元素为一行
	 * @param file 文件对象
	 * @param encoding 字符编码
	 * @return 所有文本列表
	 * @throws IOException
	 */
	public static List<String> readStringAsList(File file,String encoding) throws IOException{
		return readStringAsList(new FileInputStream(file),encoding);
	}
	
	/**
	 * 采用默认字符编码从文本输入流中读取所有文本列表，列表中每个元素为一行
	 * @param inputstream 文本输入流
	 * @return 所有文本列表
	 * @throws IOException
	 */
	public static List<String> readStringAsList(InputStream inputstream) throws IOException{
		return readStringAsList(inputstream,DEFAULT_ENCODING);
	}
	
	/**
	 * 采用指定字符编码从文本输入流中读取所有文本列表，列表中每个元素为一行
	 * @param inputstream 文本输入流
	 * @param encoding 字符编码
	 * @return 所有文本列表
	 * @throws IOException
	 */
	public static List<String> readStringAsList(InputStream inputstream,String encoding) throws IOException{
		List<String> result =new ArrayList<String>();
		BufferedReader br =null;
		try {
			br = new BufferedReader(new InputStreamReader(inputstream,encoding));
			String dataLine = "";
			while (null != (dataLine = br.readLine())){
				result.add(dataLine);
			}
			return result;
		} catch (IOException e) {
			throw e;
		}finally{
			if(br!=null){
				try {
					br.close();
				} catch (IOException e) {}
			}
		}
	}
	
	/**
	 * 读取文件最后多行数
	 * @param filename 文件名
	 * @param row      行数
	 * @return
	 * @throws Exception
	 */
	public static String readStringAsLastRow(String filename,int row) throws Exception{
		return readStringAsLastRow(new File(filename),row);
	}
	
	/**
	 * 读取文件最后行数
	 * @param file	文件名
	 * @param row	行数
	 * @return
	 * @throws Exception
	 */
	public static String readStringAsLastRow(File file,int row) throws Exception{
		RandomAccessFile rf =null;
		try {
			rf = new RandomAccessFile(file, "r");
			long len = rf.length();
			if (len == 0) {
				return "";
			}
			int _row = 0;
			while (len > 0 && _row < row) {
				len--;
				rf.seek(len);
				if (rf.readByte() == '\n') {
					//pos=rf.getFilePointer();
					_row++;
				}
			}
			StringBuffer buffer = new StringBuffer();
			String str = "";
			while ((str = rf.readLine()) != null) {
				buffer.append(new String(str.getBytes("ISO-8859-1"),"UTF-8")).append("\n");
			}
			return buffer.toString();
		} catch (Exception e) {
			throw e;
		} finally{
			if(rf!=null){
				rf.close();
			}
		}
	}
	
	/**
	 * 将字符串以默认编码写入指定的文件中
	 * @param file 文件名
	 * @param content 写入内容
	 */
	public static void writeString(String file,String content) throws FileNotFoundException,UnsupportedEncodingException,IOException{
		writeString(file,content,DEFAULT_ENCODING);
	}
	
	/**
	 * 将字符串以特定编码写入指定的文件中
	 * @param file 文件名
	 * @param content 写入内容
	 * @param encoding 内容编码
	 */
	public static void writeString(String file,String content,String encoding) throws FileNotFoundException,UnsupportedEncodingException,IOException{
		writeString(new File(file),content,encoding);
	}
	
	/**
	 * 将字符串以特定编码写入指定的文件中
	 * @param file 文件对象
	 * @param content 写入内容
	 * @param encoding 内容编码
	 */
	public static void writeString(File file,String content,String encoding) throws FileNotFoundException,UnsupportedEncodingException,IOException{
		OutputStreamWriter writer =null;
		try {
			writer =new OutputStreamWriter(new FileOutputStream(file),encoding);
			writer.write(content);
		} catch (UnsupportedEncodingException e) {
			throw e;
		} catch (FileNotFoundException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		}finally{
			if(writer!=null){
				try {
					writer.close();
				} catch (IOException e) {}
			}
		}
	}
	
	/**
	 * 获取某个目录下的所有扩展名为includes的文件
	 * @param dir 路径
	 * @param includes 扩展名数组
	 * @return 所有文件集合
	 */
	public static List<File> listAllFile(File dir,String[] includes){
		List<File> result =new ArrayList<File>();
		File[] files =dir.listFiles();
		for(int i=0;i<files.length;i++){
			File file =files[i];
			if(file.isDirectory()){
				result.addAll(listAllFile(file,includes));
			}else{
				for(String include : includes){
					if(file.getName().endsWith(include)){
						result.add(file);
						break;
					}
				}
			}
		}
		Collections.sort(result, new Comparator<File>() {
			@Override
			public int compare(File o1, File o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		return result;
	}
	
	/**
	 * 移除目录路径的最后分隔符
	 * @param path 目录路径
	 * @return 无文件分隔符的文件路径
	 */
	public static String removePathEndSeparator(String path){
		char lastChar =path.charAt(path.length()-1);
		while(lastChar=='\\' || lastChar=='/'){
			path =path.substring(0,path.length()-1);
			lastChar =path.charAt(path.length()-1);
		}
		return path;
	}
	
	/**
	 * 创建目录，可同时创建多级目录
	 * @param dir 目录路径能够
	 */
	public static void mkdirs(String dir){
		File file =new File(dir);
		if(!file.exists()){
			file.mkdirs();
		}
	}
	
	/**
	 * 递归删除文件夹及其子文件
	 * @param dir 文件夹
	 */
	public static void deldirs(String dir){
		deldirs(new File(dir));
	}
	
	/**
	 * 递归删除文件夹及其子文件
	 * @param dir 文件夹
	 */
	public static void deldirs(File dir){
		if(dir.isDirectory()){
			File[] files =dir.listFiles();
			if(files!=null && files.length>0){
				for(File file : files){
					deldirs(file);
				}
			}
			dir.delete();
		}else{
			dir.delete();
		}
	}
	
	/**
	 * 拷贝文件
	 * @param src 源文件
	 * @param target 目标文件
	 * @throws Exception 违例
	 */
	public static void copyFile(InputStream src,String target) throws IOException{
		copyFile(src,new File(target));
	}
	
	/**
	 * 拷贝文件
	 * @param src 源输入流
	 * @param target 目标文件对象
	 * @throws Exception 违例
	 */
	public static void copyFile(InputStream src,File target) throws IOException{
		File parentFile =target.getParentFile();
		if(!parentFile.exists()){
			parentFile.mkdirs();
		}
		OutputStream os =null;
		byte[] buf = new byte[1024];
		try {
			os = new FileOutputStream(target);
			int read =-1;
			while ((read = src.read(buf)) != -1) {
			    os.write(buf, 0, read);
			}
		} catch (IOException e) {
			throw e;
		} finally{
			try{if(src!=null)src.close();}catch(Exception e){throw new IOException(e);}
			try{if(os!=null)os.close();}catch(Exception e){throw new IOException(e);}
			buf =null;
		}
	}
	
	/**
	 * 拷贝文件
	 * @param src 源输入流
	 * @param os 目标输出流
	 * @throws Exception 违例
	 */
	public static void copyFile(InputStream src,OutputStream os) throws IOException{
		byte[] buf = new byte[1024];
		try {
			int read =-1;
			while ((read = src.read(buf)) != -1) {
			    os.write(buf, 0, read);
			}
		} catch (IOException e) {
			throw e;
		} finally{
			try{if(src!=null)src.close();}catch(Exception e){throw new IOException(e);}
			try{if(os!=null)os.close();}catch(Exception e){throw new IOException(e);}
			buf =null;
		}
	}
	
	/**
	 * 拷贝文件
	 * @param src 源文件对象
	 * @param target 目标文件对象
	 * @throws Exception 违例
	 */
	public static void copyFile(File src,File target) throws IOException{
		if(!target.getParentFile().exists()){
			target.getParentFile().mkdirs();
		}
		InputStream is =new FileInputStream(src);
		OutputStream os =new FileOutputStream(target);
		byte[] buf = new byte[40960];
		int read =-1;
        try {
			while ((read = is.read(buf)) != -1) {
			    os.write(buf, 0, read);
			}
		} catch (IOException e) {
			throw e;
		} finally{
			try{if(is!=null)is.close();}catch(Exception e){throw new IOException(e);}
			try{if(os!=null)os.close();}catch(Exception e){throw new IOException(e);}
			buf =null;
		}
	}
	
	/**
	 * 拷贝文件
	 * @param src 源文件
	 * @param target 目标文件
	 * @throws Exception 违例
	 */
	public static void copyFile(String src,String target) throws IOException{
		copyFile(new File(src),new File(target));
	}
}
