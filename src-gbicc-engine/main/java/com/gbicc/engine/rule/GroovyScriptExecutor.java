package com.gbicc.engine.rule;

import groovy.lang.Binding;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.script.Bindings;
import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.SimpleBindings;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

import com.gbicc.util.FileUtil;


/**
 * Groovy 脚本执行引擎服务类
 * @author wangshaoping
 *
 */
public class GroovyScriptExecutor {
	private static final Logger log =LoggerFactory.getLogger(GroovyScriptExecutor.class);
	private static GroovyScriptExecutor instance;
	private Compilable compilableEngine;
	
	public static synchronized GroovyScriptExecutor getInstance(){
		if(instance==null){
			instance =new GroovyScriptExecutor();
		}
		return instance;
	}
	
	private GroovyScriptExecutor(){
		ScriptEngineManager manager =new ScriptEngineManager();
		ScriptEngine engine =manager.getEngineByName("groovy");
		compilableEngine =(Compilable)engine;
	}
	
	public String getResourceScript(String[] resources) throws UnsupportedEncodingException, IOException{
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
	
	public String getResourceScript(List<String> resources) throws UnsupportedEncodingException, IOException{
		return getResourceScript(resources.toArray(new String[]{}));
	}
	
	/**
	 * 编译验证 groovy 脚本的语法是否正确
	 * @param script groovy 脚本
	 * @return 是否通过编译验证
	 * @throws Exception
	 */
	public boolean validate(String script) throws Exception{
		compilableEngine.compile(script);
		return true;
	}

	/**
	 * 执行 groovy 脚本
	 * @param script groovy 脚本
	 * @return 执行结果
	 * @throws Exception
	 */
	public Object eval(String script) throws Exception {
		CompiledScript compiledScript =getCompiledScript(script);
		if(compiledScript!=null){
			return compiledScript.eval();
		}
		return null;
	}
	
	public Object evalResources(String[] resources) throws Exception {
		return eval(getResourceScript(resources));
	}
	
	public Object evalResources(List<String> resources) throws Exception {
		return eval(getResourceScript(resources));
	}
	
	/**
	 * 执行 groovy 脚本（单返回值）
	 * @param script groovy 脚本
	 * @param key 上下文 key
	 * @param value 上下文 value
	 * @return 执行结果
	 * @throws Exception
	 */
	public Object eval(String script, String key, Object value) throws Exception {
		CompiledScript compiledScript =getCompiledScript(script);
		if(compiledScript!=null){
			Bindings bindings =new SimpleBindings();
			if(key!=null && !"".equals(key.trim())){
				bindings.put(key,value);
			}
			return compiledScript.eval(bindings);
		}
		return null;
	}
	
	public Object evalResources(String[] resources, String key, Object value) throws Exception {
		return eval(getResourceScript(resources),key,value);
	}
	
	public Object evalResources(List<String> resources, String key, Object value) throws Exception {
		return eval(getResourceScript(resources),key,value);
	}

	public static void main(String[] args) {
		try {
			String ftt=FileUtil.readString("D:\\workspace\\crew-script\\src\\main\\resources\\预警规则\\个贷规则\\PR001_借款客户与其保证人的关键人出现重叠.groovy");
			Pattern p=Pattern.compile("(def[\\s\\S]*?规则定义信息=[\\s\\S]*])");
			Matcher matcher=p.matcher(ftt);
			System.out.println(ftt);
			if(matcher.find()){
				System.out.println("------------------find-----------------");
				System.out.println(matcher.group(1));
				//System.out.println("------------------find-----------------");
				//System.out.println(ftt.replace(matcher.group(1), ""));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 执行 groovy 脚本（单返回值）
	 * @param script groovy 脚本
	 * @param context groovy 脚本执行上下文
	 * @return 执行结果
	 * @throws Exception
	 */
	public Object eval(String script, Map<String, Object> context) throws Exception {
		CompiledScript compiledScript =getCompiledScript(script);
		if(compiledScript!=null){
			Bindings bindings =new SimpleBindings();
			if(context!=null && context.size()>0){
				bindings.putAll(context);
			}
			return compiledScript.eval(bindings);
		}
		return null;
	}
	
	public Object evalResources(String[] resources, Map<String, Object> context) throws Exception {
		return eval(getResourceScript(resources),context);
	}
	
	public Object evalResources(List<String> resources, Map<String, Object> context) throws Exception {
		return eval(getResourceScript(resources),context);
	}
	
	/**
	 * 执行 groovy 脚本（单返回值）
	 * @param script script groovy 脚本
	 * @param bindings Groovy Bindings 对象
	 * @return 执行结果
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public Object eval(String script, Binding binding) throws Exception {
		CompiledScript compiledScript =getCompiledScript(script);
		if(compiledScript!=null){
			Bindings bindings =new SimpleBindings();
			if(binding!=null && binding.getVariables().size()>0){
				bindings.putAll(binding.getVariables());
			}
			return compiledScript.eval(bindings);
		}
		return null;
	}
	
	public Object evalResources(String[] resources, Binding binding) throws Exception {
		return eval(getResourceScript(resources),binding);
	}
	
	public Object evalResources(List<String> resources, Binding binding) throws Exception {
		return eval(getResourceScript(resources),binding);
	}
	
	/**
	 * 执行 groovy 脚本（多返回值）
	 * @param script groovy 脚本
	 * @return 执行结果
	 * @throws Exception
	 */
	public Map<String, Object> execute(String script) throws Exception {
		CompiledScript compiledScript =getCompiledScript(script);
		if(compiledScript!=null){
			Bindings bindings =new SimpleBindings();
			compiledScript.eval(bindings);
			return (Map<String,Object>)bindings;
		}
		return null;
	}
	
	public Map<String, Object> executeResources(String[] resources) throws Exception {
		return execute(getResourceScript(resources));
	}
	
	public Map<String, Object> executeResources(List<String> resources) throws Exception {
		return execute(getResourceScript(resources));
	}
	
	/**
	 * 执行 groovy 脚本（多返回值）
	 * @param script groovy 脚本
	 * @param key 上下文 key
	 * @param value 上下文 value
	 * @return 执行结果
	 * @throws Exception
	 */
	public Map<String, Object> execute(String script, String key, Object value) throws Exception {
		CompiledScript compiledScript =getCompiledScript(script);
		if(compiledScript!=null){
			Bindings bindings =new SimpleBindings();
			if(key!=null && !"".equals(key.trim())){
				bindings.put(key,value);
			}
			compiledScript.eval(bindings);
			return (Map<String,Object>)bindings;
		}
		return null;
	}
	
	public Map<String, Object> executeResources(String[] resources, String key, Object value) throws Exception {
		return execute(getResourceScript(resources),key,value);
	}
	
	public Map<String, Object> executeResources(List<String> resources, String key, Object value) throws Exception {
		return execute(getResourceScript(resources),key,value);
	}

	/**
	 * 执行 groovy 脚本（多返回值）
	 * @param script groovy 脚本
	 * @param context groovy 脚本执行上下文
	 * @return 执行结果
	 * @throws Exception
	 */
	public Map<String, Object> execute(String script, Map<String, Object> context) throws Exception {
		CompiledScript compiledScript =getCompiledScript(script);
		if(compiledScript!=null){
			Bindings bindings =new SimpleBindings();
			if(context!=null){
				bindings.putAll(context);
			}
			compiledScript.eval(bindings);
			return (Map<String,Object>)bindings;
		}
		return null;
	}
	
	public Map<String, Object> executeResources(String[] resources, Map<String, Object> context) throws Exception {
		return execute(getResourceScript(resources),context);
	}
	
	public Map<String, Object> executeResources(List<String> resources, Map<String, Object> context) throws Exception {
		return execute(getResourceScript(resources),context);
	}
	
	/**
	 * 执行 groovy 脚本（多返回值）
	 * @param script groovy 脚本
	 * @param bindings Groovy Bindings 对象
	 * @return 执行结果
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> execute(String script, Binding binding) throws Exception {
		CompiledScript compiledScript =getCompiledScript(script);
		if(compiledScript!=null){
			Bindings bindings =new SimpleBindings();
			if(binding!=null){
				bindings.putAll(binding.getVariables());
			}
			compiledScript.eval(bindings);
			return (Map<String,Object>)bindings;
		}
		return null;
	}
	
	public Map<String, Object> executeResources(String[] resources, Binding binding) throws Exception {
		return execute(getResourceScript(resources),binding);
	}
	
	public Map<String, Object> executeResources(List<String> resources, Binding binding) throws Exception {
		return execute(getResourceScript(resources),binding);
	}
	
	/**
	 * 编译 groovy 脚本
	 * @param script 脚本文本字符串
	 * @return 编译后的脚本对象
	 * @throws Exception
	 * 由于 groovy 的 Compilable 实现已经实现了缓存编译后的脚本对象（即对相同的文本不会进行重复编译），所以应用无需进行缓存。
	 */
	private CompiledScript getCompiledScript(String script) throws Exception{
		if(script!=null && !"".equals(script.trim())){
			return compilableEngine.compile(script);
		}
		return null;
	}
}
