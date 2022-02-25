package com.ryxen.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.ryxen.dto.ComicDTO;
import com.ryxen.dto.NewsDTO;
import com.ryxen.dto.RoleDTO;
import com.ryxen.dto.Search;
import com.ryxen.entity.ComicEntity;
import com.ryxen.entity.NewsEntity;

public interface INewService {
	List<NewsDTO> findByCategoryId(Integer categoryId) throws InstantiationException, IllegalAccessException;
	List<NewsDTO> findAll() throws InstantiationException, IllegalAccessException;
	List<NewsDTO> findAllWithPage(int pageNumber, int pageSize)throws InstantiationException, IllegalAccessException ;
	List<NewsDTO> findAllWithPageSearch(Search search,int pageNumber, int pageSize)throws InstantiationException, IllegalAccessException ;
	int getTotaltems(int pageNumber, int pageSize);
	NewsDTO findBySeo(String seo) ;
	void editEmptyFile(NewsEntity entity);
	void edit(final HttpServletRequest request,MultipartFile newstAvatar,NewsEntity entity)throws IllegalStateException, IOException;
	void deleteNewsByCheckBox(NewsDTO dto);
	void add(final HttpServletRequest request,MultipartFile newstAvatar,NewsEntity entity)throws IllegalStateException, IOException;
}
