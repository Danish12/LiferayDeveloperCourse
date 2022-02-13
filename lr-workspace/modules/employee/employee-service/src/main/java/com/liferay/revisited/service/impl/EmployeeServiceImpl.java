/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.revisited.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.revisited.model.Employee;
import com.liferay.revisited.service.base.EmployeeServiceBaseImpl;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the employee remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.liferay.revisited.service.EmployeeService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeServiceBaseImpl
 */
@Component(property = { "json.web.service.context.name=lr",
		"json.web.service.context.path=Employee" }, service = AopService.class)
public class EmployeeServiceImpl extends EmployeeServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use
	 * <code>com.liferay.revisited.service.EmployeeServiceUtil</code> to access the
	 * employee remote service.
	 */

	public Employee addEmployee(String name, String address, String phoneNumber, long salary, String emailAddress) {

		// TODO PERMISSION CHECKER

		return employeeLocalService.addEmployee(name, address, phoneNumber, salary, emailAddress);
	}
	
	public Employee getEmployeeById(long employeeId) throws PortalException {

		return employeeLocalService.getEmployee(employeeId);
	}

	public List<Employee> getEmployees(int startIndex, int lastIndex) {
		List<Employee> employees = new ArrayList<Employee>();

		employees = employeeLocalService.getEmployees(startIndex, lastIndex);

		return employees;

	}

	public int getEmployeesCount() {

		return employeeLocalService.getEmployeesCount();

	}
}