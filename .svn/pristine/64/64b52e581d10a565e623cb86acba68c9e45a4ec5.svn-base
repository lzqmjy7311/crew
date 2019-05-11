package com.huateng.ebank.business.parammng.update;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.parammng.operation.BhProcStepAddOperationNew;
import com.huateng.ebank.entity.data.mng.BhProcStep;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
/**
 * @author weikun wang
 *
 */

public class BhProcStepUpdate extends BaseUpdate{
	//--------------------------------覆盖saveOrUpdate()方法------------------------------------------------------
	public UpdateReturnBean saveOrUpdate(
			MultiUpdateResultBean multiUpdateResultBean,
			HttpServletRequest request, HttpServletResponse response)
			throws AppException {
		try {
			UpdateReturnBean updateReturnBean = new UpdateReturnBean();
			UpdateResultBean updateResultBean = multiUpdateResultBean
					.getUpdateResultBeanByID("parammng_BhProcStep");
			List updateList = new ArrayList();
			List delList = new ArrayList();
			List insertList = new ArrayList();

			while (updateResultBean.hasNext()) {
				BhProcStep bhProcStep = new BhProcStep();
				Map map = updateResultBean.next();
				int jobNo=new Integer(DataFormat.trim((String)map.get("jobno"))).intValue();
				String reportFlag=DataFormat.trim((String)map.get("report_flag"      )) ;
//				if(jobNo!=5&&jobNo!=10&&jobNo!=20&&jobNo!=25&&jobNo!=35&&jobNo!=40&&jobNo!=50){
//					ExceptionUtil.throwCommonException("作业号只能为5,10,20,25,35,40,50", ErrorCode.ERROR_CODE_BHPROC_STEP_PARAM);
//				}
				if(reportFlag.length()<9&&reportFlag.length()>0){
					ExceptionUtil.throwCommonException("报表标志不满足格式:*-*-*-*-*,其中*代表0,1", ErrorCode.ERROR_CODE_BHPROC_STEP_PARAM);
				}
				if(reportFlag.length()==9){
					 int    tmpFlag1=3;//3起到判断作用
					 String tmpFlag2="";
					 int    tmpFlag3=3;
					 String tmpFlag4="";
					 int    tmpFlag5=3;
					 String tmpFlag6="";
					 int    tmpFlag7=3;
					 String tmpFlag8="";
					 int    tmpFlag9=3;
					try{
					  tmpFlag1=Integer.parseInt(reportFlag.substring(0, 1));
					  tmpFlag2=reportFlag.substring(1, 2);
					  tmpFlag3=Integer.parseInt(reportFlag.substring(2, 3));
					  tmpFlag4=reportFlag.substring(3, 4);
					  tmpFlag5=Integer.parseInt(reportFlag.substring(4, 5));
					  tmpFlag6=reportFlag.substring(5, 6);
					  tmpFlag7=Integer.parseInt(reportFlag.substring(6, 7));
					  tmpFlag8=reportFlag.substring(7, 8);
					  tmpFlag9=Integer.parseInt(reportFlag.substring(8, 9));
					 }catch(Exception ex){
						 ExceptionUtil.throwCommonException("报表标志不满足格式:*-*-*-*-*,其中*代表0,1", ErrorCode.ERROR_CODE_BHPROC_STEP_PARAM);
					 }
					 if((tmpFlag1!=0&&tmpFlag1!=1)||(tmpFlag3!=0&&tmpFlag3!=1)||(tmpFlag5!=0&&tmpFlag5!=1)||(tmpFlag7!=0&&tmpFlag7!=1)||(tmpFlag9!=0&&tmpFlag9!=1)||tmpFlag2.equals("-")==false||tmpFlag4.equals("-")==false||tmpFlag6.equals("-")==false||tmpFlag8.equals("-")==false){
						 ExceptionUtil.throwCommonException("报表标志不满足格式:*-*-*-*-*,其中*代表0,1", ErrorCode.ERROR_CODE_BHPROC_STEP_PARAM);
					 }
				}
				switch (updateResultBean.getRecodeState()) {
				case UpdateResultBean.INSERT:
					if(jobNo!=5&&jobNo!=10&&jobNo!=20&&jobNo!=25&&jobNo!=35&&jobNo!=40&&jobNo!=50){
					ExceptionUtil.throwCommonException("作业号只能为5,10,20,25,35,40,50", ErrorCode.ERROR_CODE_BHPROC_STEP_PARAM);
				    }
					bhProcStep.setJobno          (new Integer(jobNo))   ;
					bhProcStep.setStep           (Integer.valueOf(DataFormat.trim((String)map.get("step"           )) ))   ;
					bhProcStep.setSubStep        (Integer.valueOf(DataFormat.trim((String)map.get("sub_step"        ))) )   ;
					bhProcStep.setProcessFunction(DataFormat.trim((String)map.get("process_function" )) )   ;
					bhProcStep.setProcessParam   (DataFormat.trim((String)map.get("process_param"    )) )   ;
					bhProcStep.setProcessTlrno   (DataFormat.trim((String)map.get("process_tlrno"    )) )   ;
					bhProcStep.setRuntime        (DataFormat.trim((String)map.get("runtime"          )) )   ;
					bhProcStep.setSubFlag        (DataFormat.trim((String)map.get("sub_flag"         )) )   ;
					bhProcStep.setReportFlag     (reportFlag)   ;
					bhProcStep.setMaxproc        (Integer.valueOf((String)map.get("maxproc"        ) ))   ;
					bhProcStep.setTempFlag       (DataFormat.trim((String)map.get("temp_flag"        )) )   ;
					bhProcStep.setSuspend        (DataFormat.trim((String)map.get("suspend"         )) )   ;
					//mod by kangbyron 2011-03-16 解决编译错误
//					bhProcStep.setSingleFlag     (DataFormat.trim((String)map.get("single_flag"      )) )   ;
					bhProcStep.setDesc0           (DataFormat.trim((String)map.get("desc"            )) )   ;
					bhProcStep.setDesc1          (DataFormat.trim((String)map.get("desc1"           )) )   ;
					bhProcStep.setDesc2          (DataFormat.trim((String)map.get("desc2"           )) )   ;
					insertList.add(bhProcStep);
					break;
				case UpdateResultBean.DELETE:
					bhProcStep.setId             (Integer.valueOf(DataFormat.trim((String)map.get("id"             )) ))   ;
//					bhProcStep.setJobno          (Integer.valueOf(DataFormat.trim((String)map.get("jobno"          ))) )   ;
//					bhProcStep.setStep           (Integer.valueOf(DataFormat.trim((String)map.get("step"           )) ))   ;
//					bhProcStep.setSubStep        (Integer.valueOf(DataFormat.trim((String)map.get("sub_step"        )) ))   ;
//					bhProcStep.setProcessFunction(DataFormat.trim((String)map.get("process_function" )) )   ;
//					bhProcStep.setProcessParam   (DataFormat.trim((String)map.get("process_param"    )) )   ;
//					bhProcStep.setProcessTlrno   (DataFormat.trim((String)map.get("process_tlrno"    )) )   ;
//					bhProcStep.setRuntime        (DataFormat.trim((String)map.get("runtime"          )) )   ;
//					bhProcStep.setSubFlag        (DataFormat.trim((String)map.get("sub_flag"         )) )   ;
//					bhProcStep.setReportFlag     (DataFormat.trim((String)map.get("report_flag"      )) )   ;
//					bhProcStep.setMaxproc        (Integer.valueOf(DataFormat.trim((String)map.get("maxproc"        )) ))   ;
//					bhProcStep.setTempFlag       (DataFormat.trim((String)map.get("temp_flag"        )) )   ;
//					bhProcStep.setSuspend        (DataFormat.trim((String)map.get("suspend"         )) )   ;
//					bhProcStep.setSingleFlag     (DataFormat.trim((String)map.get("single_flag"      )) )   ;
//					bhProcStep.setDesc           (DataFormat.trim((String)map.get("desc"            )) )   ;
//					bhProcStep.setDesc1          (DataFormat.trim((String)map.get("desc1"           )) )   ;
//					bhProcStep.setDesc2          (DataFormat.trim((String)map.get("desc2"           )) )   ;
					delList.add(bhProcStep);
					break;
				case UpdateResultBean.MODIFY:
					if(jobNo!=5&&jobNo!=10&&jobNo!=20&&jobNo!=25&&jobNo!=35&&jobNo!=40&&jobNo!=50){
					ExceptionUtil.throwCommonException("作业号只能为5,10,20,25,35,40,50", ErrorCode.ERROR_CODE_BHPROC_STEP_PARAM);
				    }
					bhProcStep.setId             (Integer.valueOf(DataFormat.trim((String)map.get("id"             ))) )   ;
					bhProcStep.setJobno          (Integer.valueOf(DataFormat.trim((String)map.get("jobno"          ))) )   ;
					bhProcStep.setStep           (Integer.valueOf(DataFormat.trim((String)map.get("step"           ))) )   ;
					bhProcStep.setSubStep        (Integer.valueOf(DataFormat.trim((String)map.get("sub_step"        )) ))   ;
					bhProcStep.setProcessFunction(DataFormat.trim((String)map.get("process_function" )) )   ;
					bhProcStep.setProcessParam   (DataFormat.trim((String)map.get("process_param"    )) )   ;
					bhProcStep.setProcessTlrno   (DataFormat.trim((String)map.get("process_tlrno"    )) )   ;
					bhProcStep.setRuntime        (DataFormat.trim((String)map.get("runtime"          )) )   ;
					bhProcStep.setSubFlag        (DataFormat.trim((String)map.get("sub_flag"         )) )   ;
					bhProcStep.setReportFlag     (DataFormat.trim((String)map.get("report_flag"      )) )   ;
					bhProcStep.setMaxproc        (Integer.valueOf(DataFormat.trim((String)map.get("maxproc"        ) )))   ;
					bhProcStep.setTempFlag       (DataFormat.trim((String)map.get("temp_flag"        )) )   ;
					bhProcStep.setSuspend        (DataFormat.trim((String)map.get("suspend"         )) )   ;
					//mod by kangbyron 2011-03-16 解决编译错误
//					bhProcStep.setSingleFlag     (DataFormat.trim((String)map.get("single_flag"      )) )   ;
//					bhProcStep.setDesc           (DataFormat.trim((String)map.get("desc"            )) )   ;
					bhProcStep.setDesc1          (DataFormat.trim((String)map.get("desc1"           )) )   ;
					bhProcStep.setDesc2          (DataFormat.trim((String)map.get("desc2"           )) )   ;
					updateList.add(bhProcStep);
					break;
				default:
					break;
				}
			}
			OperationContext oc = new OperationContext();
			//mod by kangbyron 2011-03-16 解决编译错误
			oc.setAttribute(BhProcStepAddOperationNew.IN_DEL, delList);
			oc.setAttribute(BhProcStepAddOperationNew.IN_INSERT, insertList);
			oc.setAttribute(BhProcStepAddOperationNew.IN_UPDATE, updateList);
			OPCaller.call("parammng.BhProcStepAddOperationNew", oc);
			return updateReturnBean;
//		} catch (AppException appEx) {
//			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}
}
