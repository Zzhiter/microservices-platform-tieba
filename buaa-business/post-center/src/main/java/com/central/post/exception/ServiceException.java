package com.central.post.exception;


public class ServiceException extends RuntimeException {

    private final Exceptions exceptions;

    private String exceptionDetail;

    public ServiceException(Exceptions exceptions){
        this.exceptions = exceptions;
    }

    public ServiceException(Exceptions exceptions, String exceptionDetail){
        this.exceptions = exceptions;
        this.exceptionDetail = exceptionDetail;
    }

    public Exceptions getServiceExceptionEnums() {
        return exceptions;
    }

    public String getExceptionDetail() {
        return exceptionDetail;
    }
}
