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

package com.liferay.revisited.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EmployeeService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeService
 * @generated
 */
public class EmployeeServiceWrapper
	implements EmployeeService, ServiceWrapper<EmployeeService> {

	public EmployeeServiceWrapper(EmployeeService employeeService) {
		_employeeService = employeeService;
	}

	@Override
	public com.liferay.revisited.model.Employee addEmployee(
		String name, String address, String phoneNumber, long salary,
		String emailAddress) {

		return _employeeService.addEmployee(
			name, address, phoneNumber, salary, emailAddress);
	}

	@Override
	public com.liferay.revisited.model.Employee getEmployeeById(long employeeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeService.getEmployeeById(employeeId);
	}

	@Override
	public java.util.List<com.liferay.revisited.model.Employee> getEmployees(
		int startIndex, int lastIndex) {

		return _employeeService.getEmployees(startIndex, lastIndex);
	}

	@Override
	public int getEmployeesCount() {
		return _employeeService.getEmployeesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeService.getOSGiServiceIdentifier();
	}

	@Override
	public EmployeeService getWrappedService() {
		return _employeeService;
	}

	@Override
	public void setWrappedService(EmployeeService employeeService) {
		_employeeService = employeeService;
	}

	private EmployeeService _employeeService;

}