package com.example.computerstorebackend.utilities;

import lombok.experimental.UtilityClass;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The type Date util.
 */
@UtilityClass
public class DateUtil {
    /**
     * Format date string.
     *
     * @param date       the date
     * @param dateFormat the date format
     * @return the string
     */
    public String formatDate(Date date, String dateFormat) {
        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        return format.format(date);
    }
}
