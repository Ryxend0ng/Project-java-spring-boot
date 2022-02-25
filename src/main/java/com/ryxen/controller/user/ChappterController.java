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
import com.ryxen.dto.ComicDTO;
import com.ryxen.entity.ChappterEntity;
import com.ryxen.repository.ChapterRepository;

@Controller
public class ChappterController extends BaseController{
	@Autowired
	private ChapterRepository chapRe;
	@RequestMapping(value = {"/chapter"},method = RequestMethod.GET)
	public String getDetailsChappter(final HttpServletRequest request,final HttpServletResponse response,
			final Model model) {
			List<ChappterEntity> chap= new ArrayList<ChappterEntity>();
			chap=chapRe.findAll();
	model.addAttribute("chapter", chap);
				return "user/readChappter";
		
	}
}
