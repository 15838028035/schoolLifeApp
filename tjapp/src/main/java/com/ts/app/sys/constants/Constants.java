package com.ts.app.sys.constants;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import com.ts.app.sys.utils.ReadConfig;

public class Constants {
	
	/**
	 * 用户SESSION KEY
	 */
	public static final String SESSION_USER_KEY="SESSION_USER_KEY";
	
	/**
	 * 图片验证码
	 */
	public static final String IMG_CODE="imgCode";
	
	/**
	 * 图片验证码创建时间
	 */
	public static final String IMG_BUILD_TIME="imgBuildTime";
	
	/**
	 * 返回结果（true成功，false失败）
	 */
	public static final String SUCCESS="success";
	
	/**
	 * json返回信息
	 */
	public static final String MSG="msg";

    /**
     * 是否是主干-是
     */
	public static final String MENU_IS_TRUNK_TRUE = "0";
	/**
     * 是否是主干-不是
     */
	public static final String MENU_IS_TRUNK_FALSE = "1";	
	
    /**
     * 是否有效-正常
     */
	public static final String AVAILABLE_NORMAL = "0";
	/**
     * 是否有效-冻结
     */
	public static final String AVAILABLE_NO = "1";
	/**
     * 是否有效Map
     */	
    public static final Map<String,String> AVAILABLE_MAP =new HashMap<String,String>();
    static {
    	AVAILABLE_MAP.put(AVAILABLE_NORMAL, "正常");
    	AVAILABLE_MAP.put(AVAILABLE_NO, "冻结");
    }
    
    /**
     * 是否经过外业-是
     */
	public static final String FILED_WORK_YES = "0";
	/**
     * 是否经过外业-否
     */
	public static final String FILED_WORK_NO = "1";
    /**
     * 是否经过外业
     */	
    public static final Map<String,String> FILED_WORK_MAP =new HashMap<String,String>();
    static {
    	FILED_WORK_MAP.put(FILED_WORK_YES, "是");
    	FILED_WORK_MAP.put(FILED_WORK_NO, "否");
    }
    /**
     * 删除标志
     */
    public static final String DEL_FLAG="1";
    
    /**
     * 任务状态—待接收
     */
    public static final String TASK_STATUS_TO_RECEIVE="0";
    
    /**
     * 任务状态—执行中
     */
    public static final String TASK_STATUS_IN_EXECUTION="1";
    
    /**
     * 任务状态—退回（拒绝接收任务
     */
    public static final String TASK_STATUS_RETURN="2";
    
    /**
     * 任务状态—待审核Pending audit
     */
    public static final String TASK_STATUS_PENDIND_AUDIT="3";
    
    /**
     * 任务状态—已审核
     */
    public static final String TASK_STATUS_AUDITED="4";
    
    /**
     * 任务状态—审核不通过
     */
    public static final String TASK_STATUS_NO_PASS="5";
    
    /**
     * 任务状态—超时
     */
    public static final String TASK_STATUS_TIME_OUT="6";
    /**
     *任务状态
     */	
    public static final Map<String,String> RASK_STATUS_MAP =new HashMap<String,String>();
    static {
    	RASK_STATUS_MAP.put(TASK_STATUS_TO_RECEIVE, "待接收");
    	RASK_STATUS_MAP.put(TASK_STATUS_IN_EXECUTION, "执行中");
    	RASK_STATUS_MAP.put(TASK_STATUS_RETURN, "退回");
    	RASK_STATUS_MAP.put(TASK_STATUS_PENDIND_AUDIT, "待审核");
    	RASK_STATUS_MAP.put(TASK_STATUS_AUDITED, "已审核");
    	RASK_STATUS_MAP.put(TASK_STATUS_NO_PASS, "审核不通过");
    	RASK_STATUS_MAP.put(TASK_STATUS_TIME_OUT, "超时");
    }
    
    /**
     * 成功失败状态
     */
    public static final Map<String,String> TASK_SUCCESS_FAIL=new HashMap<String,String>();
    static{
    	TASK_SUCCESS_FAIL.put(TASK_STATUS_AUDITED, "成功");
    	TASK_SUCCESS_FAIL.put(TASK_STATUS_NO_PASS, "失败");
    }
    
    /**
     *任务状态(不包括退回和超时)
     */	
    public static final Map<String,String> RASK_STATUS_NORMAL_MAP =new TreeMap<String,String>();
    static {
    	RASK_STATUS_NORMAL_MAP.put(TASK_STATUS_TO_RECEIVE, "待接收");
    	RASK_STATUS_NORMAL_MAP.put(TASK_STATUS_IN_EXECUTION, "执行中");
    	RASK_STATUS_NORMAL_MAP.put(TASK_STATUS_PENDIND_AUDIT, "待审核");
    	RASK_STATUS_NORMAL_MAP.put(TASK_STATUS_AUDITED, "已审核");
    	RASK_STATUS_NORMAL_MAP.put(TASK_STATUS_NO_PASS, "审核不通过");
    }
    
    
    /**
     * 任务不包括二次下达的状态
     */
    
    public static final String TASK_NO_SECENT_STATUS = TASK_STATUS_TO_RECEIVE+","+TASK_STATUS_RETURN+","+TASK_STATUS_TIME_OUT;
    /**
     * 任务发布状态 初次下达
     */
    public static final String TASK_RELEASE_STATUS_FIRST="0";
    
    /**
     * 任务发布状态 再次下达
     */
    public static final String TASK_RELEASE_STATUS_SECEND="1";
    
    /**
     * 任务发布状态map
     */
    public static final Map<String,String> TASK_RELEASE_STATUS_MAP = new HashMap<String,String>();
    static{
    	TASK_RELEASE_STATUS_MAP.put(TASK_RELEASE_STATUS_FIRST, "初次下达");
    	TASK_RELEASE_STATUS_MAP.put(TASK_RELEASE_STATUS_SECEND, "再次下达");
    }
    
    /**
     * 任务接收人是否被选中--否
     */
    public static final String TASK_USER_CHECKED_FALSE="0";
    
    /**
     * 任务接收人是否被选中--是
     */
    public static final String TASK_USER_CHECKED_TURE="1";
    /**
     * 项目是否收款完成--否
     */
    public static final String PROJECT_CAPITAL_STATUS_NO="0";
    
    /**
     * 项目是否收款完成--是
     */
    public static final String PROJECT_CAPITAL_STATUS_YES="1";
    
    /**
     * 项目是否收款完成
     */
    public static final Map<String,String> CAPITAL_AMOUNT_STATUS_MAP = new HashMap<String,String>();
    static{
    	CAPITAL_AMOUNT_STATUS_MAP.put("0", "未收齐");
    	CAPITAL_AMOUNT_STATUS_MAP.put("1", "已收齐");
    }
    /**
     * 文件保存路径taskDataPath
     */
    public static final String TASK_DATA_PATH=ReadConfig.getProperty("task.path");
    
    /**
     * 文件保存路径voucherPath
     */
    public static final String VOUCHER_PATH="/static/data/voucher/";
    
    /**
     * 公式常量
     */
    public static final Map<String,String> FORMULA_MAP = new HashMap<String,String>();
    static{
    	FORMULA_MAP.put("contractAmount", "项目金额");
    	FORMULA_MAP.put("passPara", "通过参数");
    	FORMULA_MAP.put("compensateAmt", "赔偿金额");
    	FORMULA_MAP.put("salary", "基本工资");
    	FORMULA_MAP.put("insurances", "各项社会缴费");
    	FORMULA_MAP.put("successTimes", "通过次数");
    	FORMULA_MAP.put("failTimes", "未通过次数");
    	FORMULA_MAP.put("projectPercent", "工序占比");
    }
    
    /**
     * admin
     */
    public static final Integer ADMIN_ROLE_ID = 1;
    
    /**
     * 设置统计显示
     */
    public static final String FORMULA_SHOW_STATUS = "1";
    /**
     * 计件工资
     */
    public static final String JI_JIAN = "计件工资";
    
	/**
     * 月末
     */
	public static final String TIME_END ="yyyy-MM-31";
	
	/**
     * 月初
     */
	public static final String TIME_START ="yyyy-MM-00";
	
	/**
     * 格式化
     */
	public static final String TIME_FORMAT ="yyyy-MM-dd HH:mm:ss";
	
	/**
     * 截止日期到期类型
     */
	public static final String NOTICE_END_TIME ="1";
	
	/**
     * 接收消息类型
     */
	public static final String NOTICE_RECEIVE ="2";
	
	/**
     * 接收审核类型
     */
	public static final String NOTICE_CHECK ="3";
	
	/**
	 * separator
	 */
	public static final String SEPARATOR = File.separator;
	/**
	 * 分公式类型
	 */
	public static final String FORMULA_FEN = "0";
	/**
	 * 总公式类型
	 */
	public static final String FORMULA_ZONG = "1";
	
	
}
