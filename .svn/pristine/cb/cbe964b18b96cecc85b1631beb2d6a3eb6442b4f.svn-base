<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<#assign customerNum=RequestParameters["customerNum"]?default("")>
<@CommonQueryMacro.page title="风险概览">
<style>
	div.divform1{
		border:1px solid black;
		min-width:1200px;
		min-height:800px;
		margin:20px 20px 20px 20px;
		float:none;
		clear:both;
	}
	div.divform2{
		width:48%;
		height:340px;
		float:left;
		margin:10px 20px 0 0;
		text-align:center;
	}
	div.divform3{
		width:46%;
		height:260px;
		float:left;
		text-align:left;
		margin: 0 0 0 50px;
		padding:50px 0 0 0
	}
	div.divform4{
		width:32.5%;
		height:360px;
		float:left;
		border:1px solid #416AA3;
		margin:20px 0 10px 5px;
		text-align:center;
		padding:15px 0 30px 0
	}
	span.form{
		font-size:140%;
		font-weight:bold;
		margin-left:30px;
	}
	div.fxsm{
		margin:0px 10px 0 0;
		width:350px;
	}
	div.tjqj{
		margin:0 0 0 20px;
	}
	div.hrdiv{
		width:1100px;
		height:1px;
		border-top:1px solid #E5E5E5;
		margin-bottom:5px
	}	
</style>
<div class="divform1">
	<div id="1" class="divform2">雷达图</div>
	<div class="divform3"><span class="form">分析说明:</span><br/>
		<div style="margin:20px 0 0 0"></div>
		<@CommonQueryMacro.CommonQuery id="zwt" init="true" submitMode="current">
		<div class="fxsm" align="right"><@CommonQueryMacro.GroupField fId="fiveCore" /></div><br>
		<div class="fxsm" align="right"><@CommonQueryMacro.GroupField fId="importChange"/></div><br>
		<div class="fxsm" align="right"><@CommonQueryMacro.GroupField fId="dataCheck" /></div><br>
		<div class="fxsm" align="right"><@CommonQueryMacro.GroupField fId="riskLevel" /></div><br>
		<div class="fxsm" align="right"><@CommonQueryMacro.GroupField fId="bz" /></div><br>
	</div>
	<div style="margin:10px 0 0 0">&nbsp;</div>
	<div style="margin:0 33% 0 0" align="right"><input  type="checkbox" name="flag" value="yes"/>剔除已风险排除的预警</div>
	<div style="clear:both"></div>
	<div class="hrdiv"></div>
	<@CommonQueryMacro.ToolBar id="mytoolbar">
	<div style="clear:both;float:none"></div>
	<div  class="divform4">
		<div style="margin:0 0 20px 0 ">
			<center>统计区间：<@CommonQueryMacro.InterfaceElement elId="startDt" isSingle="true"/>-<@CommonQueryMacro.InterfaceElement elId="endDt" isSingle="true"/>
			</center>
			<div style="margin:10px 0 0 10px">
				<@CommonQueryMacro.Button id="btQuerytwo"/>
			</div>
		</div>
		<div style="height:280px" id='2'>
			预警分布情况	
		</div>
	</div>
	<div  class="divform4">
		<div style="margin:10px 0 40px 0">
			<center>
				<@CommonQueryMacro.InterfaceElement elId="koujing" isSingle="false"/><@CommonQueryMacro.Button id="koujingbtQueryt"/>
			</center>
		</div>
		<div style="height:280px;padding:2px 2px 2px 2px" id='3'>
			预警数量统计	
		</div>
	</div>
	<div  class="divform4">
		<div style="height:280px;margin:50px 0 0 0" id='4'>
			预警等级趋势
		</div>
	</div>
	</@CommonQueryMacro.ToolBar>
	</@CommonQueryMacro.CommonQuery>
</div>
	<@CommonQueryMacro.CommonQuery id="riskoverview" init="false" submitMode="current">
		<@CommonQueryMacro.Interface id="interface1" label="请输入查询条件" showButton="false"/>
		<div style="text-align:center">
			<@CommonQueryMacro.Button id="btQuery" /><@CommonQueryMacro.Button id="btReset"/>
		</div>
      	<div id="table1">
			<div style="margin:10px 20px 3px 10px;text-align:right">
					<a href="javascript:btMore_onClick()">更多>>></a>
			</div>
	        <@CommonQueryMacro.DataTable id="riskoverviewTable1" rownumbers="false" readonly="true"  pagination="false" fieldStr="warnCode,taskCode,warnDt,rulName[170],rulThemeCd,fdDesc[300],warnStatus,eliminateDt,warningRelieveDt,handler" width="100%"/>
      	</div>
      	<div id="table2" >
	      	<div style="margin:10px 20px 3px 10px;text-align:right">
				<a href="javascript:btMore1_onClick()">返回&lt;&lt;&lt;</a>
		  	</div>
	        <@CommonQueryMacro.DataTable id="riskoverviewTable2" rownumbers="false" readonly="true"   pagination="true" fieldStr="warnCode,taskCode,warnDt,rulName[170],rulThemeCd,fdDesc[300],warnStatus,eliminateDt,warningRelieveDt,handler" width="100%"/>
     	</div>
	   	<div style="margin:50px"></div>
	</@CommonQueryMacro.CommonQuery>
	<!-- javascript -->
	<script type="text/javascript" src="${contextPath}/gbicc-pages/jquery-form.js"></script>
	<script src="${contextPath}/templets/ui/js/chart/highcharts.js"></script>
	<script src="${contextPath}/templets/ui/js/chart/highcharts-more.js"></script>
<script>
	var flag='true';
	var queryflag="false";
	var customerNum = "${RequestParameters["customerNum"]?default('')}";
	var strDate1;
	var strDate;
	var divline;
	function initCallGetter_post(){
		strDate1='1';
		$('#table2').css('display','none');
		<!-- 客户风险雷达图 --> 
		var type='ldt';
		var customerNum='${customerNum}';
		$.messager.progress({title:'请稍候',msg:'正在载入...'});
		$.ajax({
			url :"${contextPath}/char/riskoverviewHigtCharServlet",
	        type : "post",
			data:{
				customerNum:customerNum,
				type:type,
				startDt:strDate1,
				endDt:strDate
			},
			success:function(data){
				var dataJson=eval("("+data+")");
				$('div#1').highcharts({  
			        chart:{  
			          	polar:true,
			          	type:'line'
			        },  
			        credits:{
			        	text:'',
			        	href:''
			        },
			        title:{  
			            text: '客户风险雷达图',						//主表题  
			            x: -80 //center  
			        },  
			        xAxis:{   										//横坐表  
			        	categories: dataJson.listXdata,  			//动态解析
			        	tickmarkPlacement:'on',
			        	lineWidth:0
			        },  
			     	yAxis:{  
						gridLineInterpolation:'polygon',
						lineWidth:0,
						min:0,
						tickInterval:2,
						max:10,
			       	},  
			    	pane:{
			    		size:'80%'
			    	},
			      	tooltip: { 										//数据点的提示框  
						shared:false,
						pointFormat:'<span style="color:{series.color}">\u25CF<\span> {series.name}:<b>{point.y}</b><br/>'
			        },  
			        legend: {  
			     		layout: 'vertical',  
			        	align: 'left',  
			          	verticalAlign: 'top',   
			           	y:70
			       	},   
			        series:dataJson.data  							//动态解析
				 });
				 <!-- 预警等级趋势--> 
				    
				 $('div#4').highcharts({  
				        chart:{  
				             type: 'line',							//图表的显示类型（line,spline,scatter,splinearea bar,pie,area,column）  
				        },  
				        title:{  
				            text: '预警等级趋势',					//主标题  
				                
				        },  
				        xAxis: {   									//横坐标  
			               	categories: dataJson.listXdata3 		//动态解析
				        },  
				        yAxis: { 
				        	text:'等级值',
							min:0,
							maxTickInterval:4,
							tickInterval:1,
							minTickInterval:0,
							max:4,
							plotBands:[{from:0,to:1,color:'green'},{from:1,to:2,color:'yellow'},{from:2,to:3,color:'#FFA500'},{from:3,to:4,color:'red'}]
				       	}, 
						credits:{
					        text:'',
					        href:''
						},
				        tooltip:{
				        	enabled:false
				        },
				        legend:{enabled:true},
				    	series:dataJson.data3						//动态解析
			    	}); 
				$.messager.progress('close');
			}
		});
		sjt('00000000','00000000');
		sjt1('708');
		zwt_interface_dataset.setValue("koujing",'708');
		zwt_dataset.setValue("bz","五要素预警得分值越大风险越高;\n数据来源为空将导致数据验真不通过;");
	}
//	function warningtype_DropDown_onSelect(dropDown,record,editor){
//		var val = record.getValue("data");
//		if(val==0){
//			riskoverview_interface_dataset.setFieldReadOnly("rulTheme",false);
//		}else{
//			riskoverview_interface_dataset.setFieldReadOnly("rulTheme",true);
//		}
//		return true;
//	}
	function btReset_onClick(){
		riskoverview_interface_dataset.clearData();
		riskoverview_dataset.clearData();
		queryflag='false';
	}
	function btQuery_onClick(){
		queryflag='true';
		var warningtype=riskoverview_interface_dataset.getValue("warningtype");
		var warnCode=riskoverview_interface_dataset.getValue("warnCode");
		var rulName=riskoverview_interface_dataset.getValue("rulName");
		var rulTheme=riskoverview_interface_dataset.getValue("rulTheme");
		var warnDt=riskoverview_interface_dataset.getValue("warnDt");
		var endwarnDt=riskoverview_interface_dataset.getValue("endwarnDt");
		var warnStatus=riskoverview_interface_dataset.getValue("warnStatus");

		riskoverview_dataset.setParameter("warningtype",warningtype);
		riskoverview_dataset.setParameter("warnCode",warnCode);
		riskoverview_dataset.setParameter("rulName",rulName);
		riskoverview_dataset.setParameter("rulTheme",rulTheme);
		riskoverview_dataset.setParameter("warnDt",warnDt);
		riskoverview_dataset.setParameter("endwarnDt",endwarnDt);
		riskoverview_dataset.setParameter("warnStatus",warnStatus);
		riskoverview_dataset.setParameter("customerNum",customerNum);
		btMore1_onClick();
	}
	//按下统计区间按钮
	function btQuerytwo_onClick(){
		var startDt=zwt_interface_dataset.getValue("startDt");
		var endDt=zwt_interface_dataset.getValue("endDt");
		if(startDt==''||endDt=='')
			{alert("请输入查询日期！");
			return false;
		}
		if(startDt==null||endDt==null)
		{
			alert("请输入查询日期！");
			return false;
		}
		sjt(startDt,endDt);
	}
	//按下口径按钮
	function koujingbtQueryt_onClick(){
		var koujing=zwt_interface_dataset.getValue("koujing");
		if(koujing==''||koujing==null)
		{
			alert("请输入统计方式！");
			return false;
		}
		sjt1(koujing);
	}
	//处理
	function btMore_onClick(){
		if(queryflag=='true'){
			$('#table1').css('display','none');
			$('#table2').css('display','block');
			riskoverview_dataset.setParameter("flag","false");
			riskoverview_dataset.setParameter("customerNum",customerNum);
			riskoverview_dataset.flushData(riskoverview_dataset.pageIndex);	
		}
	}
	function btMore1_onClick(){
		if(queryflag=='true'){
			$('#table1').css('display','block');
			$('#table2').css('display','none');
			riskoverview_dataset.setParameter("flag","true");
			riskoverview_dataset.flushData(riskoverview_dataset.pageIndex);	
		}
	}
	function sjt(startDt,endDt){
		var type='yjfb';
		var customerNum='${customerNum}';
		var flag=$('input:checkbox[name="flag"]').is(":checked");
		$.messager.progress({title:'请稍候',msg:'正在载入...'});
		$.ajax({
			url :"${contextPath}/char/riskoverviewHigtCharServlet",
	        type : "post",
			data:{
				customerNum:customerNum,
				type:type,
				startDt:startDt,
				flag:flag,
				endDt:endDt
			},
			success:function(data){
				var dataJson=eval("("+data+")");
				   <!-- 预警分布情况 --> 
				   if(strDate1='1'){
					   strDate1=dataJson.listXdata1[0];
					   var xx=strDate1.split('-');
					   strDate1=xx[0];
					   strDate=xx[1];
						zwt_interface_dataset.setValue("startDt",strDate1);
						zwt_interface_dataset.setValue("endDt",strDate);
					   strDate1=null;
					}
				$('div#2').highcharts({  
			        chart:{  
			           	type: 'column',					//图表的显示类型（line,spline,scatter,splinearea bar,pie,area,column）  
			        },  
			        title:{  
			           	text: '预警数量分布情况',				//主表题  
			        },  
			        xAxis: {   								//横坐表  
			        	categories: dataJson.listXdata1, 	//动态解析
		            	labels:{
		            		enabled:false//动态解析
		            	}
			        },  
			    	yAxis: {   
				        min:0
			      	},  
					tooltip: { 								//数据点的提示框   
			 			valueSuffix:'次',
			 			enabled:true
					}, 
				    credits:{
			        	text:'',
			        	href:''
					},
					plotOptions:{
		        		column:{
		        			pointPadding:0.2,
		        			borderWidth:0
		        		}
			     	},
			      	series:dataJson.data1  
				});
				$.messager.progress('close');
			}
		});
	}
	function sjt1(koujing){	
		var editor=$('input:checkbox[name="flag"]').is(":checked");
		var type='kjt';
		var customerNum='${customerNum}';
		$.messager.progress({title:'请稍候',msg:'正在载入...'});
		$.ajax({
			url :"${contextPath}/char/riskoverviewHigtCharServlet",
	        type : "post",
			data:{
				customerNum:customerNum,
				type:type,
				koujing:koujing,
				editor:editor
			},
			success:function(data){
				var dataJson=eval("("+data+")");
			    $('div#3').highcharts({  
			            chart:{  
			               	type: 'line',							//图表的显示类型（line,spline,scatter,splinearea bar,pie,area,column）  
			            },  
			            title:{  
			                text: '预警数量统计'					//主表题  
			            },  
			            xAxis: {   									//横坐表  
			            	categories: dataJson.listXdata2 
			            },  
			            yAxis: {  
							min:0,  
			            }, 
					    credits:{
				        	text:'',
				        	href:''
					     }, 	
			           	series:dataJson.data2						//动态解析
			      });
				 $.messager.progress('close');
			}
		});
	}
</script>
</@CommonQueryMacro.page>