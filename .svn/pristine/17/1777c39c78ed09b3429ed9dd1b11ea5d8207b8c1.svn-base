package com.gbicc.rule.operation;

import java.util.Date;

import com.gbicc.rule.entity.TRulCategory;
import com.gbicc.rule.entity.TRulDefinition;
import com.gbicc.rule.service.TRulCategoryService;
import com.gbicc.rule.service.TRulDefinitionService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

public class TRulCategoryOperation extends BaseOperation {

	public static final String ID = TRulCategoryOperation.class.getSimpleName();
	public static final String CMD = "CMD";
	public static final String CMD_QUERY = "CMD_QUERY";
	public static final String CMD_INSERTCATEGORY = "CMD_INSERTCATEGORY";
	public static final String CMD_INSERTRULE = "CMD_INSERTRULE";
	public static final String CMD_UPDATECATEGORY = "CMD_UPDATECATEGORY";
	public static final String CMD_UPDATERULE = "CMD_UPDATERULE";
	public static final String CMD_DELETE = "CMD_DELETE";
	public static final String IN_PARAM = "IN_PARAM";
	
	@Override
	public void afterProc(OperationContext context) throws CommonException {
	}

	@Override
	public void beforeProc(OperationContext context) throws CommonException {
	}

	@Override
	public void execute(OperationContext context) throws CommonException {
		String cmd = (String) context.getAttribute(CMD);
		TRulCategory dd = (TRulCategory) context.getAttribute(IN_PARAM);
		TRulCategoryService service = TRulCategoryService.getInstance();
		TRulDefinitionService definitionService=TRulDefinitionService.getInstance();
		
		if (CMD_QUERY.equals(cmd)) {
		} else if (CMD_INSERTRULE.equals(cmd)) {
			boolean flag=service.isExistsCode(dd.getCategoryCode());
			if(flag){
				throw new CommonException("编号【"+dd.getCategoryCode()+"】已存在，不能重复添加!");
			}
			
			service.save(dd);
			if(dd.getCategoryType().equals("T2")){//如果为规则时
				TRulDefinition definition=new TRulDefinition();
				definition.setRuleCode(dd.getCategoryCode());
				definition.setRuleName(dd.getCategoryName());
				definition.setRuleCreateddate(new Date());
				definition.setCategoryId(dd.getId());
				definition.setRuleVersion(1);
				definition.setEnable("1");//起用
				definition.setRuleStatus("0");//草稿
				definitionService.save(definition);
			}
		} else if (CMD_INSERTCATEGORY.equals(cmd)) {
			boolean flag=service.isExistsCode(dd.getCategoryCode());
			if(flag){
				throw new CommonException("编号【"+dd.getCategoryCode()+"】已存在，不能重复添加!");
			}
			service.save(dd);
		} else if (CMD_UPDATECATEGORY.equals(cmd)) {
			service.update(dd);
		} else if (CMD_UPDATERULE.equals(cmd)) {
			service.update(dd);
		}  else if (CMD_DELETE.equals(cmd)) {
			service.delete(dd.getId());
			definitionService.deleteByCategoryId(dd.getId());
		}
	}

}
