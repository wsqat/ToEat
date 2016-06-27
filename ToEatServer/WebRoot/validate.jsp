<%	
	/* 登录验证 */
	String isLoginFlag = null;
	if(request.getSession().getAttribute("isLogin")!=null)
		isLoginFlag = request.getSession().getAttribute("isLogin").toString();
	if(!isLoginFlag.equals("true")){
%>
	<script type="text/javascript">
	function invalidate() {
		alert('登录后才可以浏览其他页面！'); 
	}
	invalidate();
	</script>
<%
		response.sendRedirect("login.jsp");
	}
%>

