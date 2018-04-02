package com.ts.app.sys.utils;

public class CommonUtil {

	/**
	 * 生成项目编号
	 * @return
	 */
	public static String getProjectCode(){
		String projectCode ="P_";
		projectCode+=System.currentTimeMillis()+"";
		return projectCode;
	}
	
	/**
	 * 生成任务编号
	 */
	public static String getTaskCode(){
		String taskCode ="T_";
		taskCode+=System.currentTimeMillis()+"";
		return taskCode;
	}
}
