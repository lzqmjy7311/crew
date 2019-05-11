<#import "/templets/commonQuery/CommonQueryMacroNew.ftl" as CommonQuery>

<@CommonQuery.CommonQuery >
	<table align="left">
			<tr>
       			<td valign="top" rowspan="2"  valign="center">
       				<@CommonQuery.PagePilot id="ddresult" maxpagelink="9"/>
					<@CommonQuery.Group id="group1" label="岗位信息" fieldStr="roleid,rolename" colNm=4/>
          			<@CommonQuery.DataTable id ="datatable1" fieldStr="select,funccode,funcname,rolename" width="200" readonly="false" />

          			<@CommonQuery.Button id= "btSave"/>
         			<@CommonQuery.Button id= "back"/>
        		</td>
      		</tr>

   </table>

    <script language="javascript">
      function btSave_postSubmit(button){
         alert("设置成功！");
         return true;
      }

			</script>

</@CommonQuery.CommonQuery>