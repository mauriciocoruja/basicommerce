package com.uniesquina.basicommerce.service.exceptions;

import org.springframework.dao.DataIntegrityViolationException;

public class DatabaseException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public DatabaseException(String msg){
        super(msg);
    }

}
