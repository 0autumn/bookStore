<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="datagrid_div">
	<table id="dom_choose_org" class="easyui-datagrid">
			<thead>
				<tr>
					<th data-options="field:'ck',checkbox:true"></th>
					<th data-options="field:'id',width:100,hidden:true">
						ID
					</th>
					<th data-options="field:'name',width:100">
						机构名称
					</th>
				</tr>
			</thead>
		</table>
</div>
<script type="text/javascript">
	var ORG_TOOL_BAR = [ {
		id : 'view',
		text : '选择',
		iconCls : 'icon-ok',
		handler : function() {
			var selectedArray = $('#dom_choose_org').datagrid('getSelections'); //获得所选行
			chooseWindowCallBackHandle(selectedArray);
		}
	}];

	$(function() {
		$("#dom_choose_org").datagrid( {
			url : 'getOrganizationAction.action',
			closable : true,
			checkOnSelect : true,
			striped : true,
			singleSelect : true,
			rownumbers : true,
			'toolbar' : ORG_TOOL_BAR,
			fitColumns : true,
			loadFilter : function(data) {
				var data_ = {
					"rows" : data.result.resultList,
					"total" : data.size
				}
				return data_;
			}
		});
		//回显选中记录
		$("#dom_choose_org").ajaxComplete(function(event,request, settings){
			$("tr").each(function(){
				var id = $("td[field=id]",this).text();
				if(id==${entity.orgId}){
					$('#dom_choose_org').datagrid('selectRow', id-1);
				}
			})
		});
		
	});
	//-->
</script>







