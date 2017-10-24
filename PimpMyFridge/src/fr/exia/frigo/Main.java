package fr.exia.frigo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Enumeration;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;

public class Main {

    public static void main(String[] args) {

        CommPortIdentifier serialPortId = null;

        Enumeration enumComm = CommPortIdentifier.getPortIdentifiers();

        while(enumComm.hasMoreElements())
        {
            serialPortId = (CommPortIdentifier)enumComm.nextElement();
            if(serialPortId.getPortType() == CommPortIdentifier.PORT_SERIAL)
            {
                break;
            }
        }

        if(serialPortId == null) {
            System.err.println("erreur, aucun arduino connecté");
            return;
        }
        System.out.println("Port COM connecté : " + serialPortId.getName());

        try {
            SerialPort serialPort = (SerialPort) serialPortId.open("Main",
                    2000);
            serialPort.setSerialPortParams(115200,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);

            // open the streams
            BufferedReader input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
            OutputStream output = serialPort.getOutputStream();

            Arduino uno = new Arduino(serialPort, input, output);

            serialPort.addEventListener(uno);
            serialPort.notifyOnDataAvailable(true);
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }
}