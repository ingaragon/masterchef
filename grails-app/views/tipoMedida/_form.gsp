<%@ page import="cocina.TipoMedida" %>



<div class="fieldcontain ${hasErrors(bean: tipoMedidaInstance, field: 'nombre', 'error')} required">
	<label for="nombre">
		<g:message code="tipoMedida.nombre.label" default="Nombre" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nombre" required="" value="${tipoMedidaInstance?.nombre}"/>

</div>

