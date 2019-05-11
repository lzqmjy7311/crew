<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="汇率维护">
<table align="left">
<tr>
<td valign="top" rowspan="1"  valign="top">
    <@CommonQueryMacro.CommonQuery id="Management_IntrateMng" init="false">
        <tr>
        <td>
            <table align="left">
                <tr>
                   <td valign="top" rowspan="2"  valign="top">
                       <@CommonQueryMacro.Interface id="intface" label="查询条件" colNm=4  />
                </td>
                  </tr>
            </table>
        </td>
        </tr>
        
        <tr>
        <td valign="top" rowspan="1"  >
               <@CommonQueryMacro.PagePilot id="PagePilot"/>
            <@CommonQueryMacro.DataTable id ="datatable1"
                  fieldStr="curcd,intratecdName,intrate,brcodeName,effectDate"  width="350" readonly="true"/>
        </td>
        <td valign="top">
            <table>
            <tr>
            <td align="left" valign="top" width="300">
                <@CommonQueryMacro.Group id="group1" label="利率手工录入" fieldStr="curcd,intratecd,intrate,brcode,effectDate" colNm=2/>
            </td>
            </tr>
            
            <tr align="center">
            <td align="center">
                <table>
                    <tr align="center">
                    <td align="center">
                          <@CommonQueryMacro.Button id= "btNew"/>
                      </td>
                    <td align="center">
                        <@CommonQueryMacro.Button id= "btDel"/>
                    </td>
                    <td align="center">
                        <@CommonQueryMacro.Button id= "btSave"/>
                    </td>
                      </tr>
                  </table>
            </td>
            </tr>
            </table>
        </td>
        </tr>
    </@CommonQueryMacro.CommonQuery>
</td>
</tr>
</table>
<script language="javascript">
    
    function dateCheck(effectDate,currDate){
        if(effectDate == ""){//没有生效日期，可修改
            return false;
        }
        if(currDate == ""){//没有当前日期，可修改
            return false;
        }
        if(effectDate < currDate){//生效日期小于当前日期，不可修改
            return true;
        }else{
            return false;
        }
    }

    function Management_IntrateMng_dataset_afterScroll(dataset){
      var effectDate = Management_IntrateMng_dataset.getValue("effectDate");
      var currDate = Management_IntrateMng_dataset.getValue("currDate");
      if (dateCheck(effectDate,currDate)){
            Management_IntrateMng_dataset.setFieldReadOnly("curcd",true);
    //        Management_IntrateMng_dataset.setFieldReadOnly("intType",true);
            Management_IntrateMng_dataset.setFieldReadOnly("intratecd",true);
            Management_IntrateMng_dataset.setFieldReadOnly("intrate",true);
            Management_IntrateMng_dataset.setFieldReadOnly("brcode",true);
            Management_IntrateMng_dataset.setFieldReadOnly("effectDate",true);
      }else{
        Management_IntrateMng_dataset.setFieldReadOnly("curcd",false);
    //    Management_IntrateMng_dataset.setFieldReadOnly("intType",false);
        Management_IntrateMng_dataset.setFieldReadOnly("intratecd",false);
        Management_IntrateMng_dataset.setFieldReadOnly("intrate",false);
        Management_IntrateMng_dataset.setFieldReadOnly("brcode",false);
        Management_IntrateMng_dataset.setFieldReadOnly("effectDate",false);
      }
      return true;
    }

    function btDel_onClickCheck(button) {
        var effectDate = Management_IntrateMng_dataset.getValue("effectDate");
        var currDate = Management_IntrateMng_dataset.getValue("currDate");
        if(dateCheck(effectDate,currDate)){
            alert("已生效利率不能删除。");
            return false;
        }
    }
    
    function btSave_postSubmit()
    {
        alert("保存成功");
        Management_IntrateMng_dataset.flushData(0);
    }
    
    //function intType_DropDown_onSelect(dropDown,record,editor){
    //    Management_IntrateMng_dataset.setValue("intratecd",null);
    //    Management_IntrateMng_dataset.setValue("intratecdname",null);
    //    return true;
    //}
    //
    //function intratecd_DropDown_beforeOpen(dropDown,record,editor){
    //
    //    dropDown.cached = false;
    //    QueryIntrateType_DropDownDataset.clearData(0);
    //    QueryIntrateType_DropDownDataset.setParameter("intType", Management_IntrateMng_dataset.getValue("intType"));
    //    QueryIntrateType_DropDownDataset.flushData(0);
    //}
    
    function Management_IntrateMng_dataset_beforeUpdate(dataset){
        //输入数据有效性检查
    
        //输入的有效日期必须大于今日
        if(dataset==null) return;
        var effectDate = dataset.getValue("effectDate");
        var currDate = new Date();
          if(effectDate!=null && effectDate < currDate){
            return ("输入的生效日期必须大于当前日期");
          }
    }

</script>

</@CommonQueryMacro.page>
