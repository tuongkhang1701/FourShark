<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="sidebar" class="sidebar                  responsive                    ace-save-state">
    <script type="text/javascript">
        try{ace.settings.loadState('sidebar')}catch(e){}
    </script>
    <ul class="nav nav-list">
        <li >
        	<c:url var="listProductURL" value="/admin-product" >
            	<c:param name="type" value="list" />
                <c:param name="page" value="1" />
                <c:param name="maxPageItem" value="4" />
                <c:param name="sortName" value="Name" />
                <c:param name="sortBy" value="DESC" />
            </c:url>
            <a href='${listProductURL}'>
            	<i class="menu-icon fa fa-desktop"></i>
                 Products
            </a>
        </li>
    </ul>
    
    <ul class="nav nav-list">
        <li >
                
                	<c:url var="listUserURL" value="/admin-user" >
                		<c:param name="type" value="list" />
                		<c:param name="page" value="1" />
                		<c:param name="maxPageItem" value="4" />
                		<c:param name="sortName" value="CreatedDate" />
                		<c:param name="sortBy" value="DESC" />
                	</c:url>
                    <a href='${listUserURL}'>
                    	<i class="menu-icon fa fa-user"></i>
                        Accounts
                    </a>
                </li>
     </ul>
    
    <ul class="nav nav-list">
        <li >
                
                	<c:url var="listOrderURL" value="/admin-order" >
                		<c:param name="type" value="list" />
                		<c:param name="page" value="1" />
                		<c:param name="maxPageItem" value="4" />
                		<c:param name="sortCreatedDate" value="sortCreatedDate" />
                		<c:param name="sortBy" value="DESC" />
                	</c:url>
                    <a href='${listOrderURL}'>
                    <i class="menu-icon fa fa-signal"></i>
                        Orders
                    </a>
                </li>
            </ul>
    <div class="sidebar-toggle sidebar-collapse">
        <i class="ace-icon fa fa-angle-double-left ace-save-state" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
    </div>
</div>