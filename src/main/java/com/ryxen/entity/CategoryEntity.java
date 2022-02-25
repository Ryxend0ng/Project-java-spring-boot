package com.ryxen.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "tbl_category")
public class CategoryEntity extends BaseEntity
{
	@Column(name = "name",nullable = false,length = 255)
	private String name;
	
	@Column(name = "code",nullable = false,length = 255)
	private String code;
	
	@Column(name = "seo",nullable = true,length = 1000)
	private String seo;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "categories",cascade = CascadeType.ALL)
	private Set<ComicEntity> comics=new HashSet<ComicEntity>();
	public String getName() {
		return name;
	}
	
	
	/**
	 * them  1 comic vao danh sach @OneToMany
	 * @param product
	 */
	public void addRelationComics(ComicEntity comic) {
		comics.add(comic);
		comic.setCategories(this);
	}

	/**
	 * xoa 1 comic khoi danh sach @OneToMany
	 * @param product
	 */
	public void deleteRelationComics(ComicEntity comic) {
		comics.remove(comic);
		comic.setCategories(null);
	}
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "categories",cascade = CascadeType.ALL)
	private Set<ComicEntity> comicsNew=new HashSet<ComicEntity>();
	
	/**
	 * them  1 news vao danh sach @OneToMany
	 * @param product
	 */
	public void addRelationNews(ComicEntity comicNews) {
		comicsNew.add(comicNews);
		comicNews.setCategories(this);
	}

	/**
	 * xoa 1 news khoi danh sach @OneToMany
	 * @param product
	 */
	public void deleteRelationNews(ComicEntity comicNews) {
		comicsNew.remove(comicNews);
		comicNews.setCategories(null);
	}
	public Set<ComicEntity> getComics() {
		return comics;
	}

	public void setComics(Set<ComicEntity> comics) {
		this.comics = comics;
	}

	public Set<ComicEntity> getComicsNew() {
		return comicsNew;
	}

	public void setComicsNew(Set<ComicEntity> comicsNew) {
		this.comicsNew = comicsNew;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSeo() {
		return seo;
	}

	public void setSeo(String seo) {
		this.seo = seo;
	}
	
}
