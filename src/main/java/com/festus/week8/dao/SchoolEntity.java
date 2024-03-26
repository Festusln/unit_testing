package com.festus.week8.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class SchoolEntity {

    @GeneratedValue
    @Id
    private Long id;
    private String name;
    private String address;
    private int numOfDept;
    private int numOfStaff;

    public SchoolEntity() {
    }

    public SchoolEntity(String name, String address, int numOfDept, int numOfStaff) {
        this.name = name;
        this.address = address;
        this.numOfDept = numOfDept;
        this.numOfStaff = numOfStaff;
    }
}
