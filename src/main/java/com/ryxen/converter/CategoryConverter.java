package com.ryxen.converter;

import org.springframework.stereotype.Component;

import com.ryxen.dto.CategoryDTO;
import com.ryxen.entity.CategoryEntity;

@Component
public class CategoryConverter {
	public CategoryEntity toEntity(CategoryEntity entity,CategoryDTO dto) {
		if(dto.getId()!= null) {
			entity.setId(dto.getId());
		}
		entity.setCode(dto.getCode());
		entity.setName(dto.getName());
		entity.setStatus(dto.getStatus());
		return entity;
	}
	public CategoryDTO toDto(CategoryEntity entity,CategoryDTO dto) {
		if(entity.getId()!= null) {
			dto.setId(entity.getId());
		}
		dto.setCode(entity.getCode());
		dto.setName(entity.getName());
		dto.setStatus(entity.getStatus());
		return dto;
	}
}
