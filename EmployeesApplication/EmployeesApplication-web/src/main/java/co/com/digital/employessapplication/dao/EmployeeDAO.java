/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.digital.employessapplication.dao;

import co.com.digital.employessapplication.entity.Employee;
import java.util.List;

/**
 *
 * @author munozbryg
 */
public interface EmployeeDAO {

    public List<Employee> findAll();

    public Employee findById(Employee employee);

    public void insertEmployee(Employee employee);

    public void updateEmployee(Employee employee);

    public void deleteEmployee(Employee employee);
}
