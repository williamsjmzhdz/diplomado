package edu.dgtic.dip.service;

import edu.dgtic.dip.exception.FormatException;
import edu.dgtic.dip.model.Message;

//Common interface for classes formatting Message object
public interface Formatter {
	
	public String format(Message message) throws FormatException;
	
}
