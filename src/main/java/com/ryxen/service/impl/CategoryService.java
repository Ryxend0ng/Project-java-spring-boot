package com.ryxen.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ryxen.converter.CategoryConverter;
import com.ryxen.dto.CategoryDTO;
import com.ryxen.dto.ComicDTO;
import com.ryxen.dto.Search;
import com.ryxen.entity.CategoryEntity;
import com.ryxen.entity.ComicEntity;
import com.ryxen.repository.CategoryRepository;
import com.ryxen.service.ICategoryService;
@Service
public class CategoryService extends BaseService<CategoryDTO, CategoryEntity> implements ICategoryService{
	
	@Autowired
	private CategoryRepository caRepo;
	@Autowired
	private CategoryConverter caConvert;
	@Override
	public CategoryDTO findByCode(String code) {
		// TODO Auto-generated method stub
		CategoryEntity cateEntiy= caRepo.findByCode(code);	
		return caConvert.toDto(cateEntiy, new CategoryDTO());
	}
	@Override
	public List<CategoryDTO> findAll() {
		// TODO Auto-generated method stub
		List<CategoryEntity> categorys=caRepo.findAll();
		List<CategoryDTO> categoryList=new ArrayList<CategoryDTO>();
		for(CategoryEntity category : categorys) {
			CategoryDTO cateDto=new CategoryDTO();
			cateDto=caConvert.toDto(category, cateDto);
			categoryList.add(cateDto);
		}
		return categoryList;
	}
	@Override
	public List<CategoryDTO> findAllWithPage(int pageNumber, int pageSize)
			throws InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		Pageable page=PageRequest.of(pageNumber, pageSize);		 
	    Page<CategoryEntity> pagedResult = caRepo.findAllWithPage(page);
		List<CategoryEntity> cate=pagedResult.getContent();
		return convertList(cate);
		
	}
	@Override
	public int getTotaltems(int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		Pageable page=PageRequest.of(pageNumber, pageSize);
	    Page<CategoryEntity> pagedResult = caRepo.findAllByTypePage();
	
	    PageImpl<CategoryEntity> pageImpl=new PageImpl<CategoryEntity>(pagedResult.getContent(), page,pagedResult.getTotalElements());
	    System.out.println("totale:"+pageImpl.getTotalElements());
	   
		return pageImpl.getSize() == 0 ? 1 : (int) Math.ceil((double) pagedResult.getTotalElements() / (double) pageImpl.getSize());
	}
	@Override
	protected Class<CategoryDTO> clazz() {
		// TODO Auto-generated method stub
		return CategoryDTO.class;
	}
	@Override
	@Transactional
	public void saveOrUpdate(CategoryDTO cate) {
		// TODO Auto-generated method stub
		CategoryEntity entity=new CategoryEntity();
		entity=caConvert.toEntity(entity, cate);
		caRepo.saveOrUpdate(entity);
	}
	@Override
	@Transactional
	public void deleteCategoryByCheckBox(CategoryDTO dto) {
		// TODO Auto-generated method stub
		if(dto.getIds() != null) {
			for(int i=0;i<dto.getIds().length;i++) {
				CategoryEntity entity=new CategoryEntity();
				entity.setId(dto.getIds()[i]);
				caRepo.deleteById(entity.getId());
			}
		}else {
			CategoryEntity entity=new CategoryEntity();
			entity.setId(dto.getId());
			caRepo.deleteById(dto.getId());
		}
	}
	@Override
	public List<CategoryDTO> findAllWithPageSearch(Search search, int pageNumber, int pageSize)
			throws InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		Pageable page=PageRequest.of(pageNumber, pageSize);		 
	    Page<CategoryEntity> pagedResult = caRepo.searchAndListPage(search, page);
	    List<CategoryEntity> cate=pagedResult.getContent();
		return convertList(cate);
	}
	@Override
	public CategoryDTO findById(Integer id) {
		// TODO Auto-generated method stub
		CategoryEntity cate=caRepo.findById(id);
		return caConvert.toDto(cate, new CategoryDTO());
	}

}
