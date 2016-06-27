<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Video, FFmpeg, JavaEE" />
<meta name="author" content="sage_wang" />
<meta name="description" content="The ToEatServer based on JavaEE and FFmpeg" />
<link href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet">
<link href="css/login.css" rel="stylesheet">
<title>ToEatServer</title>
</head>

<body id="subpage">

<div id="svw_header_wrapper">
	<%@ include file="/cheader.jsp"%>
</div>	<!-- END of svw_header_wrapper -->
	<%-- <center>
		<!-- 表单标签 -->
		<s:form action="Login" namespace="/">
			<s:textfield name="user.phone" label="手机号"></s:textfield>
			<s:password name="user.password" label="密码"></s:password>
			<s:submit value="登 录"></s:submit>
		</s:form>
	</center> --%>
	<br><br><br><br><br><br>
<!-- Body Main -->
<div class="container">
    <div class="col-sm-6  col-sm-offset-3">
        <!-- 表单标签 -->
		<s:form  class="form-horizontal" id="logform" role="form" action="Login" namespace="/">
            <div class="form-group">
                <label for="phone" class="col-sm-2 control-label">手机</label>
                <div class="col-sm-7">
                    <input type="tel" class="form-control" name="user.phone" id="tel" autofocus="autofocus" placeholder="手机">
                    <span class="help-inline help">手机格式不正确</span>
                </div>
            </div>
            <br><br><br>
            <div class="form-group">
                <label for="password" class="col-sm-2 control-label">密码</label>

                <div class="col-sm-7">
                    <input type="password" class="form-control" name="user.password" id="password" placeholder="密码">
                    <span class="help-inline help">密码不正确</span>
                </div>
            </div>
			<br><br><br>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-7">
                    <button id="log" type="submit" class="btn btn-block btn-primary">登录</button>
                </div>
            </div>
        </s:form>
    </div>
</div>
	
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="http://cdn.bootcss.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<!-- END of Body Main -->

 <!-- END of svw_bottom_wrapper -->

<div id="svw_footer_wrapper" style="margin-top:300px;">
    <%@ include file="/cfooter.jsp"%>
</div> <!-- END of svw_footer -->

</body>
</html>