package ru.letnes.Lambda.demo5;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class demo5 {
    public static void main(String[] args) {
        Clock clock = Clock.systemDefaultZone();
        long millis = clock.millis();
        Instant instant = clock.instant();
        Date legacyDate = Date.from(instant);

        // zoneId
        System.out.println(ZoneId.getAvailableZoneIds());
        ZoneId zone1 = ZoneId.of("Europe/Berlin");
        ZoneId zone2 = ZoneId.of("Brazil/East");
        System.out.println(zone1.getRules());
        System.out.println(zone2.getRules());
        // localTime
        LocalTime late1 = LocalTime.of(23, 59, 59);
        LocalTime late2 = LocalTime.of(22, 59, 59);
        System.out.println(late1.isAfter(late2));
        System.out.println(late2.isBefore(late1));

        System.out.println(ChronoUnit.HOURS.between(late2, late1));
        System.out.println(ChronoUnit.MINUTES.between(late2, late1));
        // localDate
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
        LocalDate yesterday = tomorrow.minusDays(2);
        System.out.println(tomorrow.getDayOfWeek());
        System.out.println(yesterday.getDayOfWeek());
        // localDateTime
        LocalDateTime loc = LocalDateTime.of(2014, Month.DECEMBER, 31, 23, 59, 59);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy - HH:mm");
        System.out.println(loc);
        System.out.println(formatter.format(loc));
    }
}
