
<%@ page import="cocina.Receta" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'receta.label', default: 'Receta')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-receta" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-receta" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list receta">
			
				<g:if test="${recetaInstance?.ingredientes}">
				<li class="fieldcontain">
					<span id="ingredientes-label" class="property-label"><g:message code="receta.ingredientes.label" default="Ingredientes" /></span>
					
						<g:each in="${recetaInstance.ingredientes}" var="i">
						<span class="property-value" aria-labelledby="ingredientes-label"><g:link controller="ingrediente" action="show" id="${i.id}">${i?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${recetaInstance?.nombre}">
				<li class="fieldcontain">
					<span id="nombre-label" class="property-label"><g:message code="receta.nombre.label" default="Nombre" /></span>
					
						<span class="property-value" aria-labelledby="nombre-label"><g:fieldValue bean="${recetaInstance}" field="nombre"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${recetaInstance?.tipoComida}">
				<li class="fieldcontain">
					<span id="tipoComida-label" class="property-label"><g:message code="receta.tipoComida.label" default="Tipo Comida" /></span>
					
						<span class="property-value" aria-labelledby="tipoComida-label"><g:link controller="tipoComida" action="show" id="${recetaInstance?.tipoComida?.id}">${recetaInstance?.tipoComida?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:recetaInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${recetaInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
