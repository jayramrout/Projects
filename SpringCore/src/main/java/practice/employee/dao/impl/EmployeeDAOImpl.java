package practice.employee.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import practice.employee.dao.IEmployeeDAO;
import practice.employee.domain.Department;
import practice.employee.domain.Employee;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by jrout on 7/31/16.
 */
@Component
public class EmployeeDAOImpl implements IEmployeeDAO{

    @Resource
    private DataSource dataSource;

    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;

    @Override
    public Employee fetchEmployee(int empId) {
        Employee emp = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ps = connection.prepareStatement("select * from employees where employee_id = ?");
            ps.setInt(1,empId);
            rs = ps.executeQuery();
            while(rs.next()) {
                String firstName = rs.getString("FIRST_NAME");
                float salary = rs.getFloat("SALARY");
                emp = new Employee(empId, firstName);
                emp.setSalary(salary);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            try{
                while(connection != null) {
                    connection.close();
                }
            }catch (Exception exp){}
        }

        return emp;
    }

    public Department fetchEmpDepartment(int empId) {
        Department department = new Department(10,"Marketing");
        return department;
    }
}
