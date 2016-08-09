package practice.employee.dao;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import practice.employee.dao.impl.EmployeeDAOImpl;
import practice.employee.domain.Department;
import practice.employee.domain.Employee;

import javax.annotation.Resource;

/**
 * Created by jrout on 7/31/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class EmployeeDAOTest {

    @Resource
    private IEmployeeDAO iEmployeeDAO;

    @Test
    public void fetchEmployeeTest(){
        Employee employee = iEmployeeDAO.fetchEmployee(100);
        System.out.println(employee.getEmployeeId() +" " + employee.getName());
        assertNotNull(employee);
    }

    @Test
    public void fetchEmpDepartmentTest(){
        IEmployeeDAO iEmployeeDAO = new EmployeeDAOImpl();
        Department department = iEmployeeDAO.fetchEmpDepartment(12);
        System.out.println(department.getDeptId() + " " + department.getDeptName());
    }
}
