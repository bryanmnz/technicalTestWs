/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.digital.employessapplication.exception;

/**
 *
 * @author munozbryg
 */
public class InvalidParameterException extends Exception {

    public InvalidParameterException(String message) {
        super(message);
    }

    public InvalidParameterException(Throwable cause) {
        super(cause);
    }
}
