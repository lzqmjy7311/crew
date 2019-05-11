package com.huateng.fs.micro.demo.test;

import java.math.BigDecimal;

import com.huateng.flowswitch.micro.common.Constants;
import com.huateng.flowswitch.micro.util.MessgeProcess;
import com.huateng.fs.micro.demo.bean.Merchant;
import com.huateng.fs.micro.demo.bean.Purchase;
import com.huateng.fs.micro.demo.bean.TestInputBean;

public class MessageTestCase extends BaseTestCase{
	public void testClient(){
		try{
			String xmlType = "20";
			TestInputBean inputBean = new TestInputBean();
			inputBean.setVersion("10");
			inputBean.setXtype(xmlType);
			inputBean.setXclass("1");
			inputBean.setPan("1111111111111111119");
			inputBean.setTestAttr("测试属性值");
			Merchant m = new Merchant();
			m.setAcqBIN("1");
			m.setMerID("1");
			m.setPassword("11111118");
			m.setName("name");
			m.setCountry("CNY");
			inputBean.setMerchant(m);
			Purchase p = new Purchase();
			p.setCurrency("RMB");
			p.setPurchAmount(new BigDecimal("100000"));
			p.setExponent("1");
			p.setPurchAmount(new BigDecimal("200000"));
			inputBean.getArray().add(p);
			
			//定长字符串(忽略属性配置)
			System.out.println("**********************String**********************");
			MessgeProcess procString = new MessgeProcess(Constants.MESSAGEG_TYPE_STRING);
			String tmsg = "10                  20111111111111111111191          1                       11111118TEST                     CNY000000200000RMB1000000000";
			String retmsg = procString.beanToMessage("CEReq_Attr", inputBean);
			System.out.println("String beanToMessage："+retmsg);
			TestInputBean retBean = procString.messageToBean(tmsg, "CEReq_Attr", TestInputBean.class);
			System.out.println("String messageToBean："+retBean.getMerchant().getName());
			
			
			System.out.println("**********************XML**********************");
			MessgeProcess procXml = new MessgeProcess(Constants.MESSAGEG_TYPE_XML);
			String retmsgXml = procXml.beanToMessage("CEReq_Attr", inputBean);
			System.out.println("XML beanToMessage："+retmsgXml);
			
//			String tmsg = "<CEReq><version>10</version><xtype>20</xtype><xclass>1</xclass><pan>1111111111111111119</pan><Merchant><acqBIN>1</acqBIN><merID>测试MERID</merID><password>11111118</password><name>TEST</name><country>CNY</country></Merchant><array><Purchase><purchAmount>000000200000</purchAmount><currency>RMB</currency><exponent>1</exponent><trsFeeAmount>000000000</trsFeeAmount></Purchase></array></CEReq>";
			String tmsgXml = "<CEReq testAttr=\"测试属性值ceshisisiss\"><version vertest=\"10\" testAttr-2=\"10\"></version><xtype>20</xtype><xclass>1</xclass><pan></pan><Merchant testAttr-b=\"1111111111111111119\"><acqBIN>1</acqBIN><merID>1</merID><password>11111118</password><name>name</name><country>CNY</country></Merchant><array testAttr-a=\"1\"><Purchase testAttr-ab=\"1\"><purchAmount>000000200000</purchAmount><currency>RMB</currency><exponent>1</exponent><trsFeeAmount>000000000</trsFeeAmount></Purchase></array></CEReq>";
			TestInputBean retBeanxml = procXml.messageToBean(tmsgXml, "CEReq_Attr", TestInputBean.class);
			System.out.println("XML messageToBean："+retBeanxml.getTestAttr());
		}catch(Exception e){
			e.printStackTrace();
			assertTrue(false);
		}
	}
}
