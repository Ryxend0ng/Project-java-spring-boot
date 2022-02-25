<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/WEB-INF/view/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${dang_nhap }</title>
<jsp:include page="/WEB-INF/view/common/user/linkStyle.jsp"></jsp:include>
</head>
<body>
<!-- header -->
    <%@ include file="../common/user/header.jsp" %>
    <!-- header -->
  <div class="login_banner">
        <div class="title">
            welcome to
        </div>
        <img src="${pageContext.request.contextPath}/template/web/image/Naver_Line_Webtoon_logo.png" alt="">
    </div>
    <div class="login_dn">
        <div class="form_login">
            <form action="/login-process" method="post">
            	<c:if test="${ not empty param.login_error}">
					<div class="alert alert-danger"> Đăng nhập không thành công! </div>
				</c:if>
                <input  type="text" name="userName" id="userName" placeholder="Tài Khoản"/>
                <input   type="text" name="password" id="password" placeholder="Mật Khẩu"/> <br>
                <div class="remember-me"><input  type="checkbox" name="remember-me"/> Nhớ mật khẩu? <br></div>
                <div class="button"><button type="button" onclick="add();">Đăng Nhập</button>
                    <div class="button-a"><a href="${pageContext.request.contextPath}/regester">Đăng Ký</a></div>
               	
                </div>
            </form>
            <div class="forgotPassword">
                <a href="${base}/enter-email">Quên mật khẩu?</a> <br>
                <p>Hoặc đăng nhập</p>
            </div>
            <div class="logo_login">
              <a href="${base }/oauth2/authorization/facebook">  <i class="fa fa-facebook-square" aria-hidden="true"></i></a>
                <i class="fa fa-instagram" aria-hidden="true"></i>
                <i class="fa fa-twitter" aria-hidden="true"></i>
                <i class="fa fa-google" aria-hidden="true"></i>
            </div>
        </div>


    </div>
    <!-- header -->
    <%@ include file="../common/user/footer.jsp" %>
    <!-- header -->
     <jsp:include page="/WEB-INF/view/manager/layout/js.jsp"></jsp:include>
     <script type="text/javascript">
     function add() {
    	let formData=new FormData();
    	
    
    	formData.append('userName',$('#userName').val());
    	formData.append('password', $('#password').val());
    
        $.ajax({
            url: "/login-process",
           
            type: "POST",
            data : formData, 
            
            processData: false,      
            contentType: false,
          	dataType : "json",
          	
            success: function (jsonResult) {
            	alert("Chúc mừng!!");
            	

            	 $.ajax({
                     url:"/home",
                     "method": "GET",
               	 	
               	 	 "headers": {
               	 	  "Authorization": "Bearer "+jsonResult.jwt
               	 	 },
               	 	 "processData": false,
               	 	 "contentType": false,
               	 	success:function(){
               	 	window.location.assign("http://localhost:8080/handle-sucess")
                    },    
                   
                 }); 
            	 
            }});
     }
        </script>
</body>
</html>