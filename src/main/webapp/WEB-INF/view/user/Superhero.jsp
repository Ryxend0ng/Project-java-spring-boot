<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ include file="/WEB-INF/view/common/taglib.jsp" %>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${superhero }</title>
<jsp:include page="/WEB-INF/view/common/user/linkStyle.jsp"></jsp:include>
</head>
<body>
<!-- header -->
    <%@ include file="/WEB-INF/view/common/user/header.jsp" %>
    <!-- header -->
 <div class="main_gener">
   <div class="list_gener">
            <ul>
                <li>
                    <a  href="/kich">Kịch</a>
                </li>
                <li>
                    <a   href="/hai-huoc">Hài Hước</a>
                </li>
                <li>
                    <a   href="/hanh-dong">Hành Động</a>
                </li>
                <li>
                    <a class="active" href="/superhero">Superhero</a>
                </li>
                <li>
                    <a href="/tinh-cam">Tình Cảm</a>
                </li>
                <li>
                    <a href="/kinh-di">Kinh Dị</a>
                </li>
                <li>
                    <a  href="/sieu-nhien ">Siêu Nhiên</a>
                </li>
            </ul>
        </div>
    <div class="main-category ">
 
            <div class="introduce">
                <div class="introduce-comic">
                    
                    <c:forEach items="${comics}" var="comic">
                    <div class="item">
                        <a href="../html/ThongTin.html">
                            <div class="title-comic">
                                <p>${comic.title } </p>
                                <div class="view"><i class="fa fa-heart" aria-hidden="true"></i>${comic.view }
                                </div>
                                <div class="up">up</div>

                            </div>
                            <img src="${pageContext.request.contextPath}${comic.image}" alt="">

                            <div class="comic-thumnail">
                                <p>${comic.title } </p>
                                <hr>${comic.shortDescription}</div>
                        </a>
                         </div>
						</c:forEach>
                   
                  
                   

                </div>
            </div>
            <nav aria-label="Page navigation example">
                <ul class="pagination justify-content-center">
                    <li class="page-item">
                        <a class="page-link" href="#" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <li class="page-item"><a class="page-link" href="#">1</a></li>
                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                    <li class="page-item">
                        <a class="page-link" href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </ul>
            </nav>

        </div>
        <!-- header -->
    <%@ include file="../common/user/footer.jsp" %>
    <!-- header -->
</body>
</html>