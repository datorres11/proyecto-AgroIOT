package com.co.proyecto.agroiot.arduino;
import com.co.proyecto.agroiot.servicios.ServiciosHumedadInterface;
import com.co.proyecto.agroiot.servicios.ServiciosTemperaturaInterface;
import com.panamahitek.ArduinoException;

import com.panamahitek.PanamaHitek_Arduino;
import com.panamahitek.PanamaHitek_MultiMessage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;

import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

public class ConexionDispositivoArduino {
	@Autowired
	private static ServiciosHumedadInterface serviciosHumedadInterface;
	
	@Autowired
	private static ServiciosTemperaturaInterface serviciosTemperaturaInterface;
	
	// Se crea una instancia de la librería PanamaHitek_Arduino
		private static PanamaHitek_Arduino ino = new PanamaHitek_Arduino();
		private static PanamaHitek_MultiMessage multi = new PanamaHitek_MultiMessage(1, ino);
		private static final Pattern p = Pattern.compile("[^\\d]*[\\d]+[^\\d]+([\\d]+)");

		public static final SerialPortEventListener listener = new SerialPortEventListener() {
			@Override
			public void serialEvent(SerialPortEvent spe) {
				String temp = " ";
				String humidity = " ";
				
				try {


					if (multi.dataReceptionCompleted()) {

						 System.out.println(multi.getMessage(0));
						Matcher m = p.matcher(multi.getMessage(0));
						if (m.find()) {
							
							temp = (m.group(1)); // second matched digits
							System.out.println(m.group(1));

							System.out.println(temp);

						}
						if (m.find()) {
							humidity = (m.group(0));

							System.out.println(m.group(0));

						}
						
						multi.flushBuffer();
						/*ArduinoDTO arduino= new ArduinoDTO(temp,humidity,date,date.getTime(),"Bogota");
						System.out.print(arduino.getHumedad());
						mng.cargarDatos(arduino);*/
						serviciosHumedadInterface.guardarHumedad(humidity);
						serviciosTemperaturaInterface.guardarTemperatura(temp);
					}
				} catch (SerialPortException | ArduinoException ex) {

				}

			}
		};
}
