package com.gbicc.person.supervision.service;


import com.gbicc.person.supervision.entity.*;


public class superInfoService{


public Boolean ChangeStatus(String id){
	Boolean flag;
	try{
	QualitysuParService qualitysuParService = QualitysuParService.getInstance();
	QualitysuPar qualitysuPar = qualitysuParService.get(id);
	if(qualitysuPar.getStatus().equals("启用")){
			qualitysuPar.setStatus("禁用");
		}
	else{
			qualitysuPar.setStatus("启用");
		}
	qualitysuParService.update(qualitysuPar);
	flag=true; 
	}
	
	catch(Exception e){
		flag=false;
		e.printStackTrace();
	}
	return flag;
}

}