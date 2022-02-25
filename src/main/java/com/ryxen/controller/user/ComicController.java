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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ryxen.controller.BaseController;
import com.ryxen.dto.CategoryDTO;
import com.ryxen.dto.ComicDTO;
import com.ryxen.entity.ComicEntity;
import com.ryxen.service.IComicService;

@Controller
public class ComicController extends BaseController{
	@Autowired
	private IComicService comicService;
	
	@RequestMapping(value = {"/superhero"},method = RequestMethod.GET)
	public String getListsuperhero(final HttpServletRequest request,final HttpServletResponse response,
			final Model model) {
		List<ComicDTO> comics=new ArrayList<ComicDTO>();
		comics=comicService.findByCategoryId(5);
		System.out.println("alo"+comics.size());
		model.addAttribute("comics", comics);
				return "user/Superhero";
		
	}
	
}
