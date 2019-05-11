<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="人员权限查询">
<table align="left" width="100%">
<tr>
<td valign="top" rowspan="1"  valign="top">
<@CommonQueryMacro.CommonQuery id="UserAuthorityDown" init="false" submitMode="all" >
	  <table align="center" width="100%">
	        <tr>
		       <td>
			    <@CommonQueryMacro.Interface id="interface" label="请输入查询条件" />
		       </td>
	        </tr>
			<tr>
       			<td valign="top"   valign="top">
          			<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="select[30],trlNo[100],trlName[120],roleIdName" readonly="false" width="100%"/>
        		</td>
      		</tr>
     </table>

</@CommonQueryMacro.CommonQuery>
</td>
</tr>
</table>
<iframe id="filedownloadfrm"  style="display: none;"></iframe>
 <script language="JavaScript">


  /*function datatable1_roleidname_onRefresh(cell,value,record){
       if(record){
           var role=record.getValue("roleidname");
           var roleString=role.split(':');
           var cellString='';
           for(var i=0;i<roleString.length;i++){
              cellString=cellString+'<a href="javascript:void(0)">'+roleString[i].split(',')[1]+'</a>&nbsp;';
           }
           cell.innerHTML=cellString;
       }
  }**/


  function excel_onClickCheck(button){
       var record=UserAuthorityDown_dataset.getFirstRecord();
       var param='';
       while(record){
           var trlNo=record.getValue('trlNo');
           var isSelect=record.getValue('select');
           record=record.getNextRecord();
           if(isSelect){
               var v=trlNo;
               if(record){
                 v=v+";";
               }
               param=param+v;
            }
       }
       if(param!=''){
         document.getElementById("filedownloadfrm").src ="${contextPath}/excel?param="+param;
       }
       return false;
  }

  function pdf_onClickCheck(button){
       var record=UserAuthorityDown_dataset.getFirstRecord();
       var param='';
       while(record){
         var trlNo=record.getValue('trlNo');
         var isSelect=record.getValue('select');
         record=record.getNextRecord();
         if(isSelect){
           var v=trlNo;
           if(record){
              v=v+";";
           }
           param=param+v;
        }
       }
       if(param!=''){
       		document.getElementById("filedownloadfrm").src ="${contextPath}/pdf?param="+param;
       }
   return false;
  }

</script>

</@CommonQueryMacro.page>