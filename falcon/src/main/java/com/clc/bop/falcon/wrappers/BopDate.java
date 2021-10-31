package com.clc.bop.falcon.wrappers;

import lombok.*;

import java.time.*;

@Getter
@AllArgsConstructor
public class BopDate{
    private static final ZoneId defaultTimeZone = ZoneId.of("America/New_York");
    private long epochMilli;
    private LocalDate localDate;
    private LocalTime localTime;
    private LocalDateTime localDateTime;

    /**
     * NOTE: All dates handled in ZoneId.of("America/New_York")
     * Assumes Instant.now()
     */
    public BopDate(){
        this(Instant.now().toEpochMilli());
    }

    /**
     * NOTE: All dates handled in ZoneId.of("America/New_York")
     * @param epochMilli long epoch time in milliseconds
     */
    public BopDate(long epochMilli) {
        this.epochMilli = epochMilli;
        this.localDate = Instant.ofEpochMilli(epochMilli).atZone(defaultTimeZone).toLocalDate();
        this.localTime = Instant.ofEpochMilli(epochMilli).atZone(defaultTimeZone).toLocalTime();
        this.localDateTime = Instant.ofEpochMilli(epochMilli).atZone(defaultTimeZone).toLocalDateTime();
    }


    /**
     * NOTE: All dates handled in ZoneId.of("America/New_York")
     * @param localDate localDate object. Time assumed to be midnight 00:00 of this date
     */
    public BopDate(LocalDate localDate) {
        this(localDate.atStartOfDay().atZone(defaultTimeZone).toInstant().toEpochMilli());
    }

    /**
     * NOTE: All dates handled in ZoneId.of("America/New_York")
     * @param localTime localTime object. Date assumed to be current date
     */
    public BopDate(LocalTime localTime) {
        this(localTime.atDate(LocalDate.now()).atZone(defaultTimeZone).toInstant().toEpochMilli());
    }

    /**
     * NOTE: All dates handled in ZoneId.of("America/New_York")
     * @param localDateTime localDateTime object
     */
    public BopDate(LocalDateTime localDateTime){
        this(localDateTime.atZone(defaultTimeZone).toInstant().toEpochMilli());
    }

    /**
     * NOTE: All dates handled in ZoneId.of("America/New_York")
     * @param date string date in yyyy-MM-dd format
     */
    public BopDate(String date) {
        this(LocalDate.parse(date).atStartOfDay().atZone(defaultTimeZone).toInstant().toEpochMilli());
    }

    /**
     * NOTE: All dates handled in ZoneId.of("America/New_York")
     * @param date string date in yyyy-MM-dd format
     * @param time string time in HH:mm:ss.SSS
     */
    public BopDate(String date, String time) {
        this(LocalDateTime.of(LocalDate.parse(date),LocalTime.parse(time)).atZone(defaultTimeZone).toInstant().toEpochMilli());
    }

}
