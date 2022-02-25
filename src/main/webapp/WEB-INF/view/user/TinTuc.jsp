<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${tin_tuc }</title>
<jsp:include page="/WEB-INF/view/common/user/linkStyle.jsp"></jsp:include>
<link href="${pageContext.request.contextPath}/template/web/css/News.css" rel="stylesheet" type="text/css" media="all"/>
</head>
<body>
<!-- header -->
    <%@ include file="../common/user/header.jsp" %>
    <!-- header -->
   <div class="new-news ">
            <div class="news_gener ">
                <div class="news_title">
                    Tin Tức Manga
                </div>
                <ul>
                <c:forEach items="${news }" var="news">
                    <li>
                        <a href="/the-royal">
                            <img src="${pageContext.request.contextPath}${news.image}" alt=" ">
                            <div class="news_thumbnail">
                                <div class="gener ">Tin tức manga</div>
                                <div class="name ">${news.title }</div>
                                <div class="news_view">1 tuần trước - ${news.view } lượt xem</div>
                                <p>${news.shortDescription }</p>
                            </div>
                        </a>
                    </li>
                   </c:forEach>

                </ul>
            </div>
            <nav aria-label="Page navigation example">
                <ul class="pagination justify-content-center ">
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