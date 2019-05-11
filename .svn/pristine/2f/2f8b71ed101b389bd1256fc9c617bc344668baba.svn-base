package com.huateng.fs.micro.demo.test;

import com.huateng.flowswitch.micro.common.Context;
import com.huateng.flowswitch.micro.ctl.ChannelFactory;
import com.huateng.flowswitch.micro.model.channel.base.IChannel;

public class ApiTestCase  extends BaseTestCase {
	public void testClient() {
		try {
			//交易为10返回值,20不带返回值
			String xtype = "20";//交易码
			IChannel channel = ChannelFactory.getInstance().getEntry("ApiServerChannel");
			String reqmsg = "<?xml version=\"1.0\" encoding=\"gb18030\"?><CEReq><version>10                  </version><xtype>"+xtype+"</xtype><xclass>1</xclass><pan>1111111111111111119</pan><Merchant><acqBIN>1          </acqBIN><merID>1                       </merID><password>11111118</password><name>name                     </name><country>CNY</country></Merchant><array><Purchase><purchAmount>000000200000</purchAmount><currency>RMB</currency><exponent>1</exponent><trsFeeAmount>000000000</trsFeeAmount></Purchase></array></CEReq>";
			Context ctx = channel.process(reqmsg);
			if(ctx.getInTxnCode().equals("20")){
				if(!ctx.isSuccess()){
					System.out.println(ctx.getOutErrMsg());;
				}else{
					System.out.println("exec success!");
				}
			}else{
				if(ctx.isSuccess()){
					System.out.println(ctx.getOutMsg());
				}else{
					System.out.println(ctx.getOutErrMsg());
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
