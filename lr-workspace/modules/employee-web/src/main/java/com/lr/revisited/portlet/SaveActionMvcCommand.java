package com.lr.revisited.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.revisited.service.EmployeeService;
import com.lr.revisited.constants.EmployeeControllerPortletKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = 
      { "javax.portlet.name=" + EmployeeControllerPortletKeys.EMPLOYEECONTROLLER,
		"mvc.command.name=saveEmployee" },
 
		service = MVCActionCommand.class)
public class SaveActionMvcCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		
		String name = ParamUtil.get(actionRequest, "name", "");
		String address = ParamUtil.get(actionRequest, "address", "");
		String phoneNo = ParamUtil.get(actionRequest, "phoneNo", "");
		long salary = ParamUtil.get(actionRequest, "salary", 0);
		String emailAddress = ParamUtil.get(actionRequest, "emailAddress", "");
		String dol = ParamUtil.get(actionRequest, "dol", "");
		String doj = ParamUtil.get(actionRequest, "doj", "");
		
		System.out.println(name + " - " + address + " - " + phoneNo + " - " + salary + " - " + emailAddress + " - " +dol + " - " +doj);

		_employeeService.addEmployee(name, address, phoneNo, salary, emailAddress);
		
		System.out.println("SaveActionMvcCommand.doProcessAction()");
		
	}
	
	private EmployeeService _employeeService;

	@Reference(unbind = "-")
	protected void setEmployeeService(EmployeeService employeeService) {
	    _employeeService = employeeService;
	}

}
