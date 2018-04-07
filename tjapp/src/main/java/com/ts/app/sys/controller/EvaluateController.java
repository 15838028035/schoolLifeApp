package com.ts.app.sys.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ts.app.sys.dao.EvaluateMapper;
import com.ts.app.sys.domain.Evaluate;

/**
 * 评价controller
 */
@Controller
public class EvaluateController extends BaseController {

	@Autowired
	private EvaluateMapper evaluateMapper;

	@RequestMapping("/evaluateController/list")
	@ResponseBody
	public List<Evaluate> list(Integer articleid){
		Map<String,Object> filterMap = new HashMap<String,Object>();
		filterMap.put("articleid", articleid);
		 List<Evaluate>  articleList= 	evaluateMapper.queryListByArticeId(articleid);
		return articleList;
	}
}
