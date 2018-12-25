package com.jp.tradereporting.logger;

public class Logger {

	public static void logMessage(String message){
		System.out.println("INFO -> "+message);
	}

	public static void logMessage(String className, String message){
		System.out.println(className+" -> "+message);
	}

	public static void logException(String className, String errorMessage, Exception e){
		System.out.println(className+" -> "+errorMessage);
		e.printStackTrace();
	}
}
