package com.capgemini.onlinevegetablesales.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {

	private static final String DATE_FORMAT = "dd-MM-yyyy";
	private static final String DATE_TIME_FORMAT = "dd-MM-yyyy HH:mm:ss";

	private Utils() {
	}

	public static String parseToDateTimeToString(LocalDateTime date) 
	{
	 DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
	      return dateTimeFormatter.format(date);
	}
	public static String parseToDateTimeToStringWithTime(LocalDateTime date) 
	{
	 DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
	 	 
	 return dateTimeFormatter.format(date);
	}
}


