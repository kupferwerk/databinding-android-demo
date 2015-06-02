package com.kupferwerk.androiddatabinding.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public class DateUtils {

   private static final DateFormat DATE_FORMAT = DateFormat.getDateInstance();

   public static String formatDate(final Date date) {
      return DATE_FORMAT.format(date);
   }

   public static Date parseDate(final String dateString) {
      try {
         return DATE_FORMAT.parse(dateString);
      } catch (ParseException e) {
         return null;
      }
   }
}
