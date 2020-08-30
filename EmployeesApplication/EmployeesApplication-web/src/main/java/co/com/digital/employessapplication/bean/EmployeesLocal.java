/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.digital.employessapplication.bean;

import co.com.digital.employessapplication.dto.RequestEmployee;
import co.com.digital.employessapplication.dto.GenericResponse;
import co.com.digital.employessapplication.entity.Employee;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author munozbryg
 */
@Local
public interface EmployeesLocal {

    GenericResponse create(RequestEmployee employee);

    List<Employee> get();

    Employee getById(int id);

    GenericResponse update(RequestEmployee employee);

    GenericResponse disable(int id);

}
