package com.ryxen.dto;


public class CommentDTO extends BaseDTO{
	private String type;
	private String content;
	private Integer userId;
	private Integer newsId;
	private Integer comicId;
	
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getNewsId() {
		return newsId;
	}
	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}
	public Integer getComicId() {
		return comicId;
	}
	public void setComicId(Integer comicId) {
		this.comicId = comicId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	

}
