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

package com.liferay.revisited.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.revisited.service.EmployeeServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * <code>EmployeeServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>com.liferay.revisited.model.EmployeeSoap</code>. If the method in the
 * service utility returns a
 * <code>com.liferay.revisited.model.Employee</code>, that is translated to a
 * <code>com.liferay.revisited.model.EmployeeSoap</code>. Methods that SOAP
 * cannot safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeServiceHttp
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class EmployeeServiceSoap {

	public static com.liferay.revisited.model.EmployeeSoap addEmployee(
			String name, String address, String phoneNumber, long salary,
			String emailAddress)
		throws RemoteException {

		try {
			com.liferay.revisited.model.Employee returnValue =
				EmployeeServiceUtil.addEmployee(
					name, address, phoneNumber, salary, emailAddress);

			return com.liferay.revisited.model.EmployeeSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.revisited.model.EmployeeSoap getEmployeeById(
			long employeeId)
		throws RemoteException {

		try {
			com.liferay.revisited.model.Employee returnValue =
				EmployeeServiceUtil.getEmployeeById(employeeId);

			return com.liferay.revisited.model.EmployeeSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.revisited.model.EmployeeSoap[] getEmployees(
			int startIndex, int lastIndex)
		throws RemoteException {

		try {
			java.util.List<com.liferay.revisited.model.Employee> returnValue =
				EmployeeServiceUtil.getEmployees(startIndex, lastIndex);

			return com.liferay.revisited.model.EmployeeSoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static int getEmployeesCount() throws RemoteException {
		try {
			int returnValue = EmployeeServiceUtil.getEmployeesCount();

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(EmployeeServiceSoap.class);

}