package com.clc.bop.falcon.wrappers;

import lombok.*;

import java.time.*;

@Getter
@Builder
@AllArgsConstructor
public class BopDate{
    private static final ZoneId defaultTimeZone = ZoneId.of("America/New_York");
    private long epochMilli;
    private LocalDate localDate;
    private LocalTime localTime;
    private LocalDateTime localDateTime;

    public BopDate(){
        this(Instant.now().toEpochMilli());
    }

    public BopDate(long epochMilli) {
        this.epochMilli = epochMilli;
        this.localDate = Instant.ofEpochMilli(epochMilli).atZone(defaultTimeZone).toLocalDate();
        this.localTime = Instant.ofEpochMilli(epochMilli).atZone(defaultTimeZone).toLocalTime();
        this.localDateTime = Instant.ofEpochMilli(epochMilli).atZone(defaultTimeZone).toLocalDateTime();
    }

    public BopDate(LocalDate localDate) {
        this(localDate.atStartOfDay().atZone(defaultTimeZone).toInstant().toEpochMilli());
    }

    public BopDate(LocalTime localTime) {
        this(localTime.atDate(LocalDate.now()).atZone(defaultTimeZone).toInstant().toEpochMilli());
    }

    public BopDate(LocalDateTime localDateTime){
        this(localDateTime.atZone(defaultTimeZone).toInstant().toEpochMilli());
    }

    public BopDate(String date) {
        this(LocalDate.parse(date).atStartOfDay().atZone(defaultTimeZone).toInstant().toEpochMilli());
    }

    public BopDate(String date, String time) {
        this(LocalDateTime.of(LocalDate.parse(date),LocalTime.parse(time)).atZone(defaultTimeZone).toInstant().toEpochMilli());
    }

}
