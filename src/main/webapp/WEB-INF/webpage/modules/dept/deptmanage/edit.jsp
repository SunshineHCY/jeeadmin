<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta name="decorator" content="form"/>
    <html:css name="bootstrap-fileinput" />
    <html:css name="simditor" />
</head>

<body class="white-bg"  formid="deptForm">
    <form:form id="deptForm" modelAttribute="data"   method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<table  class="table table-bordered  table-condensed dataTables-example dataTable no-footer">
		   <tbody>
				<tr>
					<td  class="width-15 active text-right">	
		              <label><font color="red">*</font>部门名称:</label>
		            </td>
					<td class="width-35">
					${data.deptName}
						<%-- <form:input path="deptName" htmlEscape="false" class="form-control"  datatype="*"    />
						<label class="Validform_checktip"></label> --%>
					</td>
				</tr>
		      	<tr>
					<td  class="width-15 active text-right">	
		              <label><font color="red">*</font>部门编号:</label>
		            </td>
					<td class="width-35">
					${data.deptNo}
						<%-- <form:textarea path="deptNo" rows="4" htmlEscape="false" class="form-control"  datatype="*"    />
						<label class="Validform_checktip"></label> --%>
					</td>
				</tr>
		   </tbody>
		</table>   
	</form:form>
<html:js name="bootstrap-fileinput" />
<html:js name="simditor" />
</body>
</html>