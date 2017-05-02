<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h2>结算成功，订单信息如下：</h2>
<table id="order" class="table">
  <caption>
     <label>订单号：</label><strong>#<s:property value="model.id"/></strong>
     <label>总价格：</label><em class="price"><s:property value="model.totalPrice"/></em>
     <label>用户：</label><em><s:property value="model.user.name"/></em>
     <label>订单日期：</label><s:date format="yyyy-MM-dd HH:mm:ss" name="model.creationDate"/>
  </caption>
    <tr><th>商品</th><th>单价</th><th>数量</th><th>价格</th></tr>
  <c:forEach var="var" items="${listOred}">
    <tr>
      <td>
      <img class="book small" alt="" src="images/${ var.product.book.coverImageFile}"/>
       <strong> ${ var.product.book.name}</strong> 
       <c:forEach var="vas" items="${var.value}">
	        ${vas.specName }:${vas.specValue}
	    </c:forEach>
      </td>
   
        <td>${var.product.book.price}</td>
         <td>${ var.product.quantity}</td>
       <td>${ var.product.quantity*var.product.book.price}</td>
 
    </tr>
  </c:forEach>
</table>
<p class="action-bar"><a class="button" href="index.jsp">返回首页</a></p>