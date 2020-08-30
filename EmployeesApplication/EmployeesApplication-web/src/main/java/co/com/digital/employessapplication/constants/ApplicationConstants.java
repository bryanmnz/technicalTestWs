/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.digital.employessapplication.constants;

/**
 *
 * @author munozbryg
 */
public enum ApplicationConstants {

    MSG_TRANSACTION_SUCCESS("Transaccion exitosa: "),
    
    MSG_PARAMETER_ERROR("Parametros requeridos vacíos por favor valide"),
    MSG_UNKNOW_ERROR("Error desconocido: "),
    
    COD_PARAMETER_ERROR("001"),
    COD_UNKNOW_ERROR("100"),
    
    COD_TRANSACTION_SUCCESS("000");

    private final String value;

    ApplicationConstants(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
