package com.ryxen.controller.user;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ryxen.controller.BaseController;
import com.ryxen.dto.NewsDTO;
import com.ryxen.entity.ComicEntity;
import com.ryxen.entity.NewsEntity;
import com.ryxen.service.INewService;

@Controller
public class NewContronller extends BaseController{
	@Autowired
	private INewService newService;
	@RequestMapping(value = {"/tin-tuc"},method = RequestMethod.GET)
	public String getListNew(final HttpServletRequest request,final HttpServletResponse response,
			final Model model) throws InstantiationException, IllegalAccessException {
		List<NewsDTO> news=new ArrayList<NewsDTO>();
		news=newService.findByCategoryId(8);
		
		model.addAttribute("news", news);
				return "user/TinTuc";
		
	}
}
