
<%@ page import="cocina.Ingrediente" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'ingrediente.label', default: 'Ingrediente')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-ingrediente" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-ingrediente" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list ingrediente">
			
				<g:if test="${ingredienteInstance?.cantidad}">
				<li class="fieldcontain">
					<span id="cantidad-label" class="property-label"><g:message code="ingrediente.cantidad.label" default="Cantidad" /></span>
					
						<span class="property-value" aria-labelledby="cantidad-label"><g:fieldValue bean="${ingredienteInstance}" field="cantidad"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${ingredienteInstance?.tipoIngrediente}">
				<li class="fieldcontain">
					<span id="tipoIngrediente-label" class="property-label"><g:message code="ingrediente.tipoIngrediente.label" default="Tipo Ingrediente" /></span>
					
						<span class="property-value" aria-labelledby="tipoIngrediente-label"><g:link controller="tipoIngrediente" action="show" id="${ingredienteInstance?.tipoIngrediente?.id}">${ingredienteInstance?.tipoIngrediente?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${ingredienteInstance?.tipoMedida}">
				<li class="fieldcontain">
					<span id="tipoMedida-label" class="property-label"><g:message code="ingrediente.tipoMedida.label" default="Tipo Medida" /></span>
					
						<span class="property-value" aria-labelledby="tipoMedida-label"><g:link controller="tipoMedida" action="show" id="${ingredienteInstance?.tipoMedida?.id}">${ingredienteInstance?.tipoMedida?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:ingredienteInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${ingredienteInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
