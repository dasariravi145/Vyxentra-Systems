package com.vehicle.util;

import com.vehicle.constant.AppConstants;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public final class DateUtil {

    private static final ZoneId UTC = ZoneOffset.UTC;

    private static final DateTimeFormatter DATE_FORMATTER =
            DateTimeFormatter.ofPattern(AppConstants.DATE_FORMAT);

    private static final DateTimeFormatter DATE_TIME_FORMATTER =
            DateTimeFormatter.ofPattern(AppConstants.DATE_TIME_FORMAT);

    private DateUtil() {
        throw new UnsupportedOperationException("Utility class");
    }

    // ================= FORMAT =================

    public static String formatDate(LocalDate date) {
        Objects.requireNonNull(date, "Date cannot be null");
        return date.format(DATE_FORMATTER);
    }

    public static String formatDateTime(LocalDateTime dateTime) {
        Objects.requireNonNull(dateTime, "DateTime cannot be null");
        return dateTime.format(DATE_TIME_FORMATTER);
    }

    // ================= PARSE =================

    public static LocalDate parseDate(String dateStr) {
        if (dateStr == null || dateStr.isBlank()) {
            throw new IllegalArgumentException("Date string cannot be null or empty");
        }
        try {
            return LocalDate.parse(dateStr, DATE_FORMATTER);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format: " + dateStr, e);
        }
    }

    public static LocalDateTime parseDateTime(String dateTimeStr) {
        if (dateTimeStr == null || dateTimeStr.isBlank()) {
            throw new IllegalArgumentException("DateTime string cannot be null or empty");
        }
        try {
            return LocalDateTime.parse(dateTimeStr, DATE_TIME_FORMATTER);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid datetime format: " + dateTimeStr, e);
        }
    }

    // ================= DATE CALCULATIONS =================

    public static long daysBetween(LocalDate start, LocalDate end) {
        Objects.requireNonNull(start, "Start date cannot be null");
        Objects.requireNonNull(end, "End date cannot be null");
        return ChronoUnit.DAYS.between(start, end);
    }

    public static LocalDateTime startOfDay(LocalDate date) {
        Objects.requireNonNull(date, "Date cannot be null");
        return date.atStartOfDay();
    }

    public static LocalDateTime endOfDay(LocalDate date) {
        Objects.requireNonNull(date, "Date cannot be null");
        return date.atTime(LocalTime.MAX);
    }

    public static boolean isBetween(LocalDateTime dateTime,
                                    LocalDateTime start,
                                    LocalDateTime end) {

        Objects.requireNonNull(dateTime, "DateTime cannot be null");
        Objects.requireNonNull(start, "Start DateTime cannot be null");
        Objects.requireNonNull(end, "End DateTime cannot be null");

        return !dateTime.isBefore(start) && !dateTime.isAfter(end);
    }

    // ================= UTC HELPERS =================

    public static LocalDateTime nowUtc() {
        return LocalDateTime.now(UTC);
    }

    public static ZonedDateTime toUtc(ZonedDateTime dateTime) {
        Objects.requireNonNull(dateTime, "DateTime cannot be null");
        return dateTime.withZoneSameInstant(UTC);
    }
}