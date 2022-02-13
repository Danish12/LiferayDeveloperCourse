<%@ include file="/init.jsp" %>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<p>
	<b><liferay-ui:message key="employeecontroller.caption"/></b>
</p>

<portlet:renderURL var="createEditRender">
	<portlet:param name="mvcRenderCommandName" value="/create/edit"/>
</portlet:renderURL>

<a href="${createEditRender}" >Create Employee</a>
<liferay-ui:search-container delta="10" emptyResultsMessage="no-entries-were-found" total="${totalEmployees}">

        <liferay-ui:search-container-results  results="${entries}"/>
               <liferay-ui:search-container-row
                	className="com.liferay.revisited.model.Employee"
               		 keyProperty="employeeId" modelVar="entry" escapedModel="<%=true%>">
                		<liferay-ui:search-container-column-text property="name" />
               			<liferay-ui:search-container-column-text property="address" />
               			<liferay-ui:search-container-column-text property="phoneNo" />
               			<liferay-ui:search-container-column-text property="salary" />
               			<liferay-ui:search-container-column-text name="Action">
               					<portlet:renderURL var="editRender">
									<portlet:param name="mvcRenderCommandName" value="/create/edit"/>
									<portlet:param name="employeeId" value="${entry.employeeId}"/>
								</portlet:renderURL>
								<a href="${editRender}" > Edit </a>
               			</liferay-ui:search-container-column-text>
       			 </liferay-ui:search-container-row>
                <liferay-ui:search-iterator />
</liferay-ui:search-container>