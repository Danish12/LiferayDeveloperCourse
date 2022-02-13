package com.lr.revisited.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.revisited.service.EmployeeService;
import com.lr.revisited.constants.EmployeeControllerPortletKeys;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Danish
 */

@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=EmployeeController", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + EmployeeControllerPortletKeys.EMPLOYEECONTROLLER,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class EmployeeControllerPortlet extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		int delta = ParamUtil.getInteger(renderRequest , "delta");
		int cur = ParamUtil.getInteger(renderRequest , "cur");
		int from = delta * (cur - 1 ) + 1;
		int to = delta == 0 ? 10 : delta * cur;		
		
		renderRequest.setAttribute("totalEmployees", _employeeService.getEmployeesCount());
		renderRequest.setAttribute("entries", _employeeService.getEmployees(from, to));

		super.doView(renderRequest, renderResponse);
	}

	private EmployeeService _employeeService;

	@Reference(unbind = "-")
	protected void setEmployeeService(EmployeeService employeeService) {
		_employeeService = employeeService;
	}

}