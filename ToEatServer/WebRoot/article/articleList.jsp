<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<s:if test="#session.isLogin == null">
<script>
(function() { 
		alert('登陆后才可以浏览其他页面！');
		history.go(-1);
	})(); 
</script>
</s:if>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Video, FFmpeg, JavaEE" />
<meta name="author" content="sage_wang" />
<meta name="description" content="The ToEatServer based on JavaEE and FFmpeg" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<%-- <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script> --%>
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<script src="js/articleList.js"></script>
</head>

<body data-spy="scroll" data-target="#myScrollspy">
<%@ include file="/cheader.jsp"%>
<link href="css/articleList.css" rel="stylesheet" type="text/css" />
<!-- Body Main -->
<div class="container">
    <div class="jumbotron">
        <img src="images/hfutphoto1.jpg" alt="合肥工业大学--金药食网网" id="bg">
        <h1>你好 欢迎来到金药食网！</h1>
        <p style="color: #5bc0de">这里是金药食网，专注于养生美食信息！</p>
        <p><a href="#" class="btn btn-primary" role="button">阅读使用说明</a></p>
    </div>
    <div class="row">
    	<h2><s:property value="%{getText('article.list')}"/> <a class="btn btn-primary" href="ArticleAddPage.action"><s:property value="%{getText('video.add')}"/></a></h2>
            
	            <%-- <span ><b><s:property value="%{getText('video.listmanage')}"/></b></span> --%>
	             <p></p>
	            
            
            <c:if test="${empty resultarticle}">
            <p><s:property value="%{getText('article.listempty')}"/></p>
            <div style="height:300px;"></div>
            </c:if>
            <c:forEach items="${resultarticle}" var="article">
	            <div class="col-xs-8 col-xs-offset-2" style="margin-bottom:20px;box-shadow:3px 3px 8px #000;">
					<div class="media">
		            	<div class='media-body' >
		                	<h3 class='media-heading' style="margin-top:10px;margin-bottom:10px">${article.user.name}<small>&nbsp;&nbsp;发表于${fn:substring(article.editTime,0,19)}</small></h3>
		                	<p><b>文章标题：</b>${article.title}</p>
		                	<p><b>文章类型：</b>${article.articlecategory.name}</p>
		                	<p><b>文章内容：</b>${article.content}</p>
						</div>
						<br/>
					<a class='btn btn-primary pull-left' href="ArticleReadByID.action?articleId=${article.id}"><s:property value="%{getText('video.content')}"/></a>
                	<a class='pull-left'>&nbsp;</a>
                	<a class='btn btn-primary pull-left' href="ArticleUpdateRead.action?articleId=${article.id}"><s:property value="%{getText('video.edit')}"/></a>
                	<a class='pull-left'>&nbsp;</a>
                	<a class='btn btn-primary pull-left' href="javascript:if(confirm('Are you sure to Delete?'))location='ArticleDelete.action?articleId=${article.id}'"><s:property value="%{getText('video.delete')}"/></a></p>
		            <a href='#' class='btn btn-primary pull-right' role='button'>点赞</a>
		            <a class='pull-right'>&nbsp;</a>
		            <a href='#' class='btn btn-primary pull-right' role='button'>评论</a>
		        	</div>
	        	</div>
	            <h4 class="center"></h4>
	            <br/>
            </c:forEach>
	</div>
</div>
<!-- END of Body Main -->

 <!-- END of svw_bottom_wrapper -->

<div id="svw_footer_wrapper">
    <%@ include file="/cfooter.jsp"%>
</div>

</body>
</html>