package com.ts.app.sys.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ts.app.sys.dao.ReplyMapper;
import com.ts.app.sys.domain.Reply;

/**
 * 回复controller
 */
@Controller
public class ReplyController extends BaseController {

	@Autowired
	private ReplyMapper replyMapper;

	@RequestMapping("/replyController/doInsert")
	@ResponseBody
	public Map<String,String> doInster(Reply reply){
		Map<String,String> retMap = new HashMap<String,String>();
		retMap.put("msg", "成功");
		retMap.put("flag", "1");
		
		try{
			Integer createuserid = getLoginUid();
			reply.setCreateuserid(createuserid);
			reply.setCreatedate(new Date());
			replyMapper.insert(reply);
		}catch(Exception e){
			retMap.put("msg", "失败");
			retMap.put("flag", "0");
		}
		
		return retMap;
	}
}
