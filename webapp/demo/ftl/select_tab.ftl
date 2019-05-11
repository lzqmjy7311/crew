<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="demo_field_1">
<@CommonQueryMacro.CommonQuery id="GroupFieldsSelect" init="true" submitMode="current" navigate="false">
	<@CommonQueryMacro.Group id="group1"  label="控件组" colNm="2" fieldStr="" labelwidth="100"/>
</@CommonQueryMacro.CommonQuery>
	
	<script>
	var r=true;
	function btTest_onClickCheck(button){
	if(r){
	   GroupFieldsSelect_dataset.setFieldReadOnly("staticComboboxList",false);
	   r=false;
	}else{
    	GroupFieldsSelect_dataset.setFieldReadOnly("staticComboboxList",true);
    	r=true;
	}
   }

   function staticComboboxDic_DropDown_onSelect(dropDown,record,editor){
      if(record!=null && record[0]=="0"){
           CQDemo_DropDownDataset.setParameter("id","true");       
      }else{
           CQDemo_DropDownDataset.setParameter("id","false");    
      }
      return true;
   }
 
   dynamicComboboxCQ_DropDown.cached=false;
 
	/*测试代码:
	
	
	function dialog_DropDown_onSelect(dropDown,record,editor){
	    alert('error');
	    return false;
	}
	function dialog_DropDown_beforeOpen(dropDown){
	    //return "beforeopen return error";
	}
	function staticComboboxList_DropDown_onSelect(dropDown,record,editor){
	    alert('error');
	    return false;
	}
	function staticComboboxList_DropDown_beforeOpen(dropDown){
	    //return "beforeopen return error";
	}
	function staticComboboxList2_DropDown_onSelect(dropDown,record,editor){
	    alert('error');
	    return false;
	}
	function staticComboboxList2_DropDown_beforeOpen(dropDown){
	    //return "beforeopen return error";
	}
	function staticComboboxDic_DropDown_onSelect(dropDown,record,editor){
	    alert('error');
	    return false;
	}
	function staticComboboxDic_DropDown_beforeOpen(dropDown){
	    //return "beforeopen return error";
	}
	function staticComboboxDic2_DropDown_onSelect(dropDown,record,editor){
	    alert('error');
	    return false;
	}
	function staticComboboxDic2_DropDown_beforeOpen(dropDown){
	    //return "beforeopen return error";
	}
 
	function dynamicComboboxCQ_DropDown_onSelect(dropDown,record,editor){
	    alert('error');
	    return false;
	}
	function dynamicComboboxCQ_DropDown_beforeOpen(dropDown){
	    //return "beforeopen return error";
	}
	function dynamicComboboxCQ2_DropDown_onSelect(dropDown,record,editor){
	    alert('error');
	    return false;
	}
	function dynamicComboboxCQ2_DropDown_beforeOpen(dropDown){
	    //return "beforeopen return error";
	}
	function dynamicComboboxTree_DropDown_onSelect(dropDown,record,editor){
	    alert('error');
	    return false;
	}
	function dynamicComboboxTree_DropDown_beforeOpen(dropDown){
	    //return "beforeopen return error";
	}
	function dynamicComboboxTree2_DropDown_onSelect(dropDown,record,editor){
	    alert('error');
	    return false;
	}
	function dynamicComboboxTree2_DropDown_beforeOpen(dropDown){
	    //return "beforeopen return error";
	}
	*/
	//输入模糊查询下拉框
	function editSelect_DropDown_onKeyup(val){
		//为减少服务器查询数据库压力，建议对val按照业务规则进行检查，符合要求返回true
		if(val!=null && val.length>0){
			return true;
		}
		return false;
	}
	
	function dialog_DropDown_onInitConfig(){
      return {title:'弹出框标题',buttonOk:'确定',buttonCancel:'取消',width:800,height:400};
    }
    
    /*
    function GroupFieldsSelect_dataset_onSetValue(ds,curretField,val){
    	if(curretField.name=='radio'){
    		return val;
    	}
    	alert(val);
    }
    */
	</script>
</@CommonQueryMacro.page>