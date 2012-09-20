<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title><fmt:message key="title.report03"/></title>
</head>

<body>

<script type="text/javascript">
    dojo.ready(function () {
        dojo.require("dijit.form.DateTextBox");

        reportForm.divisionId.value = defaultDivision;
        fillProjectListByDivision(reportForm.divisionId);

    });

    var projectList = ${projectListJson};
    var fullProjectList = ${fullProjectListJson};
    var defaultDivision = <sec:authentication property="principal.employee.division.id"/>;
    var employeeList = ${employeeListJson};

</script>

<h1><fmt:message key="title.reportparams"/></h1>
<h2><fmt:message key="title.report03"/></h2>
<br/>

<c:url value="/managertools/report/3" var="formUrl"/>
<form:form commandName="reportForm" method="post" action="${formUrl}" target="_blank">

    <c:if test="${fn:length(errors) > 0}">
        <div class="errors_box">
            <c:forEach items="${errors}" var="error">
                <fmt:message key="${error.code}">
                    <fmt:param value="${error.arguments[0]}"/>
                </fmt:message><br/>
            </c:forEach>
        </div>
    </c:if>

    <div id="form_header">
        <table class="report_params" cellspacing="3">
            <tr>
                <td><span class="label">Центр владельца проекта</span></td>
                <td><form:select id="divisionId" name="divisionId" cssClass="without_dojo"
                                 onmouseover="tooltip.show(getTitle(this));"
                                 onmouseout="tooltip.hide();" path="divisionId"
                                 onchange="fillProjectListByDivision(this)">
                    <form:option label="" value="0"/>
                    <form:options items="${divisionList}" itemLabel="name" itemValue="id"/>
                </form:select></td>
                <td colspan="2" align="right"><form:checkbox path="filterProjects" name="filterProjects"
                                                             id="filterProjects"
                                                             cssClass="checkbox_without_dojo"
                                                             onchange="fillProjectListByDivision()"
                                                             label="Показывать только проекты/пресейлы центра"/></td>
            </tr>
            <tr>

                <td><span class="label">Проект</span></td>
                <td><form:select id="projectId" name="projectId" cssClass="without_dojo"
                                 onmouseover="tooltip.show(getTitle(this));"
                                 onmouseout="tooltip.hide();" path="projectId">
                </form:select></td>
                <td><span class="label">Регион</span></td>
                <td><form:select id="regionId" name="regionId" cssClass="without_dojo"
                                 onmouseover="tooltip.show(getTitle(this));"
                                 onmouseout="tooltip.hide();" path="regionId">
                    <form:option label="Все" value="0"/>
                    <form:options items="${regionList}" itemLabel="name" itemValue="id"/>
                </form:select></td>
            </tr>
            <tr>
                <td><span class="label">Центр сотрудников</span></td>
                <td><form:select id="emplDivisionId" name="emplDivisionId" cssClass="without_dojo"
                                 onmouseover="tooltip.show(getTitle(this));"
                                 onmouseout="tooltip.hide();" path="emplDivisionId"
                                 onchange="fillEmployeeListByDivision(this)">
                    <form:option label="" value="0"/>
                    <form:options items="${divisionList}" itemLabel="name" itemValue="id"/>
                </form:select></td>
                <td><span class="label">Сотрудник</span></td>
                <td><form:select path="employeeId" id="employeeId" class="without_dojo"
                                 onmouseover="tooltip.show(getTitle(this));"
                                 onmouseout="tooltip.hide();">
                    <form:option label="" value="0"/>
                </form:select></td>
            </tr>
            <tr>
                <td><span class="label">Начало периода</span></td>
                <td><form:input path="beginDate" id="beginDate" name="beginDate" class="date_picker"
                                data-dojo-id="fromDate"
                                dojoType="dijit.form.DateTextBox"
                                required="false"
                                onmouseover="tooltip.show(getTitle(this));"
                                onmouseout="tooltip.hide();"
                                onChange="toDate.constraints.min = arguments[0];"/></td>
                <td><span class="label">Окончание периода</span></td>
                <td><form:input path="endDate" id="endDate" name="endDate" class="date_picker"
                                data-dojo-id="toDate"
                                dojoType="dijit.form.DateTextBox"
                                required="false"
                                onmouseover="tooltip.show(getTitle(this));"
                                onmouseout="tooltip.hide();"
                                onChange="fromDate.constraints.max = arguments[0];"/></td>
            </tr>
        </table>
        <div class="radiogroup">
            <div class="label"><fmt:message key="report.formattitle"/></div>
            <ul class="radio">
                <li><input type=radio name="printtype" id="printtype1" value="1" checked/><label
                        for="printtype1">HTML</label></li>
                <li><input type=radio name="printtype" id="printtype2" value="2"/><label for="printtype2">MS
                    Excel</label>
                </li>
                <li><input type=radio name="printtype" id="printtype3" value="3"/><label for="printtype3">PDF</label>
                </li>
            </ul>
        </div>

    </div>

    <button id="make_report_button" style="width:210px" type="submit">Сформировать отчет</button>
</form:form>
</body>

</html>