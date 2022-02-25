package com.ryxen.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ryxen.converter.RoleConverter;
import com.ryxen.dto.RoleDTO;
import com.ryxen.dto.Search;
import com.ryxen.entity.CategoryEntity;
import com.ryxen.entity.NewsEntity;
import com.ryxen.entity.RoleEntity;
import com.ryxen.entity.UserEntity;
import com.ryxen.repository.RoleRepository;
import com.ryxen.service.IRoleService;

@Service
public class RoleService extends BaseService<RoleDTO, RoleEntity> implements IRoleService{
	
	@Autowired
	private RoleRepository roleRepo;
	@Autowired
	private RoleConverter roleConvert;
	@Override
	protected Class<RoleDTO> clazz() {
		// TODO Auto-generated method stub
		return RoleDTO.class;
	}
	@Override
	public List<RoleDTO> findAll() throws InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		List<RoleEntity> roles=roleRepo.findAll();
		return convertList(roles) ;
	}
	@Override
	public List<RoleDTO> findAllWithPage(int pageNumber, int pageSize)
			throws InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
				Pageable page=PageRequest.of(pageNumber, pageSize);		 
			    Page<RoleEntity> pagedResult = roleRepo.findAllWithPage(page);
				List<RoleEntity> role=pagedResult.getContent();
				return convertList(role);
	}
	@Override
	public int getTotaltems(int pageNumber, int pageSize) {
		Pageable page=PageRequest.of(pageNumber, pageSize);
	    Page<RoleEntity> pagedResult = roleRepo.findAllByTypePage();
	
	    PageImpl<RoleEntity> pageImpl=new PageImpl<RoleEntity>(pagedResult.getContent(), page,pagedResult.getTotalElements());
	    System.out.println("totale:"+pageImpl.getTotalElements());
	   
		return pageImpl.getSize() == 0 ? 1 : (int) Math.ceil((double) pagedResult.getTotalElements() / (double) pageImpl.getSize());
	}
	@Override
	public void saveOrUpdate(RoleDTO role) {
		// TODO Auto-generated method stub
		RoleEntity entity=new RoleEntity();
		entity=roleConvert.toEntity(entity, role);
		roleRepo.saveOrUpdate(entity);
	}
	@Override
	public RoleDTO findByCode(String code) {
		// TODO Auto-generated method stub
		RoleEntity entity=new RoleEntity();
		entity=roleRepo.findByCode(code);
		return roleConvert.toDTO(entity, new RoleDTO());
	}
	@Override
	@Transactional
	public void deleteRoleByCheckBox(RoleDTO dto) {
		// TODO Auto-generated method stub
		if(dto.getIds() !=  null) {
		for(int i=0;i<dto.getIds().length;i++) {
			RoleEntity entity=new RoleEntity();
			entity.setId(dto.getIds()[i]);
			roleRepo.deleteById(entity.getId());
		}
	}else {
		RoleEntity entity=new RoleEntity();
		entity.setId(dto.getId());
		roleRepo.deleteById(entity.getId());
	}
	}
	@Override
	public List<RoleDTO> findAllWithPageSearch(Search search, int pageNumber, int pageSize)
			throws InstantiationException, IllegalAccessException {
		Pageable page=PageRequest.of(pageNumber, pageSize);		 
	    Page<RoleEntity> pagedResult = roleRepo.searchAndListPage(search, page);
	    List<RoleEntity> role=pagedResult.getContent();
		return convertList(role);
	}

	

}
