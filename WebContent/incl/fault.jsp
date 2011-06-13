<%@include file="/WEB-INF/jsps/commons/taglibs.jsp"%>
<%@ page isELIgnored="false"%>
<script language="Javascript1.2" type="text/javascript">
<!--//
	function gohome() {
  		history.go(-1);
	}
	setTimeout("gohome()", 5000);
//-->
</script>

<s:layout-render name="/WEB-INF/jsps/layout.jsp">
	<s:layout-component name="body">
		<h2><fmt:message key="global.error.message" /></h2>
		<br />
		<pre><c:out value="${exception.message}"></c:out></pre>
		<br />
		<br />
		<p><a onclick="javascript:gohome()"><fmt:message key="label.back" /></a></p>
	</s:layout-component>
</s:layout-render>
