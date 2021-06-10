<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-admin-user" />
<c:url var="UserURL" value="/admin-user" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Quản lí tài khoản</title>
</head>

<body>
	<div class="main-content">
		<form action="<c:url value='/admin-user'/>" id="formSubmit" method="get">
			<div class="main-content-inner">
				<div class="breadcrumbs ace-save-state" id="breadcrumbs">
					<ul class="breadcrumb">
						<li>
							<i class="ace-icon fa fa-home home-icon"></i>
							<a href="#">Trang chủ</a>
						</li>
					</ul>
					<!-- /.breadcrumb -->
				</div>
				<div class="page-content">
					<div class="row">
						<div class="col-xs-12">
							<c:if test="${not empty messageResponse}">
								<div class="alert alert-${alert}">
									${messageResponse}
								</div>
							</c:if>
							<div class="widget-box table-filter">
								<div class="table-btn-controls">
									<div class="pull-right tableTools-container">
										<div class="dt-buttons btn-overlap btn-group">
											<a flag="info"
												class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
												data-toggle="tooltip" title='Thêm tài khoản'
												href='<c:url value="/admin-user?type=edit"/>'>
												<span>
													<i class="fa fa-plus-circle bigger-110 purple"></i>
												</span>
											</a>
											<button id="btnDelete" type="button"
												class="dt-button buttons-html5 btn btn-white btn-primary btn-bold"
												data-toggle="tooltip" title='Xóa tài khoản'>
												<span>
													<i class="fa fa-trash-o bigger-110 pink"></i>
												</span>
											</button>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12">
									<div class="table-responsive">
										<table class="table table-bordered">
											<thead>
												<tr>
													<th class="text-center">#</th>
													<th class="text-center">Email</th>
													<th class="text-center">Phone Number</th>
													<th class="text-center">Fullname</th>
													<th class="text-center">Gender</th>
													<th class="text-center">Created Date</th>
													<th class="text-center">Modified Date</th>
													<th class="text-center">Option</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="item" items="${usermodel.listResult}">
													<tr>
														<td class="text-center"><input type="checkbox" id="checkbox_${item.id}" value="${item.id}"></td>
														<td class="text-center">${item.email}</td>
														<td class="text-center">${item.phoneNumber}</td>
														<td class="text-center">${item.fullName}</td>
														<td class="text-center">${item.gender}</td>
														<td class="text-center">${item.createdDate}</td>
														<td class="text-center">${item.modifiedDate}</td>
														<td class="text-center">
															<c:url var="editURL" value="/admin-user">
																<c:param name="type" value="edit" />
																<c:param name="id" value="${item.id}" />
															</c:url>
															<a class="btn btn-sm btn-primary btn-edit"
																data-toggle="tooltip" title="Cập nhật tài khoản"
																href='${editURL}'><i class="fa fa-pencil-square-o"
																	aria-hidden="true"></i>
															</a>
														</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
										<ul class="pagination" id="pagination"></ul>
										<input type="hidden" value="" id="page" name="page" />
										<input type="hidden" value="" id="maxPageItem" name="maxPageItem" />
										<input type="hidden" value="" id="sortName" name="sortName" />
										<input type="hidden" value="" id="sortBy" name="sortBy" />
										<input type="hidden" value="" id="type" name="type" />
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
	<!-- /.main-content -->
	<script>
		var totalPages = ${usermodel.totalPage};
		var currentPage = ${usermodel.page};
		var limit = 2;
		$(function () {
			window.pagObj = $('#pagination').twbsPagination({
				totalPages: totalPages,
				visiblePages: 10,
				startPage: currentPage,
				onPageClick: function (event, page) {
					if (currentPage != page) {
						$('#maxPageItem').val(limit);
						$('#page').val(page);
						$('#sortName').val('Username');
						$('#sortBy').val('desc');
						$('#type').val('list');
						$('#formSubmit').submit();
					}
				}
			});
		});

		$("#btnDelete").click(function () {
			var data = {};
			var ids = $('tbody input[type=checkbox]:checked').map(function () {
				return $(this).val();
			}).get();
			data['ids'] = ids;
			deleteUser(data);
		});

		function deleteUser(data) {
			$.ajax({
				url: '${APIurl}',
				type: 'DELETE',
				contentType: 'application/json',
				data: JSON.stringify(data),
				success: function (result) {
					window.location.href = "${UserURL}?type=list&maxPageItem=4&page=1&message=delete_success";
				},
				error: function (error) {
					window.location.href = "${UserURL}?type=list&maxPageItem=4&page=1&message=error_system";
				}
			});
		}
	</script>
</body>

</html>