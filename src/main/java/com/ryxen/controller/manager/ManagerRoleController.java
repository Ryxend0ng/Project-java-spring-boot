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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ryxen.controller.BaseController;
import com.ryxen.dto.CategoryDTO;
import com.ryxen.dto.NewsDTO;
import com.ryxen.dto.RoleDTO;
import com.ryxen.dto.Search;
import com.ryxen.dto.UserDTO;
import com.ryxen.entity.UserEntity;
import com.ryxen.service.IRoleService;
import com.ryxen.service.IUserService;

@Controller
public class ManagerRoleController extends BaseController {
	@Autowired
	private IRoleService roleService;
	@RequestMapping(value = {"/admin/list-roles"},method = RequestMethod.GET)
	public String getListRole(final HttpServletRequest request,final HttpServletResponse response,
			final Model model,
			@RequestParam(value = "keyWord") String keyWord) throws InstantiationException, IllegalAccessException {
		int pageNumer=getCurrentPage(request);
		int pageSize=Integer.parseInt(request.getParameter("maxPageItem"));
		
		int totalPage=roleService.getTotaltems(pageNumer, pageSize);
		Search search=new Search();
		search.setKeyWord(keyWord);
		List<RoleDTO> roles=roleService.findAllWithPageSearch(search, pageNumer, pageSize);
		System.out.println("total :"+totalPage);
		//comicRepo.convert();
		model.addAttribute("page", pageNumer+1);
		model.addAttribute("totalsPage", totalPage);
		model.addAttribute("keyWord", search.getKeyWord());
		model.addAttribute("roles", roles);
				return "manager/role/listRoles";
		
	}
	@RequestMapping(value = {"/admin/edit-roles/{roleCode}"},method = RequestMethod.GET)
	public String editRole(final HttpServletRequest request,final HttpServletResponse response,
			final @PathVariable("roleCode") String roleCode,
			final Model model
			) throws InstantiationException, IllegalAccessException  {
		
		RoleDTO dto= new RoleDTO();
		dto=roleService.findByCode(roleCode);
		
		model.addAttribute("roles", dto);
				return "manager/role/editRoles";
	}
	@RequestMapping(value = {"/admin/edit-roles"},method = RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> editRolePost(final HttpServletRequest request,
			final HttpServletResponse response,
			final @RequestBody RoleDTO role
		
			) 
					throws InstantiationException, IllegalAccessException, IllegalStateException, IOException  {
			
			roleService.saveOrUpdate(role);
			Map<String,Object> jsonResult=new HashMap<String, Object>();
			jsonResult.put("code", "200");
			jsonResult.put("message", role);
			
			return ResponseEntity.ok(jsonResult);
	}
	@RequestMapping(value = {"/admin/add-roles"},method = RequestMethod.GET)
	public String addRole(final HttpServletRequest request,final HttpServletResponse response,
		
			final Model model
			) throws InstantiationException, IllegalAccessException  {
				return "manager/role/addRole";
	}
	@RequestMapping(value = {"/admin/add-roles"},method = RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> editCategoryPost(final HttpServletRequest request,
			final HttpServletResponse response,
			final @RequestBody RoleDTO role
		
			) 
					throws InstantiationException, IllegalAccessException, IllegalStateException, IOException  {
			
			roleService.saveOrUpdate(role);
			Map<String,Object> jsonResult=new HashMap<String, Object>();
			jsonResult.put("code", "200");
			jsonResult.put("message", role);
			
			return ResponseEntity.ok(jsonResult);
	}
	@RequestMapping(value = {"/admin/delete-roles"},method = RequestMethod.DELETE)
	public ResponseEntity<Map<String,Object>> deleteRole(final HttpServletRequest request,
			final HttpServletResponse response,
			final @RequestBody RoleDTO role
			
			) 
					throws InstantiationException, IllegalAccessException  {
		String roleIds=" ";
		if(role.getIds() != null) {
			for (Integer id : role.getIds()) {
				roleIds+=", "+id;
			}
		}else if(role.getId() != null){
			roleIds +=" " +role.getId();
		}else {
			roleIds="";
		}
			roleService.deleteRoleByCheckBox(role);
			Map<String,Object> jsonResult=new HashMap<String, Object>();
			jsonResult.put("code", "200");
			jsonResult.put("message",  roleIds);
			
			return ResponseEntity.ok(jsonResult);
	}
}
