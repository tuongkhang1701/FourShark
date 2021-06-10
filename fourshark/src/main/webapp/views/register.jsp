<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-admin-user"/>
<c:url var ="UserURL" value="/admin-user	"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng Ký</title>
</head>
<body>
    <div class="container-fluid bg" style="background-image: url('./images/logo-login.png')">
        <div class="row justify-content-center">
            <div class="col-md-3 col-sm-6 col-xs-12 row-container mt-1">
                <form action="" method="post">
                    <h3 class="text-center">Đăng Ký</h3>
                        <div class="form-group">
                          <input required="true" type="text" class="form-control" id="fullName" name="fullName" placeholder="Họ và tên">
                        </div>
                        <div class="form-group">
                          <input required="true" type="email" class="form-control" id="email" name="email" placeholder="Email">
                        </div>
                        <div class="form-group">
                          <input required="true" type="password" class="form-control" id="password" placeholder="Mật khẩu" name="password">
                        </div>
                        <div class="form-group">
                          <input required="true" type="password" class="form-control" name="confirmation_pwd" id="confirmation_pwd" placeholder="Xác nhận mật khẩu">
                        </div>
                        <div class="form-group">
                          <input type="number" class="form-control" id="phoneNumber" name="phoneNumber" placeholder="Số điện thoại">
                        </div>
                        <div class="form-group">
							<select class="form-control js-example-tags" id="gender" name="gender">
							  <option selected="selected" value="Male">Nam</option>
							  <option value="Female">Nữ</option>
							</select>
                        </div>
                        <button type="submit" class="btn btn-success btn-block my-3">Đăng ký</button>
                </form>
            </div>
        </div>
		</div>
	</div>
</body>
</html>

<script>  

$(".js-example-tags").select2({
	  tags: true
	});

function verifyPassword() {  
  var pw = document.getElementById("password").value;    
   
 //minimum password length validation  
  if(pw.length < 8) {  
     document.getElementById("message").innerHTML = "Mật khẩu dài tối thiểu 8 kí tự";  
     return false;  
  }  
  
//maximum length of password validation  
  if(pw.length > 15) {  
     document.getElementById("message").innerHTML = "Mật khẩu dài tối đa 15 kí tự";  
     return false;  
  } else {  
     alert("Mật khẩu chính xác");  
  }  
}

function matchPassword() {  
	  var pw1 = document.getElementById("password");  
	  var pw2 = document.getElementById("confirm-password");  
	  if(pw1 != pw2)  
	  {   
	    alert("Mật khẩu không trùng khớp");  
	  } else {  
	    alert("Thành công");  
	  }  
	}
//check username
$(document).ready(function(){

	   $("#userName").keyup(function(){

	      var username = $(this).val().trim();

	      if(username != ''){

	         $.ajax({
	            url: '/register',
	            type: 'post',
	            data: {userName: userName},
	            success: function(response){

	                $('#uname_response').html(response);

	             }
	         });
	      }else{
	         $("#uname_response").html("");
	      }

	    });

	 });
</script>  


				

