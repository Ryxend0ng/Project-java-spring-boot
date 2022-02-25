<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/WEB-INF/view/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${dang_nhap }</title>
<jsp:include page="/WEB-INF/view/common/user/linkStyle.jsp"></jsp:include>
<style type="text/css">
.main-control {
    width: 100%;
}

.main-comic {
    width: 80%;
    margin: 0 auto;
    text-align: center;
}
.title{
padding: 10px;
color: blue;
}
#black{
color: black;
}

</style>
</head>
<body>
<!-- header -->
    <%@ include file="../common/user/header.jsp" %>
    <!-- header -->
 
   <div class="main-control">

        <div class="comic-title">
            <h4 class="title">
                <span>Truyện Dr.Stone -</span>
                <span id="black">Chaptter 1</span></h4>
        </div>
        <div class="main-comic">
            <div class="server-comic">

                <div class="server-mannual">
                    Nếu không xem được truyện vui lòng đổi "SERVER ẢNH" bên dưới <br>
                    <button class="btn btn-primary">Server1</button>
                    <button class="btn btn-primary">Server2</button>
                    <button class="btn btn-primary">Server3</button> <br>
                    <button class="btn btn-warning text-light"><i class="fa fa-exclamation-triangle" aria-hidden="true"></i> Báo lỗi</button>
                </div>
            </div>

            <div class="details-comic">
                <div class="mannual">
                    Sử dụng mũi tên trái (←) hoặc phải (→) để chuyển chapter
                </div>
                <div class="control-comic">

                    <button class="btn btn-success"><i class="fa fa-chevron-left" aria-hidden="true"></i></button>
                    <select name="cars" id="cars">
                    <option value="volvo">Chap 1</option>
                    <option value="saab">Chap 2</option>
                    <option value="mercedes">Chap 3</option>
                    <option value="audi">Chap 4</option>
                  </select>
                    <button class="btn btn-success"><i class="fa fa-chevron-right" aria-hidden="true"></i></button>
                </div>
                <div class="comic-read">
                	<c:forEach items="${chapter }" var="chap">
                	<img alt="" src="${base }${chap.path}">
                	</c:forEach>
                </div>
                <div class="footer-control">
                    <button class="btn btn-danger"><i class="fa fa-chevron-left" aria-hidden="true"></i> Chap trươc </button>
                    <button class="btn btn-danger">Chap sau <i class="fa fa-chevron-right" aria-hidden="true"></i></button>
                </div>
            </div>
        </div>
    </div>
    <!-- header -->
    <%@ include file="../common/user/footer.jsp" %>
    <!-- header -->
     <jsp:include page="/WEB-INF/view/manager/layout/js.jsp"></jsp:include>
     <script type="text/javascript">
     
        </script>
</body>
</html>