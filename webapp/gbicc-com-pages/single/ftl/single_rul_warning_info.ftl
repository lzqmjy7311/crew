<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />

<#assign businessId=RequestParameters["businessId"]?default("")>

<@CommonQueryMacro.page title="������Ԥ������">
<table>
	<tr>
		<td>
			<@CommonQueryMacro.CommonQuery id="SingleRulWarningInfo" init="true" submitMode="current">
				<@CommonQueryMacro.Group id="SingleRulWarningGroup" label="" colNm=4 labelwidth="150"
				fieldStr="fcettypecode,fcetname,rulCode,rulType,warnStatus,rulName,warnDt,mainOrg,warnDesc"/>
			</@CommonQueryMacro.CommonQuery>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DynamicTabSet id="BusinInfoTab" hasMenu="false" fit="false" height="350" width="1270" selected="A01">
		    </@CommonQueryMacro.DynamicTabSet>
		</td>
	</tr>
	
	
</table>
<script>
	//ҳ���ʼ��
	function initCallGetter_post(){
		var businessId='${businessId}';
		SingleRulWarningInfo_dataset.setParameter("id",businessId);
		SingleRulWarningInfo_dataset.flushData(SingleRulWarningInfo_dataset.pageIndex);
		
		//������TABҳ
		var OUTPUT={
			A01:{id:"A01",title:"��������ˮ",url:"/gbicc-com-pages/single/output_ftl/a01.ftl?warningId="+businessId},
			A30:{id:"A30",title:"�鶳�۵Ǽǲ�",url:"/gbicc-com-pages/single/output_ftl/a30.ftl?warningId="+businessId},
			A38:{id:"A38",title:"�жһ�Ʊ��Ϣ",url:"/gbicc-com-pages/single/output_ftl/a38.ftl?warningId="+businessId},
			B01:{id:"B01",title:"��Ȼ�˽����Ϣ",url:"/gbicc-com-pages/single/output_ftl/b01.ftl?warningId="+businessId},
			C01:{id:"C01",title:"�Թ���������ϸ",url:"/gbicc-com-pages/single/output_ftl/c01.ftl?warningId="+businessId},
			C02:{id:"C02",title:"�Թ��������ϸ",url:"/gbicc-com-pages/single/output_ftl/c02.ftl?warningId="+businessId},
			C03:{id:"C03",title:"�Ŵ���ͬ",url:"/gbicc-com-pages/single/output_ftl/c03.ftl?warningId="+businessId},
			C05:{id:"C05",title:"�Թ����ֵǼǲ�",url:"/gbicc-com-pages/single/output_ftl/c05.ftl?warningId="+businessId},
			C06:{id:"C06",title:"�Ŵ�֧��������ϸ",url:"/gbicc-com-pages/single/output_ftl/c06.ftl?warningId="+businessId},
			C08:{id:"C08",title:"�Թ�����Ѻ�����������ˮ",url:"/gbicc-com-pages/single/output_ftl/c08.ftl?warningId="+businessId},
			C09:{id:"C09",title:"Ʊ����Ϣ",url:"/gbicc-com-pages/single/output_ftl/c09.ftl?warningId="+businessId},
			C11:{id:"C11",title:"����������Ϣ",url:"/gbicc-com-pages/single/output_ftl/c11.ftl?warningId="+businessId},
			C12:{id:"C12",title:"����Ʊ����ת��Ϣ",url:"/gbicc-com-pages/single/output_ftl/c12.ftl?warningId="+businessId},
			C13:{id:"C13",title:"��������Ϣ",url:"/gbicc-com-pages/single/output_ftl/c13.ftl?warningId="+businessId},
			C14:{id:"C14",title:"����Ȧ��Ϣ",url:"/gbicc-com-pages/single/output_ftl/c14.ftl?warningId="+businessId},
			C15:{id:"C15",title:"�ͻ�ָ����Ϣ",url:"/gbicc-com-pages/single/output_ftl/c15.ftl?warningId="+businessId},
			C16:{id:"C16",title:"��Ȼ���˻���Ϣ",url:"/gbicc-com-pages/single/output_ftl/c16.ftl?warningId="+businessId},
			J02:{id:"J02",title:"�Թ��ͻ���Ϣ",url:"/gbicc-com-pages/single/output_ftl/j02.ftl?warningId="+businessId},
			J04:{id:"J04",title:"��˽�ͻ���Ϣ",url:"/gbicc-com-pages/single/output_ftl/j04.ftl?warningId="+businessId},
			J09:{id:"J09",title:"Ա����Ϣ",url:"/gbicc-com-pages/single/output_ftl/j09.ftl?warningId="+businessId},
			J16:{id:"J16",title:"����˻���Ϣ",url:"/gbicc-com-pages/single/output_ftl/j16.ftl?warningId="+businessId},
			J17:{id:"J17",title:"�Ӻ�ͬ��Ϣ",url:"/gbicc-com-pages/single/output_ftl/j17.ftl?warningId="+businessId},
			J18:{id:"J18",title:"�Ŵ���˾�ͻ���Ϣ",url:"/gbicc-com-pages/single/output_ftl/j18.ftl?warningId="+businessId},
			L01:{id:"L01",title:"�ⲿ������Ϣ",url:"/gbicc-com-pages/single/output_ftl/l01.ftl?warningId="+businessId},
			L02:{id:"L02",title:"���̱����ϸ",url:"/gbicc-com-pages/single/output_ftl/l02.ftl?warningId="+businessId},
			L03:{id:"L03",title:"���̴�����ϸ",url:"/gbicc-com-pages/single/output_ftl/l03.ftl?warningId="+businessId},
			L04:{id:"L04",title:"��ͥ������Ϣ",url:"/gbicc-com-pages/single/output_ftl/l04.ftl?warningId="+businessId},
			L05:{id:"L05",title:"�о�������Ϣ",url:"/gbicc-com-pages/single/output_ftl/l05.ftl?warningId="+businessId},
			L11:{id:"L11",title:"��ҵ������Ϣ",url:"/gbicc-com-pages/single/output_ftl/l11.ftl?warningId="+businessId},
			L12:{id:"L12",title:"����������Ϣ",url:"/gbicc-com-pages/single/output_ftl/l12.ftl?warningId="+businessId},
			L13:{id:"L13",title:"�����ļ���Ϣ",url:"/gbicc-com-pages/single/output_ftl/l13.ftl?warningId="+businessId},
			L14:{id:"L14",title:"��������Ϣ",url:"/gbicc-com-pages/single/output_ftl/l14.ftl?warningId="+businessId},
			L15:{id:"L15",title:"���ܺ���Ϣ",url:"/gbicc-com-pages/single/output_ftl/l15.ftl?warningId="+businessId},
			L16:{id:"L16",title:"��ҵ����δ���������Ϣ",url:"/gbicc-com-pages/single/output_ftl/l16.ftl?warningId="+businessId},
			L17:{id:"L17",title:"��ҵ����δ����жһ�Ʊ��Ϣ",url:"/gbicc-com-pages/single/output_ftl/l17.ftl?warningId="+businessId}
		}
		var halfresult=SingleRulWarningInfo_dataset.getValue("halfresult");
		if(halfresult!=null && halfresult!=""){
			var ids=halfresult.split("|");
			for(var i=0;i<ids.length;i++){
				if(ids[i] && OUTPUT[ids[i]]!=null){
					BusinInfoTab_tabset.add(OUTPUT[ids[i]]);
				}
			}
		}	
	}
	
	//ˢ�µ�ǰҳ
	function flushCurrentPage() {
		SingleRulWarningInfo_dataset.flushData(SingleRulWarningInfo_dataset.pageIndex);
	}

</script>
<script type='text/javascript' src='${contextPath}/dwr/interface/TaskVariable.js'> </script>
<script type="text/javascript" src="${contextPath}/gbicc-pages/jquery-form.js"></script>
</@CommonQueryMacro.page>