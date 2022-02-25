<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/WEB-INF/view/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${dang_nhap }</title>
<jsp:include page="/WEB-INF/view/common/user/linkStyle.jsp"></jsp:include>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<!-- header -->
    <%@ include file="../common/user/header.jsp" %>
    <!-- header -->
  
    <div class="login_dn" style="margin-top: 50px;'">
        <div class="form_login">
            <form>
				 <p>Vui lòng nhập email hoặc số di động để tìm kiếm tài khoản của bạn.</p> <br>
                <input type="text" id="email"  placeholder="Email của bạn"/>
               <div class="button" style="justify-content: flex-end;">
                    <div class="button-a"><a style="background-color: gray;" href="${pageContext.request.contextPath}/login">Hủy</a></div> &nbsp;
               		<button  onclick="getPassword()">Tìm kiếm</button>
                </div>              
            </form>
            </div>
        
        </div>
         <jsp:include page="/WEB-INF/view/manager/layout/js.jsp"></jsp:include>
<script >

	function getPassword() {
	
		let formData=new FormData();
		formData.append('email',$('#email').val());
    
        $.ajax({
            url: "/forgot-pasword",           
            type: "POST",
            data : formData,             
            processData: false,      
            contentType: false,
          	dataType : "json",       	
          	 success: function (jsonResult) {
             	alert("!!"+jsonResult.message);
             },
             error : function( errorMessage) {
             	
             	console.log(errorMessage);
             }
        });
     }
	
</script>

  
    <!-- header -->
    <%@ include file="../common/user/footer.jsp" %>
    <!-- header -->
</body>
</html>