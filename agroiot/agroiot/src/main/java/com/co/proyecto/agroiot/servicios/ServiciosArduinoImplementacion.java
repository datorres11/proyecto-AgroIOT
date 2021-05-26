package com.co.proyecto.agroiot.servicios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.Timer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;
import com.panamahitek.PanamaHitek_MultiMessage;


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
	public List<String> obtenerDatosDesdeArduino() {
		List<String> datos=new ArrayList<>();
		SerialPortEventListener listener = new SerialPortEventListener() {
			
			@Override
			public void serialEvent(SerialPortEvent serialPortEvent) {
				
					try {
						try {
							if(ino.isMessageAvailable()) {
								System.out.println(multi.getMessage(0));
								System.out.println(multi.getMessage(1));
								if (multi.dataReceptionCompleted()){
									/*System.out.println(ino.printMessage());
									System.out.println(ino.receiveData());*/
									
									/*serviciosHumedadInterface.guardarHumedad(multi.getMessage(0));
									serviciosTemperaturaInterface.guardarTemperatura(multi.getMessage(1));*/
									
									datos.add(multi.getMessage(0));
									datos.add(multi.getMessage(1));
									
									multi.flushBuffer();
									ino.killArduinoConnection();
								}
							}
						} catch (ArduinoException e) {
							e.printStackTrace();
						}
					} catch (SerialPortException e) {
						e.printStackTrace();
					}
			}
		};
		
		try {
			ino.arduinoRX("COM7", 9600, listener);
			//ino.killArduinoConnection();
		} catch (ArduinoException e) {
			e.printStackTrace();
		} catch (SerialPortException e) {
			e.printStackTrace();
		}
		return datos;
	}	

}
