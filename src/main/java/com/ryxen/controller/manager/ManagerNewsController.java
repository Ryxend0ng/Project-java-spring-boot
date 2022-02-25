package com.ryxen.controller.manager;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ryxen.controller.BaseController;
import com.ryxen.converter.NewsConverter;
import com.ryxen.dto.CategoryDTO;
import com.ryxen.dto.ComicDTO;
import com.ryxen.dto.NewsDTO;
import com.ryxen.dto.RoleDTO;
import com.ryxen.dto.Search;
import com.ryxen.entity.ComicEntity;
import com.ryxen.entity.NewsEntity;
import com.ryxen.service.INewService;
import com.ryxen.service.impl.CategoryService;

@Controller
public class ManagerNewsController extends BaseController{
	@Autowired
	private INewService newsService;
	@Autowired
	private CategoryService cateService;
	@Autowired
	private NewsConverter newConver;
	@RequestMapping(value = {"/admin/list-news"},method = RequestMethod.GET)
	public String getListNews(final HttpServletRequest request,final HttpServletResponse response,
			final Model model,
			@RequestParam(value = "keyWord") String keyWord) throws InstantiationException, IllegalAccessException {
		int pageNumer=getCurrentPage(request);
		int pageSize=Integer.parseInt(request.getParameter("maxPageItem"));		
		int totalPage=newsService.getTotaltems(pageNumer, pageSize);
		Search search=new Search();
		search.setKeyWord(keyWord);
		List<NewsDTO> news=newsService.findAllWithPageSearch(search, pageNumer, pageSize);
		System.out.println("total :"+totalPage);
		//comicRepo.convert();
		model.addAttribute("page", pageNumer+1);
		model.addAttribute("totalsPage", totalPage);
		model.addAttribute("keyWord", search.getKeyWord());
		model.addAttribute("news", news);
				return "manager/news/listNews";
		
	}
	@RequestMapping(value = {"/admin/edit-news/{newsSeo}"},method = RequestMethod.GET)
	public String editNews(final HttpServletRequest request,final HttpServletResponse response,
			final @PathVariable("newsSeo") String newsSeo,
			final Model model
			) throws InstantiationException, IllegalAccessException  {
		NewsDTO news=newsService.findBySeo(newsSeo);
		System.out.println("newsId:"+news.getId());
		List<CategoryDTO> cateDto=cateService.findAll();
		model.addAttribute("news", news);
		model.addAttribute("categories", cateDto);
				return "manager/news/editNews";
	}
	@RequestMapping(value = {"/admin/edit-news"},method = RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> editComicsPost(final HttpServletRequest request,
			final HttpServletResponse response,
			final @ModelAttribute NewsDTO news
		
			) 
					throws InstantiationException, IllegalAccessException, IllegalStateException, IOException  {
			 NewsEntity entity=new NewsEntity();
			 NewsDTO oldNews=newsService.findBySeo(news.getSeo());
			entity=newConver.toEntity(entity, news);
			
			if(news.getFile() != null && !news.getFile().isEmpty()) {
				newsService.edit(request, news.getFile(), entity);
			}else {
				entity.setImage(oldNews.getImage());
				newsService.editEmptyFile(entity);
			}
			Map<String,Object> jsonResult=new HashMap<String, Object>();
			jsonResult.put("code", "200");
			
			
			return ResponseEntity.ok(jsonResult);
	}
	@RequestMapping(value = {"/admin/add-news"},method = RequestMethod.GET)
	public String addNews(final HttpServletRequest request,final HttpServletResponse response,			
			final Model model,
			final @ModelAttribute("news") NewsDTO news ) throws InstantiationException, IllegalAccessException  {
		
		List<CategoryDTO> cateDto=cateService.findAll();
	
		model.addAttribute("categories", cateDto);
				return "manager/news/addNews";
	}
	@RequestMapping(value = {"/admin/add-news"},method = RequestMethod.POST)
	public String addNewsPost(final HttpServletRequest request,final HttpServletResponse response,			
			final Model model,
			final @ModelAttribute("news") NewsDTO news,
			@RequestParam("newsAvatar") MultipartFile file) throws InstantiationException, IllegalAccessException, IllegalStateException, IOException  {
		NewsEntity entity=new NewsEntity();
		System.out.println(news.getCategoryId());
		entity=newConver.toEntity(entity, news);
		System.out.println(entity.getContent());
		newsService.add(request, file, entity);
				return "manager/news/addNews";
	}
	@RequestMapping(value = {"/admin/delete-news"},method = RequestMethod.DELETE)
	public ResponseEntity<Map<String,Object>> deleteRole(final HttpServletRequest request,
			final HttpServletResponse response,
			final @RequestBody NewsDTO news
			
			) 
					throws InstantiationException, IllegalAccessException  {
		String newsIds=" ";
		if(news.getIds() != null) {
			for (Integer id : news.getIds()) {
				newsIds+=", "+id;
			}
		}else if(news.getId() != null){
			newsIds +=" " +news.getId();
		}else {
			newsIds="";
		}
			newsService.deleteNewsByCheckBox(news);
			Map<String,Object> jsonResult=new HashMap<String, Object>();
			jsonResult.put("code", "200");
			jsonResult.put("message",  newsIds);
			
			return ResponseEntity.ok(jsonResult);
	}
}
