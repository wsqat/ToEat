<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor" %>  
<s:if test="#session.isLogin == null">
<script>
(function() { 
		//alert('登陆后才可以浏览其他页面！');
		//history.go(-1);
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
<meta http-equiv="expires" content="0">
<title>ToEatServer</title>
<base href="<%=basePath%>">
<link href="<%=path%>/css/svw_style.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="<%=path%>/js/jquery-1.8.3.min.js"></script> 
<script type="text/javascript" src="<%=path%>/js/jquery-ui.min.js"></script> 
<script type="text/javascript" src="<%=path%>/js/showhide.js"></script>  
<script type="text/JavaScript" src="<%=path%>/js/jquery.mousewheel.js"></script> 

<!-- validationEngine -->
<link rel="stylesheet" href="<%=path%>/css/validationEngine.jquery.css" type="text/css"/>
<script src="<%=path%>/js/jquery.validationEngine-en.js" type="text/javascript" charset="utf-8"></script>
<script src="<%=path%>/js/jquery.validationEngine.js" type="text/javascript" charset="utf-8"></script>
<script src="<%=path%>/article/ckeditor/ckeditor.js"></script>
<script src="<%=path%>/article/ckeditor/adapters/jquery.js"></script>
<%-- <script src="<%=path%>/js/articleEdit.js"></script> --%>
<%-- <script type="text/javascript">
$(document).ready(function(){
	$("#content").ckeditor();//控件1
	$("#articleform").validationEngine();
});
</script> --%> 

<c:set var="con" value="${article.content}"/>

<script type="text/javascript">
    var editor = null;
    window.onload = function(){
        editor = CKEDITOR.replace('content',{
        	toolbar : 'Basic'
        }); //参数‘content’是textarea元素的name属性值，而非id属性值
        /* //$("#content").val("${con}"); */
    }
</script>
</head>

<body id="subpage">

<div id="svw_header_wrapper">
	<%@ include file="/cheader.jsp"%>
</div>	<!-- END of svw_header_wrapper -->

<br/>

<!-- Body Main -->
<div class="container">
    <div class="row">
        <div class="col-lg-10 col-lg-offset-1">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">文章发布</h3>
                </div>
                <div class="panel-body">
                    <form class="form-horizontal col-lg-12" id="articleform" role="form" method="post" 
	                    <c:choose>
		    			<c:when test="${!empty article}">
		    				name="update" action="ArticleUpdateUpdate.action"
		    			</c:when>
		    			<c:otherwise>
		    				name="add" action="ArticleAdd.action"
		    			</c:otherwise>
		    			</c:choose>
	                    enctype ="multipart/form-data" >
                        <div class="form-group">
                            <label class="col-lg-1 control-label">类别</label>
                            <div class="col-lg-4">
                                <select name="ArticleCategoryId" class="form-control">
                            		<c:choose>  
									   <c:when test="${article.articlecategory.id==1}"><option value="1" selected="selected">养生保健延寿类</option>  
									   </c:when>  
									   <c:otherwise><option value="1">养生保健延寿类</option>  
									   </c:otherwise>  
									</c:choose>
									<c:choose>  
									   <c:when test="${article.articlecategory.id==2}"><option value="2" selected="selected">美容美发类</option>  
									   </c:when>  
									   <c:otherwise><option value="2">美容美发类</option>  
									   </c:otherwise>  
									</c:choose>
                                    <c:choose>  
									   <c:when test="${article.articlecategory.id==3}"><option value="3" selected="selected">祛邪治病类</option>  
									   </c:when>  
									   <c:otherwise><option value="3">祛邪治病类</option> 
									   </c:otherwise>  
									</c:choose>
									<c:choose>  
									   <c:when test="${article.articlecategory.id==5}"><option value="5" selected="selected">补益气血药膳</option>  
									   </c:when>  
									   <c:otherwise><option value="5">补益气血药膳</option>  
									   </c:otherwise>  
									</c:choose>
									<c:choose>  
									   <c:when test="${article.articlecategory.id==6}"><option value="6" selected="selected">增白祛斑药膳</option>  
									   </c:when>  
									   <c:otherwise><option value="6">增白祛斑药膳</option>  
									   </c:otherwise>  
									</c:choose>
									<c:choose>  
									   <c:when test="${article.articlecategory.id==7}"><option value="7" selected="selected">祛寒药膳</option>  
									   </c:when>  
									   <c:otherwise><option value="7">祛寒药膳</option>  
									   </c:otherwise>  
									</c:choose>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="good" class="col-lg-1 control-label">标题</label>
                            <div class="col-lg-4">
                                <input name="title" type="text" class="form-control"  value="${article.title}" placeholder="文章标题" class="validate[required] required input_field">
                            </div>
                        </div>
						<div class="form-group">
                            <label for="textarea" class="col-lg-1 control-label">内容</label>
                            <div class="col-lg-10">
                                <textarea name="content" id="content" rows="10">${article.content}</textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-lg-offset-2 col-lg-4">
                                <button type="submit" class="btn btn-primary btn-block">提交</button>
                            </div>
                        </div>
                    </form>

                </div>
            </div>
        </div>
    </div>
</div>
    
<!-- END of container --> <!-- END of tempatemo_bottom_wrapper -->

<div id="svw_footer_wrapper">
    <%@ include file="/cfooter.jsp"%>
</div> <!-- END of svw_footer -->

</body>
</html>