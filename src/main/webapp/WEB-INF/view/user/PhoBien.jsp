<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${pho_bien }</title>
<jsp:include page="/WEB-INF/view/common/user/linkStyle.jsp"></jsp:include>
</head>
<body>
<!-- header -->
    <%@ include file="../common/user/header.jsp" %>
    <!-- header -->
   <div class="content">
        <!--htmml banner end-->
        <div class="main">
            <div class="most-popular ">
                <div class="popular-gener ">
                    <div class="popular_title size-title ">
                        <p>Phổ biến nhất theo thể loại &nbsp;<i class="fa fa-chevron-right " aria-hidden="true "></i></p>
                        <p>All</p>
                    </div>
                    <ul>
                        <li>
                            <a href="../html/ThongTin.html ">
                                <img src="${pageContext.request.contextPath}/template/web/image/royal1.jpg " alt=" ">
                                <div class="title-gener ">
                                    <div class="gener ">Hành Động</div>
                                    <div class="name ">Boyfriend</div>
                                    <p>Kiềm chế</p>
                                </div>
                            </a>
                        </li>
                        <li>
                            <a href="../html/ThongTin.html ">
                                <img src="${pageContext.request.contextPath}/template/web/image/vua sot.PNG " alt=" ">
                                <div class="title-gener ">
                                    <div class="gener ">Kinh dị</div>
                                    <div class="name ">Tua đi nhanh</div>
                                    <p>Huyền ảo</p>
                                </div>
                            </a>
                        </li>
                        <li>
                            <a href="../html/ThongTin.html ">
                                <img src="${pageContext.request.contextPath}/template/web/image/beha.PNG " alt=" ">
                                <div class="title-gener ">
                                    <div class="gener ">Tình cảm</div>
                                    <div class="name ">Bệ hạ</div>
                                    <p>Kiềm chế</p>
                                </div>
                            </a>
                        </li>
                        <li>
                            <a href="../html/ThongTin.html ">
                                <img src="${pageContext.request.contextPath}/template/web/image/bong.PNG " alt=" ">
                                <div class="title-gener ">
                                    <div class="gener ">Hành Động</div>
                                    <div class="name ">Bóng ma</div>
                                    <p>Sợ hãi</p>
                                </div>
                            </a>
                        </li>
                        <li>
                            <a href=" ../html/ThongTin.html ">
                                <img src="${pageContext.request.contextPath}/template/web/image/dap.PNG " alt=" ">
                                <div class="title-gener ">
                                    <div class="gener ">Hành Động</div>
                                    <div class="name ">Đập</div>
                                    <p>Xung mãn</p>
                                </div>
                            </a>
                        </li>

                    </ul>
                </div>

                <div class="popular-gener ">
                    <div class="popular_title size-title ">
                        <p>Phổ biến nhất theo nhóm &nbsp;<i class="fa fa-chevron-right " aria-hidden="true "></i></p>
                        <p>Male 2021</p>
                    </div>
                    <ul>
                        <li>
                            <a href="../html/ThongTin.html ">
                                <img src="${pageContext.request.contextPath}/template/web/image/faainlove.jpg " alt=" ">
                                <div class="title-gener ">
                                    <div class="gener ">Hành Động</div>
                                    <div class="name ">Yêu sâu</div>
                                    <p>Đột ngột</p>
                                </div>
                            </a>
                        </li>
                        <li>
                            <a href="../html/ThongTin.html ">
                                <img src="${pageContext.request.contextPath}/template/web/image/news5.jpg " alt=" ">
                                <div class="title-gener ">
                                    <div class="gener ">Lãng mạn</div>
                                    <div class="name ">Trượt yêu</div>
                                    <p>Nóng lòng</p>
                                </div>
                            </a>
                        </li>
                        <li>
                            <a href="../html/ThongTin.html ">
                                <img src="${pageContext.request.contextPath}/template/web/image/nuabm.PNG " alt=" ">
                                <div class="title-gener ">
                                    <div class="gener ">Kinh dị</div>
                                    <div class="name ">Nửa ma</div>
                                    <p>Huyền bí</p>
                                </div>
                            </a>
                        </li>
                        <li>
                            <a href=" ../html/ThongTin.html ">
                                <img src="${pageContext.request.contextPath}/template/web/image/tuynhien.PNG " alt=" ">
                                <div class="title-gener ">
                                    <div class="gener ">Hành Động</div>
                                    <div class="name ">Tuy nhiên</div>
                                    <p>Kiềm chế</p>
                                </div>
                            </a>
                        </li>
                        <li>
                            <a href=" ../html/ThongTin.html ">
                                <img src="${pageContext.request.contextPath}/template/web/image/buildKing.jpg " alt=" ">
                                <div class="title-gener ">
                                    <div class="gener ">Hành Động</div>
                                    <div class="name ">Vua KingDom</div>
                                    <p>Tương lai</p>
                                </div>
                            </a>
                        </li>

                    </ul>
                </div>

            </div>

        </div>
    </div>
    <!-- header -->
    <%@ include file="../common/user/footer.jsp" %>
    <!-- header -->
</body>
</html>