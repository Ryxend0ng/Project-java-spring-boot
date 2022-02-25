package com.ryxen.controller.manager;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
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

import com.github.slugify.Slugify;
import com.ryxen.controller.BaseController;
import com.ryxen.converter.ComicConverter;
import com.ryxen.dto.CategoryDTO;
import com.ryxen.dto.ComicDTO;
import com.ryxen.dto.Search;
import com.ryxen.entity.ComicEntity;
import com.ryxen.repository.ComicRepository;
import com.ryxen.service.IComicService;
import com.ryxen.service.impl.CategoryService;

@SuppressWarnings("unused")
@Controller
public class ManagerComicsController extends BaseController{

		@Autowired
		private IComicService comicService;
		@Autowired
		private ComicRepository comicRepo;
		@Autowired
		private CategoryService cateService;
		@Autowired
		private ComicConverter comicConvert;
		@RequestMapping(value = {"/admin/list-comics"},method = RequestMethod.GET)
		public String getListComics(final HttpServletRequest request,final HttpServletResponse response,
				final Model model,
				@RequestParam(value = "keyWord") String keyWord) throws InstantiationException, IllegalAccessException  {
	
			int pageNumer=getCurrentPage(request);
			int pageSize=Integer.parseInt(request.getParameter("maxPageItem"));
			Search search=new Search();
			search.setKeyWord(keyWord);
			System.out.println("keywword:"+keyWord);
			List<ComicDTO> comics=comicService.findAllWithPageSearch(search, pageNumer, pageSize);
			int totalPage=comicService.getTotaltems(pageNumer, pageSize);
			System.out.println("total :"+totalPage);
			//comicRepo.convert();
			model.addAttribute("page", pageNumer+1);
			model.addAttribute("totalsPage", totalPage);
			model.addAttribute("keyWord", search.getKeyWord());
			model.addAttribute("comics", comics);
					return "manager/comics/listComics";
		}
		@RequestMapping(value = {"/admin/edit-comics/{comicsSeo}"},method = RequestMethod.GET)
		public String editComics(final HttpServletRequest request,final HttpServletResponse response,
				final @PathVariable("comicsSeo") String comicsSeo,
				final Model model
				) throws InstantiationException, IllegalAccessException  {
			ComicDTO comics=comicService.findBySeo(comicsSeo);
			List<CategoryDTO> cateDto=cateService.findAll();
			model.addAttribute("comics", comics);
			model.addAttribute("categories", cateDto);
					return "manager/comics/editComics";
		}
		@RequestMapping(value = {"/admin/edit-comics"},method = RequestMethod.POST)
		public ResponseEntity<Map<String,Object>> editComicsPost(final HttpServletRequest request,
				final HttpServletResponse response,
				final @ModelAttribute ComicDTO comic
			
				) 
						throws InstantiationException, IllegalAccessException, IllegalStateException, IOException  {
				ComicEntity entity=new ComicEntity();
				ComicDTO oldDto=comicService.findBySeo(comic.getSeo());
				entity=comicConvert.toEntity(entity, comic);
				//System.out.println(comic.getFile().getBytes().length);
				if(comic.getFile() != null && !comic.getFile().isEmpty()) {
					
					comicService.edit(request, comic.getFile(), entity);
				}else {
					entity.setImage(oldDto.getImage());
					comicService.editEmptyFile(entity);
				}
				Map<String,Object> jsonResult=new HashMap<String, Object>();
				jsonResult.put("code", "200");
				
				return ResponseEntity.ok(jsonResult);
		}
		
		@RequestMapping(value = {"/admin/delete-comics"},method = RequestMethod.DELETE)
		public ResponseEntity<Map<String,Object>> deleteComicsPost(final HttpServletRequest request,
				final HttpServletResponse response,
				final @RequestBody ComicDTO comic
				
				) 
						throws InstantiationException, IllegalAccessException  {
			String comicsIds=" ";
			if(comic.getIds() != null) {
				for (Integer id : comic.getIds()) {
					comicsIds+=", "+id;
				}
			}else if(comic.getId() != null){
				comicsIds +=" " +comic.getId();
			}else {
				comicsIds="";
			}
				comicService.deleteComicsByCheckBox(comic);
				Map<String,Object> jsonResult=new HashMap<String, Object>();
				jsonResult.put("code", "200");
				jsonResult.put("message",  comicsIds);
				
				return ResponseEntity.ok(jsonResult);
		}
		private String getComicIdCheckBox(ComicDTO comic,String comicsIds) {
			if(comic.getIds() != null) {
				for (Integer id : comic.getIds()) {
					comicsIds+=", "+id;
				}
			}else if(comic.getId() != null){
				comicsIds +=" " +comic.getId();
			}else {
				comicsIds="";
			}
			return comicsIds;
		}
		@RequestMapping(value = {"/admin/add-comics"},method = RequestMethod.GET)
		public String addComics(final HttpServletRequest request,final HttpServletResponse response,			
				final Model model,
				final @ModelAttribute("comics") ComicDTO comic ) throws InstantiationException, IllegalAccessException  {
			
			List<CategoryDTO> cateDto=cateService.findAll();
		
			model.addAttribute("categories", cateDto);
					return "manager/comics/addComics";
		}
		@RequestMapping(value = {"/admin/add-comics"},method = RequestMethod.POST)
		public String addComicsPost(final HttpServletRequest request,final HttpServletResponse response,			
				final Model model,
				final @ModelAttribute("comics") ComicDTO comic,
				@RequestParam("comicAvatar") MultipartFile file) throws InstantiationException, IllegalAccessException, IllegalStateException, IOException  {
			ComicEntity entity=new ComicEntity();
			String url="/admin/add-comics";
			System.out.println(comic.getCategoryId());
			entity=comicConvert.toEntity(entity, comic);
			System.out.println(entity.getContent());
			comicService.add(request, file, entity);
					return "redirect:"+ url;
		}
}
