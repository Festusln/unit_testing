package com.festus.week8.service;

import com.festus.week8.dao.SchoolEntity;
import com.festus.week8.dao.SchoolRepository;
import com.festus.week8.model.SchoolRequestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SchoolServiceTest {

    //Service to test
    @InjectMocks
    private SchoolService schoolService;

    //declare the dependencies
    @Mock
    private SchoolRepository schoolRepository;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); //open mocks for the current class
    }

    @Test
    public void shouldAddSchoolSuccessfully() {
        //Given
        SchoolRequestData schoolRequestData = new SchoolRequestData (
               "LAUTECH",
               "Oyo State",
               25,
               150
        );

        //when
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        SchoolEntity entity = modelMapper.map(schoolRequestData, SchoolEntity.class);

        schoolService.addSchool(schoolRequestData);

        //then
        assertEquals(schoolRequestData.getName(), entity.getName());
        assertEquals(schoolRequestData.getAddress(), entity.getAddress());
        assertEquals(schoolRequestData.getNumOfDept(), entity.getNumOfDept());
        assertEquals(schoolRequestData.getNumOfStaff(), entity.getNumOfStaff());


        verify(schoolRepository, times(1)).save(entity);
    }

    @Test
    public void shouldFetchSchoolSuccessfully() {
        SchoolRequestData schoolRequestData = new SchoolRequestData(
                "LAUTECH",
                "Oyo State",
                25,
                150
        );
        schoolService.addSchool(schoolRequestData);

        when(schoolRepository.findById(1L)).thenReturn(Optional.of(new SchoolEntity(
                "LAUTECH",
                "Oyo State",
                25,
                150)));

    }
}