<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
  <title>部门列表</title>
  <meta name="decorator" content="list"/>
</head>
<body title="部门列表">
<grid:grid id="deptGridId" url="${adminPath}/dept/deptmanage/ajaxList">
	<grid:column label="sys.common.key" hidden="true"   name="id" width="100"/>
	<grid:column label="sys.common.opt"  name="opt" formatter="button" width="100"/>
	<grid:button  groupname="opt" function="delete"  />
    <grid:column label="部门名称"  name="deptName"  query="true" condition="like"  />
    <grid:column label="部门编号"  name="deptNo"  query="true"   condition="like"/>
    
	<grid:toolbar   function="create"  />
	<grid:toolbar   function="detail" icon=" fa fa-sort-amount-desc" title="查看" url="${adminPath}/dept/deptmanage/{id}" />
	<grid:toolbar   function="delete"    />
	<grid:toolbar  function="search"  />
	<grid:toolbar  function="reset"  />
</grid:grid>
<script>
</script>
</body>
</html>


<%-- <%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
  <title>部门列表</title>
  <meta name="decorator" content="list"/>
</head>
<body title="部门列表">
<grid:grid id="deptGridId" url="${adminPath}/dept/deptmanage/ajaxList">
	<grid:column label="sys.common.key" hidden="true"   name="id" width="100"/>
	<grid:column label="sys.common.opt"  name="opt" formatter="button" width="40"/>
	<grid:button   groupname="opt" function="delete" />
    <grid:column label="部门名称"  name="deptName"  query="true"  queryModel="input"  condition="like" />
    <grid:column label="部门编号"  name="deptNo"  query="true" queryMode="input" width="60"  />
    
    <grid:toolbar function="create"/>
	<grid:toolbar   function="update" />
	<grid:toolbar   function="delete" />
	
	<grid:toolbar  function="search"  />
	<grid:toolbar  function="reset" />
</grid:grid>
</body>
</html> --%>