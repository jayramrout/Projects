package practice.employee.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import practice.employee.dao.IEmployeeDAO;
import practice.employee.dao.impl.EmployeeDAOImpl;
import practice.employee.domain.Employee;
import practice.employee.service.IEmployeeService;

import javax.annotation.Resource;

/**
 * Created by jrout on 7/31/16.
 */
@Component
public class EmployeeServiceImpl implements IEmployeeService {

    @Resource
    private IEmployeeDAO employeeDAO;

    public Employee fetchEmployeeWithBonus(int empId) {
        Employee employee = employeeDAO.fetchEmployee(empId);
        if(employee.getSalary() > 20000) {
            employee.setSalary(employee.getSalary() + 100);
        }

        return employee;
    }
}