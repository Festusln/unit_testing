package com.festus.week8.model;

import lombok.Data;

@Data
public class ResponseData {
    private SuccessResponseData successResponseData;
    private ErrorResponseData errorResponseData;

    public ResponseData() {

    }
    public ResponseData(SuccessResponseData successResponseData, ErrorResponseData errorResponseData) {
        this.successResponseData = successResponseData;
        this.errorResponseData = errorResponseData;
    }
}
