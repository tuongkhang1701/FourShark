<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<body>
    <div class="container mt-3">
        <div class="media border p-3">
          <img src="./images/Aser01.jpg" alt="John Doe" class="mr-3 mt-3 img-thumbnail" style="width:400px; height: 400px;">
          <div class="media-body">
            <h1>${model.name}</h1>
            <div class="card-body">
                <div class="row">

                    <div class="col-6">
                        <div class="pull-right">
                            <span class="pricing-header pull-right" style="color: red; ">${model.price} VNĐ</span>
                        </div>
                    </div>
                </div>
            </div>


            <p>${model.content}</p> 
            
            <div class="card-footer ">
					<a href="${request.getContextPath()}/cartController?action=add&id=${model.getId()}" class="btn btn-default add-to-cart text-center">
				<i style='font-size: 24px' class='fas'>&#xf218;</i>
				</a>	                        	
                
            </div>
          </div>
        </div>
      </div>
</body>