
<%@page import="java.util.ArrayList"%>
<%@page import="com.fourshark.model.CartModel"%>
<%@page import="java.util.List"%>
<%@page import="com.fourshark.utils.SessionUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="checkoutUrl" value="/checkoutController" />
<div class="container mb-4">
        <div class="row">
            <div class="col-12">
                <div class="table-responsive">
                <h4 class="mb-sm-4 mb-3 text-center">CART</h4>
                    <table class="table table-striped">
						<thead>
							<tr>
								<th scope="col"class="text-center">Product</th>
								<th scope="col" class="text-center">Category</th>
								<th scope="col" class="text-center">Quantity</th>
								<th scope="col" class="text-center">Option</th>
								<th scope="col" class="text-center">Price</th>
								<th scope="col" class="text-center">Sub total</th>

							</tr>
						</thead>
						<tbody>
							<c:set var="total" value="0"></c:set>
							<c:forEach items="${sessionScope.cartlist}" var="c">
								<c:set var="totalInner" value="${total +  c.product.price * c.quantity}">
								</c:set>
								<input type="hidden" name="id" value="${c.product.id}">
								<tr>
									<td class="text-center"><img
										src="${pageContext.request.contextPath}${c.product.image}" width="100"/>
									</td>
									<td class="text-center">${c.product.name }</td>
									<td class="text-center">${c.quantity }</td>
									<td class="row" class="text-center"><a
										href="${request.getContextPath()}/cartController?action=add&id=${c.product.getId()}">
											<button class="btn btn-sm btn-primary"
												style='font-size: 20px'>
												<i class='fas fa-cart-arrow-down'></i>
											</button>

									</a> <a
										href="${request.getContextPath()}/cartController?action=remove&id=${c.product.getId()}">
											<button class="btn btn-sm btn-danger" style='font-size: 20px'>
												<i class="fa fa-trash"></i>
											</button>
									</a></td>

									<td class="text-center"><fmt:formatNumber value="${c.product.price}" minIntegerDigits="0"/> VNĐ</td>
									<td class="text-center"><fmt:formatNumber value="${c.product.price * c.quantity }" minIntegerDigits="0"/> VNĐ</td>


								</tr>

							</c:forEach>
							<tr>
								<td colspan="4" align="right">Tổng: </td>
								<td class="text-right"> <fmt:formatNumber value="${totalInner }" minIntegerDigits="0"/> VNĐ</td>
							</tr>
						</tbody>
					</table>
                </div>
            </div>
            
        </div>
        
    </div>
    
    <div class="privacy py-sm-5 py-4">
		<div class="container py-xl-4 py-lg-2">
			<!-- tittle heading -->
			<h3 class="tittle-w3l text-center mb-lg-5 mb-sm-4 mb-3">
				<span>Xác nhận thanh toán</span>
			</h3>
			
			<div class="checkout-left">
			
					<div class="address_form_agile mt-sm-5 mt-4">
					<c:if test="${not empty messageResponse}">
						<div class="alert alert-${alert}">
							${messageResponse}
						</div>
					</c:if>
					<h4 class="mb-sm-4 mb-3">Thông tin chi tiết</h4>
					<form action="/cartController" method="POST" id="formCheckout">
						<div class="form-group">
							<p>Họ và tên</p>
							<input class="billing-address-name form-control" type="text" name="fullName" placeholder="" required="">
						</div>
						<div class="form-group">
							<p>Số điện thoại</p>
							<input type="number" class="form-control" placeholder="" name="phoneNumber" required="">
						</div>
						<div class="form-group">
							<p>Địa chỉ giao hàng</p>
							<textarea id="deliveryAddress" class="form-control" placeholder="" name="deliveryAddress"  required=""></textarea>
						</div>
						<div class="form-group">
							<p>Phương thức thanh toán</p>
							<select class="form-control js-example-tags" id="paymentMethod" name="paymentMethod">
								<c:forEach var="item" items="${payments}">
									<option selected="selected" value="${item.id}">${item.name}</option>
								</c:forEach>
							</select>
			            </div>
			            <div class="form-group">
				            <div class="row">
			                    <div class="col-sm-12  col-md-6">
			                        <a class="btn btn-lg btn-block btn-light text-uppercase" href="/home">Tiếp tục mua sắm</a>
			                    </div>
			                    <div class="col-sm-12 col-md-6 text-right">
			                        <%-- <a class="btn btn-lg btn-block btn-success text-uppercase" id="confirmOrder" href="${request.getContextPath()}">Đặt hàng</a> --%>
			                        <button type="submit" class="btn btn-lg btn-success btn-block text-uppercase">Đặt hàng</button>
			                        <input type="hidden" name="action" value="checkout">
			                    </div>
			                </div>
			            </div>
					</form>
				</div>
			</div>
		</div>
	</div>