package com.festus.week8.model;

import com.festus.week8.dao.SchoolEntity;
import lombok.Data;

import java.util.List;

@Data
public class SuccessResponseData {
    private Long id;
    private String message;
    private long timeStamp;
    private List<SchoolEntity> data;

    public SuccessResponseData() {
    }

    public SuccessResponseData(Long id, String message, long timeStamp, List<SchoolEntity> data) {
        this.id = id;
        this.message = message;
        this.timeStamp = timeStamp;
        this.data = data;
    }

    public SuccessResponseData(String message, long timeStamp, List<SchoolEntity> data) {
        this.message = message;
        this.timeStamp = timeStamp;
        this.data = data;
    }

}
