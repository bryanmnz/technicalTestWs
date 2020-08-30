/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.digital.employessapplication.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author munozbryg
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "employee.findall", query = "SELECT e from Employee e ORDER BY e.document")
})
@Table(name="employee")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "document")
    private int document;

    @Column(name = "documenttype")
    private int documentType;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "isboss")
    private int isBoss;

    @Column(name = "function")
    private String function;

    @Column(name = "status")
    private int status;

    public int getDocument() {
        return document;
    }

    public Employee() {
    }

    public Employee(int document, int documentType, String name, String lastName, int isBoss, String function, int status) {
        this.document = document;
        this.documentType = documentType;
        this.name = name;
        this.lastName = lastName;
        this.isBoss = isBoss;
        this.function = function;
        this.status = status;
    }

    public void setDocument(int document) {
        this.document = document;
    }

    public int getDocumentType() {
        return documentType;
    }

    public void setDocumentType(int documentType) {
        this.documentType = documentType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getIsBoss() {
        return isBoss;
    }

    public void setIsBoss(int isBoss) {
        this.isBoss = isBoss;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
