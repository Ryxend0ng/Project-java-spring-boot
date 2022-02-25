<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/view/common/taglib.jsp"%>
 <div class="heaader">
        <nav class=" navbar navbar-expand-md bg-light navbar-light  ">
            <div class="container-fluid bg-success">
                <div class="logo-web">
                    <a href="" class="text-light">Webtoon</a>
                </div>
                <button class="navbar-toggler " type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
                                <span><i class="fa fa-bars" aria-hidden="true"></i></span>
                              </button>
                </ul>

                <div class="header-top bg-success">
                    <ul class=" navbar-nav ">
                        <li class="nav-item ">
                            <div class=" has-search ">
                                <span class="fa fa-search form-control-feedback "></span>
                                <input type="text " class="form-control " placeholder="Tìm kiếm ">
                            </div>
                        </li>
                        <c:if test="${ isLogined ==true }">
                        
							<div class="dropdown" style="margin-right: 20px; margin-left: 5px" >
						  <button style="color: white;"  class=" btn btn-sucess dropdown-toggle " type="button" id="dropdownMenuButton username" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						     <i class="fa fa-user-o" aria-hidden="true"></i> ${userLogined.username }
						  </button>
						  <div class="dropdown-menu " aria-labelledby="dropdownMenuButton" 
						  ">
						    <a class="dropdown-item " href="/profiles">${userLogined.username }</a> 
						    <a class="dropdown-item" href="/logout"> <i class=" fa fa-power-off"></i> Đăng xuất</a>
						   
						  </div>
						</div>
                        </c:if>
                      
                        <c:if test="${ isLogined == false}">
                          <li class="nav-item ">
                            <a href="/login">Đăng Nhập</a>
                        </li>
                        <li class="nav-item ">
                            <a href="/regester">/Đăng Ký</a>
                        </li>
                        </c:if>
                      

                    </ul>
                </div>
            </div>
        </nav>
        <nav class="navbar navbar-expand-md bg-light navbar-light header ">
            <div class="container-fluid ">
                <div class="header-bottom menu collapse navbar-collapse" id="collapsibleNavbar">
                    <ul class="navbar-nav ">
                        <li class="">
                            <div class=" has-search hidden">
                                <span class="fa fa-search form-control-feedback "></span>
                                <input type="text " class="form-control " placeholder="Tìm kiếm ">
                            </div>
                        </li>
                        <li>
                            <a href="/home " class="active ">Trang Chủ</a>
                        </li>
                        <li>
                            <a href="#">Thể Loại</a>
                            <div class="submenu ">
                                <div class="sub1 ">
                                    <ul>

                                        <li>
                                            <a  href="/hanh-dong">Hành Động</a>
                                        </li>
                                        <li>
                                            <a href="/tinh-cam">Tình Cảm</a>
                                        </li>

                                        <li>
                                            <a href="/hai-huoc">Hài Hước</a>
                                        </li>
                                        <li>
                                            <a href=" ">Ngôn Tình</a>
                                        </li>
                                        <li>
                                            <a href=" ">Gender Bender</a>
                                        </li>
                                        <li>
                                            <a href=" ">Harem</a>
                                        </li>
                                    </ul>
                                    <ul>

                                        <li>
                                            <a href="/sieu-nhien">Siêu Nhiên</a>
                                        </li>
                                        <li>
                                            <a href="/superhero">Superhero</a>
                                        </li>
                                        <li>
                                            <a href="/kinh-di">Kinh Dị</a>
                                        </li>
                                        <li>
                                            <a href="/kich">Kịch</a>
                                        </li>
                                        <li>
                                            <a href=" ">One Shot</a>
                                        </li>
                                        <li>
                                            <a href=" ">Xuyên Không</a>
                                        </li>
                                    </ul>
                                </div>

                                <div class="sale ">
                                    Rất nhiều<br> thể loại truyện <br><span>HOT</span>
                                </div>
                            </div>
                        </li>
                        <li>
                            <a href="/pho-bien">Phổ Biến</a>

                        </li>
                        <li>
                            <a href="/tin-tuc">Tin Tức Managa</a>
                        </li>
                        <li>
                            <a href="../html/ThuVien.html ">Thư viện</a>
                        </li>
                        <c:if test="${ isLogined == false}">
                        <li>
                            <div class="dang-nhap hidden">
                                <a class="hidden" href="/login">Đăng Nhập</a>
                            </div>
                        </li>
                        <li>
                            <div class="dang-ky hidden">
                                <a class="hidden " href="/regester">Đăng Ký </a>
                            </div>
                        </li>
                        </c:if>
                    </ul>
                </div>
            </div>


        </nav>
    </div>