package com.ryxen.controller.manager;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ryxen.controller.BaseController;

@Controller
public class HomeController extends BaseController{

	@RequestMapping(value = {"/admin/home"},method = RequestMethod.GET)
	public String homePage(final HttpServletRequest request,final HttpServletResponse response,
			final Model model) {
		return "manager/homeAdmin";
		
	}
	
}
