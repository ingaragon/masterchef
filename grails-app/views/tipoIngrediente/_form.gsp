<%@ page import="cocina.TipoIngrediente" %>



<div class="fieldcontain ${hasErrors(bean: tipoIngredienteInstance, field: 'nombre', 'error')} required">
	<label for="nombre">
		<g:message code="tipoIngrediente.nombre.label" default="Nombre" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nombre" required="" value="${tipoIngredienteInstance?.nombre}"/>

</div>

