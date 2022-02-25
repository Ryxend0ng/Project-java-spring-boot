package com.ryxen.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_comic")
public class ComicEntity extends BaseEntity{
	@Column(name = "title",nullable = false,length = 255)
	private String title;
	
	@Column(name = "author",nullable = false,length = 255)
	private String author;
	
	
	@Column(name = "short_description",nullable = true,columnDefinition = "TEXT")
	private String shortDescription;
	
	

	@Column(name = "content",nullable = true,columnDefinition = "TEXT")
	private String content;
	
	@Column(name = "view",nullable = true,length = 255)
	private String view;
	
	@Column(name = "image",nullable = true,length = 255)
	private String image;
	@Column(name = "seo",nullable = true,length = 1000)
	private String seo;

	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id")
	private CategoryEntity categories;
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "comics")
	private Set<CommentEntity> comments=new HashSet<CommentEntity>();
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "comic")
	private Set<ChappterEntity> chaps=new HashSet<ChappterEntity>();
	/**
	 * them  1 comment vao danh sach @OneToMany
	 * @param product
	 */
	public void addRelationComment(CommentEntity comment) {
		comments.add(comment);
		comment.setComics(this);
	}

	/**
	 * xoa 1 comment khoi danh sach @OneToMany
	 * @param product
	 */
	public void deleteRelationComment(CommentEntity comment) {
		comments.remove(comment);
		comment.setComics(null);
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

	public void setAuthor(String author) {
		this.author = author;
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

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public Set<CommentEntity> getComments() {
		return comments;
	}

	public void setComments(Set<CommentEntity> comments) {
		this.comments = comments;
	}

	public String getSeo() {
		return seo;
	}

	public void setSeo(String seo) {
		this.seo = seo;
	}

	
}
