package practice.employee.dao;

import practice.employee.domain.Department;
import practice.employee.domain.Employee;

/**
 * Created by jrout on 7/31/16.
 */
public interface IEmployeeDAO {
    Employee fetchEmployee(int empId);
    Department fetchEmpDepartment(int empId);
}
