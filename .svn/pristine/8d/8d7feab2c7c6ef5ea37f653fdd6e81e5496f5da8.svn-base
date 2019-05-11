package com.gbicc.person.zxrf.opration;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.lang3.StringUtils;

import com.gbicc.bpm.service.ProcessManagerService;
import com.gbicc.person.monitor.entity.TPlReportRelation;
import com.gbicc.person.monitor.entity.TPlTask;
import com.gbicc.person.monitor.service.TPlTaskService;
import com.gbicc.person.zxrf.entity.TPlZxrfInfo;
import com.gbicc.person.zxrf.service.TPlZxrfInfoService;
import com.gbicc.warn.entity.TWarnSignal;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.entity.dao.mng.ROOTDAO;
import com.huateng.ebank.entity.dao.mng.ROOTDAOUtils;
import com.huateng.ebank.entity.data.mng.TlrInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;


/**
 * 
 * @author liufei
 *
 * 版本：2015年11月12日 上午17:34:19
 * 类说明：中小融辅操作类
 */
public class TPlZxrfInfoCalculteOperation extends BaseOperation {
	public static final String ID = "TPlZxrfInfoCalculteOperation";
	public static final String CMD = "CMD";
	public static final String OP = "op";
	public static final String CMD_QUERY = "CMD_QUERY";
	public static final String CMD_INSERT = "CMD_INSERT";
	public static final String CMD_UPDATE = "CMD_UPDATE";
	public static final String CMD_DELETE = "CMD_DELETE";
	public static final String IN_PARAM = "IN_PARAM";
	public static final String WARNING_SIGNALS="WARNING_SIGNALS";
	public static final String BUSINESS_ID = "BUSINESS_ID";
	public static final String OPINION = "opinion";
	
	@Override
	public void afterProc(OperationContext context) throws CommonException {
	}

	@Override
	public void beforeProc(OperationContext context) throws CommonException {
	}

	@Override
	public void execute(OperationContext context) throws CommonException {
//		String businessId = (String) context.getAttribute(BUSINESS_ID);
//		TPlZxrfInfo domain = (TPlZxrfInfo) context.getAttribute(IN_PARAM);
//		List<TWarnSignal> WarnSignals=(List<TWarnSignal>)context.getAttribute(WARNING_SIGNALS);
//		TPlZxrfInfoService service = TPlZxrfInfoService.getInstance();
		//service.update(domain);
		
		//改成在update类中调service
		//this.calculteWarnSigal(businessId, domain,WarnSignals);
		
	}
	
	
	/*
	private void calculteWarnSigal(String businessId,TPlZxrfInfo domain,List<TWarnSignal> WarnSignals){
		try {
			//在此处调用规则，生成规则,保存至warnSignal表中
			//在规则表中无需保存规则结果值。
			
			//多次点击规则时，只保留最新结果
			ROOTDAO rootdao=ROOTDAOUtils.getROOTDAO();
			rootdao.executeSql("DELETE FROM ECUSER.T_PL_WARN_SIGNAL WHERE FD_REPORT_ID='"+domain.getId()+"' ");
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
			String url ="http://10.20.53.14:8080/crew2/common/rule?rulecode=PR0000&rowdate=" + sdf.format(new Date())+"&businessId="+businessId+"&isSynchronize=true";
			HttpClient httpClient =new HttpClient();
			GetMethod get =new GetMethod(url);
			try {
				httpClient.executeMethod(get);
				String response =get.getResponseBodyAsString();
				System.out.println(url);
				if(response!=null && !"".equals(response.trim())){
					System.out.println("执行成功");
				}else{
					System.out.println("执行失败");
				}

			} catch (HttpException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally{
				get.releaseConnection();
			}

			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
//		saveWarnSigalS(WarnSignals, domain);
	}
	
	
	public void saveWarnSigalS(List<TWarnSignal> WarnSignals,TPlZxrfInfo zxrfInfo ){
		ROOTDAO rootdao=ROOTDAOUtils.getROOTDAO();
		String reportId=zxrfInfo.getId();
		try {
			rootdao.executeSql("DELETE FROM ECUSER.T_PL_WARN_SIGNAL WHERE FD_REPORT_ID='"+reportId+"' ");
			if(WarnSignals!=null){
				for(TWarnSignal warnSignal: WarnSignals){
					warnSignal.setId(null);
					warnSignal.setReportId(reportId);
					rootdao.save(warnSignal);
				}
			}
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
*/
	
	
}
