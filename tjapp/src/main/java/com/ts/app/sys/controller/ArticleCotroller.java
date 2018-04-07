package com.ts.app.sys.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ts.app.sys.dao.ArticleMapper;
import com.ts.app.sys.domain.Article;

/**
 * 
 * 文章controller
 *
 */
public class ArticleCotroller extends BaseController{
	
	@Autowired
	private ArticleMapper articleMapper;

	@RequestMapping("/articleController/doInsert")
	@ResponseBody
	public Map<String,String> doInster(Article article){
		Map<String,String> retMap = new HashMap<String,String>();
		retMap.put("msg", "成功");
		retMap.put("flag", "1");
		
		try{
		Integer createuserid = getLoginUid();
		article.setCreateuserid(createuserid);
		article.setCreatedate(new Date());
		articleMapper.insert(article);
		}catch(Exception e){
			retMap.put("msg", "发布失败");
			retMap.put("flag", "0");
		}
		
		return retMap;
	}
}
