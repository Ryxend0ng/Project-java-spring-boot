package com.ryxen.converter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.ryxen.dto.UserDTO;
import com.ryxen.entity.RoleEntity;
import com.ryxen.entity.UserEntity;
import com.ryxen.repository.RoleRepository;

@Component
public class UserConverter {
	@Autowired
	private RoleRepository roleRepo;
	@SuppressWarnings("unchecked")
	public UserEntity toEntity(UserEntity entity,UserDTO dto) {
		if(dto.getId() != null) {
			entity.setId(dto.getId());
		}
		entity.setUserName(dto.getUserName());
		
		entity.setPassword(new BCryptPasswordEncoder(10).encode(dto.getPassword()));
		entity.setEmail(dto.getEmail());
		entity.setStatus(dto.getStatus());
		if(dto.getRoleId() != null) {
			entity.addUserAndRoleIntoTblUseRole(roleRepo.getById(dto.getRoleId()));
		}
		return entity;
	}
	public UserDTO toDTO(UserEntity entity,UserDTO dto) {
		if(entity.getId() != null) {
			dto.setId(entity.getId());
		}
		dto.setUserName(entity.getUserName());
		dto.setPassword(entity.getPassword());
		dto.setEmail(entity.getEmail());
		dto.setStatus(entity.getStatus());
		dto.setImageUrl(entity.getImageUrl());
		return dto;
	}
}
