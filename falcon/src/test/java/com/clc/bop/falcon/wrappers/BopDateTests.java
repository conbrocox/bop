package com.clc.bop.falcon.wrappers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class BopDateTests {
    private static final boolean print = true;
    private static final ZoneId defaultTimeZone = ZoneId.of("America/New_York");
    private static long expectedEpochMilli;
    private static LocalDate expectedLocalDate;
    private static LocalTime expectedLocalTime;
    private static LocalDateTime expectedLocalDateTime;
    private static String expectedStringDate;
    private static String expectedStringTime;

    @BeforeEach
    void setup(){
        expectedEpochMilli = 1634873614175L;
        expectedLocalDate = LocalDate.parse("2021-10-21");
        expectedLocalTime = LocalTime.parse("23:33:34.175");
        expectedLocalDateTime = LocalDateTime.parse("2021-10-21T23:33:34.175");
        expectedStringDate = "2021-10-21";
        expectedStringTime = "23:33:34.175";
    }

    @AfterEach
    void teardown(){
        expectedLocalDate = null;
        expectedLocalTime = null;
        expectedLocalDateTime = null;
        expectedStringDate = null;
        expectedStringTime = null;
    }

    @Test
    void testBopDate() {
        BopDate bopDate = new BopDate();
        assertNotNull(bopDate.getLocalDate());
        assertNotNull(bopDate.getLocalTime());
        assertNotNull(bopDate.getLocalDateTime());
    }
    @Test
    void testBopDateEpoch() {
        BopDate bopDate = new BopDate(expectedEpochMilli);
        assertEquals(expectedEpochMilli,bopDate.getEpochMilli());
        assertEquals(expectedLocalDate,bopDate.getLocalDate());
        assertEquals(expectedLocalTime,bopDate.getLocalTime());
        assertEquals(expectedLocalDateTime,bopDate.getLocalDateTime());
    }
    @Test
    void testBopDateLocalDate() {
        BopDate bopDate = new BopDate(expectedLocalDate);
        expectedEpochMilli = Instant.ofEpochMilli(expectedEpochMilli).atZone(defaultTimeZone).toLocalDate().atStartOfDay().atZone(defaultTimeZone).toInstant().toEpochMilli();
        expectedLocalTime = Instant.ofEpochMilli(expectedEpochMilli).atZone(defaultTimeZone).toLocalDate().atStartOfDay().toLocalTime();
        expectedLocalDateTime = Instant.ofEpochMilli(expectedEpochMilli).atZone(defaultTimeZone).toLocalDate().atStartOfDay();
        commonAsserts(bopDate);
    }
    @Test
    void testBopDateLocalTime() {
        BopDate bopDate = new BopDate(expectedLocalTime);
        commonAsserts(bopDate);
    }
    @Test
    void testBopDateLocalDateTime() {
        BopDate bopDate = new BopDate(expectedLocalDateTime);
        commonAsserts(bopDate);
    }
    @Test
    void testBopDateStringDate() {
        BopDate bopDate = new BopDate(expectedStringDate);
        expectedEpochMilli = Instant.ofEpochMilli(expectedEpochMilli).atZone(defaultTimeZone).toLocalDate().atStartOfDay().atZone(defaultTimeZone).toInstant().toEpochMilli();
        expectedLocalTime = Instant.ofEpochMilli(expectedEpochMilli).atZone(defaultTimeZone).toLocalDate().atStartOfDay().toLocalTime();
        expectedLocalDateTime = Instant.ofEpochMilli(expectedEpochMilli).atZone(defaultTimeZone).toLocalDate().atStartOfDay();
        commonAsserts(bopDate);
    }
    @Test
    void testBopDateStringDateStringTime() {
        BopDate bopDate = new BopDate(expectedStringDate, expectedStringTime);
        commonAsserts(bopDate);
    }

    void commonAsserts(BopDate bopDate){
        assertEquals(expectedEpochMilli,bopDate.getEpochMilli());
        assertEquals(expectedLocalDate,bopDate.getLocalDate());
        assertEquals(expectedLocalTime,bopDate.getLocalTime());
        assertEquals(expectedLocalDateTime,bopDate.getLocalDateTime());
    }
}
