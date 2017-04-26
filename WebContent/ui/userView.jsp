<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<form id="dom_var_entity">
	<table class="editTable">
		<tr>
			<td class="title">
				id:
			</td>
			<td colspan="3">
				${ user.id }
			</td>
		</tr>
		<tr>
			<td class="title">
				用户名:
			</td>
			<td colspan="3">
				${ user.userName }
			</td>
		</tr>
		<tr>
			<td class="title">
				昵称:
			</td>
			<td colspan="3">
				${ user.nickName }

			</td>
		</tr>
		<tr>
			<td class="title">
				密码:
			</td>
			<td colspan="3">
				${ user.passWord }
			</td>
		</tr>
		<tr>
			<td class="title">
				性别:
			</td>
			<td colspan="3">
				${ user.sex }
			</td>
		</tr>
		<tr>
			<td class="title">
				邮箱:
			</td>
			<td colspan="3">
				${ user.email }
			</td>
		</tr>
		<tr>
			<td class="title">
				手机电话:
			</td>
			<td colspan="3">
				${ user.mobile }
			</td>
		</tr>
		<tr>
			<td class="title">
				用户类型:
			</td>
			<td colspan="3">
				${ user.type }
			</td>
		</tr>
		<tr>
			<td class="title">
				创建时间:
			</td>
			<td colspan="3">
				<fmt:formatDate value='${ user.createTime }' pattern='yyyy-MM-dd'/>
			</td>
		</tr>
		<tr>
			<td class="title">
				最后修改时间:
			</td>
			<td colspan="3">
				<fmt:formatDate value='${user.lastUpdateTime}' pattern='yyyy-MM-dd'/>
			</td>
		</tr>
		<tr>
			<td class="title">
				是否停用:
			</td>
			<td colspan="3">
				${ user.isDel }
			</td>
		</tr>
		<tr>
			<th colspan="4">
				<div class="div_button">
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

		//关闭窗口 
		$("#dom_var_cancle_form").bind('click',function(){
			$("#dom_var_window").window('close');
		});
		
	});
</script>