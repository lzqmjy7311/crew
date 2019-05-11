package com.huateng.fs.micro.demo.test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.huateng.flowswitch.micro.common.Context;
import com.huateng.flowswitch.micro.ctl.ClientFactory;
import com.huateng.flowswitch.micro.model.server.base.IClient;
import com.huateng.fs.micro.demo.bean.Merchant;
import com.huateng.fs.micro.demo.bean.Purchase;
import com.huateng.fs.micro.demo.bean.TestInputBean;
import com.huateng.fs.micro.demo.bean.TestOutputBean;
public class ClientTestCase extends BaseTestCase {
	
	//10、20,30对应服务端处理交易码
	public final static Map<String, String> map = new HashMap<String, String>(){
		{
			this.put("10", "SocketXMLClientTest");//服务端带有返回值
			this.put("20", "SocketXMLClientNotOut");//服务端及客户端不带返回值
			this.put("30", "SocketXMLClientNotOut");//服务端带返回值，客户端不处理返回值,
		}
	};
	
	public void testClient(){
		try{
			String xmlType = "30";
			IClient client = ClientFactory.getInstance().getEntry(map.get(xmlType));
			TestInputBean inputBean = new TestInputBean();
			inputBean.setVersion("10");
			inputBean.setXtype(xmlType);
			inputBean.setXclass("1");
			inputBean.setPan("1111111111111111119");
			Context ctx =client.doProcess(inputBean);
//			assertTrue(ctx.isSuccess());
			if(xmlType.equals("10")){
				TestOutputBean tob = (TestOutputBean)ctx.getInBean();
				System.out.print(tob.toString());
			}else{
				System.out.println(ctx.isSuccess());
				if(!ctx.isSuccess()){
					System.out.println(ctx.getFailBean().toString());
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
			assertTrue(false);
		}
	}

}
