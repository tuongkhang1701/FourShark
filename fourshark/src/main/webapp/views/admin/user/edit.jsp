<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIUserurl" value="/api-admin-user"/>
<c:url var ="UserURL" value="/admin-user	"/>
<html>
<head>
    <title>Sửa đổi tài khoản</title>
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
                    <a href="#">Home</a>
                </li>
                <li class="active">Management Account</li>
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
                                <label class="col-sm-3 control-label no-padding-right">Email</label>
                                <div class="col-sm-9">
                                	<c:if test="${not empty usermodel.id}">
                                        <input type="text" class="form-control" id="email" name="email" value="${usermodel.email}" readonly/>
                                    </c:if>
                                    <c:if test="${empty usermodel.id}">
                                        <input type="text" class="form-control" id="email" name="email" value="${usermodel.email}"/>
                                    </c:if>
                                    
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Password</label>
                                <div class="col-sm-9">
                                    
                                    <c:if test="${not empty usermodel.id}">
                                        <input type="password" class="form-control" id="password" name="password" value="${usermodel.password}" />
                                    </c:if>
                                    <c:if test="${empty usermodel.id}">
                                        <input type="password" class="form-control" id="password" name="password" value="${usermodel.password}"/>
                                    </c:if>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Fullname</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="fullName" name="fullName" value="${usermodel.fullName}"/>
                                </div>
                            </div>
                            <br/>
                            
                            <br/>
                            
                            
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Phone Number</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" value="${usermodel.phoneNumber}"/>
                                </div>
                            </div>
                            <br/>
                            
                            <br/>
                            
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Gender</label>
                                <div class="col-sm-9">
                                    <select class="form-control" id="gender" name="gender">
                                        
                                            <option value="Male">Male</option>
                                            <option value="Female">Female</option>
                                    </select>
                                </div>
                            </div>
                            <br/>
                            
                            <br/>
                            <div class="form-group">
                                <div class="col-sm-12">
                                    <c:if test="${not empty usermodel.id}">
                                        <input type="button" class="btn btn-white btn-warning btn-bold" value="Update Account" id="btnAddOrUpdateUser"/>
                                    </c:if>
                                    <c:if test="${empty usermodel.id}">
                                        <input type="button" class="btn btn-white btn-warning btn-bold" value="Create Account" id="btnAddOrUpdateUser"/>
                                    </c:if>
                                </div>
                            </div>
                            <input type="hidden" value="${usermodel.id}" id="id" name="id"/>
                        </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
	
    $('#btnAddOrUpdateUser').click(function (e) {
        e.preventDefault();
        var data = {};
        var formData = $('#formSubmit').serializeArray();
        $.each(formData, function (i, v) {
            data[""+v.name+""] = v.value;
        });
        var id = $('#id').val();
        if (id == "") {
        	addUser(data);
        } else {
        	updateUser(data);
        }
    });
    function addUser(data) {
        $.ajax({
            url: '${APIUserurl}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
            	window.location.href = "${UserURL}?type=edit&id="+result.id+"&message=insert_success";
            },
            error: function (error) {
            	window.location.href = "${UserURL}?type=list&maxPageItem=2&page=1&message=error_system";
            }
        });
    }
    function updateUser(data) {
        $.ajax({
            url: '${APIUserurl}',
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
            	window.location.href = "${UserURL}?type=edit&id="+result.id+"&message=update_success";
            },
            error: function (error) {
            	window.location.href = "${UserURL}?type=list&maxPageItem=2&page=1&message=error_system";
            }
        });
    }
</script>
</body>
</html>