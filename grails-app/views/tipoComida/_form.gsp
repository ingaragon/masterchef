<%@ page import="cocina.TipoComida" %>



<div class="fieldcontain ${hasErrors(bean: tipoComidaInstance, field: 'nombre', 'error')} required">
	<label for="nombre">
		<g:message code="tipoComida.nombre.label" default="Nombre" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nombre" required="" value="${tipoComidaInstance?.nombre}"/>

</div>

