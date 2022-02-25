package com.ryxen.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import com.ryxen.dto.CategoryDTO;
import com.ryxen.dto.ComicDTO;
import com.ryxen.dto.Search;
import com.ryxen.entity.ComicEntity;

public interface IComicService {
	List<ComicDTO> findByCategoryId(int categoryId);
	List<ComicDTO> findAll();
	List<ComicDTO> findTopByCategoryId(int count,int categoryId);
	List<ComicDTO> findByCreatedDate(String createdDate);
	List<ComicDTO> findAllWithPage(int pageNumber, int pageSize)throws InstantiationException, IllegalAccessException ;
	int getTotaltems(int pageNumber, int pageSize);
	ComicDTO findBySeo(String seo) ;
	void editEmptyFile(ComicEntity entity);
	void edit(final HttpServletRequest request,MultipartFile comicstAvatar,ComicEntity comicsEntity)throws IllegalStateException, IOException;
	void deleteComicsByCheckBox(ComicDTO dto);
	void add(final HttpServletRequest request,MultipartFile comicstAvatar,ComicEntity comicsEntity)throws IllegalStateException, IOException;
	List<ComicDTO> findAllWithPageSearch(Search search,int pageNumber, int pageSize)throws InstantiationException, IllegalAccessException ;
}
