
<%@ page import="cocina.Receta" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main">
        <g:set var="entityName" value="${message(code: 'receta.label', default: 'Receta')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <div id="list-receta" class="content scaffold-list" role="main">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <table class="table">
                <thead>
                    <tr>
                        <g:sortableColumn property="nombre" title="${message(code: 'receta.nombre.label')}" />
                        <th><g:message code="receta.tipoComida.label" default="Tipo Comida" /></th>
                    </tr>
                </thead>
                <tbody>
                    <g:each in="${recetaInstanceList}" status="i" var="recetaInstance">
                        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                            <td><g:link action="show" id="${recetaInstance.id}">${fieldValue(bean: recetaInstance, field: "nombre")}</g:link></td>
                            <td>${fieldValue(bean: recetaInstance, field: "tipoComida.nombre")}</td>
                        </tr>
                    </g:each>
                </tbody>
            </table>
            <div class="pagination">
                <g:paginate total="${recetaInstanceCount ?: 0}" />
            </div>
        </div>
    </body>
</html>
