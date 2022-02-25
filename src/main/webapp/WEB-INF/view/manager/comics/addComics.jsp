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
						<sf:form action="${base }/admin/add-comics"   modelAttribute="comics"
						method="POST" enctype="multipart/form-data">
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Thể
									loại</label>
								<div class="col-sm-9">
								<c:if test="${empty comics.categoryId}">
									<sf:select path="categoryId" class="form-control" id="category">
									<option value="">Chọn loại bài viết</option>
     							 		 <sf:options items="${categories }" itemValue="id" itemLabel="name" />
									</sf:select>
									</c:if>
									
								
								</div>
							</div>
							<br /> <br />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Tiêu
									đề</label>
								<div class="col-sm-9">
									<sf:input  path="title" type="text" class="form-control" id="title" name="title"
										 />
								</div>
							</div>
							<br /> <br />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Tác giả
									</label>
								<div class="col-sm-9">
									<sf:input path="author" type="text" class="form-control" id="author"
										name="author" />
								</div>
							</div>
							<br /> <br />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Mô
									tả ngắn</label>
								<div class="col-sm-9">
									<sf:input path="shortDescription" type="text" class="form-control" id="shortDescription"
										name="shortDescription"  />
								</div>
							</div>
							<br /> <br />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Nội
									dung</label>
									
									<div class="col-sm-9">
									<sf:textarea path="content" rows="" cols="" id="content" name="content"
										style="width: 820px; height: 175px"></sf:textarea>
								</div>
								
								
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">seo
									</label>
								<div class="col-sm-9">
									<sf:input path="seo" type="text" class="form-control" id="seo"
										name="seo" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Image
									</label>
								<div class="col-sm-9">
								<input  type="file" class="form-control" id="file"
										name="comicAvatar" required="required" multiple="multiple"/>
								</div>
							</div>
							<br /> <br />
							
							<div class="form-group">
								<div class="col-sm-12">
								
									<c:if test="${empty comics.id}">
										<input type="submit"
											class="btn btn-white btn-warning btn-bold"
											value="Thêm bài viết"  />
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
	
   
</script>

</body>
</html>
