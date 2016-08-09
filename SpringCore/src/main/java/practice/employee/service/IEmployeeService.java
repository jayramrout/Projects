package practice.employee.service;

import practice.employee.domain.Employee;

/**
 * Created by jrout on 7/31/16.
 */
public interface IEmployeeService {
    Employee fetchEmployeeWithBonus(int empId);
}
