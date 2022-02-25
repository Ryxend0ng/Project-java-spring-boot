package com.ryxen.dto;



import org.springframework.web.multipart.MultipartFile;

import com.ryxen.entity.CategoryEntity;

public class ComicDTO extends BaseDTO{
	private String author;
	private String shortDescription;
	private String content;
	private String view;
	private String image;
	private String title;
	private String seo;
	private Integer categoryId;
	private CategoryEntity categories;
	private MultipartFile file;
	
	
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public CategoryEntity getCategories() {
		return categories;
	}
	public void setCategories(CategoryEntity categories) {
		this.categories = categories;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getView() {
		return view;
	}
	public void setView(String view) {
		this.view = view;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getSeo() {
		return seo;
	}
	public void setSeo(String seo) {
		this.seo = seo;
	}
	
}
