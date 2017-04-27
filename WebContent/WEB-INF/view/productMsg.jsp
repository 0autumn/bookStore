<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
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
});
</script>
<p> </p>
<div align="left"> 

    <div style="display:inline-block"><img class="tip" src="/Store/images/tm3.jpg" /></div>
    <div style="display:inline-block">
      <div align="center">法国LAFUMA乐飞叶女士户外防风防泼水中长登山冲锋衣LFJ06AC71</div>
      <div align="center">¥ 1539.00 </div>
      
      <div align="center">尺码</div>
     <div align="center">颜色分类</div>
     <div align="center">数量 库存19件</div>
      <div align="right"><a class="button button-blue" href="addToCart.action?bookId=<s:property value="productId"/>&quantity=1"> 
		添加到购物车<s:property value="id"/>
	  </a></div>
    </div>
    

</div>
