<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="顺延方式设置 ">
<table align="left">

<tr>
<td valign="top" rowspan="1"  valign="top">
<@CommonQueryMacro.CommonQuery id="delay" init="true">
<table align="left">
			<tr>
       		<td valign="top">
      		<table>

      		<tr>
      		<td align="left" valign="top" width="300">
        			<@CommonQueryMacro.Group id="group1" label="设置顺延方式" fieldStr="delaytype" />
        	</td>
      		</tr>
      		<table id="tableBtQuery">
      		<tr>
      		<td align="left" valign="top" width="800">
        			<@CommonQueryMacro.Group id="group1" label="系统自动调整方式" fieldStr="check1,check3,check2,delaydays" />
        	</td>
      		</tr>
      	   </table>
      		<tr>
      		<td align="center">
         			<@CommonQueryMacro.Button id= "btSave"/>

        		</td>

      	  	</tr>
      	  	</table>
      		</td>
      		</tr>
   </table>

</@CommonQueryMacro.CommonQuery>
<script language="javascript">

function initCallGetter_post(){
	var v_delaytype = delay_dataset.getValue("delaytype");
	if(v_delaytype!="1")
		{
			document.all.tableBtQuery.style.display="none";
		}
		else
		{
		document.all.tableBtQuery.style.display="";
		}
}

function delay_dataset_afterChange(dataset, field)
{
	if(field.name=="delaytype")
	{
		var delaytype=dataset.getValue("delaytype").substring(0,1);
		if(delaytype!="1")
		{
			document.all.tableBtQuery.style.display="none";
		}
		else
		{
		document.all.tableBtQuery.style.display="";
		}
	}

	if(field.name=="check2"){
		if(dataset.getValue("check2")==true){
			dataset.setFieldReadOnly("delaydays",false);
		}else{
			dataset.setValue2("delaydays","0")
			dataset.setFieldReadOnly("delaydays",true);
		}
	}
}

</script>

</@CommonQueryMacro.page>
