package com.jp.tradereporting.exception;

public class ApplicationException extends RuntimeException {

	private static final long serialVersionUID = -842680685284755718L;

	public ApplicationException(Exception exception) {
		super(exception);
	}

	public ApplicationException(String message, Exception exception) {
		super(message,exception);
	}

	public ApplicationException(String format, Object... args) {
		super(String.format(format, args));
	}

}
