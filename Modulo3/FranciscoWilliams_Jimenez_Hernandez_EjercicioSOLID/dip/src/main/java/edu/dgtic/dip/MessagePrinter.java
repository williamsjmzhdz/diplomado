package edu.dgtic.dip;

import edu.dgtic.dip.model.Message;
import edu.dgtic.dip.service.Formatter;
import java.io.Writer;

public class MessagePrinter {

	private final Formatter formatter;
	private final Writer output;

	public MessagePrinter(Formatter formatter, Writer output) {
		this.formatter = formatter;
		this.output = output;
	}

	//Writes message to a file
	public void writeMessage(Message msg) {
		try {
			String formattedMessage = formatter.format(msg);
			output.write(formattedMessage);
			output.flush();
		} catch (Exception e) {
			throw new RuntimeException("Error al escribir el mensaje", e);
		}
	}
}
