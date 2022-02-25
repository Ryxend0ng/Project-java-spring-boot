<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="sidebar"
	class="sidebar                  responsive                    ace-save-state">
	<script type="text/javascript">
        try{ace.settings.loadState('sidebar')}catch(e){}
    </script>
	<div class="sidebar-shortcuts">
		<div class="sidebar-shortcuts-large">
			<button class="btn btn-success">
				<i class="ace-icon fa fa-signal"></i>
			</button>

			<button class="btn btn-info">
				<i class="ace-icon fa fa-pencil"></i>
			</button>

			<button class="btn btn-warning">
				<i class="ace-icon fa fa-users"></i>
			</button>

			<button class="btn btn-danger">
				<i class="ace-icon fa fa-cogs"></i>
			</button>
		</div>
		<div class="sidebar-shortcuts-mini">
			<span class="btn btn-success"></span> <span class="btn btn-info"></span>

			<span class="btn btn-warning"></span> <span class="btn btn-danger"></span>
		</div>
	</div>
	<!-- quan ly the loai -->
	<ul class="nav nav-list" >
		<li><a href="#" class="dropdown-toggle" style="font-size: 15px;">  <i
				class="menu-icon fa ">I</i> <span class="menu-text"></span>
				Quản lý Category <b class="arrow fa fa-angle-down"></b>
		</a> <b class="arrow"></b>
			<ul class="submenu">
				<li><a
					href='<c:url value="${base }/admin/list-categories?keyWord=&page=1&maxPageItem=2"/>'>
						<i class="menu-icon fa fa-caret-right"></i> Danh sách và cập nhật thể loại
				</a> <b class="arrow"></b></li>
				<li><a
					href="${base }/admin/add-categories">
						<i class="menu-icon fa fa-caret-right"></i> Thêm thể loại
				</a> <b class="arrow"></b></li>
			</ul></li>
	</ul>
	
	<!-- quan ly truyện -->
	<ul class="nav nav-list">
		<li><a href="#" class="dropdown-toggle" style="font-size: 15px;">  <i
				class="menu-icon fa ">II</i> <span class="menu-text"></span>
				Quản lý comics <b class="arrow fa fa-angle-down"></b>
		</a> <b class="arrow"></b>
			<ul class="submenu">
				<li><a
					href="${base }/admin/list-comics?keyWord=&page=1&maxPageItem=10">
						<i class="menu-icon fa fa-caret-right"></i> Danh sách và cập nhật truyện
				</a> <b class="arrow"></b></li>
				<li><a
					href="${base }/admin/add-comics">
						<i class="menu-icon fa fa-caret-right"></i> Thêm truyện
				</a> <b class="arrow"></b></li>
			</ul></li>
	</ul>
	<!-- quan ly tin tức -->
	<ul class="nav nav-list" >
		<li><a href="#" class="dropdown-toggle" style="font-size: 15px;"> <i
				class="menu-icon fa ">III</i><span class="menu-text"></span>
				Quản lý news <b class="arrow fa fa-angle-down"></b>
		</a> <b class="arrow"></b>
			<ul class="submenu">
				<li><a
					href="${base }/admin/list-news?keyWord=&page=1&maxPageItem=2">
						<i class="menu-icon fa fa-caret-right"></i> Danh sách và cập nhật tin tức
				</a> <b class="arrow"></b></li>
				<li><a
					href="${base }/admin/add-news">
						<i class="menu-icon fa fa-caret-right"></i> Thêm tin tức
				</a> <b class="arrow"></b></li>
			</ul></li>
	</ul>
	<!-- quan ly user -->
	<ul class="nav nav-list" >
		<li><a href="#" class="dropdown-toggle" style="font-size: 15px;"> <i
				class="menu-icon fa ">IV</i><span class="menu-text"></span>
				Quản lý user <b class="arrow fa fa-angle-down"></b>
		</a> <b class="arrow"></b>
			<ul class="submenu">
				<li><a
					href="${base }/admin/list-users?keyWord=&page=1&maxPageItem=1">
						<i class="menu-icon fa fa-caret-right"></i> Danh sách và cập nhật người dùng
				</a> <b class="arrow"></b></li>
				<li><a
					href="${base }/admin/add-users">
						<i class="menu-icon fa fa-caret-right"></i> Thêm người dùng
				</a> <b class="arrow"></b></li>
			</ul></li>
	</ul>
	<!-- quan ly role -->
	<ul class="nav nav-list" style="font-size: 15px;">
		<li><a href="#" class="dropdown-toggle" style="font-size: 15px;"> <i
				class="menu-icon fa ">V</i> <span class="menu-text"></span>
				Quản lý role <b class="arrow fa fa-angle-down"></b>
		</a> <b class="arrow"></b>
			<ul class="submenu">
				<li><a
					href="${base }/admin/list-roles?keyWord=&page=1&maxPageItem=1">
						<i class="menu-icon fa fa-caret-right"></i> Danh sách và cập nhật role
				</a> <b class="arrow"></b></li>
				<li><a
					href="${base }/admin/add-roles">
						<i class="menu-icon fa fa-caret-right"></i> Thêm role
				</a> <b class="arrow"></b></li>
			</ul></li>
	</ul>

</div>