package com.ts.app.sys.domain;

public class Article extends BaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5482545360200806056L;
	/**
	 * 文章id
	 */
	private Integer articleId;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 文章内容
	 */
	private String articleContent;	
	/**
	 * 图片路径
	 */
	private String imgUrl;	
	/**
	 * 点赞数
	 */
	private String likeNum;
	/**
	 * 评价数
	 */
	private String evaluateNum;
	public Integer getArticleId() {
		return articleId;
	}
	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArticleContent() {
		return articleContent;
	}
	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getLikeNum() {
		return likeNum;
	}
	public void setLikeNum(String likeNum) {
		this.likeNum = likeNum;
	}
	public String getEvaluateNum() {
		return evaluateNum;
	}
	public void setEvaluateNum(String evaluateNum) {
		this.evaluateNum = evaluateNum;
	}
	
	

}
