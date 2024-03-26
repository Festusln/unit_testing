package com.festus.week8.model;

//import jakarta.validation.constraints.Min;
//import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SchoolRequestData {
//    @NotNull(message = "School name can not be null")
    private String name;

//    @NotNull(message = "Address cannot be null")
    private String address;

//    @Min(value = 1, message = "Number of department must be greater than 0")
    private int numOfDept;

//    @Min(value = 1, message = "Number of staff must be greater than 0")
    private int numOfStaff;

    public SchoolRequestData(String name, String address, int numOfDept, int numOfStaff) {
        this.name = name;
        this.address = address;
        this.numOfDept = numOfDept;
        this.numOfStaff = numOfStaff;
    }

    public ErrorResponseData validateRequestData(SchoolRequestData schoolRequestData) {
        ErrorResponseData errorResponseData = new ErrorResponseData();

        if (schoolRequestData.getName() == null) {
            errorResponseData.setError("Bad Request");
            errorResponseData.setErrMsg("School name cannot be null");
            return errorResponseData;
        } else if (schoolRequestData.getAddress() == null) {
            errorResponseData.setError("Bad Request");
            errorResponseData.setErrMsg("School Address cannot be null");
            return errorResponseData;
        } else if (schoolRequestData.getNumOfDept() <= 0) {
            errorResponseData.setError("Bad Request");
            errorResponseData.setErrMsg("Number of department cannot be less than 1");
            return errorResponseData;
        } else if (schoolRequestData.getNumOfStaff() <= 0) {
            errorResponseData.setError("Bad Request");
            errorResponseData.setErrMsg("Number of staff cannot be less than 1");
            return errorResponseData;
        }

        return null;
    }

}
