package com.example.hackaton;

import com.example.hackaton.exceptions.ResourceNotFoundException;
import com.example.hackaton.exceptions.UnauthorizedOperationException;
import com.example.hackaton.exceptions.UsernameAlreadyExists;
import com.example.hackaton.exceptions.UsernameNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleResourceNotFoundException(ResourceNotFoundException e) {
        return e.getMessage();
    }

    @ExceptionHandler(UnauthorizedOperationException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public String handleUnauthorizedOperationException(UnauthorizedOperationException e) {
        return e.getMessage();
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleUsernameNotFoundException(UsernameNotFoundException e) { return e.getMessage(); }

    @ExceptionHandler(UsernameAlreadyExists.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleUsernameAlreadyExists(UsernameAlreadyExists e) { return e.getMessage(); }
}
