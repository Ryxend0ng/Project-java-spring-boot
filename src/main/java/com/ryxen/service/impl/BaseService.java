package com.ryxen.service.impl;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryxen.converter.CategoryConverter;
import com.ryxen.converter.ComicConverter;
import com.ryxen.converter.NewsConverter;
import com.ryxen.converter.RoleConverter;
import com.ryxen.converter.UserConverter;
import com.ryxen.dto.BaseDTO;
import com.ryxen.dto.CategoryDTO;
import com.ryxen.dto.ComicDTO;
import com.ryxen.dto.NewsDTO;
import com.ryxen.dto.RoleDTO;
import com.ryxen.dto.UserDTO;
import com.ryxen.entity.BaseEntity;
import com.ryxen.entity.CategoryEntity;
import com.ryxen.entity.ComicEntity;
import com.ryxen.entity.NewsEntity;
import com.ryxen.entity.RoleEntity;
import com.ryxen.entity.UserEntity;
import com.ryxen.repository.BaseRepository;

@Service
public abstract class BaseService <E extends BaseDTO, T> {
	@Autowired
	private CategoryConverter cateConvert;
	@Autowired
	private UserConverter userConvert;
	@Autowired
	private NewsConverter newsConvert;
	@Autowired
	private ComicConverter comicConvert;
	@Autowired
	private RoleConverter roleConvert;
	protected abstract Class<E> clazz();
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<E> convertList(List<T> listEntity) throws InstantiationException, IllegalAccessException{
		
		List<E> listDto=new ArrayList<E>();
		for(T entity : listEntity) {
			E dto=clazz().newInstance();
			if(equals(dto,new CategoryDTO())) {
				//CategoryDTO cateDto=(CategoryDTO) dto;
				dto=(E) new CategoryDTO();
				
				dto=(E) cateConvert.toDto((CategoryEntity)entity, (CategoryDTO)dto);
				listDto.add(dto);
			}else if(equals(dto,new ComicDTO())) {
				//CategoryDTO cateDto=(CategoryDTO) dto;
				dto=(E) new ComicDTO();
				
				dto=(E) comicConvert.toDto((ComicEntity)entity, (ComicDTO)dto);
				listDto.add(dto);
			}else if(equals(dto,new NewsDTO())) {
				//CategoryDTO cateDto=(CategoryDTO) dto;
				dto=(E) new NewsDTO();
				
				dto=(E) newsConvert.toDto((NewsEntity)entity, (NewsDTO)dto);
				listDto.add(dto);
			}else if(equals(dto,new UserDTO())) {
				//CategoryDTO cateDto=(CategoryDTO) dto;
				dto=(E) new UserDTO();
				
				dto=(E) userConvert.toDTO((UserEntity)entity, (UserDTO)dto);
				listDto.add(dto);
			}else if(equals(dto,new RoleDTO())) {
				//CategoryDTO cateDto=(CategoryDTO) dto;
				dto=(E) new RoleDTO();
				
				dto=(E) roleConvert.toDTO((RoleEntity)entity, (RoleDTO)dto);
				listDto.add(dto);
			}
		}
		return listDto;
	}
	public boolean equals(E dto,Object obj) {
		return dto.getClass() == obj.getClass();
	}
}
