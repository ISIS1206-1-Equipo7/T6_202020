package model.logic;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Accidente  {
	
	
	//---------------
	//ATRIBUTOS:
	//---------------
	/**
	 * Atributo id
	 */
	private String id;
	
	/**
	 * Atributo severity
	 */
	private String severity;
	
	/**
	 * Atributo startDate (fecha inicial)
	 */
	private String startDate;
	
	/**
	 * Atributo endDate (fecha final)
	 */
	private String endDate;
	
	/**
	 * Atributo startHour
	 */
	private String startHour;
	
	/**
	 * Atributo endHour
	 */
	private String endHour;
	
	/**
	 * Atributo de latitud inicial
	 */
	private String latitude;
	
	/**
	 * Atributo de longitud inicial
	 */
	private String longitude;
	
	/**
	 * Atributo de estado
	 */
	private String state;
	
	/**
	 * Constructor
	 */
	public Accidente (String id, String severity, String startDate, String endDate, String startHour, String endHour, String latitude, String longitude, String state) {
		this.id = id;
		this.severity = severity;
		this.startDate = startDate;
		this.endDate = endDate;
		this.startHour = startHour;
		this.endHour = endHour;
		this.latitude = latitude;
		this.longitude = longitude;
		this.state = state;
	}
	
	//---------------
	//METODOS:
	//--------------
	
	/**
	 * Retorna el atributo id
	 */
	public String getID() {
		return id;
	}
	
	/**
	 * Retorna el atributo severity
	 */
	public String getSeverity() {
		return severity;
	}
	
	/**
	 * Retorna el atributo startTime
	 */
	public String getStartDate() {
		return startDate;
	}
	
	/**
	 * Retorna el atributo endTime
	 */
	public String getEndDate() {
		return endDate;
	}
	
	/**
	 * Retorna el atributo startHour
	 */
	public String getStartHour() {
		return startHour;
	}
	
	/**
	 * Retorna el atributo endHour
	 */
	
	public String getEndHour() {
		return endHour;
	}
	
	/**
	 * Retorna el atributo state
	 */
	public String getState() {
		return state;
	}
	
	/**
	 * retorna el atributo Latitude como DOUBLE.
	 */
	public double getLat() {
		return Double.parseDouble(latitude);
	}
	
	/**
	 * retorna el atributo Longitude como DOUBLE.
	 */
	public double getlon() {
		return Double.parseDouble(longitude);

	}
	
	/**
	 * convierte el string de la fecha en formato Date.
	 */
	public Date toDate() {
		
		String formatedDate = startDate.replace("-", "/");
		Date fecha = null;
		try {
			
			fecha =  new SimpleDateFormat("yyyy/M/dd").parse(formatedDate);

		}
		catch(Exception e) {
			e.getMessage();

		}
		
		return fecha;
		
	}


	

	
}