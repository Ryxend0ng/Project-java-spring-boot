package com.ryxen.controller.user;

import java.nio.charset.Charset;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ryxen.controller.BaseController;
import com.ryxen.converter.UserConverter;
import com.ryxen.dto.UserDTO;
import com.ryxen.entity.UserEntity;
import com.ryxen.security.JwtTokenProvider;
import com.ryxen.service.IUserService;
@Controller
public class UserController extends BaseController{
	@Autowired
	private IUserService userService;
	
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenProvider tokenProvider;
	@Autowired
	private UserConverter uConvert;
	@RequestMapping(value = {"/enter-email"},method = RequestMethod.GET)
	public String forgotEmail(final HttpServletRequest request,final HttpServletResponse response,
			final Model model)
			 {
			
				return "user/forgotPassword";
		
	}
	@RequestMapping(value = {"/regester"},method = RequestMethod.GET)
	public String dangKy(final HttpServletRequest request,final HttpServletResponse response,
			final Model model,
			@ModelAttribute("account") UserDTO userDto) throws InstantiationException, IllegalAccessException {
		List<UserDTO> users=(List<UserDTO>) userService.findAll();
		
		model.addAttribute("users",users);
				return "user/DangKy";
		
	}
	@RequestMapping(value = {"/regester"},method = RequestMethod.POST)
	public String _dangKy(final HttpServletRequest request,final HttpServletResponse response,
			final Model model,
			@ModelAttribute("account") UserDTO userDto) throws InstantiationException, IllegalAccessException {
		userDto.setRoleId(1);
		userDto.setStatus(true);
		UserDTO uDto= userService.findByUserName(userDto.getUserName());
		String checkUsername="";
		if(uDto != null) {
			checkUsername="User already exist!! Please choose a new username";
		}else {
			userService.saveOrUpdate(userDto);
		}
		List<UserDTO> users=(List<UserDTO>) userService.findAll();
		model.addAttribute("checkName",checkUsername);
		model.addAttribute("users",users);
		
				return "redirect:"+"/login";
		
	}
	@RequestMapping(value = {"/login"},method = RequestMethod.GET)
	public String dangNhap(final HttpServletRequest request,final HttpServletResponse response,
			final Model model,
			@ModelAttribute("account") UserDTO userDto) {
		
				return "user/DangNhap";
		
	}
	@RequestMapping(value = {"/login-process"},method = RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> _dangNhap(final HttpServletRequest request,final HttpServletResponse response,
			final Model model,
			@ModelAttribute UserDTO userDto) {
		System.out.println("user session:"+userDto.getUserName());
		// Xác thực từ username và password.
		   request.getSession().setAttribute("username", userDto.getUserName());
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                		userDto.getUserName(),
                		userDto.getPassword()
                )
        );
        System.out.println("auth:"+authentication.getPrincipal());
        // Nếu không xảy ra exception tức là thông tin hợp lệ
      
       
        // Trả về jwt cho người dùng.
        String jwt = tokenProvider.createJwtToken(authentication);
        userDto.setJwt(jwt);
		System.out.println("jwt:"+userDto.getJwt());
//		response.setHeader("Authorization", "Bearer "+jwt);
//		request.setAttribute("Authorization", "Bearer "+jwt);
		Map<String,Object>jsonResult=new HashMap<String, Object>();		
		jsonResult.put("jwt", userDto.getJwt());
		return ResponseEntity.ok(jsonResult);
		
	}
	@SuppressWarnings("serial")
	HttpHeaders createHeaders(String jwt){
		   return new HttpHeaders() {{
		        
		         String authHeader = "Bearer " +jwt;
		         set( "Authorization", authHeader );
		      }};
		}
	@RequestMapping(value = {"/handle-sucess"},method = RequestMethod.GET)
	public String handleSucess(final HttpServletRequest request,final HttpServletResponse response,
			final Model model) {
		
		List<String> roles = roles();
		String url="";
		for(String role : roles) {
			if(role.equalsIgnoreCase("ADMIN")) {
				url="/admin/home";
			}else if (role.equalsIgnoreCase("USER")){
				url="/home";
			}
		}
				return "redirect:" + url;
				
	}
	@RequestMapping(value = {"/profiles"},method = RequestMethod.GET)
	public String profiles(final HttpServletRequest request,final HttpServletResponse response,
			final Model model)
			{
				UserEntity user= (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				UserDTO uDto=uConvert.toDTO(user, new UserDTO());
				model.addAttribute("users", uDto);
				return "user/profiles";
		
	}
}
