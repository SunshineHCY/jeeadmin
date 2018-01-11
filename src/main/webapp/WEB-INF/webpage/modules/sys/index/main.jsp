<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>首页</title>
	<meta name="keywords" content="<spring:message code="sys.site.keywords" arguments="${platformName}"/>">
	<meta name="description" content="<spring:message code="sys.site.description" arguments="${platformName}"/>">

    <html:css  name="favicon,bootstrap,font-awesome,animate"/>
    <link href="${staticPath}/common/css/style.css" rel="stylesheet">
    
</head>

<body class="gray-bg">
    <div class="row  border-bottom white-bg dashboard-header">
        <div class="col-sm-12">
            <blockquote class="text-warning" style="font-size:14px"> 欢迎进入财富资讯后台管理系统
            </blockquote>
        </div>
    </div>
     <style>
.lifangti {
	transform: rotateX(-33.5deg) rotateY(45deg);
	transform-origin: 50px 0px;
	transform-style: preserve-3d;
	-webkit-transform: rotateX(-33.5deg) rotateY(45deg);
	-webkit-transform-origin: 50px 0px;
	-webkit-transform-style: preserve-3d;
	-moz-transform: rotateX(-33.5deg) rotateY(45deg);
	-moz-transform-origin: 50px 0px;
	top: 50%;
	left: 50%;
	margin: -100px 0 0 -50px;
	position: absolute;
	display: block;
	animation: xuanzhuan 5s infinite ease;
	-moz-animation: xuanzhuan 5s infinite ease; /* Firefox */
	-webkit-animation: xuanzhuan 5s infinite ease; /* Safari ºÍ Chrome */
	-o-animation: xuanzhuan 5s infinite ease; /* Opera */
}

	.lifangti > .bgabox {
		width: 100px;
		height: 100px;
		position: absolute;
		opacity: 0.6;
	}

.leftm {
	background-color: #ff6a00;
	transform: rotateY(90deg) translateZ(-50PX);
	-moz-transform: rotateY(90deg) translateZ(-50PX);
	-webkit-transform: rotateY(90deg) translateZ(-50PX);
}

.rightm {
	background-color: #6faed9;
	transform: rotateY(90deg) translateZ(50px);
	-moz-transform: rotateY(90deg) translateZ(50px);
	-webkit-transform: rotateY(90deg) translateZ(50px);
}

.topm {
	transform: rotateX(90deg) translateZ(50px);
	-moz-transform: rotateX(90deg) translateZ(50px);
	-webkit-transform: rotateX(90deg) translateZ(50px);
	background-color: #ff0000;
	opacity: 1;
}

.bottomm {
	transform: rotateX(90deg) translateZ(-50px);
	-moz-transform: rotateX(90deg) translateZ(-50px);
	-webkit-transform: rotateX(90deg) translateZ(-50px);
	background-color: #52d538;
}

.beform {
	background-color: #b12d9e;
	transform: translateZ(50px);
	-moz-transform: translateZ(50px);
	-webkit-transform: translateZ(50px);
}

.afterm {
	background-color: #138fc6;
	transform: translateZ(-50px);
	-moz-transform: translateZ(-50px);
	-webkit-transform: translateZ(-50px);
}

@keyframes xuanzhuan {
	from {
		transform: rotateX(-33.5deg) rotateY(45deg);
		-webkit-transform: rotateX(-33.5deg) rotateY(45deg);
		-moz-transform: rotateX(-33.5deg) rotateY(45deg);
	}

	to {
		transform: rotateX(-33.5deg) rotateY(765deg);
		-webkit-transform: rotateX(-33.5deg) rotateY(765deg);
		-moz-transform: rotateX(-33.5deg) rotateY(765deg);
	}
}

.lifangtimin {
	transform-origin: 25px 0px;
	transform-style: preserve-3d;
	-webkit-transform-origin: 25px 0px;
	top: 50%;
	margin: -50px 0 0 -25px;
	position: absolute;
	display: block;
	transform: translateX(50px) translateY(75px) rotateY(0deg);
	-webkit-transform: translateX(50px) translateY(75px) rotateY(0deg);
	-moz-transform: translateX(50px) translateY(75px) rotateY(0deg);
	animation: xuanzhuanm 5s infinite ease;
	-moz-animation: xuanzhuanm 5s infinite ease; /* Firefox */
	-webkit-animation: xuanzhuanm 5s infinite ease; /* Safari ºÍ Chrome */
	-o-animation: xuanzhuanm 5s infinite ease; /* Opera */
}

	.lifangtimin > div {
		width: 50px;
		height: 50px;
		position: absolute;
		opacity: 1;
	}

.leftmm {
	background-color: #ff6a00;
	transform: rotateY(90deg) translateZ(-25px);
	-webkit-transform: rotateY(90deg) translateZ(-25px);
	-moz-transform: rotateY(90deg) translateZ(-25px);
}

.rightmm {
	background-color: #6faed9;
	transform: rotateY(90deg) translateZ(25px);
	-webkit-transform: rotateY(90deg) translateZ(25px);
	-moz-transform: rotateY(90deg) translateZ(25px);
}

.topmm {
	transform: rotateX(90deg) translateZ(25px);
	-webkit-transform: rotateX(90deg) translateZ(25px);
	-moz-transform: rotateX(90deg) translateZ(25px);
	background-color: #ff0000;
	opacity: 1;
}

.bottommm {
	transform: rotateX(90deg) translateZ(-25px);
	-webkit-transform: rotateX(90deg) translateZ(-25px);
	-moz-transform: rotateX(90deg) translateZ(-25px);
	background-color: #52d538;
}

.beformm {
	background-color: #b12d9e;
	transform: translateZ(25px);
	-webkit-transform: translateZ(25px);
	-moz-transform: translateZ(25px);
}

.aftermm {
	background-color: #138fc6;
	transform: translateZ(-25px);
	-webkit-transform: translateZ(-25px);
	-moz-transform: translateZ(-25px);
}

@keyframes xuanzhuanm {
	from {
		transform: translateX(50px) translateY(75px) rotateY(0deg);
		-webkit-transform: translateX(50px) translateY(75px) rotateY(0deg);
		-moz-transform: translateX(50px) translateY(75px) rotateY(0deg);
	}

	to {
		transform: translateX(50px) translateY(75px) rotateY(-1080deg);
		-webkit-transform: translateX(50px) translateY(75px) rotateY(-1080deg);
		-moz-transform: translateX(50px) translateY(75px) rotateY(-1080deg);
	}
}
</style>
    <div class="wrapper wrapper-content">
        <div class="row">
           <!--  <div class="col-sm-4">

                <div class="portlet box" style="display:none;">
                    <div class="portlet-header">
                        <h5>商业支持</h5>
                    </div>
                    <div class="portlet-body">
                        <p>我们提供基于jeeadmin的二次开发服务，具体费用请联系官方。</p>
                    </div>
                </div>
                <div class="portlet box">
                    <div class="portlet-header">
                        <h5>联系信息</h5>

                    </div>
                    <div class="portlet-body">
	                    <p><i class="fa fa-send-o"></i> 官网：<a href="http://www.jeeadmin.cn/" target="_blank">http://www.jeeadmin.cn/</a></p>
	                    <p><i class="fa fa-qq"></i> QQ群：<a href="javascript:;">570062301</a></p>
	                    <p><i class="fa fa-code"></i> 源码下载：<a href="http://git.oschina.net/dataact/jeeadmin/"  target="_blank">开源中国</a></p>
	                </div>

                </div>
            </div>
            <div class="col-sm-4">
                <div class="portlet box">
                    <div class="portlet-header">
                        <h5>更新日志</h5>
                    </div>
                    <div class="portlet-body no-padding">
                        <div class="panel-body">
                            <div class="panel-group" id="version">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h5 class="panel-title">
                                                <a data-toggle="collapse" data-parent="#version" href="#v01">v1.0</a><code class="pull-right">2017.07.06</code>
                                        </h5>
                                    </div>
                                    <div id="v01" class="panel-collapse collapse in">
                                        <div class="panel-body">
                                             <ol>
                                                <li>框架首次发布</li>
                                            </ol>
                                        </div>
                                    </div>
                                </div>
                                
                                
                            </div>
                        </div>
                    </div>
                </div>
            </div> -->
            <div class="lifangti">

	<div class="beform bgabox"></div>
	<div class="afterm bgabox"></div>
	<div class="leftm bgabox"></div>
	<div class="rightm bgabox"></div>
	<div class="topm bgabox"></div>
	<div class="bottomm bgabox"></div>
	
	<div class="lifangtimin">
		<div class="beformm"></div>
		<div class="aftermm"></div>
		<div class="leftmm"></div>
		<div class="rightmm"></div>
		<div class="topmm"></div>
		<div class="bottommm"></div>
	</div>
	
</div>
        </div>
    </div>
 	<!-- 全局js -->
	<html:js  name="jquery,bootstrap"/>

	<!-- 自定义js -->
	<script src="${staticPath}/common/js/content.js"></script>
	
</body>

</html>