
<%@ page import="cocina.Receta" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main">
        <g:set var="entityName" value="${message(code: 'receta.label', default: 'Receta')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <div id="show-receta" class="content scaffold-show" role="main">
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <ol class="property-list receta">
                <g:if test="${recetaInstance?.nombre}">
                    <h2><g:fieldValue bean="${recetaInstance}" field="nombre"/></h2>
                </g:if>

                <g:if test="${recetaInstance?.ingredientes}">
                    <h3><g:message code="receta.ingredientes.label"/></h3>
                    <table class="table">
                        <thead>
                            <tr>
                                <th><g:message code="receta.ingrediente.cantidad.label"/></th>
                                <th><g:message code="receta.ingrediente.nombre.label"/></th>
                            </tr>
                        </thead>
                        <tbody>
                            <g:each in="${recetaInstance.ingredientes}" status="i" var="ingredienteInstance">
                                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                                    <td>${fieldValue(bean: ingredienteInstance, field: "cantidad")}</td>
                                    <td>${fieldValue(bean: ingredienteInstance, field: "tipoIngrediente.nombre")}</td>
                                </tr>
                            </g:each>
                        </tbody>
                    </table>
                </g:if>
            </ol>
            
            <ol class="property-list receta">
                
            </ol>
            
            <sec:ifAllGranted roles="ROLE_SUPERADMIN">
                <g:form url="[resource:recetaInstance, action:'delete']" method="DELETE">
                    <fieldset class="buttons">
                        <g:link class="edit" action="edit" resource="${recetaInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                        <g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                    </fieldset>
                </g:form>
            </sec:ifAllGranted>
        </div>
