/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.digital.employessapplication.bean;

import co.com.digital.employessapplication.constants.ApplicationConstants;
import co.com.digital.employessapplication.dao.EmployeeDAO;
import co.com.digital.employessapplication.dto.RequestEmployee;
import co.com.digital.employessapplication.dto.GenericResponse;
import co.com.digital.employessapplication.entity.Employee;
import co.com.digital.employessapplication.exception.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.apache.logging.log4j.*;

/**
 *
 * @author munozbryg
 */
@Stateless
public class EmployessBean implements EmployeesLocal {

    static Logger log = LogManager.getRootLogger();

    @Inject
    private EmployeeDAO employeeDao;

    @Override
    public GenericResponse create(RequestEmployee employee) {
        GenericResponse response = new GenericResponse();

        try {
            if (!employee.validate()) {
                throw new InvalidParameterException(ApplicationConstants.MSG_PARAMETER_ERROR.getValue());
            }

            Employee employeeEntity = new Employee(
                    employee.getDocument(),
                    employee.getDocumentType(),
                    employee.getName(),
                    employee.getLastName(),
                    employee.getIsBoss(),
                    employee.getFunction(),
                    employee.getStatus()
            );
            employeeDao.insertEmployee(employeeEntity);

            response.setMessage(
                    ApplicationConstants.MSG_TRANSACTION_SUCCESS.getValue()
                    + " Usuario creado con exito! ");
            response.setCode(ApplicationConstants.COD_TRANSACTION_SUCCESS.getValue());
        } catch (InvalidParameterException e) {
            response.setMessage(e.getMessage());
            response.setCode(ApplicationConstants.COD_PARAMETER_ERROR.getValue());
        } catch (Exception ex) {
            log.error(ex);
            response.setMessage(ApplicationConstants.MSG_UNKNOW_ERROR.getValue()
                    + ex.getMessage()
            );
            response.setCode(ApplicationConstants.COD_UNKNOW_ERROR.getValue());
        }
        return response;
    }

    @Override
    public List<Employee> get() {
        List<Employee> employees;
        try {
            employees = employeeDao.findAll();
        } catch (Exception ex) {
            employees = new ArrayList<>();
            //response.setMessage(ApplicationConstants.MSG_UNKNOW_ERROR.getValue());
            //response.setCode(ApplicationConstants.COD_UNKNOW_ERROR.getValue());
        }
        return employees;
    }

    @Override
    public Employee getById(int id) {
        Employee employee = new Employee();
        try {
            employee.setDocument(id);
            employee = employeeDao.findById(employee);
        } catch (Exception ex) {
            //response.setMessage(ApplicationConstants.MSG_UNKNOW_ERROR.getValue());
            //response.setCode(ApplicationConstants.COD_UNKNOW_ERROR.getValue());
        }
        return employee;
    }

    @Override
    public GenericResponse update(RequestEmployee employee) {
        GenericResponse response = new GenericResponse();
        try {
            if (!employee.validate()) {
                throw new InvalidParameterException(ApplicationConstants.MSG_PARAMETER_ERROR.getValue());
            }

            Employee employeeEntity = new Employee(
                    employee.getDocument(),
                    employee.getDocumentType(),
                    employee.getName(),
                    employee.getLastName(),
                    employee.getIsBoss(),
                    employee.getFunction(),
                    employee.getStatus()
            );
            employeeDao.updateEmployee(employeeEntity);

            response.setMessage(
                    ApplicationConstants.MSG_TRANSACTION_SUCCESS.getValue()
                    + " Usuario creado con exito! ");
            response.setCode(ApplicationConstants.COD_TRANSACTION_SUCCESS.getValue());
        } catch (InvalidParameterException e) {
            response.setMessage(e.getMessage());
            response.setCode(ApplicationConstants.COD_PARAMETER_ERROR.getValue());
        } catch (Exception ex) {
            response.setMessage(ApplicationConstants.MSG_UNKNOW_ERROR.getValue());
            response.setCode(ApplicationConstants.COD_UNKNOW_ERROR.getValue());
        }
        return response;
    }

    @Override
    public GenericResponse disable(int id) {
        GenericResponse response = new GenericResponse();
        try {
            /*if (!employee.validate()) {
                throw new InvalidParameterException(ApplicationConstants.MSG_PARAMETER_ERROR.getValue());
            }*/
            Employee employeeEntity = new Employee();
            employeeEntity.setDocument(id);
            Employee employeeEntityUpdate
                    = employeeDao.findById(employeeEntity);
            employeeEntityUpdate.setStatus(0);
            employeeDao.updateEmployee(employeeEntityUpdate);

            response.setMessage(
                    ApplicationConstants.MSG_TRANSACTION_SUCCESS.getValue()
                    + " Usuario deshabilitado con exito! ");
            response.setCode(ApplicationConstants.COD_TRANSACTION_SUCCESS.getValue());
            //} catch (InvalidParameterException e) {
            //    response.setMessage(e.getMessage());
            //    response.setCode(ApplicationConstants.COD_PARAMETER_ERROR.getValue());
        } catch (Exception ex) {
            response.setMessage(ApplicationConstants.MSG_UNKNOW_ERROR.getValue() 
                    + ex.getMessage());
            log.error(ex);
            response.setCode(ApplicationConstants.COD_UNKNOW_ERROR.getValue());
        }
        return response;
    }

}
