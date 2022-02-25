<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="/WEB-INF/view/common/taglib.jsp" %>

<html>
<head>

 <title>Simple Sidebar - Start Bootstrap Template</title>
   
        <!-- variables -->
        <jsp:include page="/WEB-INF/view/common/taglib.jsp"></jsp:include>
        
        <!-- css -->
        <jsp:include page="/WEB-INF/view/manager/layout/cssAdmin.jsp"></jsp:include>
        <style type="text/css">
        	.div_editor1{
        		width:100px;
        	}
        </style>
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
						<sf:form action="${base }/admin/edit-comics"  id="formSubmit"  enctype="multipart/form-data"
						method="POST" modelAttribute="comic">
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Thể
									loại</label>
								<div class="col-sm-9">
									<select class="form-control" id="categoryId"
										name="categoryId">
										
										<c:if test="${not empty comics.categoryId}">
											<option value="">Chọn loại bài viết</option>
											<c:forEach var="item" items="${categories}">
												<option value="${item.id}"
													<c:if test="${item.id == comics.categoryId}">selected="selected"</c:if>>
													${item.name}</option>
											</c:forEach>
										</c:if>
									</select>
								</div>
							</div>
							<br/> <br/>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Tiêu
									đề</label>
								<div class="col-sm-9" >
									<input type="text" class="form-control " id="title" name="title"
										value="${comics.title}" />
								</div>
							</div>
							<br /> <br />
							<br/> <br/>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Ảnh
									</label>
								<div class="col-sm-9">
									<img width="200px" alt="" src="${base }${comics.image}"/>
								</div>
							</div>
							<br/> <br/>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Tác giả
									</label>
								<div class="col-sm-9">
									<input type="text" class="form-control  div_editor1" id="author"
										name="author" value="${comics.author}" />
								</div>
							</div>
							<br/> <br/>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Mô
									tả ngắn</label>
								<div class="col-sm-9">
									<input type="text" class="form-control div_editor1" id="shortDescription"
										name="shortDescription" value="${comics.shortDescription}" />
								</div>
							</div>
							<br/> <br/>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Nội
									dung</label>
								<div class="col-sm-9">
									<textarea 
								class="div_editor2"	rows="" cols="" id="content" name="content"
										style="width:750px; height: 175px">${comics.content}</textarea>
								</div>
							</div>
							<br/> <br/>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">seo
									</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="seo"
										name="seo" value="${comics.seo}" />
								</div>
							</div>
							<br/> <br/>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Avatar
									</label>
								<div class="col-sm-9">
									<input type="file" class="form-control" id="file"
										name="file" />
								</div>
								<input type="hidden" value="${comics.id}" id="id" name="id" />
							</div>
							<br/> <br/>
							<div class="form-group">
								<div class="col-sm-12">
									<c:if test="${not empty comics.id}">
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
	
	var editor1 = new RichTextEditor(".div_editor1");
	var editor2 = new RichTextEditor(".div_editor2");
    function updateNew() {
    	let formData=new FormData();
    	
    	formData.append('categoryId', $('#categoryId').val());
    	formData.append('title',$('#title').val());
    	formData.append('author',$('#author').val());
    	formData.append('shortDescription',$('#shortDescription').val());
    	formData.append('content',$('#content').val());
    	formData.append('seo', $('#seo').val());
    	
    	formData.append('id', $('#id').val());
        if($('#file')[0].files[0]){
        	formData.append('file',$('#file')[0].files[0]);
        }else{
        	
        }
    	
        $.ajax({
            url: "/admin/edit-comics",
           
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
