<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'calendarioAcademico.label', default: 'CalendarioAcademico')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#edit-calendarioAcademico" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="edit-calendarioAcademico" class="content scaffold-edit" role="main">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.calendarioAcademico}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.calendarioAcademico}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form resource="${this.calendarioAcademico}" method="PUT">
                <g:hiddenField name="version" value="${this.calendarioAcademico?.version}" />
                <fieldset class="form">
                    <input class="save" type="submit" value="${message(code: 'default.button.update.label', default: 'Update')}" />
                    <table> 
                        <tr>
                            <td>Anio</td>
                            <td colspan=2><g:textField name="anio" value="${this.calendarioAcademico?.anio}" /></td>
                        </tr>

                        <tr>
                            <td>Primer cuatrimestre</td>
                            <td>Inicio: <g:textField name="primerCuatrimestre.semanaInicio" value="${this.calendarioAcademico?.primerCuatrimestre.semanaInicio}" /></td>
                            <td>Duracion: <g:textField name="primerCuatrimestre.semanasDuracion" value="${this.calendarioAcademico?.primerCuatrimestre.semanasDuracion}" /></td>
                        </tr>
                        <tr>
                            <td>Segundo cuatrimestre</td>
                            <td>Inicio: <g:textField name="segundoCuatrimestre.semanaInicio" value="${this.calendarioAcademico?.segundoCuatrimestre.semanaInicio}" /></td>
                            <td>Duracion: <g:textField name="segundoCuatrimestre.semanasDuracion" value="${this.calendarioAcademico?.segundoCuatrimestre.semanasDuracion}" /></td>
                        </tr>
                    </table>
                    <!-- <f:all bean="calendarioAcademico"/> -->
                </fieldset>
                <fieldset class="buttons">
                    <input class="save" type="submit" value="${message(code: 'default.button.update.label', default: 'Update')}" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
