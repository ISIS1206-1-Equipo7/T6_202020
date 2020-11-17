package model.logic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


import model.data_structures.BinarySearchTree;
import model.data_structures.DiGraph;
import model.data_structures.RedBlackTree;
import model.data_structures.TablaHashSeparateChaining;

/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo {

	//-----------
	// CONSTANTES
	//-----------
	
	/**
	 * Archivo 1
	 */
	private static final String ruta1 = "data/201801-1-citibike-tripdata.csv";

	/**
	 * Archivo 2
	 */
	private static final String ruta2 = "data/201801-2-citibike-tripdata.csv";
	
	/**
	 * Archivo 3
	 */
	private static final String ruta3 = "data/201801-3-citibike-tripdata.csv";
	
	/**
	 * Archivo 4
	 */
	private static final String ruta4 = "data/201801-4-citibike-tripdata.csv";

	//----------
	// ATRIBUTOS
	//----------
	
	/**
	 * Estructura del grafo
	 */
	private DiGraph grafo;

	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public Modelo()
	{
		grafo = new DiGraph(3665);
	}

	/**
	 * Importa, lee y guarda los datos necesarios
	 */
	public void leerDatos(boolean todos)
	{			
		long tiempoI;
		long tiempoF;
		double tiempoT;
		
		tiempoI = System.nanoTime();
		
		// ------------------------------------------------
		
		int viajes = 0;
		
		if (todos) {
			viajes += this.leerArchivo(ruta1);
			viajes += this.leerArchivo(ruta2);
			viajes += this.leerArchivo(ruta3);
			viajes += this.leerArchivo(ruta4);
		} else {
			viajes += this.leerArchivo(ruta1);
			viajes += this.leerArchivo(ruta2);
		}
		
		// ------------------------------------------------
		
		tiempoF = System.nanoTime();
		tiempoT = (double) (tiempoF-tiempoI)/1000000000;
		
		// IMPRIMIR
		
	
		System.out.println("***** Informacion de la lectura de datos *****");
		System.out.println("- Numero total de viajes leidos de los archivos: " + viajes);
		System.out.println("- Numero total de estaciones (vertices) en el grafo: " + grafo.numVertices());
		System.out.println("- Numero total de arcos entre estaciones: " + grafo.numEdges());
	}
	
	private int leerArchivo(String ruta) {
		String lineaDatos;
		int contador = 0;

		try
		{			
			FileReader fr = new FileReader(ruta);
			BufferedReader br = new BufferedReader(fr);
			br.readLine();
			
			while ( (lineaDatos = br.readLine()) != null )
			{
				String[] camposDatos = lineaDatos.split(",");

				// ------
				// CAMPOS
				// ------
				
				// tripDuration
				String tripDuration = camposDatos[0];
				// startTime
				String startTime = camposDatos[1];
				// stopTime
				String stopTime = camposDatos[2];
				//startID
				String startID = camposDatos[3];
				// startName
				String startName = camposDatos[4];
				// startLatitude
				String startLatitude = camposDatos[5];
				// startLongitude
				String startLongitude = camposDatos[6];
				// endID
				String endID = camposDatos[7];
				// endName
				String endName = camposDatos[8];
				// endLatitude
				String endLatitude = camposDatos[9];
				// endLongitude
				String endLongitude = camposDatos[10];
				// bikeID
				String bikeID = camposDatos[11];
				// userType
				String userType = camposDatos[12];
				// birthYear
				String birthYear = camposDatos[13];
				// gender
				String gender = camposDatos[14];
				
				Viaje viaje = new Viaje(tripDuration, startTime, stopTime, startID, startName, startLatitude, startLongitude, endID, endName, endLatitude, endLongitude, bikeID, userType, birthYear, gender);
				
				// si alguna de las estaciones (vertices) no esta en el grafo, la agrega:
				if (!grafo.containsVertex(startID)) {
					grafo.insertVertex(startID, viaje);
				}
				
				if (!grafo.containsVertex(endID)) {
					grafo.insertVertex(endID, viaje);
				}
				
				// luego de agregar las estaciones agrega el nuevo arco o modifica el peso del arco existente:
				// Esta modificacion se hace de la siguiente manera: si el arco entre ambas estaciones ya existe,
				// llama a setWeight para modificar el peso del arco. Este peso es un promedio de todos los tiempos
				// entre estas dos estaciones.
				
				double duration = Double.parseDouble(tripDuration);
				
				try {
					grafo.addEdge(startID, endID, duration);
				}
				catch(IllegalArgumentException e) {		
					
					if(e.getMessage().equals("el arco que se intenta agregar ya existe")) {  // el arco ya se habia creado
						
						grafo.getVertex(startID).getEdge(endID).setWeight(duration); // recalcula el peso del arco existente
					}
					else {
						e.printStackTrace();
					}
				}
				catch(IndexOutOfBoundsException i) {		// error en la carga de datos
					
					i.printStackTrace();
				}
				
				
				contador ++;
			}

			// Cierra el lector
			br.close();
			
			return contador;
			
		} catch (Exception e)
		{
			System.out.println("Error al cargar los datos: " + e.getMessage());
			return 0;
		}
	}
	
	private void minEdge() {
		
	}
	
	private void maxEdge() {
		
	}
}