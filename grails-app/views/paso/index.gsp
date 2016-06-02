
<%@ page import="cocina.Paso" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'paso.label', default: 'Paso')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-paso" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-paso" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="descripcion" title="${message(code: 'paso.descripcion.label', default: 'Descripcion')}" />
					
						<g:sortableColumn property="numeroPaso" title="${message(code: 'paso.numeroPaso.label', default: 'Numero Paso')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${pasoInstanceList}" status="i" var="pasoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${pasoInstance.id}">${fieldValue(bean: pasoInstance, field: "descripcion")}</g:link></td>
					
						<td>${fieldValue(bean: pasoInstance, field: "numeroPaso")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${pasoInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
