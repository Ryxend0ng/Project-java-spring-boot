package com.ryxen.controller.user;



import java.util.ArrayList;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ryxen.controller.BaseController;
import com.ryxen.dto.CategoryDTO;
import com.ryxen.dto.ComicDTO;
import com.ryxen.dto.NewsDTO;
import com.ryxen.dto.UserDTO;
import com.ryxen.entity.CommentEntity;
import com.ryxen.entity.UserEntity;
import com.ryxen.repository.CommentRepository;
import com.ryxen.service.ICategoryService;
import com.ryxen.service.IComicService;
import com.ryxen.service.INewService;
import com.ryxen.service.IUserService;

@Controller(value = "homeOfUser")
public class HomeController extends BaseController{
	@Autowired
	private INewService newService;
	@Autowired
	private IComicService comicService;
	@Autowired
	private ICategoryService cateService;
	@Autowired
	private CommentRepository comRe;
	@Autowired
	private IUserService userService;
	
		@SuppressWarnings("null")
		@RequestMapping(value = {"/home"},method = RequestMethod.GET)
		public String homePage(final HttpServletRequest request,final HttpServletResponse response,
				final Model model) throws InstantiationException, IllegalAccessException {
		
			//danh sach tin tuc theo the loai tin tuc managa
			List<NewsDTO> news=new ArrayList<NewsDTO>();
			news=newService.findByCategoryId(cateService.findByCode("tin-tuc-managa").getId());
			System.out.println("size:"+news.size());
			
			//danh sach truyen theo the loai superhero
			List<ComicDTO> comics=new ArrayList<ComicDTO>();
			comics=comicService.findTopByCategoryId(4,cateService.findByCode("superhero").getId());
			
			//danh sach truyen theo the loai kinh di
			List<ComicDTO> comicsKd=new ArrayList<ComicDTO>();
			comicsKd=comicService.findTopByCategoryId(4, cateService.findByCode("kinh-di").getId());
			
			//danh sach truyen theo thoi gian
			List<ComicDTO> comicsTg=new ArrayList<ComicDTO>();
			comicsTg=comicService.findByCreatedDate("2021-08-22");
			
			//danh sach truyen tu 1 den 9
			List<ComicDTO> comicRandom=new ArrayList<ComicDTO>();
			comicRandom=comicService.findTopByCategoryId(9, 0);
			String username = (String) request.getSession().getAttribute("username");
			System.out.println("usnamr:"+username);
			
		
			model.addAttribute("comics", comics);
			model.addAttribute("comicBy9", comicRandom);
			model.addAttribute("comicsNew", comicsTg);
			model.addAttribute("comicsKd", comicsKd);
			model.addAttribute("news", news);
			return "user/home";
			
		}
		
		@RequestMapping(value = {"/pho-bien"},method = RequestMethod.GET)
		public String phoBien(final HttpServletRequest request,final HttpServletResponse response,
				final Model model) {
			model.addAttribute("pho_bien", "Phổ biến");
					return "user/PhoBien";
			
		}
		@RequestMapping(value = {"/hai-huoc"},method = RequestMethod.GET)
		public String haiHuoc(final HttpServletRequest request,final HttpServletResponse response,
				final Model model) {
			List<ComicDTO> comics=new ArrayList<ComicDTO>();
			comics=comicService.findByCategoryId(5);
			System.out.println("alo"+comics.size());
			model.addAttribute("comics", comics);
			model.addAttribute("hai_huoc", "Hài hước");
					return "user/HaiHuoc";
			
		}
		
		@RequestMapping(value = {"/hanh-dong"},method = RequestMethod.GET)
		public String hanhDong(final HttpServletRequest request,final HttpServletResponse response,
				final Model model) {
			List<ComicDTO> comics=new ArrayList<ComicDTO>();
			comics=comicService.findByCategoryId(5);
			System.out.println("alo"+comics.size());
			model.addAttribute("comics", comics);
			model.addAttribute("hanh_dong", "Hành động");
					return "user/HanhDong";
			
		}
		@RequestMapping(value = {"/kich"},method = RequestMethod.GET)
		public String kich(final HttpServletRequest request,final HttpServletResponse response,
				final Model model) {
			List<ComicDTO> comics=new ArrayList<ComicDTO>();
			comics=comicService.findByCategoryId(5);
			System.out.println("alo"+comics.size());
			model.addAttribute("comics", comics);
			model.addAttribute("kich", "Kịch");
					return "user/Kich";
			
		}
		@RequestMapping(value = {"/kinh-di"},method = RequestMethod.GET)
		public String kinhDi(final HttpServletRequest request,final HttpServletResponse response,
				final Model model) {
			List<ComicDTO> comics=new ArrayList<ComicDTO>();
			comics=comicService.findByCategoryId(5);
			System.out.println("alo"+comics.size());
			model.addAttribute("comics", comics);
			model.addAttribute("kinh)_di", "Kinh dị");
					return "user/KinhDI";
			
		}
		@RequestMapping(value = {"/sieu-nhien"},method = RequestMethod.GET)
		public String sieuNhien(final HttpServletRequest request,final HttpServletResponse response,
				final Model model) {
			List<ComicDTO> comics=new ArrayList<ComicDTO>();
			comics=comicService.findByCategoryId(5);
			System.out.println("alo"+comics.size());
			model.addAttribute("comics", comics);
			model.addAttribute("sieu-nhien", "Siêu nhiên");
					return "user/SieuNhien";
			
		}
	
		@RequestMapping(value = {"/thong-tin/{comicSeo}"},method = RequestMethod.GET)
		public String thongTin(final HttpServletRequest request,final HttpServletResponse response,
				final Model model,
				@PathVariable(value = "comicSeo") String comicSeo) throws InstantiationException, IllegalAccessException {
			//danh sach truyen 
			ComicDTO comicRandom=new ComicDTO();
			comicRandom=comicService.findBySeo(comicSeo);
			CategoryDTO  category= cateService.findById(comicRandom.getCategoryId());
			List<CommentEntity> listComment=comRe.findAll();
			List<UserDTO> listUser=userService.findAll();
			
			model.addAttribute("users", listUser);
			model.addAttribute("comments", listComment);
			model.addAttribute("category", category.getName());
			model.addAttribute("thong_tin", "Thông tin");
			model.addAttribute("comics", comicRandom);
					return "user/ThongTin";
			
		}
		@RequestMapping(value = {"/tinh-cam"},method = RequestMethod.GET)
		public String tinhCam(final HttpServletRequest request,final HttpServletResponse response,
				final Model model) {
			List<ComicDTO> comics=new ArrayList<ComicDTO>();
			comics=comicService.findByCategoryId(5);
			System.out.println("alo"+comics.size());
			model.addAttribute("comics", comics);
			model.addAttribute("tinh_cam", "Tình cảm");
					return "user/TinhCam";
			
		}
	
		@RequestMapping(value = {"/build-king"},method = RequestMethod.GET)
		public String buildKing(final HttpServletRequest request,final HttpServletResponse response,
				final Model model) {
			model.addAttribute("build_king", "Build king");
					return "user/Superhero";
			
		}
		@RequestMapping(value = {"/fall-in-love"},method = RequestMethod.GET)
		public String fallLove(final HttpServletRequest request,final HttpServletResponse response,
				final Model model) {
			model.addAttribute("fall_in_love", "Fall in love");
					return "user/FailInLove";
			
		}
		@RequestMapping(value = {"/the-royal"},method = RequestMethod.GET)
		public String theroyal(final HttpServletRequest request,final HttpServletResponse response,
				final Model model) {
			model.addAttribute("the_royal", "The Royal");
					return "user/TheRoyal";
			
		}
		@RequestMapping(value = {"/trick-wish"},method = RequestMethod.GET)
		public String trickWish(final HttpServletRequest request,final HttpServletResponse response,
				final Model model) {
			model.addAttribute("trick_wish", "Trick wish");
					return "user/TrickWish";
			
		}
		
		
}
