package com.ryxen.controller.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ryxen.controller.BaseController;
import com.ryxen.converter.CategoryConverter;
import com.ryxen.dto.CategoryDTO;
import com.ryxen.dto.ComicDTO;
import com.ryxen.dto.Search;
import com.ryxen.service.ICategoryService;
import com.ryxen.service.IComicService;

@RestController
@RequestMapping("/api")
public class TestController extends BaseController{
	
	@Autowired
	private ICategoryService caService;
	@GetMapping("/list/category")
	public ResponseEntity<?> listSuper(final HttpServletRequest request,
			final HttpServletResponse response
			
		
			) 
					throws InstantiationException, IllegalAccessException, IllegalStateException, IOException  {
			
			List<CategoryDTO> caDto=new ArrayList<CategoryDTO>();
			caDto=caService.findAll();			
			return ResponseEntity.ok().body("alo");
	}
//	@GetMapping("/list/page-comic")
//	public ResponseEntity<?> getListComics(final HttpServletRequest request,final HttpServletResponse response,
//			final Model model,
//			@RequestParam(value = "keyWord") String keyWord) throws InstantiationException, IllegalAccessException  {
//
//		int pageNumer=getCurrentPage(request);
//		int pageSize=Integer.parseInt(request.getParameter("maxPageItem"));
//		Search search=new Search();
//		search.setKeyWord(keyWord);
//		System.out.println("keywword:"+keyWord);
//		List<ComicDTO> comics=comicService.findAllWithPageSearch(search, pageNumer, pageSize);
//		int totalPage=comicService.getTotaltems(pageNumer, pageSize);
//		
//		return ResponseEntity.ok().body(comics);
//	}
}
