<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>jQuery EasyUI首页</title>
		
		<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
		<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
		<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
		<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
	</head>
	<body class="easyui-layout">
		<!-- 北 -->
		<div data-options="region:'north',border:false" style="height: 36px; border: 0px; padding: 0px; overflow: hidden;">
			<div class="accordion" style="text-align: right; height: 100%; background-color: #438EB9;">
				<div style="margin: auto;">
					<img src="img/top.jpg" width="1400"  height="35" style="margin: auto;border: 0px;" border="0" />
				</div>
			</div>
			
		</div>
		<!-- 西 -->
		<div data-options="region:'west',split:true,title:' '"style="width: 155px;">
			<div class="easyui-layout" data-options="fit:true">
				<div id="pic" data-options="region:'north',split:false" style="height: 130px; padding: 4px;">
					<c:if test="${!empty sessionScope.manger}">
					
					<img alt="" src="img/head.jpg" width="130px;">
					  <div align="center"><a href="/Store/manger/user/mangerLogout"><span style="color: red">${sessionScope.manger.nickName}</span>注销/退出登录</a></div>
					 
					</c:if>
					<c:if test="${empty sessionScope.manger}">
					 <div align="center"><a href="/Store/manger/user/mangerLogin">请登录</a>  </div>
					</c:if>
					<div align="center" id="showDate"></div>
				</div>
				<div data-options="region:'center'">
						<div id="frame_accordion" class="easyui-accordion" data-options="fit:true">  
						    <div title="基础资料" data-options="" style="overflow:auto;padding:10px;">  
						        <ul id="tree1" class="easyui-tree" >  
								    <li  data-options="iconCls:'icon-client_account_template'">  
				                        <span>用户信息管理</span>  
				                    </li>  
				                    <li data-options="iconCls:'icon-group_green_edit'">  
				                        <span>新闻表管理</span>  
				                    </li>  
				                    <li data-options="iconCls:'icon-my-account'">  
				                        <span>客户信息管理</span>  
				                    </li>  
								    <li data-options="iconCls:'icon-business-contact'">  
								        <span>项目资料管理</span>  
								    </li>
								     <li data-options="iconCls:'icon-brainstorming-contact'">  
								        <span>央行后台管理</span>  
								    </li> 
								</ul>  
						    </div>  
						    <div title="系统管理" style="padding:10px;">  
						        	那片笑声让我想起我的那些花儿   
						    </div>  
						    <div title="人员管理" style="padding:10px;">  
						        	在我生命每个角落静静为我开着   
						    </div>
						    <div title="模型管理" style="padding:10px;">  
						       		我曾以为我会永远守在她身旁   
						    </div>
						    <div title="统计查询" style="padding:10px;">  
						        	今天我们已经离去在人海茫茫   
						    </div>  
						</div> 
				</div>
			</div>
		</div>
		<!-- 南 -->
		<div data-options="region:'south',border:false" style="height: 20px; background-color: #f3f3f3;text-align: right;">
			@版权所有2014&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</div>
		<!-- 中 -->
		<div data-options="region:'center'">
			<div class="easyui-tabs" id="frame_tabs" style="overflow: hidden;background-color: #f3f3f3;"
				data-options="fit:true,border:false,plain:true">
				<div title="首页" style="overflow: hidden;">
					<jsp:include page="/home.jsp"></jsp:include>
				</div>
			</div>
		</div> 
	</body>
	<script type="text/javascript">

		$(function(){
			$("#_easyui_tree_5").bind('click',function(){
				if(!$('#frame_tabs').tabs('getTab', '央行后台管理')){
					alert("屏住呼吸,我们马上就可以进入到央行后台管理系统了!激动否? ");
				}
				$.messager.alert('警告','生活从来都是欺骗我们,但我们也要笑着面对(ˇˍˇ)');   
			});
			setInterval("getTime();",1000);
		});
		//取得系统当前时间
		function getTime(){
			var myDate = new Date();
			var date = myDate.toLocaleDateString();
			var hours = myDate.getHours();
			var minutes = myDate.getMinutes();
			var seconds = myDate.getSeconds();
			$("#showDate").html(date+" "+hours+":"+minutes+":"+seconds);
		}
	
		$('#tree1').tree( {
			 onSelect : function(node) {  
                openMenuTow(node);  
            } 
		});
		function openMenuTow(node){

			 //树型菜单的名字   
            var noteText = $(".tree-title", node.target).text();  
            var exist_tab = $('#frame_tabs').tabs('getTab', noteText);  
            //判断是否已经打开该选项卡  
            if (exist_tab) {  
                $('#frame_tabs').tabs('select', noteText);  
                return;  
            } else {  
                var content = "";
                if(noteText=="用户信息管理"){
                	content = '<iframe scrolling="auto" frameborder="0"  src="/Store/ui/userLayout.jsp" style="width:100%;height:100%;"></iframe>';
                }else if(noteText=='新闻表管理'){
                	content = '<iframe scrolling="auto" frameborder="0"  src="/easyBuy/ui/news.jsp" style="width:100%;height:100%;"></iframe>';
                }else if(noteText=='央行后台管理'){
                	content = '<div style="font-size: 35px; text-align: center;margin-top: 100px;">二十岁出头，你一无所有，但你却拥有一切，因为你还有牛逼的梦想。</br></br>只有行动，才能解除你所有的不安</br></br>'+
                	'<div style="font-size: 25px;">我们的生命，就是以不断出发的姿势得到重生 走在路上 无法停息......</div></div>';
                 }else{
                	content = '<div style="font-size: 35px; text-align: center;margin-top: 100px;">系统维护升级中！</br>'+
                	'<div style="font-size:20px;">如果觉得无聊,我们可以去<a href="http://www.aqee.net/docs/the-quiet-place/" target="_blank">一个安静的地方</a></div></div>';
                }
                $('#frame_tabs').tabs('add', {  
                    'id' : 'tab',  
                    title : noteText,  
                    fit : true,  
                    content : content,  
                    closable : true  
                });  
                //获取最后一个tabs 在新加的选项卡后面添加"关闭全部"  
                var li = $(".tabs-wrap ul li:last-child");  
                $("#close").remove();  
                li.after("<li id='close'><a class='tabs-inner' href='javascript:void()' onClick='javascript:closeAll()'>关闭全部</a></li>");  
            }  
		}
		function closeAll() {  
            $(".tabs li").each(function(index, obj) {  
                  //获取所有可关闭的选项卡  
                  var tab = $(".tabs-closable", this).text();  
                  $(".easyui-tabs").tabs('close', tab);  
            });  
            $("#close").remove();//同时把此按钮关闭  
        }  
	</script>
	
</html>
