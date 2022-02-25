<!-- JSTL -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="/WEB-INF/view/common/taglib.jsp" %>
<html >
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Simple Sidebar - Start Bootstrap Template</title>
   
        <!-- variables -->
        <jsp:include page="/WEB-INF/view/common/taglib.jsp"></jsp:include>
        
        <!-- css -->
        <jsp:include page="/WEB-INF/view/manager/layout/cssAdmin.jsp"></jsp:include>
        
        <style>

</style>
    </head>
    <body >
    
            <!-- Sidebar-->
          <jsp:include page="/WEB-INF/view/common/manager/menu.jsp"></jsp:include>
<div class="main-content">

		
			<div class="main-content-inner">
				<div class="breadcrumbs ace-save-state" id="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Trang
								chủ</a></li>
					</ul>
					<!-- /.breadcrumb -->
				</div>
				<div class="page-content">
				<div class="search1">
				
		
					
				</div>
				<form action="/admin/list-categories" id="formSubmit"
			method="get">
				<input type="text" placeholder="Tìm kiếm"  id="keyword" name="keyWord" > <input type="submit"  class="btn btn-primary" id="search"    value="Tìm Kiếm">
					<div class="row">
						<div class="col-xs-12">
							<c:if test="${not empty messageResponse}">
								<div class="alert alert-${alert}">${messageResponse}</div>
							</c:if>
							<div class="widget-box table-filter">
								<div class="table-btn-controls">
									<div class="pull-right tableTools-container">
										<div class="dt-buttons btn-overlap btn-group">
											<a flag="info"
												class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
												data-toggle="tooltip" title='Thêm bài viết'
												href='<c:url value="/admin/add-categories"/>'> <span>
													<i class="fa fa-plus-circle bigger-110 purple"></i>
											</span>
											</a>
											<button id="btnDelete" type="button"
												class="dt-button buttons-html5 btn btn-white btn-primary btn-bold"
												data-toggle="tooltip" title='Xóa bài viết'>
												<span> <i class="fa fa-trash-o bigger-110 pink"></i>
												</span>
											</button>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12">
									<div class="table-responsive">
										<table class="table table-bordered table-striped ">
											<thead>
												<tr>
													<th><input type="checkbox" id="checkAll"></th>
													<th>Id</th>
													<th>Content</th>
													<th>UserId</th>
													<th>Type</th>
													
												</tr>
											</thead>
									<tbody>
												<c:forEach items="${categories}" var="categories">
													<tr>
														<td><input type="checkbox" id="checkbox_${categories.id}"
															value="${categories.id}" name="ids"></td>
														<td>${categories.id }</td>
													
										        		<td>${categories.name }</td>
										        		<td class="">${categories.code }</td>
										        		<td c>${comics.status }</td>
														<td class="text-center">
															 <a class="btn btn-sm btn-primary btn-edit"
															data-toggle="tooltip" title="Cập nhật bài viết"
															href="${base}/admin/edit-categories/${categories.code}"><i class="fa fa-pencil-square-o"
																aria-hidden="true"></i> </a>
																<button class="btn btn-sm btn-danger btn-edit"
															data-toggle="tooltip" title="Xóa  bài viết"
															onclick="deleteNew(${categories.id })" ><i class="fa fa-trash-o bigger-110 "></i> </button>
															<button class="btn btn-sm  btn-secondary btn-edit"
															data-toggle="tooltip" title="Xem  bài viết"
															 ><i class="fa fa-eye"></i></button></td>
													</tr>
												</c:forEach>
											</tbody>
											
										</table>
										<%--start poupup --%>
										
										<%-- end poupup --%>
										<div class="text-center">
										<ul class="pagination" id="pagination"></ul>
										</div>
										
										
									</div>
								</div>
							</div>
						</div>
					</div>
						</form>
				</div>
			</div>
	
	</div>
	   <jsp:include page="/WEB-INF/view/manager/layout/js.jsp"></jsp:include>
   
        <!-- javascript -->
        <jsp:include page="/WEB-INF/view/manager/layout/js.jsp"></jsp:include>
       
    </body>
</html>

