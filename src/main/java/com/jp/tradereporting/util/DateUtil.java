package com.jp.tradereporting.util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil {
	
	private static String dateFormat = "d MMM yy";
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
	
	public static LocalDate parseDate(String dateString){
		return LocalDate.parse(dateString,formatter);
	}
	
	public static LocalDate getNextWorkingDate(LocalDate inputDate){
		if (inputDate.getDayOfWeek() == DayOfWeek.FRIDAY) {
			return inputDate.plusDays(2);
		} else if (inputDate.getDayOfWeek() == DayOfWeek.SATURDAY){
			return inputDate.plusDays(1);
		} else {
			return inputDate;
		}
	}
	
}
 