package com.ryxen.repository;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Repository;

import com.ryxen.entity.CommentEntity;

@Repository
public class CommentRepository extends BaseRepository<CommentEntity>{

	@Override
	protected Class<CommentEntity> clazz() {
		// TODO Auto-generated method stub
		return CommentEntity.class;
	}
	public CommentEntity addComment(CommentEntity coment) {
		CommentEntity com=saveOrUpdate(coment);
		Calendar cd=Calendar.getInstance();
		Date now=cd.getTime();
		
		
		com.setCreatedDate(now);
		return com;
	}
}
