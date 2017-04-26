<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<form id="dom_var_entity">
	<table class="editTable">
		<c:if test="${pageType==2}">
			<tr>
				<td class="title">
					id:
				</td>
				<td colspan="3">
					<input type="text" class="easyui-validatebox" data-options="required:true"
						id="entity_username" name="id" readonly="readonly" value="${user.id}">
				</td>
			</tr>
		</c:if>
		<tr>
			<td class="title">
				用户名:
			</td>
			<td colspan="3">
				<input type="text" class="easyui-validatebox" data-options="required:true"
					id="entity_username" name="userName" value="${user.userName}">
			</td>
		</tr>
		<tr>
			<td class="title">
				昵称:
			</td>
			<td colspan="3">
				<input type="text" class="easyui-validatebox" data-options="required:true"
					id="entity_username" name="nickName" value="${user.nickName}">
			</td>
		</tr>
		<tr>
			<td class="title">
				密码:
			</td>
			<td colspan="3">
				<input type="text" class="easyui-validatebox" data-options="required:true"
					id="entity_username" name="passWord" value="${user.passWord}">
			</td>
		</tr>
		<tr>
			<td class="title">
				性别:
			</td>
			<td colspan="3">
				<input type="text" class="easyui-validatebox" data-options="required:true"
					id="entity_username" name="sex" value="${user.sex}">
			</td>
		</tr>
		<tr>
			<td class="title">
				邮箱:
			</td>
			<td colspan="3">
				<input type="text" class="easyui-validatebox" data-options="required:true"
					id="entity_username" name="email" value="${user.email}">
			</td>
		</tr>
		<tr>
			<td class="title">
				手机电话:
			</td>
			<td colspan="3">
				<input type="text" class="easyui-validatebox" data-options="required:true"
					id="entity_username" name="mobile" value="${user.mobile}">
			</td>
		</tr>
		<tr>
			<td class="title">
				用户类型:
			</td>
			<td colspan="3">
				<input type="text" class="easyui-validatebox" data-options="required:true"
					id="entity_username" name="type" value="${user.type}">
			</td>
		</tr>
		<c:if test="${pageType==2}">
			<tr>
				<td class="title">
					创建时间:
				</td>
				<td colspan="3">
					<input type="text" class="easyui-validatebox" data-options="required:true"
						id="entity_username" name="createTime"    value="<fmt:formatDate value='${ user.createTime }' pattern='yyyy-MM-dd'/>">
				</td>
			</tr>
			<tr>
				<td class="title">
					最后修改时间:
				</td>
				<td colspan="3">
					<input type="text" class="easyui-validatebox" data-options="required:true"
						id="entity_username" name="lastUpdateTime" value="<fmt:formatDate value='${user.lastUpdateTime}' pattern='yyyy-MM-dd'/>">
				</td>
			</tr> 
		</c:if>
		<tr>
			<td class="title">
				是否停用:
			</td>
			<td colspan="3">
				<input type="text" class="easyui-validatebox" data-options="required:true"
					id="entity_username" name="isDel" value="${user.isDel}">
			</td>
		</tr>
		<tr>
			<th colspan="4">
				<div class="div_button">
					<c:if test="${pageType==1}">
						<a id="dom_var_add_entity" href="javascript:void(0)"
							class="easyui-linkbutton" style="width: 55px;">增加</a>
					</c:if>
					<c:if test="${pageType==2}">
						<a id="dom_var_edit_entity" href="javascript:void(0)"
							class="easyui-linkbutton" style="width: 55px;">修改</a>
					</c:if>
					
					<a id="dom_var_cancle_form" href="javascript:void(0)"
						class="easyui-linkbutton" style="width: 55px;">取消</a>
				</div>
			</th>
		</tr> 
	</table>
</form>
<script type="text/javascript">
	$(function(){
		$("table tr:nth-child(odd)").css("background-color","#eeeeee"); //隔行换色

		initChoose_Window_Default('#chooseOrg',
				'#win_chooseOrg', function(rows) {
					console.info(rows);
					$('#entity_orgname').val(rows[0].name);  //将返回的值 赋给 entity_orgname
					$('#entity_orgId').val(rows[0].id);  //将返回的值 赋给 entity_orgId
					return false;
				});

		function initChoose_Window_Default(chooseButtonId, openWindowId, callback) {
			$(chooseButtonId).bind('click', function() {
				chooseWindowCallBackHandle = function(row) {
					var isClose = callback(row);
					if (!isClose || isClose == false) {
						$(openWindowId).window('close');
					}
				};
				$(openWindowId).window('refresh', "");   //刷新 
				$(openWindowId).panel('open');
			});
		}
		
		//关闭窗口 
		$("#dom_var_cancle_form").bind('click',function(){
			$("#dom_var_window").window('close');
		});
		/* 提交新增的用户信息 */
		$("#dom_var_add_entity").bind('click',function(){
			if ($('#dom_var_entity').form('validate')) {
				if (confirm('您确定保存该任务吗？')) {
					$.post('/easyBuy/manger/user/add', $("#dom_var_entity").serialize(), function(flag) {
						if (flag.state == '1') {
							alert("操作成功，窗口即将关闭!");
							$("#dom_var_window").window('close');  //关闭
							$('#tt').datagrid('reload');           //刷新 
						} else {
							alert("操作失败!");
						}
					});
				};
			};
		});
		/* 提交修改的用户信息 */
		$("#dom_var_edit_entity").bind('click',function(){
			if ($('#dom_var_entity').form('validate')) {
				$.post('/easyBuy/manger/user/update', $("#dom_var_entity").serialize(), function(flag) {
					if (flag.state == '1') {
						alert("操作成功，窗口即将关闭!");
						$("#dom_var_window").window('close');  //关闭
						$('#tt').datagrid('reload');           //刷新 
					} else {
						alert("操作失败!");
					}
				});
			}
		}); 
		
	});
</script>