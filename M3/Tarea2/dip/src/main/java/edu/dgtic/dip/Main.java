package edu.dgtic.dip;

import edu.dgtic.dip.model.Message;
import edu.dgtic.dip.service.Formatter;
import edu.dgtic.dip.service.JSONFormatter;

import java.io.IOException;
import java.io.PrintWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Message msg = new Message("Este es un mensaje de prueba.");

		// Utiliza la abstracción Formatter en vez de una implementación específica
		Formatter formatter = new JSONFormatter(); // Puede cambiar fácilmente a TextFormatter

		// PrintWriter también es una dependencia, por lo que también la abstraemos
		try (PrintWriter writer = new PrintWriter("test_msg.txt")) {
			MessagePrinter printer = new MessagePrinter(formatter, writer);
			printer.writeMessage(msg);
		}
	}

}
