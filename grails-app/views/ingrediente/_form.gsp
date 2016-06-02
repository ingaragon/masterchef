<%@ page import="cocina.Ingrediente" %>



<div class="fieldcontain ${hasErrors(bean: ingredienteInstance, field: 'cantidad', 'error')} required">
	<label for="cantidad">
		<g:message code="ingrediente.cantidad.label" default="Cantidad" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="cantidad" value="${fieldValue(bean: ingredienteInstance, field: 'cantidad')}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: ingredienteInstance, field: 'tipoIngrediente', 'error')} required">
	<label for="tipoIngrediente">
		<g:message code="ingrediente.tipoIngrediente.label" default="Tipo Ingrediente" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="tipoIngrediente" name="tipoIngrediente.id" from="${cocina.TipoIngrediente.list()}" optionKey="id" required="" value="${ingredienteInstance?.tipoIngrediente?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: ingredienteInstance, field: 'tipoMedida', 'error')} required">
	<label for="tipoMedida">
		<g:message code="ingrediente.tipoMedida.label" default="Tipo Medida" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="tipoMedida" name="tipoMedida.id" from="${cocina.TipoMedida.list()}" optionKey="id" required="" value="${ingredienteInstance?.tipoMedida?.id}" class="many-to-one"/>

</div>

