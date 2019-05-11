<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="票据信息">
<CENTER><H1 id="draftTitle"></H1></CENTER>
<table align="center" class="grouptable">
<tr>
<td valign="center" align="center">
<div id="draftDiv">
<table align="center"  width="800px" cellspacing="0" cellpadding="0">
          <tr>
            <td colspan="2"><table frame=void class="grouptable">
               <tr>
                  <td colspan="2" align="center" nowrap class="labeltd"> 出票日 </td>
				  <td class="datatd" >${RequestParameters["stdissdate"]}</td>
                  <td colspan="2" align="center" nowrap class="labeltd"> 票据类型 </td>
                 <td class="datatd">${RequestParameters["stdbilltypName"]}</td>
                </tr>
               <tr>
                  <td colspan="2" align="center" nowrap class="labeltd"> 汇票到期日 </td>
 			      <td class="datatd">${RequestParameters["stdduedate"]}</td>
                  <td colspan="2" align="center" nowrap class="labeltd"> 票据号码 </td>
                   <td class="datatd">${RequestParameters["stdbillnum"]}</td>
                </tr>

                <tr>
                  <td width="4%" rowspan="4" align="center" nowrap class="labeltd"> 出 <br> 票 <br> 人 </td>
                  <td width="7%" align="center" nowrap class="labeltd" > 全&nbsp;&nbsp;称 </td>
                  <td width="39%" class="datatd">${RequestParameters["stddrwrnam"]}</td>
                  <td width="4%" rowspan="4" align="center" nowrap class="labeltd"> 收 <br> 款 <br> 人 </td>
                  <td width="10%" align="center" nowrap class="labeltd"> 全&nbsp;&nbsp;称 </td>
                  <td width="36%" class="datatd">
                  	${RequestParameters["stdpyeenam"]}
                  </td>
                </tr>
                <tr>
                  <td align="center" nowrap class="labeltd" > 帐&nbsp;&nbsp;号 </td>
                  <td class="datatd">${RequestParameters["stddrwracc"]}</td>
                  <td align="center" nowrap class="labeltd" > 帐&nbsp;&nbsp;号 </td>
                  <td class="datatd">${RequestParameters["stdpyeeacc"]}</tr>
                <tr>
                  <td align="center" nowrap class="labeltd" > 行&nbsp;&nbsp;号 </td>
                  <td class="datatd" nowrap>${RequestParameters["stddrwrbnm"]}</tr>
                  <td align="center" nowrap class="labeltd"> 行&nbsp;&nbsp;号 </td>
 				  <td class="datatd" nowrap>${RequestParameters["stdpyeebnm"]}</tr>
                </tr>

                <tr>
                  <td align="center" nowrap class="labeltd"> 开户行 </td>
                  <td class="datatd" nowrap>
						<#assign drwrUBankName = getUBankName(RequestParameters["stddrwrbnm"])>
						${drwrUBankName}
                    </tr>
                   <td align="center" nowrap class="labeltd"> 开户行 </td>
                   <td class="datatd" nowrap>
						<#assign pyeeUBankName = getUBankName(RequestParameters["stdpyeebnm"])>
						${pyeeUBankName}
                   </tr>
                </tr>

                <tr height="50">
				  <td colspan="2" align="center" nowrap class="labeltd"> 票据金额 </td>
 				  <td colspan="1" class="datatd" >人民币 (大写) &nbsp; &nbsp;${RequestParameters["stdpmmoneyCH"]}</td>
 				  <td colspan="3" class="datatd" ><div align="center">${RequestParameters["stdpmmoney"]}</div></td>
                </tr>


                <tr>
                  <td width="4%" rowspan="2" align="center" nowrap class="labeltd"> 承 <br> 兑 <br> 人 <br> 信 <br> 息 </td>
                  <td align="center" nowrap class="labeltd" >全&nbsp;&nbsp;称</td>
                  <td class="datatd">
                  	${RequestParameters["stdaccpnam"]}
                  </td>
                  <td colspan="2" align="center" nowrap class="labeltd"> 开户行行号 </td>
  				  <td class="datatd">${RequestParameters["stdaccpbnm"]}</td>
                </tr>

                <tr>
				  <td align="center" nowrap class="labeltd" >帐&nbsp;&nbsp;号</td>
 				  <td class="datatd">${RequestParameters["stdaccpacc"]}</td>
                  <td colspan="2" align="center" nowrap class="labeltd">开户行名称 </td>
				  <td class="datatd">
						<#assign accpUBankName = getUBankName(RequestParameters["stdaccpbnm"])>
						${accpUBankName}
				  </td>
                </tr>

                <tr>

                  <td colspan="2" align="center" nowrap class="labeltd" >允许背书 </td>
                 <td class="datatd">${RequestParameters["stdendormkName"]}</td>
                </tr>
                 <tr>
				  <td colspan="2" align="center" nowrap class="labeltd"> 出票备注 </td>
 				  <td colspan="4" class="datatd">${RequestParameters["std400memo"]}</td>
                </tr>

            </table>
          </tr>
</table>
</div>
<div id="infoDiv" style="display:none"></div>
</td>
</tr>
</table>
<br/>
<br/>
<CENTER>
	<input type="button" extra="button" value="历史信息" id="btChange" onClick="changeView();"/>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="button" extra="button"  value="关闭" id="btBack1" onClick="window.close();"/>
</CENTER>
<script type='text/javascript' src='${contextPath}/dwr/interface/GetDraftShowDetailInfo.js'></script>
<script language="javascript">
	var stdbilltyp = "${RequestParameters["stdbilltyp"]}";
	function initCallGetter_post() {
		if(stdbilltyp == "AC01"){
			document.getElementById('draftTitle').innerHTML = '电子银行承兑汇票';
		}else if(stdbilltyp == "AC02"){
			document.getElementById('draftTitle').innerHTML = '电子商业承兑汇票';
		}
		ChangeTableRowEvent();
	}

   	function ChangeTableRowEvent() {
		var v_stdshwinfoid = "${RequestParameters["stdshwinfoid"]}";
		var v_stdbillnum = "${RequestParameters["stdbillnum"]}";
		var v_stdendormk = "${RequestParameters["stdendormkName"]}";
   		document.getElementById("infoDiv").innerHTML = "";
		GetDraftShowDetailInfo.getShowDetailInstances(v_stdshwinfoid,v_stdbillnum,v_stdendormk,function(htmlStr) {
			document.getElementById("infoDiv").innerHTML = htmlStr;
		});
   	}

   	function changeView() {
   		if (infoDiv.style.display == "none") {
   			infoDiv.style.display = "";
   			draftDiv.style.display = "none";
   			btChange.value = "票据信息";
   		} else {
   			infoDiv.style.display = "none";
   			draftDiv.style.display = "";
   			btChange.value = "历史信息";
   		}
   	}
</script>
</@CommonQueryMacro.page>