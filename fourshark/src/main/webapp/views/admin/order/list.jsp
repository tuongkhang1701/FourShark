<%@include file="/common/taglib.jsp"%>
<c:url var="APIOrderurl" value="/api-admin-order" />
<c:url var="DetailURL" value="/admin-detail" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>List Order</title>
</head>

<body>
	<div class="main-content">
		<form action="<c:url value='/admin-order'/>" id="formSubmit" method="get">
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
							
							<div class="row">
								<div class="col-xs-12">
									<div class="table-responsive">
										<table class="table table-bordered">
											<thead>
												<tr>
													<th class="text-center">Email</th>
													<th class="text-center">Payment Method</th>
													<th class="text-center">Delivery Address</th>
													<th class="text-center">Created Date</th>
													<th class="text-center">Option</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="item" items="${ordermodel.listResult}">
													<tr>
														<td class="text-center">
														<c:forEach var="user" items="${userList}">
															<c:if test="${user.getId() == item.getUser().getId()}">
																${user.getEmail()}
															</c:if>
														</c:forEach>
														</td>
														<td class="text-center">
															<c:forEach var="payment" items="${paymentList}">
																<c:if test="${payment.getId() == item.getPaymentMethod().getId()}">
																	${payment.getName()}
																</c:if>
															</c:forEach>
														</td>
														<td class="text-center">${item.deliveryAddress}</td>
														<td class="text-center">${item.createdDate}</td>
														<td class="text-center">
															<c:url var="editURL" value="/admin-product">
																<c:param name="type" value="edit" />
																<c:param name="id" value="${item.id}" />
															</c:url>
															<a id="btnAddOrUpdateOrder" class="formSubmit btn btn-sm btn-primary btn-edit"
																data-toggle="tooltip" title="Cập nhật bài viết" href="${DetailURL}?type=edit&id=${item.id}">
																View Detail Order >>>
																
															</a>
														</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
										<ul class="pagination" id=pagination></ul>
										<input type="hidden" value="" id="page" name="page" />
										<input type="hidden" value="" id="maxPageItem" name="maxPageItem" />
										<input type="hidden" value="" id="sortCreatedDate" name="sortCreatedDate" />
										<input type="hidden" value="" id="sortBy" name="sortBy" />
										<input type="hidden" value="" id="type" name="type" />
										<input type="hidden" id="id" name="id" value="${item.getId()}">
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
		var totalPages = ${model.totalPage};
		var currentPage = ${model.page};
		var limit = 4;
		$(function () {
			window.pagObj = $('#pagination').twbsPagination({
				totalPages: totalPages,
				visiblePages: 10,
				startPage: currentPage,
				onPageClick: function (event, page) {
					if (currentPage != page) {
						$('#maxPageItem').val(limit);
						$('#page').val(page);
						$('#sortName').val('CreatedDate');
						$('#sortBy').val('desc');
						$('#type').val('list');
						$('#formSubmit').submit();
					}
				}
			});
		});
		
	    $('#btnAddOrUpdateOrder').click(function (e) {
	        e.preventDefault();
	        var data = {};
	        var formData = $('#formSubmit').serializeArray();
	        $.each(formData, function (i, v) {
	            data[""+v.name+""] = v.value;
	        });
	        var id = $('#id').val();
	        viewDetail(data);
	    });
	    function viewDetail(data) {
	        $.ajax({
	            url: '${APIurl}',
	            type: 'POST',
	            contentType: 'application/json',
	            data: JSON.stringify(data),
	            dataType: 'json',
	            success: function (result) {
	            	window.location.href = "${DetailURL}?type=edit&id="+result.id+"&message=insert_success";
	            },
	            error: function (error) {
	            	window.location.href = "${DetailURL}?type=list&maxPageItem=2&page=1&message=error_system";
	            }
	        });
	    }
	</script>
</body>

</html>