<%@page import="com.ryxen.service.impl.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/view/common/taglib.jsp" %>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${dang_ky}</title>
<jsp:include page="/WEB-INF/view/common/user/linkStyle.jsp"></jsp:include>
</head>
<body>
<!-- header -->
    <%@ include file="/WEB-INF/view/common/user/header.jsp" %>
    <!-- header -->
   <div class="login">
        <div class="title">
            <p><i class="fa fa-user-plus" aria-hidden="true"></i>Đăng Ký Tài Khoản</p>
        </div>
        <div class="form_dk">
       
            <sf:form action="regester" method="post" modelAttribute="account">
                <p>Địa chỉ Email*</p> <sf:input type="text" path="email" name="email" placeholder="Nhập địa chỉ email"/>
                <p>Tên Tài Khoản*</p> <sf:input id="name" onmouseout="checkName();" type="text" path="userName" name="username" placeholder="Nhập Tên Tài Khoản"/> <br>
                <p>Mật Khẩu*</p> <sf:input type="text" path="password" name="password" placeholder="Nhập Mật Khẩu"/>
              	
                <p class="DieuKhoan">Bằng cách đăng ký, tôi đồng ý với Điều khoản sử dụng và Chính sách bảo mật của WEBTOON</p>
                <div> <button type="submit">Đăng Ký Ngay</button></div>
            </sf:form>
        </div>
        <div class="footer_login">
            <p>Terms of use</p>
            <p><i class="fa fa-creative-commons" aria-hidden="true"></i> WEBTOON Entertainment Inc.</p> <br>
        </div>
    </div>
    <!-- header -->
    <%@ include file="../common/user/footer.jsp" %>
    <!-- header -->
    <script type="text/javascript">
    	
    </script>
</body>
</html>