package com.ts.app.sys.dao;

import java.util.List;
import java.util.Map;

import com.ts.app.sys.domain.Article;

public interface ArticleMapper {
    int deleteByPrimaryKey(Integer articleid);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Integer articleid);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKeyWithBLOBs(Article record);

    int updateByPrimaryKey(Article record);
    
	public List<Article> queryListArticle(Map<String, Object> filterMap) ;
	
	public List<Article> queryListArticle2(Map<String, Object> filterMap) ;
}