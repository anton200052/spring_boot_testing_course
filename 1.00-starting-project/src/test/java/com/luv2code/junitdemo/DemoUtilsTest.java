package com.luv2code.junitdemo;

import org.junit.jupiter.api.*;

import java.lang.reflect.Executable;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.Simple.class)
public class DemoUtilsTest {
    private DemoUtils demoUtils;

    @BeforeEach
    public void setUp() {
        demoUtils = new DemoUtils();
    }

    @AfterEach
    public void tearDown() {
        demoUtils = null;
    }

    @Test
    public void testEqualOrNot() {
        assertEquals(6, demoUtils.add(2, 4), "2 + 4 must be 6");
    }

    @Test
    public void testNullOrNot() {
        assertNull(demoUtils.checkNull(null), "Object must not be null");
        assertNotNull(demoUtils.checkNull(new String("")), "Object must not be null");
    }

    @Test
    public void testSameAndNot() {
        assertSame(demoUtils.getAcademy(), demoUtils.getAcademyDuplicate());
        assertNotSame("", demoUtils.getAcademy());
    }

    @Test
    public void testTrueOrFalse() {
        assertTrue(demoUtils.isGreater(7, 6));
        assertFalse(demoUtils.isGreater(5, 6));
    }

    @Test
    public void testArrayEqualOrNot() {
        String[] expected = {"A", "B", "C"};

        assertArrayEquals(expected, demoUtils.getFirstThreeLettersOfAlphabet());
    }

    @Test
    public void testIterableEqualOrNot() {
        List<String> expected = List.of("luv", "2", "code");

        assertIterableEquals(expected, demoUtils.getAcademyInList());
    }
    
    @Test
    public void testThrowsOrNor() {
        assertThrows(Exception.class, () -> demoUtils.throwException(-1)) ;
        assertDoesNotThrow(() -> demoUtils.throwException(1));
    }

    @Test
    public void testTimeout() {
        assertTimeoutPreemptively(Duration.ofSeconds(3), () -> demoUtils.checkTimeout());
    }

    @Test
    public void testMultiply() {
        assertEquals(8, demoUtils.multiply(2, 4), "2 * 4 must be 8");
        assertNotEquals(6, demoUtils.multiply(2, 4), "2 * 4 must be 8");
    }
}
