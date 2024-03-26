package com.festus.week8.controller;

import com.festus.week8.controller.ErrorException;
import com.festus.week8.model.ErrorResponseData;
import com.festus.week8.model.ResponseData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GeneralExceptionHandler {
    //Exception handler
    @ExceptionHandler
    public ResponseEntity<ResponseData> exceptionHandler(ErrorException errorException) {
        ErrorResponseData errorResponseData = new ErrorResponseData("Failed",
                errorException.getMessage(), System.currentTimeMillis());
        ResponseData response = new ResponseData(null, errorResponseData);

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    //Exception handler
    @ExceptionHandler
    public ResponseEntity<ResponseData> otherExceptionHandler(Exception errorException) {
        ErrorResponseData errorResponseData = new ErrorResponseData("Failed",
                errorException.getMessage(), System.currentTimeMillis());
        ResponseData response = new ResponseData(null, errorResponseData);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
