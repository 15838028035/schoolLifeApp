package com.ts.app.sys.shiro;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.ts.app.sys.constants.Constants;
import com.ts.app.sys.domain.User;
import com.ts.app.sys.exception.CustomException;
import com.ts.app.sys.service.UserService;

public class CustomRealm extends AuthorizingRealm {  
  
    @Autowired
    private UserService userService;  
  
    //授权
    @Override  
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		//从 principals获取主身份信息
		User user =  (User) principals.getPrimaryPrincipal();
		//根据身份信息获取权限信息，从数据库获取到权限数据
		List<String> permissions = new ArrayList<String>();
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		simpleAuthorizationInfo.addStringPermissions(permissions);
		
		return simpleAuthorizationInfo;
	}
    
    //认证
    @Override  
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {  
    	String username = (String) token.getPrincipal();  // 获取用户身份信息
    	User user = new User();
    	user.setUserName(username);
        List<User> userList = userService.findUserList(user); //查询数据库获取用户信息
        if(userList.size() == 0){
        	throw new UnknownAccountException(); //没找到帐号
        }
        
        if(userList.size() > 1){
        	try {
				throw new CustomException("有重复用户存在"); //用户重复
			} catch (CustomException e) {
				e.printStackTrace();
			} 
        }
        user = userList.get(0); //得到用户信息+
        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
				user, user.getPassword(),ByteSource.Util.bytes(user.getSalt()), this.getName());        
        return simpleAuthenticationInfo;  
    }  
    
    @Override  
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {  
        super.clearCachedAuthorizationInfo(principals);  
    }  
    
    @Override  
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {  
        super.clearCachedAuthenticationInfo(principals);  
    }
  
    @Override  
    public void clearCache(PrincipalCollection principals) {  
        super.clearCache(principals);  
    }  
  
    public void clearAllCachedAuthorizationInfo() {  
        getAuthorizationCache().clear();  
    }  
  
    public void clearAllCachedAuthenticationInfo() {  
        getAuthenticationCache().clear();  
    }  
  
    public void clearAllCache() {  
        clearAllCachedAuthenticationInfo();  
        clearAllCachedAuthorizationInfo();  
    }  
  
} 