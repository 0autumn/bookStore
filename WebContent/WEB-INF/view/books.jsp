<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<h2>货物清单</h2>
<s:if test="books.size>0">
<ul id="books">
  <s:iterator value="books">
	<li>
	  <s:if test="coverImageFile!=null">
	    <img class="book" src="images/<s:property value="coverImageFile"/>" />
	  </s:if>
	  <s:else>
	    <img class="book" src="images/book.png"/>
	  </s:else>
	  <p>书名：<strong><s:property value="name"/></strong></p>
	  <p>价格：<strong><s:property value="price"/></strong></p>
	  <a class="button button-blue" href="addToCart.action?bookId=<s:property value="id"/>&quantity=1"> 
		添加到购物车
	  </a>
	</li>
  </s:iterator>
</ul>
</s:if>
<s:else>
  <p class="message">
    <s:if test="keyword==null">对不起，暂无货物！</s:if>
    <s:else>对不起，找不到包含关键字“<s:property value="keyword"/>”的图书</s:else>
  </p>
  <p class="action-bar">
     <a class="button" href="index.jsp">返回首页</a>
    
  </p>
</s:else>