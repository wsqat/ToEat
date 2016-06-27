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
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<script src="js/articleList.js"></script>
</head>

<body data-spy="scroll" data-target="#myScrollspy">
<%@ include file="/cheader.jsp"%>
<link href="css/articleContent.css" rel="stylesheet" type="text/css" />
<!-- Body Main -->
<div class="container">
    <div class="jumbotron">
        <img src="images/hfutphoto1.jpg" alt="合肥工业大学--金药食网网" id="bg">
        <h1>你好 欢迎来到金药食网！</h1>
        <p style="color: #5bc0de">这里是金药食网，专注于养生美食信息！</p>
        <p><a href="#" class="btn btn-primary" role="button">阅读使用说明</a></p>
    </div>
    <div class="row">
	            <div class="col-xs-10 col-xs-offset-1" style="margin-bottom:20px;box-shadow:3px 3px 8px #000;">
					<div class="media">
		            	<div class='media-body' >
		                	<h3 class='media-heading' style="margin-top:10px;margin-bottom:10px">${article.user.name}<small>&nbsp;&nbsp;发表于${fn:substring(article.editTime,0,19)}</small></h3>
		                	<p><b>文章标题：</b>${article.title}</p>
		                	<p><b>文章类型：</b>${article.articlecategory.name}</p>
		                	<p><b>文章内容：</b>${article.content}</p>
						</div>
						<br/>
					
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
	            
	            <!-- 评论 -->
	            <c:forEach items="${relatedComments}" var="comment">
	            <div class="col-xs-10 col-xs-offset-1" style="margin-bottom:10px;box-shadow:3px 3px 8px #000;">
		            <div class="media">
	               		<div class="form-group" style="margin-top:10px;">
	                    	<div class="col-sm-12">${comment.content}</div>
	               		</div>
	               		<a class='btn btn-small pull-left' href="javascript:if(confirm('Are you sure to Delete?'))location='CommentDelete.action?commentId=${comment.id}'"><s:property value="%{getText('video.delete')}"/></a></p>
		                <div class="form-group pull-right">
		                    <div class="col-sm-12">
		                    	
		                        <h4 class='media-heading' style="margin-top:10px;">${comment.user.name}<small>&nbsp;&nbsp;发表于${fn:substring(comment.editTime,0,19)}</small></h3>
		                    </div>
		                    
		                </div>
			        </div>
			    </div>
		        </c:forEach>
		        
		        <div class="col-xs-10 col-xs-offset-1" style="margin-bottom:20px;box-shadow:3px 3px 8px #000;">
			        <div class="media">
	            		<form class="form-horizontal publish" role="form" action="CommentAdd.action" method="post">
	                		<input type="hidden" name="articleId" value="${article.id}">
	                		<div class="form-group">
		                    	<div class="col-sm-12">
		                    	    <textarea name="content" class="form-control" rows="3" placeholder="我要说点啥……"></textarea>
		                    	</div>
	                		</div>
			                <div class="form-group">
			                    <div class="col-sm-12">
			                        <button id="publish" class="btn btn-info">发表评论</button>
			                    </div>
			                </div>
			            </form>
			        </div>
			    </div>
	</div>
</div>
<!-- END of Body Main -->

 <!-- END of svw_bottom_wrapper -->

<div id="svw_footer_wrapper">
    <%@ include file="/cfooter.jsp"%>
</div>

</body>
</html>