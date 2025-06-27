package com.suresh.employee_service.ExceptionHandling;

public class ExternalServiceException extends RuntimeException{
    public ExternalServiceException(String  message){
        super(message);
    }
}
