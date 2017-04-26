 <%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>人员信息列表</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css" href="css/base.css">
		<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
		<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
		<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
		<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="js/easyUtil.js"></script>
	</head>

	<body>
		<div class="search_div">
			<form id="dom_var_search">
				用户名:
				<input id="userName" type="text">
				昵称:
				<input id="nickName" type="text">
				
				<a id="a_var_search" href="javascript:void(0)"
					class="easyui-linkbutton" data-options="plain:true"
					iconCls="icon-search">查询</a>
				<a id="a_var_reset" href="javascript:void(0)"
					class="easyui-linkbutton" data-options="plain:true"
					iconCls="icon-reload">清除条件</a>
			</form>
		</div>
		<table id="tt" class="easyui-datagrid">
			<thead>
				<tr>
					<th data-options="field:'ck',checkbox:true"></th>
					<th data-options="field:'id',width:100">
						id
					</th>
					<th data-options="field:'name',width:100">
						用户名
					</th>
				    <th data-options="field:'passWord',width:100">
						密码
					</th>
					<th data-options="field:'loginTimes',width:100">
						性别
					</th>
					<th data-options="field:'type',width:100">
						用户类型
					</th>
					<th data-options="field:'creationDate',width:100, formatter:function(value, row, index){return formatDate(value);}">
						创建时间
					</th>
					<th data-options="field:'lastLoginDate',width:100, formatter:function(value, row, index){return formatDate(value);}">
						最后登录时间
					</th>
					
				</tr>
			</thead>
		</table>
		<!-- 分页栏 -->
		<div id="dom_var_pagination" class="easyui-pagination"></div>
		<!-- 弹出窗口 -->
		<div id="dom_var_window"></div>
	</body>
	<script type="text/javascript">
	var TOOL_BAR = [ {
		id : 'view',
		text : '查看',
		iconCls : 'icon-tip',
		handler : function() {
			shortMenuOpen_grid(null, {
				name : 'view'
			});
		}
	}, {
		id : 'add',
		text : '增加',
		iconCls : 'icon-add',
		handler : function() {
			shortMenuOpen_grid(null, {
				name : 'add'
			});
		}
	}, {
		id : 'edit',
		text : '修改',
		iconCls : 'icon-edit',
		handler : function() {
			shortMenuOpen_grid(null, {
				name : 'edit'
			});
		}
	}, {
		id : 'del',
		text : '删除',
		iconCls : 'icon-remove',
		handler : function() {
			shortMenuOpen_grid(null, {
				name : 'del'
			});
		}
	} ];

	$(function() {
		$("#tt").datagrid( {
			url : '/easyBuy/manger/user/limitUsers',

			closable : true,
			checkOnSelect : true,
			striped : true,
			rownumbers : true,
			'toolbar' : TOOL_BAR,
			fitColumns : true,
			loadFilter : function(data) {
				var data_ = {
					"rows" : data.list,
					"total" : data.size
				};
				$("#dom_var_pagination").pagination( {
					total : data.size
				});
				return data_;
			}
		});

		$("#dom_var_pagination").pagination( {
			 onSelectPage: function(pageNumber, pageSize){ 
	            //$('#tt').datagrid('load', "getUserAction.action?currentPage="+pageNumber+"&pageSize="+pageSize+"");
			 	$("#tt").datagrid( {
					url : '/easyBuy/manger/user/limitUsers?page='+pageNumber+'&page_num='+pageSize+'',
					closable : true,
					checkOnSelect : true,
					striped : true,
					rownumbers : true,
					'toolbar' : TOOL_BAR,
					fitColumns : true,
					loadFilter : function(data) {
						var data_ = {
							"rows" : data.list,
							"total" : data.size
						};
						$("#dom_var_pagination").pagination( {
							total : data.size
						});
						return data_;
					}
				});
	        }
		});
	});
	$("#a_var_search").bind('click', function() {
		var userName = $("#userName").val();
		var nickName = $("#nickName").val();
		$("#tt").datagrid( {
			url : '/easyBuy/manger/user/limitUsers?userName='+userName+'&nickName='+nickName,
			closable : true,
			checkOnSelect : true,
			striped : true,
			rownumbers : true,
			'toolbar' : TOOL_BAR,
			fitColumns : true,
			loadFilter : function(data) {
				if(data.list!=null){
					var data_ = {
							"rows" : data.list
						};
						$("#dom_var_pagination").pagination( {
							total : data.size
						});
						return data_;
				}else{
					var data_ = {
							"rows" : ''
						};
						$("#dom_var_pagination").pagination( {
							total : ''
						});
						return data_;
				}
				
			}
		});;
	});
	//清除条件 
	$("#a_var_reset").bind('click',function(){
		$("#userName").val('');
		$("#nickName").val('');
	});
	function shortMenuOpen_grid(rowIndex, menuItem){
		if (menuItem.name == 'add') {
			$("#dom_var_window").window( {
				width : "500",
				height : "300",
				title : "新增",
				modal : true,
				minimizable : false,
				closed : true
			});
			$("#dom_var_window").window('open'); 
			$("#dom_var_window").window('refresh', "/easyBuy/manger/user/getUser?id=-1&pageType=1");
		}
		if (menuItem.name == 'del') {
			var selectedArray = $('#tt').datagrid('getSelections');  //返回被选择的行 
			var ids;
			$(selectedArray).each(function(index,obj){
				if(index==0){
					ids = obj.id;
				}else{
					ids = ids + ',' + obj.id;
				}
			});
			if(selectedArray.length>0){
				var str = selectedArray.length + '条数据将被删除,是否继续?';
				$.messager.confirm('提示',str,function(flag){
					if(flag){
						$.post('/easyBuy/manger/user/delete?ids='+ids,{},function(f){
							if(f.state=='1'){
								$.messager.alert('成功', '删除成功!', 'info');
								$('#tt').datagrid('reload');
							}
						});
					}
				});
			}else{
				$.messager.alert('提示', '请至少选择一条记录!', 'info');  //提示信息 
			}
		}
		if (menuItem.name == 'edit') {
			var selectedArray = $('#tt').datagrid('getSelections');  //返回被选择的行 
			if(selectedArray.length==1){
				$("#dom_var_window").window( {
					width : "500",
					height : "300",
					title : "修改",
					modal : true,
					minimizable : false,
					closed : true
				});
				$("#dom_var_window").window('open'); 
				$("#dom_var_window").window('refresh', "/easyBuy/manger/user/getUser?id="+selectedArray[0].id+"&pageType=2");
			}else{
				$.messager.alert('提示', '请选择一条记录!', 'info');  //提示信息
			}
		}
		if (menuItem.name == 'view') {
			var selectedArray = $('#tt').datagrid('getSelections');  //返回被选择的行 
			if(selectedArray.length==1){
				$("#dom_var_window").window( {
					width : "500",
					height : "280",
					title : "查看",
					modal : true,
					minimizable : false,
					closed : true
				});
				$("#dom_var_window").window('open'); 
				$("#dom_var_window").window('refresh', "/easyBuy/manger/user/view?id="+selectedArray[0].id);
			}else{
				$.messager.alert('提示', '请选择一条记录!', 'info');  //提示信息
			}
		}
	}
</script>
</html>
