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
		<form action="/admin/list-news" id="formSubmit"
			method="get">
			<div class="main-content-inner">
				<div class="breadcrumbs ace-save-state" id="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Trang
								chủ</a></li>
					</ul>
					<!-- /.breadcrumb -->
				</div>
				<div class="page-content">
				<div class="search">
			
						<input type="text" placeholder="Tìm kiếm"  id="keyword" name="keyWord" > <input type="submit"  class="btn btn-primary" id="search"    value="Tìm Kiếm">
				</div>
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
												href='<c:url value="/admin/add-news"/>'> <span>
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
													<th>Avatar</th>
													<th>title</th>
													<th>Short Descriptsion</th>
													<th>CategoryId</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${news}" var="news">
													<tr>
														<td><input type="checkbox" id="checkbox_${news.id}"
															value="${news.id}" name="ids"></td>
														<td>${news.id }</td>
														<td><img width="100px" src="${base }${news.image}"></td>
										        		<td>${news.title }</td>
										        		<td class="">${news.shortDescription }</td>
										        		<td class="text-center">${news.categoryId }</td>
														<td>
															 <a class="btn btn-sm btn-primary btn-edit"
															data-toggle="tooltip" title="Cập nhật bài viết"
															href="${base}/admin/edit-news/${news.seo}"><i class="fa fa-pencil-square-o"
																aria-hidden="true"></i> </a>
																<button class="btn btn-sm btn-danger btn-edit"
															data-toggle="tooltip" title="Xóa  bài viết"
															onclick="deleteNew(${news.id })" ><i class="fa fa-trash-o bigger-110 "></i> </button></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
										<div class="text-center">
										<ul class="pagination" id="pagination"></ul>
										</div>
										<input type="hidden" value="${page }" id="page" name="page" /> <input
											type="hidden" value="2" id="maxPageItem" name="maxPageItem" />
										
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
    <script>
			var totalPages = ${totalsPage};
			var currentPage = ${page};
			var maxPageItem =2;
			$(function () {
				window.pagObj = $('#pagination').twbsPagination({
					totalPages: totalPages,
					visiblePages: 10,
					startPage: currentPage,
					onPageClick: function (event, page) {
						if (currentPage != page) {
							$('#maxPageItem').val(maxPageItem);
							$('#page').val(page);
							$('#keyword').val("${keyWord}");
							$('#formSubmit').submit();
						}
					}
				});
			});
			
			  $('#checkAll').click( function () {
				    $('input[type="checkbox"]').prop('checked', this.checked)
				  })
			$("#btnDelete").click(function() {
				var data = {};
				var ids = $('tbody input[type=checkbox]:checked').map(function () {
		            return $(this).val();
		        }).get();
				data['ids'] = ids;
				deleteNew(data);
			});
			
			function deleteNew(data) {
				var dataBtn={};
				if(Array.isArray(data)){
					
				}else{
					 dataBtn={
							id : data
					}
				}	
		        $.ajax({
		            url: '/admin/delete-news',
		            type: 'DELETE',
		            contentType: 'application/json',
		            data: JSON.stringify(Array.isArray(data) ? data : dataBtn),
		            success: function (jsonResult) {
		            	alert("Chúc mừng!!! Đã lưu thành công news có ID là: "+jsonResult.message);
		            	window.location.href = "/admin/list-news?keyWord=&page=1&maxPageItem=2";
		            },
		            error: function (jqXhr, textStatus, errorMessage) {
		            
		            	console.log(errorMessage);
		            }
		        });
		    }
		</script>
     </div>
        <!-- javascript -->
        <jsp:include page="/WEB-INF/view/manager/layout/js.jsp"></jsp:include>
       
    </body>
</html>

