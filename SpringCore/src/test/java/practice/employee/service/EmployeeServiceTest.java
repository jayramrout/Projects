package practice.employee.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import practice.employee.domain.Employee;
import practice.employee.service.impl.EmployeeServiceImpl;

import javax.annotation.Resource;


//@ContextConfiguration("classpath:applicationContext.xml")
//public class EmployeeServiceTest extends AbstractJUnit4SpringContextTests{

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class EmployeeServiceTest {

    @Resource
    private IEmployeeService employeeService;

    @Test
    public void fetchEmployeeWithBonusTest() {
        Employee employee = employeeService.fetchEmployeeWithBonus(100);
        System.out.println(employee.getName() + " " + employee.getSalary());
    }
}
