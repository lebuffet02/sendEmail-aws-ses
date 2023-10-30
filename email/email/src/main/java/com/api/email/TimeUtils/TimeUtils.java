package com.api.email.TimeUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {

    private static final String PATTERN_DATE = "yyyy-MM-dd hh:mm:ss";

    public static String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_DATE);
        return sdf.format(date);
    }
}
