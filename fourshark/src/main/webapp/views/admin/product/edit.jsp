<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-admin-product"/>
<c:url var ="ProductURL" value="/admin-product	"/>
<html>
<head>
    <title>Chỉnh sửa sản phẩm</title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
            </script>
            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Trang chủ</a>
                </li>
                <li class="active">Chỉnh sửa sản phẩm</li>
            </ul><!-- /.breadcrumb -->
        </div>
        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                        <c:if test="${not empty messageResponse}">
									<div class="alert alert-${alert}">
  										${messageResponse}
									</div>
						</c:if>
                        <form id="formSubmit" enctype="multipart/form-data">
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Category</label>
                                <div class="col-sm-9">
                                    <select class="form-control" id="categoryCode" name="categoryCode">
                                        <c:if test="${empty model.categoryCode}">
                                            <option value="">--Select Category--</option>
                                            <c:forEach var="item" items="${categories}">
                                                <option value="${item.code}">${item.name}</option>
                                            </c:forEach>
                                        </c:if>
                                        <c:if test="${not empty model.categoryCode}">
                                            <option value="">--Select Category--</option>
                                            <c:forEach var="item" items="${categories}">
                                                <option value="${item.code}" <c:if test="${item.code == model.categoryCode}">selected="selected"</c:if>>
                                                        ${item.name}
                                                </option>
                                            </c:forEach>
                                        </c:if>
                                    </select>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <%-- <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Brand</label>	
                                <div class="col-sm-9">
                                    <select class="form-control" id="brandId" name="brandId">
                                        <c:if test="${empty model.brandId}">
                                            <option value="">--Select Brand--</option>
                                            <c:forEach var="item" items="${brands}">
                                                <option value="${item.id}">${item.name}</option>
                                            </c:forEach>
                                        </c:if>
                                        <c:if test="${not empty model.brandId}">
                                            <option value="">--Select Brand--</option>
                                            <c:forEach var="item" items="${brands}">
                                                <option value="${item.id}" <c:if test="${item.id == model.brandId}">selected="selected"</c:if>>
                                                        ${item.name}
                                                </option>
                                            </c:forEach>
                                        </c:if>
                                    </select>
                                </div>
                            </div>
                            <br/>
                            <br/> --%>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Product</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="name" name="name" value="${model.name}"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Quantity</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="quantity" name="quantity" value="${model.quantity}"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <%-- <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Hình ảnh</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="image" name="image" value="${model.image}"/>
                                    <input type="file" class="form-control" id="image" name="image"  value="Select image..." />
                                </div>
                            </div>
                            <br/> --%>
                            
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Content</label>
                                <div class="col-sm-9">                                 
                                    <textarea rows="" cols="" id="content" name="content" style="width: 820px;height: 175px">${model.content}</textarea>
                                </div>
                            </div>
                            <br/>
                            
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Price</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="price" name="price" value="${model.price}"/>
                                </div>
                            </div>
                            <br/>
                            
                            <br/>
                            <div class="form-group">
                                <div class="col-sm-12">
                                    <c:if test="${not empty model.id}">
                                        <input type="button" class="btn btn-white btn-warning btn-bold" value="Update Product" id="btnAddOrUpdateNew"/>
                                    </c:if>
                                    <c:if test="${empty model.id}">
                                        <input type="button" class="btn btn-white btn-warning btn-bold" value="Create Product" id="btnAddOrUpdateNew"/>
                                    </c:if>
                                </div>
                            </div>
                            <input type="hidden" value="${model.id}" id="id" name="id"/>
                        </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
	var editor = '';
	$(document).ready(function(){
		editor = CKEDITOR.replace('content');
	});
	
    $('#btnAddOrUpdateNew').click(function (e) {
        e.preventDefault();
        var data = {};
        var formData = $('#formSubmit').serializeArray();
        $.each(formData, function (i, v) {
            data[""+v.name+""] = v.value;
        });
        data["content"] = editor.getData();
        var id = $('#id').val();
        if (id == "") {
            addProduct(data);
        } else {
            updateProduct(data);
        }
    });
    function addProduct(data) {
        $.ajax({
            url: '${APIurl}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
            	window.location.href = "${ProductURL}?type=edit&id="+result.id+"&message=insert_success";
            },
            error: function (error) {
            	window.location.href = "${ProductURL}?type=list&maxPageItem=2&page=1&message=error_system";
            }
        });
    }
    function updateProduct(data) {
        $.ajax({
            url: '${APIurl}',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
            	window.location.href = "${ProductURL}?type=edit&id="+result.id+"&message=update_success";
            },
            error: function (error) {
            	window.location.href = "${ProductURL}?type=list&maxPageItem=2&page=1&message=error_system";
            }
        });
    }
</script>
</body>
</html>