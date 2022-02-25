package com.ryxen.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ryxen.entity.RoleEntity;
import com.ryxen.entity.UserEntity;

@Controller
public abstract class BaseController {
	
	public int getCurrentPage(HttpServletRequest request) {
		try {
			int page=Integer.parseInt(request.getParameter("page"))-1;
				if(page <=0) {
					return 0;
				}else
				return page;
			
		}catch (Exception e) {
			// TODO: handle exception
			return -1;
		}
	
	}
	@ModelAttribute("trang_chu")
	public String home() {
		return "Trang chủ";
	}
	@ModelAttribute("roles")
	public List<String> roles() {
		List<String> roles=new ArrayList<String>();
		UserEntity logined = getUserLogined();
		
		if(logined == null) return roles;
		for(RoleEntity r : logined.getRoles()) {
			roles.add(r.getAuthority());
		}
		
		return roles;
	}
	
	@ModelAttribute("isLogined")
	public boolean isLogined() {
		boolean isLogined = false;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			isLogined = true;
		}
		System.out.println("is"+isLogined);
		return isLogined;
	}
	
	@ModelAttribute("userLogined")
	public UserEntity getUserLogined() {
		Object userLogined = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println("type user:"+userLogined);
		if(userLogined != null && userLogined instanceof UserDetails)
			return (UserEntity) userLogined;
		
		return null;
	}
	
	@ModelAttribute("dang_ky")
	public String dangKy() {
		return "Đăng Ký";
	}
	@ModelAttribute("dang_nhap")
	public String dangNhap() {
		return "Đăng nhập";
	}
	@ModelAttribute("superhero")
	public String superhero() {
		return "SuperHero";
	}
	@ModelAttribute("thong_tin")
	public String thongTin() {
		return "Thông tin";
	}
	@ModelAttribute("kinh-di")
	public String kinhDi() {
		return "Kinh dị";
	}
	@ModelAttribute("tinh-cam")
	public String tinhCam() {
		return "Tinh cảm";
	}
}
