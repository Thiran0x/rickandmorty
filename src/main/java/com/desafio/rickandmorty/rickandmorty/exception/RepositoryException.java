package com.desafio.rickandmorty.rickandmorty.exception;

import org.springframework.http.HttpStatus;

/**
 * Created by Matias Arce on 30-04-2022.
 */
public class RepositoryException extends Exception {

    HttpStatus httpStatus;

    public RepositoryException(String message,HttpStatus httpStatus, Throwable cause) {
        super(message, cause);
        this.httpStatus=httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
