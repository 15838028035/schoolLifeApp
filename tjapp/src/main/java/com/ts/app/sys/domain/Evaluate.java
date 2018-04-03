package com.ts.app.sys.domain;

public class Evaluate extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8591340552178696944L;
	
	/**
	 * 评价id
	 */
	private Integer evaluateId;
	/**
	 * 文章id
	 */
	private Integer articleId;
	/**
	 * 评价内容
	 */
	private String evaluateContent;	
	/**
	 * 是否已读
	 */
	private String isReaded;
	public Integer getEvaluateId() {
		return evaluateId;
	}
	public void setEvaluateId(Integer evaluateId) {
		this.evaluateId = evaluateId;
	}
	public Integer getArticleId() {
		return articleId;
	}
	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
	public String getEvaluateContent() {
		return evaluateContent;
	}
	public void setEvaluateContent(String evaluateContent) {
		this.evaluateContent = evaluateContent;
	}
	public String getIsReaded() {
		return isReaded;
	}
	public void setIsReaded(String isReaded) {
		this.isReaded = isReaded;
	}	
	
}
