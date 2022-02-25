<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Trang chủ</title>
<link rel="stylesheet"
	href="${base }/template/admin/assets/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="${base }/template/admin/font-awesome/4.5.0/css/font-awesome.min.css" />
<link rel="stylesheet"
	href="${base }/template/admin/assets/css/ace.min.css"
	class="ace-main-stylesheet" id="main-ace-style" />
<script
	src="${base }/template/admin/assets/js/ace-extra.min.js"></script>
<link rel="stylesheet"
	href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type='text/javascript'
	src="${base }/template/admin/js/jquery-2.2.3.min.js"></script>
<script
	src="${base }/template/admin/assets/js/jquery.2.1.1.min.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="${base }/template/paging/jquery.twbsPagination.js" ></script>
</head>
<body>
 <jsp:include page="/WEB-INF/view/common/manager/header.jsp"></jsp:include>
<div class="main-container" id="main-container">
		<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
		</script>
		<!-- header -->
		 <jsp:include page="/WEB-INF/view/common/manager/menu.jsp"></jsp:include>
		<!-- header -->
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
				<div class="row">
					<div class="col-xs-12"></div>
				</div>
			</div>
		</div>
	</div>
	<!-- /.main-content -->
	 <jsp:include page="/WEB-INF/view/common/manager/footer.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/view/manager/layout/js.jsp"></jsp:include>
</body>
</html>