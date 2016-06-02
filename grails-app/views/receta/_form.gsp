<%@ page import="cocina.Receta" %>



<div class="fieldcontain ${hasErrors(bean: recetaInstance, field: 'ingredientes', 'error')} ">
	<label for="ingredientes">
		<g:message code="receta.ingredientes.label" default="Ingredientes" />
		
	</label>
	<g:select name="ingredientes" from="${cocina.Ingrediente.list()}" multiple="multiple" optionKey="id" size="5" value="${recetaInstance?.ingredientes*.id}" class="many-to-many"/>

</div>

<div class="fieldcontain ${hasErrors(bean: recetaInstance, field: 'nombre', 'error')} required">
	<label for="nombre">
		<g:message code="receta.nombre.label" default="Nombre" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nombre" required="" value="${recetaInstance?.nombre}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: recetaInstance, field: 'tipoComida', 'error')} required">
	<label for="tipoComida">
		<g:message code="receta.tipoComida.label" default="Tipo Comida" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="tipoComida" name="tipoComida.id" from="${cocina.TipoComida.list()}" optionKey="id" required="" value="${recetaInstance?.tipoComida?.id}" class="many-to-one"/>

</div>

