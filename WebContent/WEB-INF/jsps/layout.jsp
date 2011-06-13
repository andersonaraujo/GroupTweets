<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@include file="/WEB-INF/jsps/commons/taglibs.jsp" %>

<%-- Short hand for the context root. --%>
<c:set var="ctx" scope="page">${pageContext.request.contextPath}</c:set>

<s:layout-definition>
	<fmt:bundle basename="StripesResources">
		<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
		<html xmlns="http://www.w3.org/1999/xhtml">

			<head>
				<meta http-equiv="content-type" content="text/html; charset=utf-8" />
				<s:layout-component name="head"/>
				<title><fmt:message key="label.topbanner.title"/> | <fmt:message key="label.topbanner.subtitle"/></title>
				<link href="css/estilo.css" rel="stylesheet" type="text/css">
				<meta name="keywords" content="" />
				<meta name="description" content="<fmt:message key="label.topbanner.subtitle"/>" />
				<script language="Javascript1.2" type="text/javascript">
					<!--//
					var ajaxError = '<fmt:message key="message.ajaxerror" />';
					var msgConfirmRemove = "<fmt:message key='message.confirmdelete'/>";
					var msgConfirm = "<fmt:message key='message.confirm'/>";
					var caminhoImagem = "${ctx}/img/loadingAnimation.gif";
					//-->
				</script>
				<s:layout-component name="meta" />
			</head>

			<body>
				<!--INICIO GERAL -->
				<div id="geral">

					<!--INICIO MAE -->
					<div id="mae">

						<div class="clear"></div>
						<s:layout-component name="avisos" />

						<div class="clear"></div>
						<div class="grid_16" style="color: red;">
							<s:errors globalErrorsOnly="true"/>
						</div>

						<div class="grid_16" style="color: green;">
							<strong><s:messages/></strong>
						</div>
						<div class="clear"></div>

						<!--INICIO CONTEUDO -->
						<div id="conteudo">
							<s:layout-component name="body">
								<jsp:include page="/incl/empty.html"/>
							</s:layout-component>
						</div>
						<!--FIM CONTEUDO -->

					<!--FIM MAE -->
					</div>

				<!--FIM GERAL -->
				</div>

				<!--INICIO RODAPE -->
				<s:layout-component name="footer">
				    <div id="rodape">
				    	<!-- <fmt:message key="message.copyright" /> -->
					</div>
				</s:layout-component>
				<!--FIM RODAPE -->

			</body>
		</html>
	</fmt:bundle>
</s:layout-definition>