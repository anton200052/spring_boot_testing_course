package com.luv2code.test;

import com.luv2code.component.MvcTestingExampleApplication;
import com.luv2code.component.dao.ApplicationDao;
import com.luv2code.component.models.CollegeStudent;
import com.luv2code.component.models.StudentGrades;
import com.luv2code.component.service.ApplicationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest(classes= MvcTestingExampleApplication.class)
public class MockAnnotationsTest {
    @Mock
    private ApplicationDao applicationDao;

    @InjectMocks
    private ApplicationService applicationService;

    @Autowired
    private StudentGrades studentGrades;

    @Autowired
    private CollegeStudent collegeStudent;

    @BeforeEach
    public void beforeEach() {
        collegeStudent.setFirstname("Eric");
        collegeStudent.setLastname("Roby");
        collegeStudent.setEmailAddress("eric.roby@luv2code_school.com");
        studentGrades.setMathGradeResults(new ArrayList<>(Arrays.asList(100.0, 85.0, 76.50, 91.75)));
        collegeStudent.setStudentGrades(studentGrades);
    }

    @Test
    @DisplayName("Add grade results testing")
    void addGradesTest(){
        List<Double> grades = collegeStudent.getStudentGrades().getMathGradeResults();

        when(applicationDao.addGradeResultsForSingleClass(grades)).thenReturn(100.0);

        assertEquals(100.0, applicationService.addGradeResultsForSingleClass(grades));
    }

    @Test
    @DisplayName("Find avg grade results testing")
    void findGradesAvgTest(){
        List<Double> grades = collegeStudent.getStudentGrades().getMathGradeResults();

        when(applicationDao.findGradePointAverage(grades)).thenReturn(100.0);

        assertEquals(100.0, applicationService.findGradePointAverage(grades));
    }

    @Test
    @DisplayName("Null testing")
    void nullTest(){
        Object expected = "Expected value";

        when(applicationDao.checkNull(expected)).thenReturn(expected);
        when(applicationDao.checkNull(null)).thenReturn(null);

        assertNotNull(applicationService.checkNull(expected));
        assertNull(applicationService.checkNull(null));
    }
}
