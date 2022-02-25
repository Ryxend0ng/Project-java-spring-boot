package com.ryxen.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ryxen.dto.ComicDTO;
import com.ryxen.entity.ComicEntity;
import com.ryxen.repository.CategoryRepository;

@Component
public class ComicConverter {
	@Autowired
	private CategoryRepository categoryRepository;
	
	public ComicEntity toEntity(ComicEntity entity,ComicDTO dto) {
		if(dto.getId() != null) {
			entity.setId(dto.getId());
		}
			entity.setTitle(dto.getTitle());
			entity.setAuthor(dto.getAuthor());
			entity.setShortDescription(dto.getShortDescription());
	//		entity.setView(dto.getView());
	//		entity.setContent(dto.getContent());
			
	//		entity.setStatus(dto.getStatus());
			entity.setSeo(dto.getSeo());
			entity.setCategories(categoryRepository.getById(dto.getCategoryId()));
			if(dto.getFile() != null) { 
				entity.setImage("/template/web/image/"+dto.getFile().getOriginalFilename());
			}
		
		return entity;
	}
	public ComicDTO toDto(ComicEntity entity,ComicDTO dto) {
		if(entity.getId() != null) {
			dto.setId(entity.getId());
		}
			dto.setTitle(entity.getTitle());
			dto.setAuthor(entity.getAuthor());
			dto.setShortDescription(entity.getShortDescription());
			dto.setView(entity.getView());
			dto.setContent(entity.getContent());
			dto.setImage(entity.getImage());
			dto.setStatus(entity.getStatus());
			dto.setSeo(entity.getSeo());
			dto.setCategoryId(entity.getCategories().getId());
			
		
		return dto;
	}
}
