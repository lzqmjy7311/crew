package com.gbicc.override;

import org.apache.shiro.authc.UsernamePasswordToken;

import com.huateng.ebank.framework.security.Md5;

/**
 * 重写UsernamePasswordToken
 * @date    2016年1月5日
 * @author  tangdu
 * @desc
 */
public class MyUsernamePasswordToken extends UsernamePasswordToken {
	private static final long serialVersionUID = 5596549156650997509L;
	public static final String DEFAULT_PWD="gbicc";//该密码无用只为绕过空 (Z2JpY2M=)为华腾的前台密码可逆加密
	
	public static enum Result{
		REQUIRED_CHECKED(1,"需要通过密码验证"),
		NOT_REQUIRED_CHECKED_SUCCESS(20,"校验成功"),
		NOT_REQUIRED_CHECKED_ERROR(21,"非正常访问，验证失败！"),
		NOT_REQUIRED_CHECKED_ORG_ERROR(22,"非正常访问，机构号无法识别！")
		;
		private int code=1;
		private String message;
		Result(int code,String message){
			this.code=code;
			this.message=message;
		}
		public int getCode(){
			return this.code;
		}
		public String getMessage(){
			return this.message;
		}
	}
	private Result result;

	public MyUsernamePasswordToken(String username, String password) {
		super(username, password);
		result=Result.REQUIRED_CHECKED;
	}
	
	/**
	 * 重写FP验证API
	 * @param username 用户名
	 * @param userorg  核心机构
	 * @param secret   密钥作验证
	 */
	private String secret;
	private String userorg;
	public MyUsernamePasswordToken(String username,
			String userorg,String secret) {
		super(username,DEFAULT_PWD);
		this.secret=secret;
		this.userorg=userorg;
		check();
	}
	public String getSecret(){
		return this.secret;
	}
	
	public String getUserOrg(){
		return this.userorg;
	}
	
	public Result getResult(){
		return this.result;
	}
	
	public void check(){
		Md5 dd=new Md5();
		String sc=dd.getMD5ofStr("#"+this.getUsername().trim()+"@");
		if(sc.equals(secret)){
			this.result=Result.NOT_REQUIRED_CHECKED_SUCCESS;
		}else
			this.result=Result.NOT_REQUIRED_CHECKED_ERROR;
	}
	
	public static void main(String[] args) {
		Md5 dd=new Md5();
		String userName="06336";
		System.out.println(dd.getMD5ofStr(userName));
		System.out.println(dd.getMD5ofStr("#"+userName+"@"));
		//out：E73FAD60181526288AA88C04175339CF
	}
}
