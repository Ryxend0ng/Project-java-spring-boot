package com.ryxen.service.impl;

import java.io.IOException;
import java.util.ArrayList;
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

import com.ryxen.converter.NewsConverter;
import com.ryxen.dto.ComicDTO;
import com.ryxen.dto.NewsDTO;
import com.ryxen.dto.Search;
import com.ryxen.entity.ComicEntity;
import com.ryxen.entity.NewsEntity;
import com.ryxen.entity.RoleEntity;
import com.ryxen.repository.NewRepository;
import com.ryxen.service.INewService;

@Service
public class NewService extends BaseService<NewsDTO, NewsEntity> implements INewService {
	@Autowired
	private NewRepository newRepo;
	@Autowired
	private NewsConverter newsConverter;
	
	
	@Override
	protected Class<NewsDTO> clazz() {
		// TODO Auto-generated method stub
		return NewsDTO.class;
	}
	
	public List<NewsDTO> findByCategoryId(Integer categoryId) throws InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		List<NewsEntity> newsLEntity=newRepo.findByCategoryId(categoryId); 
		
		return convertList(newsLEntity);
		 
	}

	@Override
	public List<NewsDTO> findAll() throws InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		List<NewsEntity> newsLEntity= newRepo.findAll();
		return convertList(newsLEntity);
	}

	@Override
	public List<NewsDTO> findAllWithPage(int pageNumber, int pageSize) throws InstantiationException, IllegalAccessException{
	Pageable page=PageRequest.of(pageNumber, pageSize);		 
    Page<NewsEntity> pagedResult = newRepo.findAllWithPage(page);
	List<NewsEntity> news=pagedResult.getContent();
	return convertList(news);
	}

	@Override
	public int getTotaltems(int pageNumber, int pageSize) {
		Pageable page=PageRequest.of(pageNumber, pageSize);
	    Page<NewsEntity> pagedResult = newRepo.findAllByTypePage();
	
	    PageImpl<NewsEntity> pageImpl=new PageImpl<NewsEntity>(pagedResult.getContent(), page,pagedResult.getTotalElements());
	    System.out.println("totale:"+pageImpl.getTotalElements());
	   
		return pageImpl.getSize() == 0 ? 1 : (int) Math.ceil((double) pagedResult.getTotalElements() / (double) pageImpl.getSize());
	}

	@Override
	public NewsDTO findBySeo(String seo) {
		NewsEntity newsEntity= newRepo.findBySeo(seo);
		return newsConverter.toDto(newsEntity,new NewsDTO());
	}

	@Override
	public void editEmptyFile(NewsEntity entity) {
		// TODO Auto-generated method stub
		newRepo.saveOrUpdate(entity);
	}

	@Override
	public void edit(HttpServletRequest request, MultipartFile newstAvatar, NewsEntity entity)
			throws IllegalStateException, IOException {
		// TODO Auto-generated method stub
		NewsEntity  news=newRepo.edit(request, newstAvatar, entity);
		if(news != null) {
			System.out.println("ok");
		}else {
			System.out.println("no");
		}
	}

	

	@Override
	public void add(HttpServletRequest request, MultipartFile newstAvatar, NewsEntity entity)
			throws IllegalStateException, IOException {
		// TODO Auto-generated method stub
		NewsEntity  news=newRepo.add(request, newstAvatar, entity);
		if(news != null) {
			System.out.println("ok");
		}else {
			System.out.println("no");
		}
	}

	@Override
	@Transactional
	public void deleteNewsByCheckBox(NewsDTO dto) {
		// TODO Auto-generated method stub
		if(dto.getIds() != null) {
		for(int i=0;i<dto.getIds().length;i++) {
			NewsEntity entity=new NewsEntity();
			entity.setId(dto.getIds()[i]);
			newRepo.deleteById(entity.getId());
		}
	}else {
		NewsEntity entity=new NewsEntity();
		entity.setId(dto.getId());
		newRepo.deleteById(dto.getId());
	}
	}

	@Override
	public List<NewsDTO> findAllWithPageSearch(Search search, int pageNumber, int pageSize)
			throws InstantiationException, IllegalAccessException {
		Pageable page=PageRequest.of(pageNumber, pageSize);		 
	    Page<NewsEntity> pagedResult = newRepo.searchAndListPage(search, page);
	    List<NewsEntity> news=pagedResult.getContent();
		return convertList(news);
	}
	

}
