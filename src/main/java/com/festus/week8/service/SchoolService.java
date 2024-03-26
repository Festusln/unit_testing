package com.festus.week8.service;

import com.festus.week8.controller.ErrorException;
import com.festus.week8.dao.SchoolEntity;
import com.festus.week8.dao.SchoolRepository;
import com.festus.week8.model.ResponseData;
import com.festus.week8.model.SchoolRequestData;
import com.festus.week8.model.SuccessResponseData;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class SchoolService {

    @Autowired
    SchoolRepository schoolRepository;
    public ResponseEntity<ResponseData> addSchool(SchoolRequestData schoolRequestData) {

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        SchoolEntity schoolEntity = modelMapper.map(schoolRequestData, SchoolEntity.class);

        try {
            schoolRepository.save(schoolEntity);
        }
        catch (Exception e) {
            throw new ErrorException(e.getMessage());
        }

        SuccessResponseData successResponseData = new SuccessResponseData(schoolEntity.getId(),
                        "Successful", System.currentTimeMillis(), null);
        ResponseData responseData = new ResponseData(successResponseData, null );
        return new ResponseEntity<>(responseData, HttpStatus.CREATED);
    }

    public ResponseEntity<ResponseData> getSchool(Long id) {
        Optional<SchoolEntity> schoolEntity = Optional.of(new SchoolEntity());
        System.out.println("Checking...");
        schoolEntity = schoolRepository.findById(id);
        if (schoolEntity.isEmpty()) {
            System.out.println("User does not exist...");
            throw new ErrorException("Id does not exist");
        }

        List<SchoolEntity> dataResp = new ArrayList<>();
        dataResp.add(schoolEntity.get());
        SuccessResponseData successResponseData = new SuccessResponseData(
                "Successful", System.currentTimeMillis(), new ArrayList<SchoolEntity>((dataResp)));
        ResponseData responseData = new ResponseData(successResponseData, null );
        return new ResponseEntity<>(responseData, HttpStatus.CREATED);
    }
}
