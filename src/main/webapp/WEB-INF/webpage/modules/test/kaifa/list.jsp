<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>
<head>
  <title>部门管理</title>
  <meta name="decorator" content="list"/>
  <html:component name="bootstrap-treeview"/>
  <style>
  .rows{
  width:100%;
  position: relative;}
  .total{
  top: 60px;
    position: absolute;
  }
  </style>
 
</head>
<body title="部门管理">
<script type="text/javascript">
</script>
<div class="rows">
	  <span class="total" id = "total" ></span>
	  
<grid:grid id="kaifaGridId"  url="${adminPath}/test/kaifa/moreTableAjaxList"  sortname="userName" sortorder="asc">
	<grid:column label="sys.common.key" hidden="true"   name="id" width="100" />
    <grid:column label="姓名"  name="realname"  query="true"  />
    <grid:column label="登录名"  name="userName"    dict="dept"/> 
    <grid:column label="部门名称"  name="deptName"      />
    <grid:column label="部门编号"  name="deptNo"     />
    <grid:column label="手机号码"  name="ipone"  query="true"  />
    <grid:toolbar   icon="fa fa-search"  layout="right" title = "重置" function="reset1"/>
	<grid:toolbar   icon="fa fa-search"  layout="right" title = "搜索" function="search1"/>
	<grid:toolbar   icon="fa fa-download" title="下载" layout="right"  function="exportDownLoad" /> 
	
</grid:grid>
</div>
<script>
/**
 * 查询
 */
function search1() {
	total();
	search('kaifaGridIdGrid');
}

/**
 * 下载
 */
function exportDownLoad() {
    var url ='${adminPath}/test/kaifa/orderExport';
    var parms=	common();
window.location.href=url+parms;
}

/**
 * 获取总额
 */
function total(){
	debugger
	var url ='${adminPath}/test/kaifa/total';
    var parms=	common();
   $.ajax({
		type : "post",
		url : url+encodeURI(encodeURI(parms)),
		async:false,
		data : {
		},
		dataType : "json",
		success:function(total1){
			   $("#total").html("合计："+total1);
		}
	 });
}
/**
 *重置 
 */
function reset1() {
	debugger 
	total();
	reset('kaifaGridIdGrid');
}

function common(){
	var paramStr="?realname="+ $("input[name='realname']").val()
	 +"&ipone="+ $("input[name='ipone']").val();
  return paramStr;
}
/**
 * 界面加载显示合计内容
 */
total();
</script>
</body>
</html>