package com.festus.week8.model;

import lombok.Data;

@Data
public class ErrorResponseData {
    private String error;
    private String errMsg;
    private long time;

    public ErrorResponseData() {

    }

    public ErrorResponseData(String error, String errMsg, long time) {
        this.error = error;
        this.errMsg = errMsg;
        this.time = time;
    }
}
