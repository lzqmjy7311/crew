package com.gbicc.engine.rule.util;

import groovy.lang.Writable;
import groovy.text.SimpleTemplateEngine;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import org.codehaus.groovy.control.CompilationFailedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

import com.gbicc.util.FileUtil;

public class TemplateUtil {
	private static final Logger log =LoggerFactory.getLogger(TemplateUtil.class);
	
	public static String template(String template,Map<String,Object> context) throws CompilationFailedException, ClassNotFoundException, IOException{
		SimpleTemplateEngine engine =new SimpleTemplateEngine();
		Writable writable =engine.createTemplate(template).make(context);
		return writable.toString();
	}
	
	public static String templateResources(List<String> resources,Map<String,Object> context) throws CompilationFailedException, ClassNotFoundException, IOException{
		return template(getResourceScript(resources),context);
	}
	
	public static String templateResources(String[] resources,Map<String,Object> context) throws CompilationFailedException, ClassNotFoundException, IOException{
		return template(getResourceScript(resources),context);
	}
	
	private static String getResourceScript(List<String> resources) throws UnsupportedEncodingException, IOException{
		return getResourceScript(resources.toArray(new String[]{}));
	}
	
	private static String getResourceScript(String[] resources) throws UnsupportedEncodingException, IOException{
		StringBuilder sb =new StringBuilder();
		for(String r : resources){
			Resource resource =new DefaultResourceLoader().getResource(r);
			if(resource.exists()){
				sb.append(FileUtil.readString(resource.getInputStream()));
			}else{
				log.warn("Can NOT found resource [" + r + "]");
			}
		}
		return sb.toString();
	}
}
