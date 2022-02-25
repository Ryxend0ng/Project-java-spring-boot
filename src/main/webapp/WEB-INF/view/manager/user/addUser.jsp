<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/view/common/taglib.jsp" %>

<html>
<head>

 <title>Simple Sidebar - Start Bootstrap Template</title>
   
        <!-- variables -->
        <jsp:include page="/WEB-INF/view/common/taglib.jsp"></jsp:include>
        
        <!-- css -->
        <jsp:include page="/WEB-INF/view/manager/layout/cssAdmin.jsp"></jsp:include>
</head>
<body>
 <jsp:include page="/WEB-INF/view/common/manager/menu.jsp"></jsp:include>
	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs" id="breadcrumbs">
				<script type="text/javascript">
                try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
            </script>
				<ul class="breadcrumb">
					<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Trang
							chủ</a></li>
					<li class="active">Chỉnh sửa bài viết</li>
				</ul>
				<!-- /.breadcrumb -->
			</div>
			<div class="page-content">
				<div class="row">
					<div class="col-xs-12">
						<c:if test="${not empty messageResponse}">
							<div class="alert alert-${alert}">${messageResponse}</div>
						</c:if>
						<sf:form action="${base }/admin/add-users"  id="formSubmit" 
						method="POST" modelAttribute="user">
							
							<br /> <br />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">
									UserName
									</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="userName" name="userName"
										 />
								</div>
							</div>
							<br /> <br />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Password
									</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="password"
										name="password"  />
								</div>
							</div>
							<br /> <br />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Email
									</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="email"
										name="email"  />
								</div>
							</div>
							<br /> <br />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Trạng thái hoạt động</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="status"
										name="status"  />
								</div>
							</div>
							<br /> <br />
								<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Phân quyền</label>
								<div class="col-sm-9">
								
									<sf:select path="roleId" class="form-control" id="roleId">
									<option value="">Chọn quyền</option>
     							 		 <sf:options items="${roles }" itemValue="id" itemLabel="name" />
									</sf:select>
									
								</div>
							</div>
							<br /> <br />
								
							
							<br /> <br />
							<div class="form-group">
								<div class="col-sm-12">
									<input type="button"
											class="btn btn-white btn-warning btn-bold"
											value="Cập nhật bài viết" id="btnAddOrUpdateNew" onclick="updateNew()"/>
																
								</div>
							</div>
							
						</sf:form>
					</div>
				</div>
			</div>
		</div>
	</div>
	 <jsp:include page="/WEB-INF/view/manager/layout/js.jsp"></jsp:include>
	<script>
	
   
    function updateNew() {
    	let data={
    			
    			userName : $('#userName').val(),
    			password : $('#password').val(),
    			status : $('#status').val(),
    			email : $('#email').val(),
    			roleId : $('#roleId').val()
    	}
    	
        $.ajax({
            url: "/admin/add-users",        
            type: "POST",
            contentType : "application/json",
			data : JSON.stringify(data),

			dataType : "json", // kieu du lieu tra ve tu controller la json
         
            success: function (jsonResult) {
            	alert("Chúc mừng!!! Đã lưu thành công thể loại :"+jsonResult.message.userName);
            },
            error : function( errorMessage) {
            	
            	console.log(errorMessage);
            }
        });
    }
</script>

</body>
</html>
