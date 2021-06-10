<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!-- header-bottom-->
<header>
    <nav class="navbar navbar-expand-sm navbar-light bg-light sticky-top">
        <div class="container-fluid">
            <div class="col-1">
                <a class="navbar-brand" href="/home">
                    <img src="./images/logo.png" height="120px">
                </a>
            </div>
            <div class="col-11">
                <div class="col">
                    <div class="collapse navbar-collapse row-1" id="navbarResponsive">
                        <div class="container-fluid">
                            <div class="row row-padding">
                                <div class="col-12">
                                    <ul class="navbar-nav">
                                        <div class="col-2">
                                            <li class="nav-item ">
                                                <a class="nav-link active" href="/home">Trang Chủ</a>
                                            </li>
                                        </div>

                                        <div class="col-2">
                                            <li class="nav-item">
                                                <a class="nav-link" href="/about?action=about">Về Chúng Tôi</a>
                                            </li>
                                        </div>

                                        <div class="col-2">
                                            <li class="nav-item">
                                                <a class="nav-link" href="/about?action=introduce">Giới Thiệu</a>
                                            </li>
                                        </div>

                                        <div class="col-2">
                                            <li class="nav-item">
                                                <a class="nav-link" href="/about?action=leader">Ban Lãnh Đạo</a>
                                            </li>
                                        </div>

                                        <div class="col-2">
                                            <li class="nav-item">
                                                <a class="nav-link" href="/about?action=contact">Liên Hệ</a>
                                            </li>
                                        </div>
										 <c:if test="${empty USERMODEL}">
                                        <div class="col-2">
                                           
                                                <li class="nav-item">
                                                    <a class="nav-link"
                                                        href='<c:url value="/login?action=login"/>'>Đăng nhập</a>
                                                </li>
                                        </div>
                                            </c:if>
                                        <c:if test="${not empty USERMODEL}">
                                        <div class="col-2">
                                                <li class="nav-item">
                                                    <a class="nav-link"
                                                        href='<c:url value="/logout?action=logout"/>'>Thoát</a>
                                                </li>
                                        	</div>
                                        </c:if>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="collapse navbar-collapse row-1">
                        <div class="container-fluid">
                            <div class="row row-padding">
                                <div class="col-11">
                                    <!--Search-->
                                    <form class="form-inline col-12" action="<c:url value='/home?action=search' />" method="get">
                                        <input class="form-group col-10" name="action" id="action" type="hidden" value="search">
                                        <input class="form-group col-10" name="keyword" id="keyword" type="text" placeholder="Search">
                                        <button class="form-group btn btn-success col-2" type="submit">Search</button>
                                    </form>
                                </div>
                                <div class="col-1">
                                    <!--Button Cart-->
                                    <a type="button" class="btn btn-info " href="<c:url value='/cart?action=cart' />">
                                        <i class='fas fa-cart-arrow-down' style='font-size:30px;color:black'></i>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </nav>
</header>