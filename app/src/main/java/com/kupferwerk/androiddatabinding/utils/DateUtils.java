package com.kupferwerk.androiddatabinding.utils;

import java.text.DateFormat;
import java.util.Date;

public class DateUtils {

   private static final DateFormat DATE_FORMAT = DateFormat.getDateInstance();

   public static String formatDate(final Date date) {
      return DATE_FORMAT.format(date);
   }
}
