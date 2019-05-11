package com.huateng.fs.micro.demo.channel;

import org.apache.commons.lang.ArrayUtils;

import com.huateng.exception.AppException;
import com.huateng.flowswitch.micro.common.Context;
import com.huateng.flowswitch.micro.common.Module;
import com.huateng.flowswitch.micro.common.Rescode;
import com.huateng.flowswitch.micro.model.base._Entry;
import com.huateng.flowswitch.micro.model.channel.base.IChannelInterceptor;
/**
 * <p>Title: ClientChannelInterceptor</p>
 * <p>Description: 广州农商特殊报文协议头处理-客户端</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: huateng</p>
 * @author shen_antonio
 * @version 1.0
 */
/*
 报头块的格式如下表：
相对位移	长度	属性	名称	值域	说明
1．	0	6	n	报文长度	 整个报文的长度含这六位
6	4	4	交易码	 不同的报文用不同的交易码
10	16	16	报文MAC	 跳过报头部分全包算MAC
26	4	4	MAC机器号
30	1	1	结束标识	#
 */
public class ClientChannelHandAndBodyInterceptor extends _Entry<IChannelInterceptor>
		implements IChannelInterceptor {

	public IChannelInterceptor getIntance() {
		// TODO Auto-generated method stub
		return this;
	}
	/**
	 * 请求为buffer，尚未赋值
	 */
	public void doPreRequest(Context ctx) throws AppException {
		// TODO Auto-generated method stub

	}

	/**
	 * 请求已经为buffer赋值，可以获取到报文
	 */
	public void doPostRequest(Context ctx) throws AppException {
		// TODO Auto-generated method stub
		byte[] outMsg = ctx.getOutMsgByte();
		try{
			String outMsgStr = new String(outMsg,ctx.getEncoding());
			System.out.println("====================outmsg:"+outMsgStr);
			String newmsg = outMsgStr.replace("<MSG01>", "<MSG01 xmlns=\"urn:schemas-edifactoring-com:MSG01\">");
			ctx.setOutMsg(newmsg);
			ctx.setOutMsgByte(newmsg.getBytes(ctx.getEncoding()));
		}catch (Exception e) {
			throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_ERROR, "ClientChannelHandAndBodyInterceptor doPostRequest Fail",e);
		}
	}

	/**
	 * 获取返回报文,尚未放入buffer
	 */
	public void doPreRespone(Context ctx) throws AppException {
		//返回报文
		byte[] inMsgByte = ctx.getInMsgByte();
		try{
		System.out.println("=====================respone msg:"+new String(inMsgByte,"utf-8"));
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * 返回报文已经翻入buffer
	 */
	public void doPostRespone(Context ctx) throws AppException {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 异常报文尚未放入buffer
	 */
	public void doPreException(Context ctx) throws AppException {
		// TODO Auto-generated method stub

	}

	/**
	 * 异常报文已放入buffer
	 */
	public void doPostException(Context ctx) throws AppException {
		// TODO Auto-generated method stub

	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

}
