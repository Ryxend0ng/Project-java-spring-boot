package com.ryxen.controller.manager;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ryxen.controller.BaseController;
import com.ryxen.converter.UserConverter;
import com.ryxen.dto.CategoryDTO;
import com.ryxen.dto.RoleDTO;
import com.ryxen.dto.Search;
import com.ryxen.dto.UserDTO;
import com.ryxen.entity.UserEntity;
import com.ryxen.service.IUserService;
import com.ryxen.service.impl.RoleService;

@Controller
public class ManagerUserController extends BaseController{
	@Autowired
	private IUserService userService;
	@Autowired
	private UserConverter userConvert;
	@Autowired
	private RoleService roleService;
	@RequestMapping(value = {"/admin/list-users"},method = RequestMethod.GET)
	public String getListUsers(final HttpServletRequest request,final HttpServletResponse response,
			final Model model,
			@RequestParam(value = "keyWord") String keyWord) throws InstantiationException, IllegalAccessException {
		int pageNumer=getCurrentPage(request);
		int pageSize=Integer.parseInt(request.getParameter("maxPageItem"));
		
		int totalPage=userService.getTotaltems(pageNumer, pageSize);
		Search search=new Search();
		search.setKeyWord(keyWord);
		List<UserDTO> users=userService.findAllWithPageSearch(search, pageNumer, pageSize);
		System.out.println("total :"+totalPage);
		
		model.addAttribute("page", pageNumer+1);
		model.addAttribute("totalsPage", totalPage);
		model.addAttribute("keyWord", search.getKeyWord());
		model.addAttribute("users", users);
				return "manager/user/listUsers";
		
	}
	@RequestMapping(value = {"/admin/edit-users/{userName}"},method = RequestMethod.GET)
	public String editUser(final HttpServletRequest request,final HttpServletResponse response,
			final @PathVariable("userName") String userName,
			final Model model
			) throws InstantiationException, IllegalAccessException  {
		UserEntity user=userService.loadByUserName(userName);
		UserDTO dto= new UserDTO();
		dto=userConvert.toDTO(user, dto);
		
		model.addAttribute("user", dto);
				return "manager/user/editUsers";
	}
	@RequestMapping(value = {"/admin/edit-users"},method = RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> editUserPost(final HttpServletRequest request,
			final HttpServletResponse response,
			final @RequestBody UserDTO user
		
			) 
					throws InstantiationException, IllegalAccessException, IllegalStateException, IOException  {
			
			userService.saveOrUpdate(user);
			Map<String,Object> jsonResult=new HashMap<String, Object>();
			jsonResult.put("code", "200");
			jsonResult.put("message", user);
			
			return ResponseEntity.ok(jsonResult);
	}
	@RequestMapping(value = {"/admin/add-users"},method = RequestMethod.GET)
	public String addUser(final HttpServletRequest request,final HttpServletResponse response,
		
			final Model model
			) throws InstantiationException, IllegalAccessException  {
		List<RoleDTO> roles=roleService.findAll();
		model.addAttribute("roles", roles);
		model.addAttribute("user", new UserDTO());
				return "manager/user/addUser";
	}
	@RequestMapping(value = {"/admin/add-users"},method = RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> addUserPost(final HttpServletRequest request,
			final HttpServletResponse response,
			final @RequestBody UserDTO user
		
			) 
					throws InstantiationException, IllegalAccessException, IllegalStateException, IOException  {
			System.out.println(user.getRoleId());
			userService.saveOrUpdate(user);
			Map<String,Object> jsonResult=new HashMap<String, Object>();
			jsonResult.put("code", "200");
			jsonResult.put("message", user);
			
			return ResponseEntity.ok(jsonResult);
	}
	@RequestMapping(value = {"/admin/delete-users"},method = RequestMethod.DELETE)
	public ResponseEntity<Map<String,Object>> deleteUser(final HttpServletRequest request,
			final HttpServletResponse response,
			final @RequestBody UserDTO user
			
			) 
					throws InstantiationException, IllegalAccessException  {
		String userIds=" ";
		if(user.getIds() != null) {
			for (Integer id : user.getIds()) {
				userIds+=", "+id;
			}
		}else if(user.getId() != null){
			userIds +=" " +user.getId();
		}else {
			userIds="";
		}
			userService.deleteUserByCheckBox(user);
			Map<String,Object> jsonResult=new HashMap<String, Object>();
			jsonResult.put("code", "200");
			jsonResult.put("message",  userIds);
			
			return ResponseEntity.ok(jsonResult);
	}
	
	
}
