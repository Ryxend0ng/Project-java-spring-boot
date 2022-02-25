package com.ryxen.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ryxen.dto.NewsDTO;
import com.ryxen.entity.NewsEntity;
import com.ryxen.repository.CategoryRepository;

@Component
public class NewsConverter {
	@Autowired
	private CategoryRepository categoryRepository;
	public NewsEntity toEntity(NewsEntity entity,NewsDTO dto) {
		if(dto.getId() != null) {
			entity.setId(dto.getId());
		}
			entity.setTitle(dto.getTitle());
			entity.setContent(dto.getContent());
			if(dto.getImage() != null) {
			entity.setImage(dto.getImage());
			}
			entity.setStatus(dto.getStatus());
			entity.setView(dto.getView());
			entity.setSeo(dto.getSeo());
			entity.setShortDescription(dto.getShortDescription());
			entity.setCategories(categoryRepository.getById(dto.getCategoryId()));
		
		return entity;
	}
	public NewsDTO toDto(NewsEntity entity,NewsDTO dto) {
		if(entity.getId() != null) {
			dto.setId(entity.getId());
		}
			dto.setTitle(entity.getTitle());
			dto.setContent(entity.getContent());
			dto.setImage(entity.getImage());
			dto.setStatus(entity.getStatus());
			dto.setView(entity.getView());
			dto.setSeo(entity.getSeo());
			dto.setShortDescription(entity.getShortDescription());
			dto.setCategoryId(entity.getCategories().getId());	
		return dto;
	}

}
