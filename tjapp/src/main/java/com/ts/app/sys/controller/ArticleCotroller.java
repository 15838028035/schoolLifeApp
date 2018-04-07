package com.ts.app.sys.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ts.app.sys.dao.ArticleMapper;
import com.ts.app.sys.domain.Article;

/**
 * 
 * 文章controller
 *
 */
@Controller
public class ArticleCotroller extends BaseController{
	
	@Autowired
	private ArticleMapper articleMapper;

	@RequestMapping("/articleController/list")
	@ResponseBody
	public List<Article> list(){
			Map<String,String> filterMap = new HashMap<String,String>();
			if(!isAdminLogin()){
				Integer createuserid = getLoginUid();
				filterMap.put("dynamicWhere", " where createUserId="+createuserid);
			}else {
				filterMap.put("dynamicWhere", " ");
			}
			
			 List<Article>  articleList= 	articleMapper.queryListArticle(filterMap);
		return articleList;
	}
	
	/**
	 * 我的帖子
	 */
	@RequestMapping("/articleController/listMy")
	@ResponseBody
	public List<Article> listMy(){
			Map<String,String> filterMap = new HashMap<String,String>();
				Integer createuserid = getLoginUid();
				filterMap.put("dynamicWhere", " where createUserId="+createuserid);
			 List<Article>  articleList= 	articleMapper.queryListArticle(filterMap);
		return articleList;
	}
	
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
	
	@RequestMapping("/articleController/get")
	@ResponseBody
	public Article get(Integer articleid){
		Article article = new Article();
		try{
			
			article = articleMapper.selectByPrimaryKey(articleid);
		}catch(Exception e){
			
		}
		
		return article;
	}
}
