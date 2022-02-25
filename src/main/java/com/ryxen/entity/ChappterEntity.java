package com.ryxen.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_chappter")
public class ChappterEntity extends BaseEntity{
	@Column(name = "path",nullable = true,length = 1000)
	private String path;
	
	@Column(name = "name",nullable = true,length = 45)
	private String name;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "comic_id")
	private ComicEntity comic;
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ComicEntity getComic() {
		return comic;
	}

	public void setComic(ComicEntity comic) {
		this.comic = comic;
	}
	
	
}
