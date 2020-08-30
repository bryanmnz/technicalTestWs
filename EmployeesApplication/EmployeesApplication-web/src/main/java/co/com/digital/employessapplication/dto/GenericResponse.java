/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.digital.employessapplication.dto;

import java.io.Serializable;

/**
 *
 * @author munozbryg
 */
public class GenericResponse implements Serializable {

    private static final long serialVersionUID = 8799656478674716638L;

    private String message;

    private String code;

    public GenericResponse(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public GenericResponse() {

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
