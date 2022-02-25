package com.ryxen.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ryxen.converter.ComicConverter;
import com.ryxen.dto.ComicDTO;
import com.ryxen.dto.Search;
import com.ryxen.entity.CategoryEntity;
import com.ryxen.entity.ComicEntity;
import com.ryxen.repository.ComicRepository;
import com.ryxen.service.IComicService;


@Service
public class ComicService extends BaseService<ComicDTO, ComicEntity> implements IComicService{
@Autowired
private ComicRepository comicRepo;
@Autowired
private ComicConverter conmicConvert;
	@Override
	protected Class<ComicDTO> clazz() {
		// TODO Auto-generated method stub
		return ComicDTO.class;
	}
	@Override
	public List<ComicDTO> findByCategoryId(int categoryId) {
		// TODO Auto-generated method stub
		List<ComicEntity> comics=comicRepo.findByCategoryId(categoryId); 
		List<ComicDTO> comicList=new ArrayList<ComicDTO>();
		for(ComicEntity comic : comics) {
			ComicDTO comicDto=new ComicDTO();
			comicDto=conmicConvert.toDto(comic, comicDto);
			comicList.add(comicDto);
		}
		return comicList;
	}
	@Override
	public List<ComicDTO> findAll() {
		// TODO Auto-generated method stub
		List<ComicEntity> comics=comicRepo.findAll();
		List<ComicDTO> comicList=new ArrayList<ComicDTO>();
		for(ComicEntity comic : comics) {
			ComicDTO comicDto=new ComicDTO();
			comicDto=conmicConvert.toDto(comic, comicDto);
			comicList.add(comicDto);
		}
		return comicList;
	}
	@Override
	public List<ComicDTO> findTopByCategoryId( int count,int categoryId) {
		// TODO Auto-generated method stub
		List<ComicEntity> comics=comicRepo.findByTopByCategoryId(count, categoryId);
		List<ComicDTO> comicList=new ArrayList<ComicDTO>();
		for(ComicEntity comic : comics) {
			ComicDTO comicDto=new ComicDTO();
			comicDto=conmicConvert.toDto(comic, comicDto);
			comicList.add(comicDto);
		}
		return comicList;
	}
	@Override
	public List<ComicDTO> findByCreatedDate(String createdDate) {
		// TODO Auto-generated method stub
		List<ComicEntity> comics=comicRepo.findByCreatedDate(createdDate);
		List<ComicDTO> comicList=new ArrayList<ComicDTO>();
		for(ComicEntity comic : comics) {
			ComicDTO comicDto=new ComicDTO();
			comicDto=conmicConvert.toDto(comic, comicDto);
			comicList.add(comicDto);
		}
		return comicList;
	}
	@Override
	public List<ComicDTO> findAllWithPage(int pageNumber, int pageSize) throws InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		Pageable page=PageRequest.of(pageNumber, pageSize);		 
	    Page<ComicEntity> pagedResult = comicRepo.findAllWithPage(page);
		List<ComicEntity> comics=pagedResult.getContent();
		return convertList(comics);
	}
	@Override
	public int getTotaltems(int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		Pageable page=PageRequest.of(pageNumber, pageSize);
	    Page<ComicEntity> pagedResult = comicRepo.findAllByTypePage();
	
	    PageImpl<ComicEntity> pageImpl=new PageImpl<ComicEntity>(pagedResult.getContent(), page,pagedResult.getTotalElements());
	    System.out.println("totale:"+pageImpl.getTotalElements());
	   
		return pageImpl.getSize() == 0 ? 1 : (int) Math.ceil((double) pagedResult.getTotalElements() / (double) pageImpl.getSize());
	}
	@Override
	public ComicDTO findBySeo(String seo)
			 {
		// TODO Auto-generated method stub
		ComicEntity comicEntity= comicRepo.findBySeo(seo);
		return conmicConvert.toDto(comicEntity,new ComicDTO());
	}
	@Override
	@Transactional
	public void edit(final HttpServletRequest request,MultipartFile comicstAvatar,ComicEntity comicsEntity) throws IllegalStateException, IOException {
		// TODO Auto-generated method stub
		ComicEntity comic=comicRepo.edit(request, comicstAvatar, comicsEntity);
		if(comic != null) {
			System.out.println("ok");
		}else {
			System.out.println("no");
		}
	}
	@Override
	@Transactional
	public void deleteComicsByCheckBox(ComicDTO dto) {
		// TODO Auto-generated method stub
		if(dto.getIds() != null) {
		for(int i=0;i<dto.getIds().length;i++) {
			ComicEntity entity=new ComicEntity();
			entity.setId(dto.getIds()[i]);
			comicRepo.deleteById(entity.getId());
		}
	}else {
		ComicEntity entity=new ComicEntity();
		entity.setId(dto.getId());
		comicRepo.deleteById(entity.getId());
	}
	}
	@Override
	@Transactional
	public void add(HttpServletRequest request, MultipartFile comicstAvatar, ComicEntity comicsEntity)
			throws IllegalStateException, IOException {
		// TODO Auto-generated method stub
		ComicEntity comic=comicRepo.add(request, comicstAvatar, comicsEntity);
		if(comic != null) {
			System.out.println("ok");
		}else {
			System.out.println("no");
		}
	}
	@Override
	public void editEmptyFile(ComicEntity entity) {
		// TODO Auto-generated method stub
		comicRepo.saveOrUpdate(entity);
	}
	@Override
	public List<ComicDTO> findAllWithPageSearch(Search search, int pageNumber, int pageSize)
			throws InstantiationException, IllegalAccessException {
		Pageable page=PageRequest.of(pageNumber, pageSize);		 
	    Page<ComicEntity> pagedResult = comicRepo.searchAndListPage(search, page);
	    List<ComicEntity> comic=pagedResult.getContent();
		return convertList(comic);
	}
	
	
	

}
