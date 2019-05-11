<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="demo_field_1">
	<@CommonQueryMacro.CommonQuery id="GroupFieldsTextInput" init="true" submitMode="current" navigate="false">
		<@CommonQueryMacro.Group id="group1"  label="控件组" hotkey="true" colNm="2" fieldStr="text,placeholder,textInput,integerText,doubleText,currencyText,textArea,组合域{textyear|'年'|textmonth|'月'|textday|'日'}[2]" />
	</@CommonQueryMacro.CommonQuery>
		<div name='group1' class="group" style="width:50%"><h5>select左右移动</h5>
			<table width="100%" class="grouptable" height="100%" style="table-layout: auto;">
				<tr id="text_TR" fieldId="text">
			 <td  align="right" nowrap style="width:40%">
			       <select  multiple name="left" id="left" size="5" style='width:100%;'
					  ondblclick="moveOption(document.getElementById('left'), document.getElementById('right'))">
					  </select>
			 </td>
			 <td align="center" width="100px">
			 	<@CommonQueryMacro.SimpleButton id="btn5" desc="&gt;&gt;" onclick="moveOption(document.getElementById('left'),document.getElementById('right'))" icon="" plain="false" /> <br/>
			 	<@CommonQueryMacro.SimpleButton id="btn6" desc="&lt;&lt;" onclick="moveOption(document.getElementById('right'), document.getElementById('left'))" icon="" plain="false" /> 
			 </td>
		 		<td  class="labeltd" valign=center align="right" nowrap style="width:40%">
			        <select  multiple name="right" id="right" size="5" style='width:100%;'
				  ondblclick="moveOption(document.getElementById('right'), document.getElementById('left'))">
				  </select>
			 </td>
			 </tr>
			 </table>
		</div>
		<@CommonQueryMacro.SimpleButton id="btn10" desc="获取左侧" onclick="getSelect('left');" icon="" plain="false" />&nbsp;&nbsp;
		<@CommonQueryMacro.SimpleButton id="btn11" desc="获取右侧" onclick="getSelect('right')" icon="" plain="false" /> 
		
	<script>
	
		function initCallGetter_post(){
			var lfval = GroupFieldsTextInput_dataset.getValue("leftSel");
			initSel(lfval,'left');
			var rgval = GroupFieldsTextInput_dataset.getValue("rightSel");
			initSel(rgval,'right');
		}
		
		function initSel(val,selId){
			if(val!=null && val.length>0){
				var obj = document.getElementById(selId);
				var vals = val.split(";");
				for(var i=0;i<vals.length;i++){
					var tmp = vals[i];
					if(tmp!=null && tmp.length>0){
						var tmps = tmp.split("=");
						var opt = null;
						if(tmps.length>1){
							opt = new Option(tmps[1],tmps[0]);
						}else{
							opt = new Option(tmps[0],tmps[0]);
						}
						obj.options.add(opt);
					}
				}
			}
		}
		
	
		function datalabel_text_onRefresh(el,value){
			el.innerHTML="<a href='javascript:void(0);'>"+value+"</a>";
		}
		//移动
		function moveOption(obj1, obj2)
		{
			 for(var i = obj1.options.length - 1 ; i >= 0 ; i--)
			 {
				 if(obj1.options[i].selected)
				 {
					var opt = new Option(obj1.options[i].text,obj1.options[i].value);
					obj2.options.add(opt);
					obj1.remove(i);
				}
			 }
		}
		
		function getSelect(selId){
		
			var obj = document.getElementById(selId);
			var str = "";
			for(var i=0;i<obj.options.length;i++){
				str+=obj.options[i].value+",";
			}
			alert(str);
		}
		
		
	</script>
</@CommonQueryMacro.page>