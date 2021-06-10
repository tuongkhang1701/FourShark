
      
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>	
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng nhập</title>
</head>

<body>
    <div class="container-fluid bg" style="background-image: url('./images/logo-login.png')">
        <div class="row justify-content-center">
          <div class="col-md-3 col-sm-6 col-xs-12 row-container mt-1">
         	 <c:if test="${not empty message}">
				<div class="alert alert-${alert}">
					${message}
				</div>
			</c:if>
            <form method="POST" action="">
              <h3 class="text-center">Đăng Nhập</h3>
              <div class="form-group">
                <input type="email" class="form-control" id="email" name="email" placeholder="Địa chỉ Email">
                <p class="emailError"></p>
              </div>
              <div class="form-group">
                <input type="password" class="form-control" id="password" name="password" placeholder="Mật khẩu">            
                <p class="passwordError"></p>
              </div>
              <button type="submit" class="btn btn-success btn-block my-3">Đăng nhập</button>
            </form>
          </div>
        </div>
      </div>
</body>
</html>