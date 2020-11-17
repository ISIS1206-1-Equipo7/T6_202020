package model.logic;

public class Viaje {
	
	// ---------
	// ATRIBUTOS
	// ---------
	
	/**
	 * Duracion del viaje
	 */
	private String tripDuration;
	
	/**
	 * Hora inicial del viaje
	 */
	private String startTime;
	
	/**
	 * Hora final del viaje
	 */
	private String stopTime;
	
	/**
	 * ID de la estacion inicial
	 */
	private String startID;
	
	/**
	 * Nombre de la estacion inicial
	 */
	private String startName;
	
	/**
	 * Latitud de la estacion inicial
	 */
	private String startLatitude;
	
	/**
	 * Longitud de la estacion inicial
	 */
	private String startLongitude;
	
	/**
	 * ID de la estacion final
	 */
	private String endID;
	
	/**
	 * Nombre de la estacion final
	 */
	private String endName;
	
	/**
	 * Latitud de la estacion final
	 */
	private String endLatitude;
	
	/**
	 * Longitud de la estacion final
	 */
	private String endLongitude;
	
	/**
	 * ID de la bicicleta/ usuario
	 */
	private String bikeID;
	
	/**
	 * Tipo de usuario
	 */
	private String userType;
	
	/**
	 * Anno de nacimiento del usuario
	 */
	private String birthYear;
	
	/**
	 * Genero del usuario
	 */
	private String gender;
	
	/**
	 * Constructor
	 */
	public Viaje(String tripDuration, String startTime, String stopTime, String startID, String startName, String startLatitude, String startLongitude, String endID, String endName, String endLatitude, String endLongitude, String bikeID, String userType, String birthYear, String gender) {
		this.tripDuration = tripDuration;
		this.startTime = startTime;
		this.stopTime = stopTime;
		this.startID = startID;
		this.startName = startName;
		this.startLatitude = startLatitude;
		this.startLongitude = startLongitude;
		this.endID = endID;
		this.endName = endName;
		this.endLatitude = endLatitude;
		this.endLongitude = endLongitude;
		this.bikeID = bikeID;
		this.userType = userType;
		this.birthYear = birthYear;
		this.gender = gender;
	}
	
	/**
	 * Retorna la duracion del viaje
	 */
	public String getTripDuration() {
		return this.tripDuration;
	}
	
	/**
	 * Retorna la hora inicial del viaje
	 */
	public String getStartTime() {
		return this.startTime;
	}
	
	/**
	 * Retorna la hora final del viaje
	 */
	public String getStopTime() {
		return this.stopTime;
	}
	
	/**
	 * Retorna el id de la estacion inicial
	 */
	public String getStartID() {
		return this.startID;
	}
	
	/**
	 * Retorna el nombre de la estacion inicial
	 */
	public String getStartName() {
		return this.startName;
	}
	
	/**
	 * Retorna la latitud de la estacion inicial
	 */
	public String getStartLatitude() {
		return this.startLatitude;
	}
	
	/**
	 * Retorna la longitud de la estacion inicial
	 */
	public String getStartLongitude() {
		return this.startLongitude;
	}
	
	/**
	 * Retorna el id de la estacion final
	 */
	public String getEndID() {
		return this.endID;
	}
	
	/**
	 * Retorna el nombre de la estacion final
	 */
	public String getEndName() {
		return this.endName;
	}
	
	/**
	 * Retorna la latitud de la estacion final
	 */
	public String getEndLatitude() {
		return this.endLatitude;
	}
	
	/**
	 * Retorna la longitud de la estacion final
	 */
	public String getEndLongitude() {
		return this.endLongitude;
	}
	
	/**
	 * Retorna el id de la bicicleta/ usuario
	 */
	public String getBikeID() {
		return this.bikeID;
	}
	
	/**
	 * Retorna el tipo de usuario
	 */
	public String getUserType() {
		return this.userType;
	}
	
	/**
	 * Retorna el anno de nacimiento del usuario
	 */
	public String getBirthYear() {
		return this.birthYear;
	}
	
	/**
	 * Retorna el genero del usuario
	 */
	public String getGender() {
		return this.gender;
	}
}
