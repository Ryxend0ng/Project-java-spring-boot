package com.ryxen.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.ryxen.converter.UserConverter;
import com.ryxen.dto.Search;
import com.ryxen.dto.UserDTO;
import com.ryxen.entity.CategoryEntity;
import com.ryxen.entity.RoleEntity;
import com.ryxen.entity.UserEntity;
import com.ryxen.repository.UserRepository;
import com.ryxen.service.IUserService;

@Service
public class UserService  extends BaseService<UserDTO, UserEntity> implements IUserService{
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private UserConverter userConvert;
	@Override
	protected Class<UserDTO> clazz() {
		// TODO Auto-generated method stub
		return UserDTO.class;
	}
	@Override
	public UserEntity findById(Integer id) {
		// TODO Auto-generated method stub
		return userRepo.findById(id);
	}
	@Override
	public UserEntity loadByUserName(String name) {
		// TODO Auto-generated method stub
		return userRepo.loadByUserName(name);
	}
	@Override
	public List<UserDTO> findAll() throws InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		List<UserEntity> users=userRepo.findAll();
		return convertList(users);
	}
	@Override
	public List<UserDTO> findAllWithPage(int pageNumber, int pageSize)
			throws InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		Pageable page=PageRequest.of(pageNumber, pageSize);		 
	    Page<UserEntity> pagedResult = userRepo.findAllWithPage(page);
		List<UserEntity> user=pagedResult.getContent();
		return convertList(user);
	}
	@Override
	public int getTotaltems(int pageNumber, int pageSize) {
		Pageable page=PageRequest.of(pageNumber, pageSize);
	    Page<UserEntity> pagedResult = userRepo.findAllByTypePage();
	
	    PageImpl<UserEntity> pageImpl=new PageImpl<UserEntity>(pagedResult.getContent(), page,pagedResult.getTotalElements());
	    System.out.println("totale:"+pageImpl.getTotalElements());
	   
		return pageImpl.getSize() == 0 ? 1 : (int) Math.ceil((double) pagedResult.getTotalElements() / (double) pageImpl.getSize());
	}
	@Override
	public void saveOrUpdate(UserDTO user) {
		// TODO Auto-generated method stub
		UserEntity entity=new UserEntity();
		entity=userConvert.toEntity(entity, user);
		userRepo.saveOrUpdate(entity);
	}
	@Override
	@Transactional
	public void deleteUserByCheckBox(UserDTO dto) {
		// TODO Auto-generated method stub
		if(dto.getIds() != null) {
		for(int i=0;i<dto.getIds().length;i++) {
			UserEntity entity=new UserEntity();
			entity.setId(dto.getIds()[i]);
			userRepo.deleteById(entity.getId());
		}
	}else {
		UserEntity entity=new UserEntity();
		entity.setId(dto.getId());
		userRepo.deleteById(entity.getId());
	}
	}
	@Override
	public List<UserDTO> findAllWithPageSearch(Search search, int pageNumber, int pageSize)
			throws InstantiationException, IllegalAccessException {
		Pageable page=PageRequest.of(pageNumber, pageSize);		 
	    Page<UserEntity> pagedResult = userRepo.searchAndListPage(search, page);
	    List<UserEntity> users=pagedResult.getContent();
		return convertList(users);
	}
	@Override
	public UserDTO findByEmail(String email) {
		// TODO Auto-generated method stub
		
		UserEntity user= userRepo.findByEmail(email);
		
		return userConvert.toDTO(user, new UserDTO());
	}
	@Override
	public UserDTO findByUserName(String name) {
		UserEntity user= userRepo.findByUserName(name);
		
		return userConvert.toDTO(user, new UserDTO());
	}
	

}
