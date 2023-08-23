package com.wellsfargo.onlinebanking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class RequestAlreadyExistsException extends Exception {
	public RequestAlreadyExistsException(String message){
        super(message);
    }
}

