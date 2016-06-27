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

<title>ToEatServer</title>
</head>

<body id="subpage">

<div id="svw_header_wrapper">
	<%@ include file="/cheader.jsp"%>
</div>	<!-- END of svw_header_wrapper -->
<style type="text/css">
.container {font-family: 'Microsoft YaHei', 宋体, Tahoma, Helvetica, Arial, 宋体, sans-serif;}
.container a{color: #337ab7;text-decoration:none;}

</style>
<!-- Body Main -->
<div class="container">
    <h2>ToEatServer—关于</h2>
    <hr/>
    <h4><a href="http://localhost:8080/ToEatServer/" target="_blank">
		ToEatServer</a>本科生的毕业设计，基于Java Web SSH框架，用于进行视频上传、播放以及管理，为Android客户端提供服务~~~。</h4>
    <br/>
    <hr/>
    <h2>自我介绍</h2>
    <div class="col-lg-12">
        <div class="media">
            <div class="media-body">
                <h3 class="media-heading" style="color: #5cb85c">王世卿</h3>
                <h4>合肥工业大学12级软件工程专业本科生，技术宅，爱生活，爱音乐，这个ToEatServer是我的毕设的服务器端。</h4>
                <h4>CSDN博客: <a href="http://blog.csdn.net/sage_wang/">http://blog.csdn.net/sage_wang</a></h4>
                <h4>个人博客: <a href="http://blog.hfutfind.com/">http://blog.hfutfind.com/</a></h4>
            </div>
            <div class="media-right">
                <a href="http://blog.csdn.net/sage_wang/" target="_blank" title="王世卿的博客">
                    <img class="media-object" src="images/sage_wang.jpg" style="width: 100px; height: 100px; border-radius:10px;">
                </a>
            </div>
        </div>
    </div>
    <br/><br/>	
    <hr/>
    <br/>
    <hr/>
    <h2>架构介绍</h2>
    <div class="col-lg-12">
    	 <div class="media">
            <div class="media-body">
                <h3 class="media-heading" style="color: #5cb85c">前台：html+css+javascript</h3>
                <h4>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;使用了一些javascript插件，如首页灯笼式效果的CloudCarousel,
                	用于表单验证的jQuery Validation Engine等等。其中视频播放器用了FlowPlayer（包含了RTMP插件）来支持HTTP的点播和RTMP的直播。
                	还使用了Bootstrap前端框架的部分UI组件。</h4>
				<h3 class="media-heading" style="color: #5cb85c">后台：SSH框架</h3>
				<h4>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;使用Java EE系统中传统的三层架构: Action层, Service层以及DAO层。</h4>
				
				<h3 class="media-heading" style="color: #5cb85c">前后台数据交互：JSTL标签和EL表达式</h3>
				<h4>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;为了和国际化接轨, 还使用了Struts2的i18n方式, 将页面所有的参数抽离出来, 使用变量保存到不同的文件中, 如此一来,就可以实现国际化, 多种语言显示。</h4>
				
				<h3 class="media-heading" style="color: #5cb85c">相关线程：截取视频缩略图+视频转码</h3>
				<h4>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;网站部署到服务器上后, 系统自动运行两个线程, 上传视频后, 通过调用FFmpeg.exe程序, 定时处理截取视频缩略图, 再进行上传视频的转码。</h4>
            </div>
        </div>
    </div>
    <br/>
    <hr/>
</div>
<br/>
    
<!-- END of Body Main -->

 <!-- END of svw_bottom_wrapper -->

<div id="svw_footer_wrapper">
    <%@ include file="/cfooter.jsp"%>
</div> <!-- END of svw_footer -->

</body>
</html>