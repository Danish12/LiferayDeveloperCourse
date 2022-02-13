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
import com.liferay.revisited.model.Employee;
import com.liferay.revisited.model.impl.EmployeeImpl;
import com.liferay.revisited.service.base.EmployeeLocalServiceBaseImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the employee local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.liferay.revisited.service.EmployeeLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.liferay.revisited.model.Employee", service = AopService.class)
public class EmployeeLocalServiceImpl extends EmployeeLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use
	 * <code>com.liferay.revisited.service.EmployeeLocalService</code> via injection
	 * or a <code>org.osgi.util.tracker.ServiceTracker</code> or use
	 * <code>com.liferay.revisited.service.EmployeeLocalServiceUtil</code>.
	 */
	
	
	public Employee addEmployee(String name, String address, String phoneNumber, long salary, String emailAddress) {
		Employee employee = new EmployeeImpl();
		
		employee.setAddress(address);
		employee.setPhoneNo(phoneNumber);
		employee.setSalary(salary);
		employee.setEmailAddress(emailAddress);
		employee.setName(name);
		
		long employeeId = counterLocalService.increment(Employee.class.getName());
		employee.setEmployeeId(employeeId );
		
		employeeLocalService.addEmployee(employee);
		
		
		return employee;
	}
	
}