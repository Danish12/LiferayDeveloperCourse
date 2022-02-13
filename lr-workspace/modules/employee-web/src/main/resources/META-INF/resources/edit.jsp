<%@page import="com.liferay.revisited.model.Employee"%>
<%@ include file="/init.jsp" %>

<portlet:actionURL name="saveEmployee" var="saveEmployeeURL" >
	
</portlet:actionURL>

<h1>Create/Edit Employee Details</h1>

<aui:form name="fm" action="${saveEmployeeURL}">

    <aui:model-context bean="${employee}" model="<%= Employee.class %>"/>
	<aui:input name="name"> </aui:input>
	
	<aui:input name="address"> </aui:input>
	
	<aui:input name="phoneNo"> </aui:input>
	<aui:input name="salary"> </aui:input>
	<aui:input name="emailAddress"> </aui:input>
	<aui:input name="doj"> </aui:input>
	<aui:input name="dol"> </aui:input>
	
	<aui:button-row>
             <aui:button cssClass="btn btn-primary" type="submit" />
    </aui:button-row>
	

</aui:form>
