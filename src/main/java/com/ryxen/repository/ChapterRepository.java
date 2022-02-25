package com.ryxen.repository;

import org.springframework.stereotype.Repository;

import com.ryxen.entity.ChappterEntity;

@Repository
public class ChapterRepository extends BaseRepository<ChappterEntity>{

	@Override
	protected Class<ChappterEntity> clazz() {
		// TODO Auto-generated method stub
		return ChappterEntity.class;
	}

}
