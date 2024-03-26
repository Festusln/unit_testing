package com.festus.week8.controller;

import com.festus.week8.model.ErrorResponseData;
import com.festus.week8.model.ResponseData;
import com.festus.week8.model.SchoolRequestData;
import com.festus.week8.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("schools")
public class SchoolController {
    @Autowired
    SchoolService schoolService;

    @PostMapping("add")
    public ResponseEntity<ResponseData> saveNewSchool(@RequestBody SchoolRequestData schoolRequestData) {

        ResponseData responseData = new ResponseData();
        ErrorResponseData errorResponseData = new ErrorResponseData();

        errorResponseData = schoolRequestData.validateRequestData(schoolRequestData);

        if (errorResponseData != null) {
            responseData.setErrorResponseData(errorResponseData);
            return new ResponseEntity<ResponseData>(responseData, HttpStatus.BAD_REQUEST);
        }

        return schoolService.addSchool(schoolRequestData);
    }

    @GetMapping("fetch/{id}")
    public ResponseEntity<ResponseData> getSchool(@PathVariable Long id) {
        return schoolService.getSchool(id);
    }

}
