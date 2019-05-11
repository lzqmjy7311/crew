package com.huateng.ebank.business.management.service;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.gbicc.override.MyUsernamePasswordToken;
import com.gbicc.override.MyUsernamePasswordToken.Result;
import com.huateng.ebank.business.common.UserSessionInfo;
import com.huateng.ebank.framework.exceptions.CommonException;


/**
 * @author shen_antonio
 *
 */
public class FPAuthorizingRealm extends AuthorizingRealm {

	@Override
	/**
     * 
     * 当用户进行访问链接时的授权方法
     * 
     */
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		 String username=(String)principals.fromRealm(getName()).iterator().next();  
	        if( username != null ){  
	        	SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();  
	            return info;  
	        }  
	        return null;  
	}

	@Override
	 /**
     * 用户登录的认证方法
     * 
     */
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken arg0) throws AuthenticationException {
		MyUsernamePasswordToken usernamePasswordToken = (MyUsernamePasswordToken) arg0;
        String username = usernamePasswordToken.getUsername();
        char[] password = usernamePasswordToken.getPassword();
        String brhno = usernamePasswordToken.getHost();
        UserMgrService userMgrService = UserMgrService.getInstance();
		// 用户校验\保存用户会话信息
        UserSessionInfo sessionInfo = null;
        try{
        	Result result=usernamePasswordToken.getResult();
        	if(result==Result.REQUIRED_CHECKED){
        		sessionInfo = userMgrService
        			.loginUserSessionInfo(username, new String(password), brhno);//1_密码验证
        	}else if(result==Result.NOT_REQUIRED_CHECKED_SUCCESS){
        		sessionInfo = userMgrService
        			.loginUserSessionInfo(username, brhno);//2_跳过密码验证
        		password=MyUsernamePasswordToken.DEFAULT_PWD.toCharArray();
        	}else if(result==Result.NOT_REQUIRED_CHECKED_ERROR){//2_跳过密码时验证失败
        		throw new AuthenticationException(result.getMessage());
        	}
        }catch(CommonException cex){
        	throw new AuthenticationException(cex.getErrMessage(),cex);
        }
		return new SimpleAuthenticationInfo(sessionInfo,password,username);
	}

}
