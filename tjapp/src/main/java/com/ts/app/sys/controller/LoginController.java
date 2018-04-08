package com.ts.app.sys.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.session.SessionException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Maps;
import com.ts.app.sys.constants.Constants;
import com.ts.app.sys.domain.User;
import com.ts.app.sys.service.UserService;
import com.ts.app.sys.shiro.CustomRealm;
import com.ts.app.sys.shiro.CustomUsernamePasswordToken;
import com.ts.app.sys.utils.CacheUtils;
import com.ts.app.sys.utils.DateTimeUtil;

@Controller
public class LoginController{
	
	@Autowired
	private UserService userService;  
	
	@Autowired
	private CustomRealm customRealm;
	
	private static Logger logger = Logger.getLogger(LoginController.class);
	
	
	/** 
     * ��¼
     */
    @RequestMapping(value = "/loginSubmit")
    @ResponseBody
    public Map loginSubmit(HttpServletRequest request,String userName,String password) { 
        Map map = Maps.newHashMap();
    	boolean result = false;
        String errorMessage = "";
        if(!checkImgCode(request)){ //У��ͼƬ��֤��
    		errorMessage = "��֤�벻��ȷ";
    	}else{
	        // ��ȡ��ǰʵ����Ϣ
	        Subject subject = SecurityUtils.getSubject();  
	        
	        CustomUsernamePasswordToken token = new CustomUsernamePasswordToken(userName, password); 
	        token.setRememberMe(true);  
	        try {
	            subject.login(token);
	        } catch (UnknownAccountException e) {  
	            errorMessage = "�û����������벻��ȷ";  
	        } catch (IncorrectCredentialsException e) {  
	            errorMessage = "�û����������벻��ȷ";  
	        } catch (LockedAccountException e) {  
	            errorMessage = "��ǰ�û���ͣ��,���ܵ�¼";  
	        }catch (AuthenticationException e) {  
	            errorMessage = "��¼ʧ��";  
	            logger.error("��¼ʧ�ܣ�" + e);
	            e.printStackTrace();
	            token.clear();
	        }
    	}
        //��ȡsession
        HttpSession session = request.getSession(false);
        // ��ȡsession��ǰһ�ε����url
        String url = (String) session.getAttribute(Constants.URL_KEY); 
        if(!StringUtils.isEmpty(url)){
        	map.put(Constants.URL_KEY, url);
        }
        map.put(Constants.SUCCESS, result);
        map.put(Constants.MSG, errorMessage);
        return map;
    }
    
    /**
	 * У����֤��
	 */
	public boolean checkImgCode(HttpServletRequest request){
		boolean result = false;
		HttpSession session = request.getSession(false);
		String validCode = (String) session.getAttribute(Constants.IMG_CODE); // ��ȡsession����ȷ����֤��
		String imgCode = request.getParameter("imgCode"); //ȡ���������֤��,����session�е���֤���жԱ� 
		if(validCode!=null && imgCode!=null 
				&& validCode.equalsIgnoreCase(imgCode)){
			result = true; 
		}
		return result;
	}
   
}
