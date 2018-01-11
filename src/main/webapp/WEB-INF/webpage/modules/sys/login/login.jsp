<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/webpage/common/taglibs.jspf"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<title>财富资讯平台</title>

<head>
    <title><spring:message code="sys.site.title" arguments="${platformName}"/></title>
    <meta name="keywords" content="<spring:message code="sys.site.keywords" arguments="${platformName}"/>">
    <meta name="description" content="<spring:message code="sys.site.description" arguments="${platformName}"/>">
    
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="Thu, 19 Nov 1900 08:52:00 GMT">
    <!--Loading bootstrap css-->
    <link type="text/css" rel="stylesheet" href="${staticPath}/vendors/jquery-ui-1.10.4.custom/css/ui-lightness/jquery-ui-1.10.4.custom.min.css">
    <html:css  name="favicon,bootstrap,font-awesome,animate,pace,iCheck,toastr,bootstrapvalidator"/>
    <!--Loading style-->
     <link type="text/css" rel="stylesheet" href="${staticPath}/uadmin/css/style2.0.css">
<%--     <link type="text/css" rel="stylesheet" href="${staticPath}/uadmin/css/themes/style1/orange-blue.css" class="default-style">
    <link type="text/css" rel="stylesheet" href="${staticPath}/uadmin/css/themes/style1/orange-blue.css" id="theme-change" class="style-change color-change">
    <link type="text/css" rel="stylesheet" href="${staticPath}/uadmin/css/style-responsive.css"> 
 --%></head>
<style type="text/css">
	ul li{font-size: 30px;color:#2ec0f6;}
	.tyg-div{z-index:-1000;float:left;position:absolute;left:5%;top:20%;}
	.tyg-p{
		font-size: 14px;
	    font-family: 'microsoft yahei';
	    position: absolute;
	    top: 135px;
	    left: 60px;
	}
	.tyg-div-denglv{
		z-index:1000;float:right;position:absolute;right:3%;top:10%;
	}
	.tyg-div-form{
		background-color: #23305a;
		width:300px;
		height:auto;
		margin:120px auto 0 auto;
		color:#2ec0f6;
	}
	.tyg-div-form form {padding:10px;}
	.tyg-div-form form input[type="text"]{
		width: 270px;
	    height: 30px;
	    margin: 25px 10px 0px 0px;
	}
	.tyg-div-form form button {
	    cursor: pointer;
	    width: 270px;
	    height: 44px;
	    margin-top: 25px;
	    padding: 0;
	    background: #2ec0f6;
	    -moz-border-radius: 6px;
	    -webkit-border-radius: 6px;
	    border-radius: 6px;
	    border: 1px solid #2ec0f6;
	    -moz-box-shadow:
	        0 15px 30px 0 rgba(255,255,255,.25) inset,
	        0 2px 7px 0 rgba(0,0,0,.2);
	    -webkit-box-shadow:
	        0 15px 30px 0 rgba(255,255,255,.25) inset,
	        0 2px 7px 0 rgba(0,0,0,.2);
	    box-shadow:
	        0 15px 30px 0 rgba(255,255,255,.25) inset,
	        0 2px 7px 0 rgba(0,0,0,.2);
	    font-family: 'PT Sans', Helvetica, Arial, sans-serif;
	    font-size: 14px;
	    font-weight: 700;
	    color: #fff;
	    text-shadow: 0 1px 2px rgba(0,0,0,.1);
	    -o-transition: all .2s;
	    -moz-transition: all .2s;
	    -webkit-transition: all .2s;
	    -ms-transition: all .2s;
}
</style>
<body >
<div class="tyg-div">
	<ul>
    	<li>让</li>
    	<li><div style="margin-left:20px;">数</div></li>
    	<li><div style="margin-left:40px;">据</div></li>
    	<li><div style="margin-left:60px;">改</div></li>
    	<li><div style="margin-left:80px;">变</div></li>
    	<li><div style="margin-left:100px;">生</div></li>
    	<li><div style="margin-left:120px;">活</div></li>
    </ul>
</div> 
<div id="contPar" class="contPar">
	<div id="page1"  style="z-index:1;">
		<div class="title0">智慧财富资讯平台<img src="https://cdn.paicaifu.com/wealth/img/favicon.ico" /></div>
		<!--<div class="title1">旅游、交通、气象、公共安全、大数据</div>-->
		<div class="imgGroug">
			<ul>
				<img alt="" class="img0 png" src="${staticPath}/uadmin/images/img/page1_0.png">
				<img alt="" class="img1 png" src="${staticPath}/uadmin/images/img/page1_1.png">
				<img alt="" class="img2 png" src="${staticPath}/uadmin/images/img/page1_2.png">
			</ul>
		</div>
		<img alt="" class="img3 png" src="${staticPath}/uadmin/images/img/page1_3.jpg">
	</div>
</div>
<div class="tyg-div-denglv">
    <div class="tyg-div-form">
    
                
        <form  id="loginform"  method="post" >
        
            <h3>登录<span style="font-size:16px;display:inline-block;padding-left:10px">欢迎访问  财富资讯</span></h2>
            <div class="body-content ">
               <!--  <p>jeeadmin欢迎您！</p> -->
                <div class="form-group" style="margin-bottom: 30px;"   >
                    <div class="input-icon right">
                        <input name="username" class="form-control" placeholder="<spring:message code="sys.login.username.placeholder"/>" required="">
                    </div>
                </div>
                <div class="form-group">
                    <div class="input-icon right">
                        <input name="password" type="password" class="form-control" placeholder="<spring:message code="sys.login.password.placeholder"/>" required="">
                    </div>
                </div>
                <c:if test="${showCaptcha eq 1}">
                <div class="form-group">
               	   <div class="pull-left">
                     <input   name="jcaptchaCode" class="form-control" placeholder="<spring:message code="sys.login.captcha.placeholder"/>" required="">
                   </div>
                   <div class="pull-right">
                     <img id="img_jcaptcha"  src="${appPath}/jcaptcha.jpg" width="100" height="35" onclick="changeJcaptchaSrc();" />
                    </div>   
                </div>
                <div class="clearfix"></div>
                </c:if>
	                    <button type="submit" style="margin-top: 10px;"><spring:message code="sys.login.submit.label"/> &nbsp;
	                        <i class="fa fa-chevron-circle-right"></i>
	                    </button>
	             
            </div>
        </form>
    </div>
  </div>
    <html:js  name="jquery,bootstrap,iCheck,bootstrap-hover-dropdown,toastr,bootstrapvalidator"/>
    <script src="${staticPath}/uadmin/js/jquery-migrate-1.2.1.min.js"></script>
    <script src="${staticPath}/uadmin/js/jquery-ui.js"></script>
    <script src="${staticPath}/uadmin/js/html5shiv.js"></script>
    <script src="${staticPath}/uadmin/js/respond.min.js"></script>
    <script src="${staticPath}/uadmin/js/jquery.menu.js"></script>
    <script src="${staticPath}/uadmin/js/com.js"></script>
    <script>
        //BEGIN CHECKBOX & RADIO
        $('input[type="checkbox"]').iCheck({
            checkboxClass: 'icheckbox_minimal-grey',
            increaseArea: '20%' // optional
        });
        $('input[type="radio"]').iCheck({
            radioClass: 'iradio_minimal-grey',
            increaseArea: '20%' // optional
        });
        //END CHECKBOX & RADIO
        function changeJcaptchaSrc(){  
            document.getElementById("img_jcaptcha").src='${appPath}/jcaptcha.jpg?_='+(new Date()).getTime();  
        }  
    </script>
     <script type="text/javascript">
		$(document).ready(function() {
		     $("#loginform").bootstrapValidator();
		     var error="${error}";
		     if (error!="")
		     {
		    	 showToast(error,"error");
		     }
		});
		
		function showToast(msg,shortCutFunction)
		 {
			 toastr.options = {
					  "closeButton": true,
					  "debug": false,
					  "progressBar": true,
					  "positionClass": "toast-bottom-right",
					  "onclick": null,
					  "showDuration": "400",
					  "hideDuration": "1000",
					  "timeOut": "7000",
					  "extendedTimeOut": "1000",
					  "showEasing": "swing",
					  "hideEasing": "linear",
					  "showMethod": "fadeIn",
					  "hideMethod": "fadeOut"
			}
			toastr[shortCutFunction](msg,"提示");
		 }
	</script>

</body>
</html>