<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>about</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">       
    <link href="https://use.fontawesome.com/releases/v5.0.4/css/all.css" rel="stylesheet">    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
    </script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js">
    </script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <script src='https://kit.fontawesome.com/a076d05399.js'></script>
   <link rel="stylesheet" href="./template/css/home.css">
   <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<header>
    <nav class="navbar navbar-expand-sm navbar-light bg-light sticky-top">
        <div class="container-fluid">
            <!--Logo-->
            <a class="navbar-brand col-2" href="/home">
                <img src="./images/logo.png" height="80px"> 
            </a> 
            
            <!--Header Right-->
            
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link active" href="/home" >Trang Chủ</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="/about?action=introduce">Giới Thiệu</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="/about?action=leader">Ban Lãnh Đạo</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/about?action=contact">Liên Hệ</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>

<dec:body/>

</html>