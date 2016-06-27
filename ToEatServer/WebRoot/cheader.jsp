<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<link href="css/common.css" rel="stylesheet" type="text/css" />
<link rel="shortcut icon" href="images/favicon.ico"/>
<link href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet">
<script src="http://cdn.bootcss.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    
    <nav class="navbar navbar-default navbar-fixed-top navbar-inverse" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-6">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" id="brand" href="Index.action">ToEatServer</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-6">
            <ul class="nav navbar-nav">
                <li class="active"><a href="Index.action"><s:property value="%{getText('index.index')}"/></a></li>
            	<li><a href="VideoReadAll.action?islive=0"><s:property value="%{getText('video.vod')}"/></a></li>
            	<li><a href="VideoReadAll.action?islive=1"><s:property value="%{getText('video.live')}"/></a></li>
            	<li><a href="ArticleReadAll.action"><s:property value="%{getText('article.nav')}"/></a></li>
                <li><a href="About.action"><s:property value="%{getText('about.about')}"/></a></li>
            	<li><a href="ConfigureUpdateRead.action"><s:property value="%{getText('configure.configure')}"/></a></li>
                <s:if test="#session.isLogin != null"><li><a href="Logout.action"><s:property value="%{getText('system.logout')}"/></a></li></s:if>
                <s:if test="#session.isLogin == null"><li><a href="login.jsp"><s:property value="%{getText('system.login')}"/></a></li></s:if>
                <li class="dropdown">
		          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><s:property value="%{getText('configure.language')}"/><span class="caret"></span></a>
		          <ul class="dropdown-menu">
		            <li><a href="Index.action?request_locale=en_US">English</a></li>
		            <li><a href="Index.action?request_locale=zh_US">简体中文</a></li>
		          </ul>
		        </li>
            </ul>
            <ul class="nav navbar-nav pull-right">
                <li>
                    <form class="navbar-form navbar-right" role="search" action="shi_info.php" method="post">
                        <div class="form-group">
                            <div class="input-group">
                            <div class="input-group-btn">
                                <select class="form-control" role="menu" name="item">
                                    <option value=""><s:property value="%{getText('video.all')}"/></option>
                                    <option value="点播"><s:property value="%{getText('video.vod')}"/></option>
                                    <option value="直播"><s:property value="%{getText('video.live')}"/></option>
                                </select>
                            </div>
                            <input type="text" name="search" class="form-control" placeholder="<s:property value="%{getText('video.search')}"/>">
                            <span class="input-group-btn">
                                <button type="submit" class="btn btn-primary btn-default"><s:property value="%{getText('video.searchBtn')}"/></button>
                            </span>
                            </div>
                        </div>
                    </form>
                </li>
            </ul>
        </div>
    </div>
</nav>
    
    