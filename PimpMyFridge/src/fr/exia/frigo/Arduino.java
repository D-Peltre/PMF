package fr.exia.frigo;

import java.io.BufferedReader;
import java.io.OutputStream;

import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

public class Arduino implements SerialPortEventListener {

    private SerialPort port;
    private BufferedReader input;
    private OutputStream output;

    public Arduino(SerialPort port, BufferedReader input, OutputStream output) {
        this.port = port;
        this.input = input;
        this.output = output;
    }

    public void serialEvent(SerialPortEvent event) {
        if (event.getEventType() != SerialPortEvent.DATA_AVAILABLE) {
            return;
        }

        try {

            while (!input.ready());

            String inputLine = input.readLine();
            System.out.println(inputLine);
        }
        catch (Exception e) {
            System.err.println("Erreur de lecture" + e.getMessage());
        }


    }

}