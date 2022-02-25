package com.ryxen.controller.manager;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ryxen.controller.BaseController;
import com.ryxen.converter.UserConverter;
import com.ryxen.dto.UserDTO;
import com.ryxen.entity.UserEntity;
import com.ryxen.service.IUserService;

@Controller
@SuppressWarnings("unused")
public class ManagerSendMail extends BaseController{
	private static final String alpha = "abcdefghijklmnopqrstuvwxyz"; // a-z
	private static final String alphaUpperCase = alpha.toUpperCase(); // A-Z
	private static final String digits = "0123456789"; // 0-9
	 private static final String ALPHA_NUMERIC = alpha + alphaUpperCase + digits;
	 private static Random generator = new Random();
	@Autowired
	private JavaMailSender emailSender;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private UserConverter userConvert;
	
	@ResponseBody
	@RequestMapping(value = "/send-mail")
	public String emailSend() {
		
		SimpleMailMessage message=new SimpleMailMessage();

        message.setFrom("nguyenvandong778899@gmail.com");
        message.setReplyTo("alo1");
        message.setSentDate(new Date());
      
        message.setTo("nguyenvandong778899@gmail.com");
        message.setSubject("Test Simple Email");
        message.setText("Hello, Im testing Simple Email");
 
        // Send Message!
        this.emailSender.send(message);
		return "Email sent";
	}
	
	@RequestMapping(value = "/forgot-pasword",method = RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> forgotPasswordUser(final HttpServletRequest request,
			final HttpServletResponse response,		
			final Model model,
			final @ModelAttribute UserDTO userDto) {
		System.out.println("email:"+userDto.getEmail());
		UserDTO user=userService.findByEmail(userDto.getEmail());
		
		user.setPassword(new BCryptPasswordEncoder(10).encode(randomAlphaNumeric(4)));
		userService.saveOrUpdate(user);
		SimpleMailMessage message=new SimpleMailMessage();
	//	UserDTO user=userService.
        message.setSentDate(new Date());
     
        message.setTo(user.getEmail());
        message.setSubject("Your PassWord");
        message.setText("Your password is :"+randomAlphaNumeric(4));
       
        // Send Message!
        this.emailSender.send(message);
        Map<String,Object> jsonResult=new HashMap<String, Object>();
        jsonResult.put("message", "Mật khẩu được gửi trong Email !.Vui lòng check Email của bạn");
		return ResponseEntity.ok(jsonResult);
	}
	 public String randomAlphaNumeric(int numberOfCharactor) {
	        StringBuilder sb = new StringBuilder();
	        for (int i = 0; i < numberOfCharactor; i++) {
	            int number = randomNumber(0, ALPHA_NUMERIC.length() - 1);
	            char ch = ALPHA_NUMERIC.charAt(number);
	            sb.append(ch);
	        }
	        return sb.toString();
	    }
	 public static int randomNumber(int min, int max) {
	        return generator.nextInt((max - min) + 1) + min;
	    }
}
