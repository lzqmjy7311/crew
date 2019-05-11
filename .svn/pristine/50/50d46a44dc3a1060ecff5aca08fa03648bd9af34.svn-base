package com.gbicc.company.warnDisposal.operation;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.gbicc.company.warnDisposal.entity.TCmWarnTaskRel;
import com.gbicc.company.warnDisposal.service.TCmWarnTaskRelService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

public class TCmWarnTaskRelOperation extends BaseOperation {

	public static final String ID = TCmWarnTaskRelOperation.class.getSimpleName();
	public static final String CMD = "CMD";
	public static final String CMD_QUERY = "CMD_QUERY";
	public static final String CMD_INSERT = "CMD_INSERT";
	public static final String CMD_UPDATE = "CMD_UPDATE";
	public static final String CMD_DELETE = "CMD_DELETE";
	public static final String IN_PARAM = "IN_PARAM";
	
	@Override
	public void afterProc(OperationContext context) throws CommonException {
	}

	@Override
	public void beforeProc(OperationContext context) throws CommonException {
	}

	@Override
	public void execute(OperationContext context) throws CommonException {
		String cmd = (String) context.getAttribute(CMD);
		TCmWarnTaskRel dd = (TCmWarnTaskRel) context.getAttribute(IN_PARAM);
		TCmWarnTaskRelService service = TCmWarnTaskRelService.getInstance();
		if (CMD_QUERY.equals(cmd)) {
		} else if (CMD_INSERT.equals(cmd)) {
			service.save(dd);
		} else if (CMD_UPDATE.equals(cmd)) {
			service.update(dd);
		} else if (CMD_DELETE.equals(cmd)) {
			service.delete(dd.getId());
		}
		
	}
	
	public static void main(String[] args) throws IOException, MessagingException {
//		BASE64Encoder encode = new BASE64Encoder();
//		System.out.println("输入：");
//		String uname=new BufferedReader(new InputStreamReader(System.in)).readLine();
//		System.out.println("uname:"+uname);
//		System.out.println("unameencode:"+encode.encode(uname.getBytes()));
		
		Session session=Session.getInstance(new Properties());
		MimeMessage msg=new MimeMessage(session);
		
		MimeMultipart magMultipart=new MimeMultipart("multipart/mixed");
		msg.setContent(magMultipart);
		
		MimeBodyPart attch1 = new MimeBodyPart();
		MimeBodyPart attch2 = new MimeBodyPart();
		MimeBodyPart content = new MimeBodyPart();
		magMultipart.addBodyPart(attch1);
		magMultipart.addBodyPart(attch2);
		magMultipart.addBodyPart(content);
		
		DataSource ds1 = new FileDataSource("D://AA.txt");
		DataHandler dh1 = new DataHandler(ds1);
		attch1.setDataHandler(dh1);
		
		DataSource ds2 = new FileDataSource("D://BB.txt");
		DataHandler dh2 = new DataHandler(ds2);
		attch1.setDataHandler(dh2);
		
		MimeMultipart bodymu= new MimeMultipart("multipart/related");
		content.setContent(bodymu);
		MimeBodyPart htmlpart=new MimeBodyPart();
		MimeBodyPart gifhtml=new MimeBodyPart();
		bodymu.addBodyPart(htmlpart);
		bodymu.addBodyPart(gifhtml);
		
		
		DataSource gfds = new FileDataSource("D:/");
		DataHandler gfdh = new DataHandler(gfds);
		gifhtml.setDataHandler(gfdh);
		//gifhtml.setHeader("Con", value);
		
		htmlpart.setContent("", "text/html;charset=gbk;");
		
		msg.saveChanges();
		OutputStream in = new FileOutputStream("");
		msg.writeTo(in);
		in.close();
	}

}
