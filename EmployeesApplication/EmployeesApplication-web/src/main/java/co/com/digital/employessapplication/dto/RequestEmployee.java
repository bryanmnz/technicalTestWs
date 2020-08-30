/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.digital.employessapplication.dto;

import java.util.List;

/**
 *
 * @author munozbryg
 */
public class RequestEmployee extends Person {

    private List<String> boss;

    private int isBoss;

    private String function;

    private int status;

    public List<String> getBoss() {
        return boss;
    }

    public void setBoss(List<String> boss) {
        this.boss = boss;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public int getIsBoss() {
        return isBoss;
    }

    public void setIsBoss(int isBoss) {
        this.isBoss = isBoss;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean validate() {
        boolean isValid = true;

        if (this.getName().isEmpty()) {
            isValid = false;
        }

        return isValid;

    }

    @Override
    public String toString() {
        return "RequestEmployee{" + "boss=" + boss + ", isBoss=" + isBoss + ", function=" + function + ", status=" + status + '}';
    }
    
    
}
