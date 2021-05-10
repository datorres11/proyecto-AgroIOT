package com.co.proyecto.agroiot.servicios;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.PortInUseException;
import org.springframework.stereotype.Component;

import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;
import com.panamahitek.PanamaHitek_MultiMessage;


import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

@Component
public class ServiciosArduinoImplementacion implements ServiciosArduinoInterface{
	@Autowired
	private static ServiciosHumedadInterface serviciosHumedadInterface;
	
	@Autowired
	private static ServiciosTemperaturaInterface serviciosTemperaturaInterface;
	
	
	private PanamaHitek_Arduino ino = new PanamaHitek_Arduino();
	private PanamaHitek_MultiMessage multi = new PanamaHitek_MultiMessage(1, ino);
	private Pattern p = Pattern.compile("[^\\d]*[\\d]+[^\\d]+([\\d]+)");
	
	@Override
	public HashMap<String, String> obtenerDatosDesdeArduino() {
		SerialPortEventListener listener = new SerialPortEventListener() {
			
			@Override
			public void serialEvent(SerialPortEvent serialPortEvent) {
				
				try {
					if(ino.isMessageAvailable()) {
						System.out.println(ino.printMessage());
					}
				} catch (SerialPortException e1) {
					e1.printStackTrace();
				} catch (ArduinoException e1) {
					e1.printStackTrace();
				}
				
				try {
					System.out.println(ino.receiveData());
				} catch (ArduinoException e) {
					e.printStackTrace();
				} catch (SerialPortException e) {
					e.printStackTrace();
				}
				
			}
		};
		
		
		try {
			ino.arduinoRX("COM5", 9600, listener);
		} catch (ArduinoException e) {
			e.printStackTrace();
		} catch (SerialPortException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/*private void abrirPuerto() {
		Enumeration listaPuertos = CommPortIdentifier.getPortIdentifiers();
		CommPortIdentifier idPuerto = null;
		boolean encontrado = false;
		while (listaPuertos.hasMoreElements() && !encontrado) {
		idPuerto = (CommPortIdentifier) listaPuertos.nextElement();
			if (idPuerto.getPortType() == CommPortIdentifier.PORT_SERIAL) {
			if (idPuerto.getName().equals("COM4")) {
				encontrado = true;
					}
			}
		}
		/*SerialPort puertoSerie =null;

		try {
		puertoSerie = (SerialPort)idPuerto.open( "COM4",2000 );
		} catch( PortInUseException e ) {
		System.out.println(«Error abriendo el puerto serie»);
		}
		}*/
	
	

}