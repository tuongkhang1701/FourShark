<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><dec:title default="Đăng nhập" /></title>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
    </script>
    <link rel="stylesheet" 
      href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"> 
    <script 
      src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js">    
    </script>            
    <!-- My CSS and JQuery -->
    <link href="<c:url value='/template/css/login.css' />" rel="stylesheet">
    <script type="text/javascript" src="<c:url value='/template/jquery/index.js' />"></script> 
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">       
    <link href="https://use.fontawesome.com/releases/v5.0.4/css/all.css" rel="stylesheet">    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
    </script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js">
    </script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <script src='https://kit.fontawesome.com/a076d05399.js'></script>
   <link rel="stylesheet" href="<c:url value='/template/css/home.css' />">
   <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<header>
  <nav class="navbar navbar-expand-sm navbar-light bg-light sticky-top">
      <div class="container-fluid">
          <!--Logo-->
          <a class="navbar-brand col-1" href="/home">
              <img src="./images/logo.png" height="80px"> 
          </a> 
          <!--Header Right-->
          <div class="collapse navbar-collapse" id="navbarResponsive">
              <ul class="navbar-nav ml-auto">
                  <li class="nav-item">
                      <a class="nav-link active" href="/home" >Home</a>
                  </li>


                  <li class="nav-item">
                      <a class="nav-link" href="/about?action=about">About</a>
                  </li>

                  <li class="nav-item">
                      <a class="nav-link" href="/about?action=contact">Liên hệ</a>
                  </li>

                  <li class="nav-item">
                  	<c:if test="${status == 'login'}">                  	
                      <a class="nav-link" href="/register?action=register">Đăng ký</a>
                  	</c:if>
                  	<c:if test="${status == 'register'}">                  	
                      <a class="nav-link" href="/login?action=login">Đăng nhập</a>
                  	</c:if>
                  </li>

              </ul>
          </div>
      </div>
  </nav>
</header>

<dec:body />

<footer>
  <div class="container-fluid padding">
      <div class="row text-center">
          <div class="col-md-4">
              <hr class="light">
              <h1>Thông tin công ty</h1>
              <hr class="light">
              <p>Điện thoại: 028-8888-9999</p>
              <p>Email: 4shark@gmail.com</p>
              <p>Địa chỉ: 185-187, Hoàng Văn Thụ, Phường 8, Quận Phú Nhuận, TP.Hồ Chí Minh</p>
          </div>

          <div class="col-md-4">
              <hr class="light">
              <h1>Giờ Làm Việc</h1>
              <hr class="light">
              <p>Thứ 2 -> Thứ 7: 8am - 10pm</p>
              <p>Chủ Nhật: 8am - 5pm</p>
          </div>

          <div class="col-md-4">
              <hr class="light">
              <h1>Tuyển Dụng</h1>
              <hr class="light">
              <p>Liên Hệ: 097 450 28 29(Anh Cao Trí)</p>
              <p>Hỗ Trợ vay vốn <i style="font-size:24px" class="fa">&#xf1b5;</i></p>
          </div>

      </div>
  </div>
  <hr class="container-fluid light">
  <div class="container-fluid padding">
      <p class="text-md-center light"><i style='font-size:24px' class='fab'>&#xf209;</i>2020 Gia Định. All Right Reserved. Design bt FourShark Gia Định</p>
  </div>
</footer>
</html>