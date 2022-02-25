package com.ryxen.controller.user;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import com.ryxen.controller.BaseController;
import com.ryxen.converter.UserConverter;
import com.ryxen.dto.ChatMessager;
import com.ryxen.dto.UserDTO;
import com.ryxen.entity.CommentEntity;
import com.ryxen.entity.UserEntity;
import com.ryxen.repository.CommentRepository;
import com.ryxen.service.IUserService;

@Controller
public class WebSocketController extends BaseController{
	@Autowired
	private IUserService userService;
	@Autowired
	private UserConverter userConvert;
	@Autowired
	private CommentRepository comRe;
	
	
	 @MessageMapping("/chat.sendMessage")
	    @SendTo("/topic/publicChatRoom")
	    public ChatMessager sendMessage(@Payload ChatMessager chatMessage) {
		 CommentEntity com=new CommentEntity();
		 com.setUserName(chatMessage.getSender());
		 com.setContent(chatMessage.getContent());
		 com.setType("comic");
		Calendar cd=Calendar.getInstance();
		Date now=cd.getTime();		
			com.setCreatedDate(now);
		 //com.setUser(uEn);
		 System.out.println("message:"+chatMessage.getContent());
		 comRe.saveOrUpdate(com);
	        return chatMessage;
	    }
	 
	    @MessageMapping("/chat.addUser")
	    @SendTo("/topic/publicChatRoom")
	    public ChatMessager addUser(@Payload ChatMessager chatMessage, SimpMessageHeaderAccessor headerAccessor) {
	        // Add username in web socket session
	        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
	        return chatMessage;
	    }
}
