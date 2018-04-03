package com.ts.app.sys.domain;

public class Reply extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7069853283990547332L;
	
	/**
	 * 回复id
	 */
	private Integer replyId;
	/**
	 * 评价id
	 */
	private Integer articleId;
	/**
	 * 回复内容
	 */
	private String repayContent;	
	/**
	 * 是否已读
	 */
	private String isReaded;
	public Integer getReplyId() {
		return replyId;
	}
	public void setReplyId(Integer replyId) {
		this.replyId = replyId;
	}
	public Integer getArticleId() {
		return articleId;
	}
	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
	public String getRepayContent() {
		return repayContent;
	}
	public void setRepayContent(String repayContent) {
		this.repayContent = repayContent;
	}
	public String getIsReaded() {
		return isReaded;
	}
	public void setIsReaded(String isReaded) {
		this.isReaded = isReaded;
	}
	
	

}
