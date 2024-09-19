package edu.dgtic.dip.exception;

import java.io.IOException;

//Thrown by formatter
public class FormatException extends IOException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FormatException(Exception cause) {
		super(cause);
	}
}
