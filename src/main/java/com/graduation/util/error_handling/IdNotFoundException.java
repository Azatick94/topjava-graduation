package com.graduation.util.error_handling;

public class IdNotFoundException extends RuntimeException {

    public IdNotFoundException(Integer id) {
        super("id not found : " + id);
    }
}
