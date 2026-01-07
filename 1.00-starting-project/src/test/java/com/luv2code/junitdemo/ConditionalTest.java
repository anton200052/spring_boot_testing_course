package com.luv2code.junitdemo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

class ConditionalTest {

    @Test
    @Disabled("Dont run until JIRA #123 is resolved")
    void basicTest() {

    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void testForWindowsOnly() {

    }

    @Test
    @EnabledOnOs(OS.MAC)
    void testForMacOnly() {

    }

    @Test
    @EnabledOnOs({OS.WINDOWS, OS.MAC})
    void testForMacAndWindowsOnly() {

    }

    @Test
    @EnabledOnOs(OS.LINUX)
    void testForLinuxOnly() {

    }

    @Test
    @EnabledOnJre(JRE.JAVA_23)
    void testForJava23Only() {

    }

    @Test
    @EnabledOnJre(JRE.JAVA_17)
    void testForJava17Only() {

    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_17, max = JRE.JAVA_25)
    void testForJavaRangeOnly() {

    }
}
