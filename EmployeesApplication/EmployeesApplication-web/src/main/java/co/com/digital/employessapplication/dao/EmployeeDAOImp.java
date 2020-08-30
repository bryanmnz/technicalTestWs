/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.digital.employessapplication.dao;

import co.com.digital.employessapplication.entity.Employee;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author munozbryg
 */
@Stateless
public class EmployeeDAOImp implements EmployeeDAO {

    @PersistenceContext(unitName = "EmployeePU")
    EntityManager em;

    @Override
    public List<Employee> findAll() {
        return em.createNamedQuery("employee.findall").getResultList();
    }

    @Override
    public Employee findById(Employee employee) {
        return em.find(Employee.class, employee.getDocument());
    }

    @Override
    public void insertEmployee(Employee employee) {
        em.persist(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        em.merge(employee);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        em.merge(employee);
    }

}
