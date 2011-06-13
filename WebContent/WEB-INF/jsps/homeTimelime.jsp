<%@include file="/WEB-INF/jsps/commons/taglibs.jsp"%>
<%@ page isELIgnored="false"%>
<s:layout-render name="/WEB-INF/jsps/layout.jsp">
	<s:layout-component name="body">
		<div style="height: 200px;">
			<br />
			<c:forEach var="row" items="${actionBean.homeTimelineList}" varStatus="status">
				<img src="${row.user.profileImageURL}" />&nbsp;<b>${row.user.screenName}</b>&nbsp;-&nbsp;${row.user.name}</br>
				${row.text}<br />
				================================================<br />
			</c:forEach>
		</div>
	</s:layout-component>
</s:layout-render>
