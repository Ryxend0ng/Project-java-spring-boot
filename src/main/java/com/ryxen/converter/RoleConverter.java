package com.ryxen.converter;

import org.springframework.stereotype.Component;

import com.ryxen.dto.RoleDTO;
import com.ryxen.dto.UserDTO;
import com.ryxen.entity.RoleEntity;
import com.ryxen.entity.UserEntity;

@Component
public class RoleConverter {
	public RoleEntity toEntity(RoleEntity entity,RoleDTO dto) {
		if(dto.getId() != null) {
			entity.setId(dto.getId());
		}
		entity.setName(dto.getName());
		entity.setCode(dto.getCode());
		entity.setStatus(dto.getStatus());
		return entity;
	}
	public RoleDTO toDTO(RoleEntity entity,RoleDTO dto) {
		if(entity.getId() != null) {
			dto.setId(entity.getId());
		}
		dto.setName(entity.getName());
		dto.setCode(entity.getCode());
		dto.setStatus(entity.getStatus());
		return dto;
	}
}
