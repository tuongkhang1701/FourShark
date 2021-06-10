
<%@page import="java.text.NumberFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html lang="en">

<head>
	<title>Trang chủ</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta charset="UTF-8" />
	<meta name="keywords" content="Electro Store Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design"
	/>

</head>

<body>

	<%
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumIntegerDigits(0);
	%>
        <div id="slides" class="carousel slides" data-ride="carousel">
            <ul class="carousel-indicators">
                <li data-target="#slides" data-slide-to="0"></li>
                <li data-target="#slides" data-slide-to="1"></li>
                <li data-target="#slides" data-slide-to="2"></li>
                <li data-target="#slides" data-slide-to="3"></li>
            </ul>

            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="./images/carousel01.png" >
                </div>

                <div class="carousel-item">
                    <img src="./images/carousel02.png" >
                </div>

                <div class="carousel-item">
                    <img src="./images/carousel03.png" >
                </div>

                <div class="carousel-item ">
                    <img src="./images/carousel04.png" >
                </div>
            </div>

        </div>

        <div class="container-fluid">
            <div class="row padding">
            <c:forEach var="item" items="${parentCategories}">
            	<div class="btn-group">
                	<a class="btn btn-outline-dark" type="button" href="<c:url value='/home?action=category&id=${item.getId()}' />">
                    ${item.name}
                    </a>
                </div>
            </c:forEach>
        </div>
        
        <div class="btn btn-group-toggle">
		<div class="container-fluid">
			<div class="col">
				<div class="col-12">
					<div class="row">
						<c:if test="${listAfterSearch == null}">
							<c:forEach var="product" items="${products}">
							<button type="button"
								class="btn btn-outline-secondary btn-lg col-3">
								<a href="/home?action=detailProduct&id=${product.getId()}"><img src="${product.image}"></a>
								<blockquote class="blockquote text-center">
									<h6>${product.name }</h6>
								</blockquote>
								<div class="card-footer">
									<div class="product-device pull-right">
										<span class="pricing-header pull-left" style="color:red;" ><fmt:formatNumber value="${product.price}" minIntegerDigits="0"/> VND</span>
									</div>
									<br>
									<div class="option">
										<a href="${request.getContextPath()}/cartController?action=add&id=${product.getId()}" class="btn btn-default add-to-cart text-center">
										<i style='font-size: 24px' class='fas'>&#xf218;</i>
										</a>
									</div>

								</div>
							</button>
							</c:forEach>
						</c:if>
						
						<c:if test="${listAfterSearch != null}">
							<c:forEach var="product" items="${listAfterSearch}">
							<button type="button"
								class="btn btn-outline-secondary btn-lg col-3">
								<a href="/home?action=detailProduct&id=${product.getId()}"><img src="${product.image}"></a>
								<blockquote class="blockquote text-center">
									<h6>${product.name }</h6>
								</blockquote>
								<div class="card-footer">
									<div class="product-device pull-right">
										<span class="pricing-header pull-left" style="color:red;" ><fmt:formatNumber value="${product.price}" minIntegerDigits="0"/> VND</span>
									</div>
									<br>
									<div class="option">
										<a href="${request.getContextPath()}/cartController?action=add&id=${product.getId()}" class="btn btn-default add-to-cart text-center">
										<i style='font-size: 24px' class='fas'>&#xf218;</i>
										</a>
									</div>

								</div>
							</button>
							</c:forEach>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</div>
        </div>

        <div class="footer-top-first">
			<div class="container py-md-5 py-sm-4 py-3">
				<div class="row w3l-grids-footer border-top border-bottom py-sm-4 py-3">
					<div class="col-md-4 offer-footer">
						<div class="row">
							<div class="col-2 icon-fot">
								<i class="fas fa-dolly" style="font-size:48px;color:blue"></i>
							</div>
							<div class="col-8 text-form-footer">
								<h3 class="text-dark">Miễn Phí Vận Chuyển</h3>
							</div>
						</div>
					</div>
					<div class="col-md-4 offer-footer my-md-0 my-4">
						<div class="row">
							<div class="col-2 icon-fot">
								<i class="fas fa-shipping-fast" style="font-size:48px;color:blue"></i>
							</div>
							<div class="col-8 text-form-footer">
								<h3 class="text-dark">Giao Hàng Siêu Tốc</h3>
							</div>
						</div>
					</div>
					<div class="col-md-4 offer-footer">
						<div class="row">
							<div class="col-2 icon-fot">
								<i class="far fa-thumbs-up" style="font-size:48px;color:blue"></i>
							</div>
							<div class="col-8 text-form-footer">
								<h3 class="text-dark">Lựa Chọn Hàng Đầu</h3>
							</div>
						</div>
					</div>
				</div>
				<!-- //footer second section -->
			</div>
        </div>
        
    </body>

</html>