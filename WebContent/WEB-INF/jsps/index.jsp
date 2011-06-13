<%@include file="/WEB-INF/jsps/commons/taglibs.jsp"%>
<%@ page isELIgnored="false"%>
<s:layout-render name="/WEB-INF/jsps/layout.jsp">
	<s:layout-component name="body">
		<div style="height: 200px;">
			<br />
			<s:link beanclass="org.grouptweets.action.SignInWithTwitterAction">
				<img src="img/sign-in-with-twitter-d.png" border="0" alt="" />
			</s:link>
		</div>
	</s:layout-component>
</s:layout-render>
