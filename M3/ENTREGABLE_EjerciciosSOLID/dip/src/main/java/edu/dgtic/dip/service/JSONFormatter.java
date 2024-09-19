package edu.dgtic.dip.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.dgtic.dip.exception.FormatException;
import edu.dgtic.dip.model.Message;

//Formats message to JSON format
public class JSONFormatter implements Formatter{

	public String format(Message message) throws FormatException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.findAndRegisterModules();
		try {
			return mapper.writeValueAsString(message);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			throw new FormatException(e);
		}
	}
}
