package com.lr.revisited.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.revisited.service.EmployeeService;
import com.lr.revisited.constants.EmployeeControllerPortletKeys;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + EmployeeControllerPortletKeys.EMPLOYEECONTROLLER,
				"mvc.command.name=/create/edit"
		}
		)
public class CreateEditRenderMvcCommand implements MVCRenderCommand{

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		long employeeId = ParamUtil.getLong(renderRequest, "employeeId", 0);
		
		if(employeeId > 0) {
			try {
				renderRequest.setAttribute("employee", _employeeService.getEmployeeById(employeeId));
			} catch (PortalException e) {
				e.printStackTrace();
			}
		}
		
		return "/edit.jsp";
	}

	
	private EmployeeService _employeeService;

	@Reference(unbind = "-")
	protected void setEmployeeService(EmployeeService employeeService) {
	    _employeeService = employeeService;
	}

}
