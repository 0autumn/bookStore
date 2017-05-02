<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="/Store/js/jquery-1.8.2.min.js"></script>
<style type="text/css">
#tip {position:absolute;color:#333;display:none;}
#tip s {position:absolute;top:40px;left:-20px;display:block;width:0px;height:0px;font-size:0px;line-height:0px;border-color:transparent #BBA transparent transparent;border-style:dashed solid dashed dashed;border-width:10px;}
#tip s i {position:absolute;top:-10px;left:-8px;display:block;width:0px;height:0px;font-size:0px;line-height:0px;border-color:transparent #fff transparent transparent;border-style:dashed solid dashed dashed;border-width:10px;}
#tip .t_box {position:relative;background-color:#CCC;filter:alpha(opacity=50);-moz-opacity:0.5;bottom:-3px;right:-3px;}
#tip .t_box div {position:relative;background-color:#FFF;border:1px solid #ACA899;background:#FFF;padding:1px;top:-3px;left:-3px;}
.tip {width:150px;height:102px;border:1px solid #DDD; margin-left: 20px;}
</style>
<script type="text/javascript">
$(function(){
  $('.tip').mouseover(function(){
   var $tip=$('<div id="tip"><div class="t_box"><div><s><i></i></s><img src="'+this.src+'" /></div></div></div>');
   $('body').append($tip);
   $('#tip').show('fast');
  }).mouseout(function(){
   $('#tip').remove();
  }).mousemove(function(e){
   $('#tip').css({"top":(e.pageY-60)+"px","left":(e.pageX+30)+"px"});
  });
  
  $('.select').click(function(){
	  var myClick=$('.select').index($(this));
	  var array=document.getElementsByName("id");
	  var num=$('.num').eq(myClick).val();
	  $('.num').each(function(i,element){
		   if($('.num').eq(i).val()==num){
			   array[i].checked = false;
		   }
		
	  });
	  array[myClick].checked=true;
	  
  });
	  
	  
  
});
 
</script>
<p> </p>
<div align="left"> 

    <div style="display:inline-block"><img class="tip" src="/Store/images/tm3.jpg" /></div>
    <div style="display:inline-block">
     <div align="center">${productMsg.poduct.name}</div>
      <div align="center">${productMsg.poduct.title} </div>
      <div align="center">价格：¥ ${productMsg.poduct.price} </div>
        <form action="addToCart.action?bookId=<s:property value="productId"/>&quantity=1" method="post">
      <c:forEach var="var" items="${productMsg.spec}" varStatus="syu">
      <div align="center">${var.specName.spec_name }
    
         <c:forEach var="var" items="${var.specValue}" varStatus="status">
            <input class="num"  type="hidden" value="${syu.count}">
            <c:if test="${status.count==1 }">
            <input class="select" type="checkbox" name="id"  value="${var.id}" checked="checked"/><span>${var.spec_value}</span>
         </c:if>
          <c:if test="${status.count!=1 }">
            <input class="select" type="checkbox" name="id"  value="${var.id}" /><span>${var.spec_value}</span>
         </c:if>
         </c:forEach>
    
      </div>
      </c:forEach> 
       
      <div align="center">数量 库存${productMsg.poduct.stock}件</div>
      <div align="right">
		<input type="submit" value="添加到购物车" />
		<!-- <a class="button button-blue" > </a> -->
	  </div>
	   </form>
    </div>
    

</div>
