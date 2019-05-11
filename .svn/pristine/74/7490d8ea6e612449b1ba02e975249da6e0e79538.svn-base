package com.huateng.fs.micro.demo.services;

import java.math.BigDecimal;

import com.huateng.exception.AppException;
import com.huateng.fs.micro.demo.bean.Purchase;
import com.huateng.fs.micro.demo.bean.TestInputBean;
import com.huateng.fs.micro.demo.bean.TestOutputBean;

public class TestService {
	/**
	 * 测试添加服务类 1001
	 * @param tib
	 * @return
	 * @throws AppException
	 */
	public TestOutputBean testAdd(TestInputBean tib)throws AppException{
		TestOutputBean outBean = new TestOutputBean();
		outBean.setVersion(tib.getVersion());
		if(tib.getPan().trim().equals("1")){
			outBean.setRspcode("9999");
			outBean.setRspmsg("add exception,pan=1");
		}else{
			//保存至数据库
			outBean.setRspcode("0000");
			outBean.setRspmsg("add success");
		}
		return outBean;
	}
	
	/**
	 * 测试添加服务类 1002
	 * @param tib
	 * @return
	 * @throws AppException
	 */
	public TestOutputBean testQuery(TestInputBean tib)throws AppException{
		TestOutputBean outBean = new TestOutputBean();
		outBean.setVersion(tib.getVersion());
		if(tib.getPan()!=null && tib.getPan().trim().equals("1")){
			outBean.setRspcode("9999");
			outBean.setRspmsg("query exception,pan=1");
		}else{
			Purchase p1 = new Purchase();
			p1.setPan(tib.getPan());
			p1.setPurchAmount(new BigDecimal("1234"));
			p1.setCurrency("CNY");
			p1.setExponent("1");
			p1.setTrsFeeAmount(new BigDecimal("0.22"));
			outBean.getArray().add(p1);
			
			Purchase p2 = new Purchase();
			p2.setPan(tib.getPan());
			p2.setPurchAmount(new BigDecimal("1223"));
			p2.setCurrency("CNY");
			p2.setExponent("1");
			p2.setTrsFeeAmount(new BigDecimal("0.18"));
			outBean.getArray().add(p2);
			
			outBean.setRspcode("0000");
			outBean.setRspmsg("query success");
		}
		return outBean;
	}
	
	public TestOutputBean test(TestInputBean tib)throws AppException{
		System.out.println("Method：test,带返回值方法执行10");
		TestOutputBean outBean = new TestOutputBean();
		outBean.setRspcode("0000");
		outBean.setRspmsg("sucess");
		return outBean;
	}
	
	public void testNoRet(TestInputBean tib) throws AppException{
		System.out.println("Method：testNoRet,不带返回值方法执行20");
//		throw new AppException("","9999","default",null);
	}
	
	public TestOutputBean testNoDeal(TestInputBean tib)throws AppException{
		System.out.println("Method：test,服务端带返回值方法执行30（客户端不处理）");
		TestOutputBean outBean = new TestOutputBean();
		outBean.setRspcode("0000");
		outBean.setRspmsg("sucess");
		return outBean;
	}
}
