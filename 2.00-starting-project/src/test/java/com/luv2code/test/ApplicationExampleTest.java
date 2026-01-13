package com.luv2code.test;

import com.luv2code.component.MvcTestingExampleApplication;
import com.luv2code.component.models.CollegeStudent;
import com.luv2code.component.models.StudentGrades;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = MvcTestingExampleApplication.class)
public class ApplicationExampleTest {

    private static int count = 0;

    @Value("${info.app.name}")
    private String appInfo;

    @Value("${info.app.description}")
    private String appDescription;

    @Value("${info.app.version}")
    private String appVersion;

    @Value("${info.school.name}")
    private String schoolName;

    @Autowired
    private CollegeStudent collegeStudent;

    @Autowired
    private StudentGrades studentGrades;

    @BeforeEach
    public void beforeEachTesting() {
        count++;
        System.out.println("App info: " + appInfo + " app description: " + appDescription + " app version: " + appVersion + " school name: " + schoolName);
        collegeStudent.setFirstname("Anton");
        collegeStudent.setLastname("Vasylkov");
        collegeStudent.setEmailAddress("dfksdkf@gmail.com");

        studentGrades.setMathGradeResults(new ArrayList<>(Arrays.asList(100.0, 85.0, 76.50, 91.75)));
        collegeStudent.setStudentGrades(studentGrades);
    }

    @Test
    void addGradeResultsForStudentsGrades() {
        assertEquals(353.25, studentGrades.addGradeResultsForSingleClass(collegeStudent.getStudentGrades().getMathGradeResults()));
    }

    @Test
    void addGradeResultsForStudentsGradesNotEquals() {
        assertNotEquals(100.0, studentGrades.addGradeResultsForSingleClass(collegeStudent.getStudentGrades().getMathGradeResults()));
    }

    @Test
    void isGradeGreater() {
        assertTrue(studentGrades.isGradeGreater(100.0, 56.75));
    }

    @Test
    void isGradeNotGreater() {
        assertFalse(studentGrades.isGradeGreater(45.25, 60.0));
    }

    @Test
    void countGradePointAverage() {
        assertEquals(88.31, studentGrades.findGradePointAverage(collegeStudent.getStudentGrades().getMathGradeResults()));
    }

    @Test
    void countGradePointAverageNotEquals() {
        assertNotEquals(100.0, studentGrades.findGradePointAverage(collegeStudent.getStudentGrades().getMathGradeResults()));
    }

    @Test
    @DisplayName("Check if object is null or not")
    void testCheckNull() {
        assertNotNull(studentGrades.checkNull(collegeStudent), "Объект не должен быть null");
        assertNull(studentGrades.checkNull(null), "Должен вернуть null, если на вход подан null");
    }
}
