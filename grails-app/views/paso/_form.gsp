<%@ page import="cocina.Paso" %>



<div class="fieldcontain ${hasErrors(bean: pasoInstance, field: 'descripcion', 'error')} required">
	<label for="descripcion">
		<g:message code="paso.descripcion.label" default="Descripcion" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="descripcion" required="" value="${pasoInstance?.descripcion}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: pasoInstance, field: 'numeroPaso', 'error')} required">
	<label for="numeroPaso">
		<g:message code="paso.numeroPaso.label" default="Numero Paso" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="numeroPaso" type="number" value="${pasoInstance.numeroPaso}" required=""/>

</div>

