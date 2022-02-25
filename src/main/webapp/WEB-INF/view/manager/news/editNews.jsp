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
						<sf:form action="${base }/admin/edit-news"  id="formSubmit"  enctype="multipart/form-data"
						method="POST" modelAttribute="news">
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Thể
									loại</label>
								<div class="col-sm-9">
									<select class="form-control" id="categoryId"
										name="categoryId">
										
										<c:if test="${not empty news.categoryId}">
											<option value="">Chọn loại bài viết</option>
											<c:forEach var="item" items="${categories}">
												<option value="${item.id}"
													<c:if test="${item.id == news.categoryId}">selected="selected"</c:if>>
													${item.name}</option>
											</c:forEach>
										</c:if>
									</select>
								</div>
							</div>
							<br /> <br />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Tiêu
									đề</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="title" name="title"
										value="${news.title}" />
								</div>
							</div>
							<br /> <br />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Ảnh
									</label>
								<div class="col-sm-9">
									<img width="200px" alt="" src="${base }${news.image}"/>
								</div>
							</div>
							
							<br /> <br />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Mô
									tả ngắn</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="shortDescription"
										name="shortDescription" value="${news.shortDescription}" />
								</div>
							</div>
							<br /> <br />
							
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">seo
									</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="seo"
										name="seo" value="${news.seo}" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Avatar
									</label>
								<div class="col-sm-9">
									<input type="file" class="form-control" id="file"
										name="file" />
								</div>
								<input type="hidden" value="${news.id}" id="id" name="id" />
							</div>
							<br /> <br />
							<div class="form-group">
								<div class="col-sm-12">
									<c:if test="${not empty news.id}">
										<input type="button"
											class="btn btn-white btn-warning btn-bold"
											value="Cập nhật bài viết" id="btnAddOrUpdateNew" onclick="updateNew()"/>
									</c:if>
									
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
    	let formData=new FormData();
    	
    	formData.append('categoryId', $('#categoryId').val());
    	formData.append('title',$('#title').val()); 	
    	formData.append('shortDescription',$('#shortDescription').val());
    	formData.append('seo', $('#seo').val());  	
    	formData.append('id', $('#id').val());
        if($('#file')[0].files[0]){
        	formData.append('file',$('#file')[0].files[0]);
        }else{
        	
        }
    	
        $.ajax({
            url: "/admin/edit-news",
           
            type: "POST",
            data : formData, 
            
            processData: false,      
            contentType: false,
          	dataType : "json",
            success: function (jsonResult) {
            	alert("Chúc mừng!!! Đã lưu thành công truyện :");
            },
            error : function( errorMessage) {
            	
            	console.log(errorMessage);
            }
        });
    }
</script>

</body>
</html>
