package com.ryxen.service;

import java.util.List;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.ryxen.dto.CategoryDTO;
import com.ryxen.dto.NewsDTO;
import com.ryxen.dto.Search;
import com.ryxen.dto.UserDTO;
import com.ryxen.entity.UserEntity;

public interface IUserService {
	UserEntity findById(Integer id);
	UserEntity loadByUserName(String name);
	List<UserDTO> findAll() throws InstantiationException, IllegalAccessException ;
	List<UserDTO> findAllWithPage(int pageNumber, int pageSize)throws InstantiationException, IllegalAccessException ;
	List<UserDTO> findAllWithPageSearch(Search search,int pageNumber, int pageSize)throws InstantiationException, IllegalAccessException ;
	int getTotaltems(int pageNumber, int pageSize);
	void saveOrUpdate(UserDTO user);
	void deleteUserByCheckBox(UserDTO dto);
	UserDTO findByEmail(String email);
	UserDTO findByUserName(String name);
}
