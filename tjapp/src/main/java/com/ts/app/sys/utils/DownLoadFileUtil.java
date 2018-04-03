package com.ts.app.sys.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

public class DownLoadFileUtil {

	public static void loadFile(HttpServletResponse response,String filePath,String fileName) throws Exception{
		fileName = new String(fileName.getBytes("ISO-8859-1"),"UTF-8"); 
		File file = new File(filePath + File.separator + fileName);
   		FileInputStream in = new FileInputStream(file);
		OutputStream out = response.getOutputStream();
		if (file.exists()) {
			response.setCharacterEncoding("utf-8");
			response.setHeader("content-disposition", "attachment;filename="+ URLEncoder.encode(fileName, "UTF-8"));
    		byte buffer[] = new byte[1024];
    		int len = 0;
    		while ((len = in.read(buffer)) > 0) {
    			out.write(buffer, 0, len);
    		}
    		in.close();
    		out.close();
        }
	}
}
