package com.ryxen.controller.manager;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;import javax.transaction.Transactional;

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
import com.ryxen.converter.CategoryConverter;
import com.ryxen.dto.CategoryDTO;
import com.ryxen.dto.ComicDTO;
import com.ryxen.dto.Search;
import com.ryxen.entity.CategoryEntity;
import com.ryxen.entity.ComicEntity;
import com.ryxen.service.ICategoryService;

@Controller
public class ManagerCategoryController extends BaseController {
	@Autowired
	private ICategoryService categoryService;
	@Autowired
	private CategoryConverter categoryConverter;
	
	@RequestMapping(value = {"/admin/list-categories"},method = RequestMethod.GET)
	public String getListCategory(final HttpServletRequest request,final HttpServletResponse response,
			final Model model,
			@RequestParam(value = "keyWord") String keyWord) throws InstantiationException, IllegalAccessException {
		int pageNumer=getCurrentPage(request);
		int pageSize=Integer.parseInt(request.getParameter("maxPageItem"));
		Search search=new Search();
		search.setKeyWord(keyWord);
		System.out.println("keywword:"+keyWord);
		List<CategoryDTO> categories=categoryService.findAllWithPageSearch(search, pageNumer, pageSize);
		int totalPage=categoryService.getTotaltems(pageNumer, pageSize);
		System.out.println("total :"+totalPage);
		//comicRepo.convert();
		model.addAttribute("page", pageNumer+1);
		model.addAttribute("totalsPage", totalPage);
		model.addAttribute("keyWord", search.getKeyWord());
		model.addAttribute("categories", categories);
				return "manager/categories/listCategory";
		
	}
	@RequestMapping(value = {"/admin/edit-categories/{categoryCode}"},method = RequestMethod.GET)
	public String editComics(final HttpServletRequest request,final HttpServletResponse response,
			final @PathVariable("categoryCode") String categoryCode,
			final Model model
			) throws InstantiationException, IllegalAccessException  {
		CategoryDTO category=categoryService.findByCode(categoryCode);
		
		
		model.addAttribute("category", category);
				return "manager/categories/editCategory";
	}
	@RequestMapping(value = {"/admin/edit-categories"},method = RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> editComicsPost(final HttpServletRequest request,
			final HttpServletResponse response,
			final @RequestBody CategoryDTO category
		
			) 
					throws InstantiationException, IllegalAccessException, IllegalStateException, IOException  {
			
			categoryService.saveOrUpdate(category);
			Map<String,Object> jsonResult=new HashMap<String, Object>();
			jsonResult.put("code", "200");
			jsonResult.put("message", category);
			
			return ResponseEntity.ok(jsonResult);
	}
	@RequestMapping(value = {"/admin/add-categories"},method = RequestMethod.GET)
	public String addComics(final HttpServletRequest request,final HttpServletResponse response,
		
			final Model model
			) throws InstantiationException, IllegalAccessException  {
				return "manager/categories/addCategory";
	}
	@RequestMapping(value = {"/admin/add-categories"},method = RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> editCategoryPost(final HttpServletRequest request,
			final HttpServletResponse response,
			final @RequestBody CategoryDTO category
		
			) 
					throws InstantiationException, IllegalAccessException, IllegalStateException, IOException  {
			
			categoryService.saveOrUpdate(category);
			Map<String,Object> jsonResult=new HashMap<String, Object>();
			jsonResult.put("code", "200");
			jsonResult.put("message", category);
			
			return ResponseEntity.ok(jsonResult);
	}
	@RequestMapping(value = {"/admin/delete-categories"},method = RequestMethod.DELETE)
	public ResponseEntity<Map<String,Object>> deleteCategory(final HttpServletRequest request,
			final HttpServletResponse response,
			final @RequestBody CategoryDTO cate
			
			) 
					throws InstantiationException, IllegalAccessException  {
			String cateIds=" ";
				if(cate.getIds() != null) {
					for (Integer id : cate.getIds()) {
						cateIds+=", "+id;
					}
				}else if(cate.getId() != null){
					cateIds +=" " +cate.getId();
				}else {
					cateIds="";
				}
			System.out.println(cateIds);
			categoryService.deleteCategoryByCheckBox(cate);
			Map<String,Object> jsonResult=new HashMap<String, Object>();
			jsonResult.put("code", "200");
			jsonResult.put("message",  cateIds);
			
			return ResponseEntity.ok(jsonResult);
	}
	
}
