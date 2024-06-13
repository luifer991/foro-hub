package com.foro.foro_hub.infra.errors;

public class ValidationExist extends RuntimeException {
    public ValidationExist ( String s ) {
        super( s );
    }
}
