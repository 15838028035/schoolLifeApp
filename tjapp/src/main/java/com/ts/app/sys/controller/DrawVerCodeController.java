package com.ts.app.sys.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ts.app.sys.constants.Constants;
import com.ts.app.sys.utils.SCaptcha;

@Controller
public class DrawVerCodeController {
	
	/**
     * @description ����ͼƬ��֤��
     */
    @RequestMapping(value = "/drawVerCode")
    @ResponseBody
    public void drawVerCode(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        // ������Ӧ�����͸�ʽΪͼƬ��ʽ
        response.setContentType("image/jpeg");
        // ��ֹͼ�񻺴档
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        //ʵ��������֤�����
        SCaptcha instance = new SCaptcha();
        //����֤�����session
        session.setAttribute(Constants.IMG_CODE, instance.getCode());
        //��ҳ�������֤��ͼƬ
        instance.write(response.getOutputStream());
    }
    
    public static void main(String[] args) {  
    	SCaptcha vCode = new SCaptcha();  
        try {  
            String path="D:/t/"+new Date().getTime()+".png";  
            System.out.println(vCode.getCode()+" >"+path);  
            vCode.write(path);  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    } 
}

