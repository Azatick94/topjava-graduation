package com.graduation.util.exception;

public class IdNotFoundException extends RuntimeException {

    public IdNotFoundException(Integer id) {
        super("id not found : " + id);
    }
}
