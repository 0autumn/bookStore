<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form id="dom_var_entity">
	<input type="hidden" id="entity_orgId" name="entity.orgId" value="${entity.orgId }"/>
	<input type="hidden" id="entity_id" name="entity.id" value="${entity.id }"/>
	<table class="editTable">
		<tr>
			<td class="title">
				名称:
			</td>
			<td colspan="3">
				<input type="text" class="easyui-validatebox" data-options="required:true"
					id="entity_username" name="entity.username" value="${entity.username}">
			</td>
		</tr>
		<tr>
			<td class="title">
				组织机构:
			</td>
			<td colspan="3">
				<input type="text" class="easyui-validatebox" readonly="readonly"
					data-options="required:false,validType:',maxLength[32]'"
					id="entity_orgname" name="entity.orgname" value="${entity.orgname }">
					<a id="chooseOrg" href="javascript:void(0)" class="easyui-linkbutton" style="color: #000000;width: 55px;">选择</a>
				<div id="win_chooseOrg" class="easyui-window"
					style="width: 300px; height: 200px;"
					data-options="title:'组织机构',closed:true,modal:true,href:'CHOOSEORG_CONSOLE.action'"></div>
			</td>
		</tr>
		<tr>
			<td class="title">
				登录名:
			</td>
			<td colspan="3">
				<input type="text" class="easyui-validatebox"
					data-options="required:false,validType:',maxLength[32]'"
					id="entity_loginname" name="entity.loginname"
					value="${entity.loginname}">

			</td>
		</tr>
		<tr>
			<td class="title">
				备注:
			</td>
			<td colspan="3">
				<textarea rows="3" cols="32" class="easyui-validatebox"
					data-options="required:false,validType:',maxLength[64]'"
					id="entity_note" name="entity.note">${entity.note}</textarea>
			</td>
		</tr>
		<tr>
			<td class="title">
				状态:
			</td>
			<td colspan="3">
				<select name="entity.state" id="entity_state" val="${entity.state}">
					<option value="可用">
						可用
					</option>
					<option value="禁用">
						禁用
					</option>
				</select>
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
				$(openWindowId).window('refresh', 'CHOOSEORG_CONSOLE.action?entity.orgId=${(entity.orgId==null||entity.orgId=='')?0:entity.orgId }');   //刷新 
				$(openWindowId).panel('open');
			});
		}
		
		//关闭窗口 
		$("#dom_var_cancle_form").bind('click',function(){
			$("#dom_var_window").window('close');
		})
		$("#dom_var_add_entity").bind('click',function(){
			if ($('#dom_var_entity').form('validate')) {
				if (confirm('您确定保存该任务吗？')) {
					$.post('userSaveAction.action', $("#dom_var_entity").serializeArray(), function(flag) {
						if (flag.state == '1') {
							alert("操作成功，窗口即将关闭!");
							$("#dom_var_window").window('close');  //关闭
							$('#tt').datagrid('reload');           //刷新 
						} else {
							alert("操作失败!");
						}
					});
				}
			}
		})
		$("#dom_var_edit_entity").bind('click',function(){
			if ($('#dom_var_entity').form('validate')) {
				$.post('userEditAction.action', $("#dom_var_entity").serializeArray(), function(flag) {
					if (flag.state == '1') {
						alert("操作成功，窗口即将关闭!");
						$("#dom_var_window").window('close');  //关闭
						$('#tt').datagrid('reload');           //刷新 
					} else {
						alert("操作失败!");
					}
				});
			}
		})
		
	})
</script>