package com.ryxen.service;

import java.util.List;

import com.ryxen.dto.CategoryDTO;
import com.ryxen.dto.NewsDTO;
import com.ryxen.dto.RoleDTO;
import com.ryxen.dto.Search;
import com.ryxen.dto.UserDTO;

public interface IRoleService {
	List<RoleDTO> findAll() throws InstantiationException, IllegalAccessException ;
	List<RoleDTO> findAllWithPage(int pageNumber, int pageSize)throws InstantiationException, IllegalAccessException ;
	List<RoleDTO> findAllWithPageSearch(Search search,int pageNumber, int pageSize)throws InstantiationException, IllegalAccessException ;
	int getTotaltems(int pageNumber, int pageSize);
	void saveOrUpdate(RoleDTO role);
	RoleDTO findByCode(String code);
	void deleteRoleByCheckBox(RoleDTO dto);
}
