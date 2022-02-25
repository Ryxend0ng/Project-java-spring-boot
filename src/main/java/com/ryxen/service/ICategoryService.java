package com.ryxen.service;

import java.util.List;

import com.ryxen.dto.CategoryDTO;
import com.ryxen.dto.ComicDTO;
import com.ryxen.dto.Search;

public interface ICategoryService {
	CategoryDTO findByCode(String code);
	CategoryDTO findById(Integer id);
	List<CategoryDTO> findAll();
	List<CategoryDTO> findAllWithPage(int pageNumber, int pageSize)throws InstantiationException, IllegalAccessException ;
	List<CategoryDTO> findAllWithPageSearch(Search search,int pageNumber, int pageSize)throws InstantiationException, IllegalAccessException ;
	int getTotaltems(int pageNumber, int pageSize);
	void saveOrUpdate(CategoryDTO cate);
	void deleteCategoryByCheckBox(CategoryDTO dto);
}
