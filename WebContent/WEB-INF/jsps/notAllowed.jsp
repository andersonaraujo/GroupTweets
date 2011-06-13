<%@ page isELIgnored="false"%>
<%@ taglib prefix="s" uri="http://stripes.sourceforge.net/stripes.tld"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>

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
		<div class="boxHome">
			<h2><fmt:message key="label.permission.denied" /></h2>
			<br />
			<fmt:message key="label.permission.denied.semacesso"/>
			<br/><br/>
			<p><a onclick="javascript:gohome()"><fmt:message key="label.back"/></a></p>
		</div>
	</s:layout-component>
</s:layout-render>
