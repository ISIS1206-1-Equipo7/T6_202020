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
import model.data_structures.RedBlackTree;
import model.data_structures.TablaHashSeparateChaining;

/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo {

	//-------------
	// CONSTANTES
	//-------------

	/**
	 * Ruta del año 2016
	 */
	private static final String ruta2016 = "data/us_accidents_dis_2016.csv";

	/**
	 * Ruta del año 2017
	 */
	private static final String ruta2017 = "data/us_accidents_dis_2017.csv";

	/**
	 * Ruta del año 2018
	 */
	private static final String ruta2018 = "data/us_accidents_dis_2018.csv";

	/**
	 * Ruta del año 2019
	 */
	private static final String ruta2019 = "data/us_accidents_dis_2019.csv";

	/**
	 * Ruta de todos los annos
	 */
	private static final String rutaTodos = "data/US_Accidents_Dec19.csv";


	//-------------
	// ATRIBUTOS
	//-------------

	/**
	 * Estructura de datos balanceada
	 */
	private RedBlackTree <String, Accidente> datosRBT;

	private RedBlackTree <String, Accidente> accidentesHoras;

	/**
	 * estructura clasica del arbol binario de busqueda
	 */
	//private BinarySearchTree<String, Accidente> datosBST;

	/**
	 * Ruta de los datos
	 */
	private String ruta;

	/**
	 * llave minima guardada en la estructura
	 */
	private String minKey;


	/**
	 * llave maxima guardada en la estructura
	 */
	private String maxKey;



	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public Modelo()
	{
		datosRBT = new RedBlackTree<String, Accidente>();
		accidentesHoras = new RedBlackTree<String, Accidente>();
		//		datosBST = new BinarySearchTree<String, Accidente>();
	}


	/**
	 * Req1: Conocer los accidentes en una fecha
	 */
	public void conocerAccidentesFechaRBT(String fecha)
	{	
		long tiempoI;
		long tiempoF;
		double tiempoT;



		int gradoUno = 0;
		int gradoDos = 0;
		int gradoTres = 0;
		int gradoCuatro = 0;

		tiempoI = System.nanoTime();
		LinkedList<Accidente> listaAcci = (LinkedList<Accidente>) datosRBT.get(fecha);
		
		for (Accidente actual : listaAcci) {

			if(actual.getSeverity().equals("1"))
				gradoUno++;
			else if(actual.getSeverity().equals("2"))
				gradoDos++;
			else if(actual.getSeverity().equals("3"))
				gradoTres++;
			else
				gradoCuatro++;
		}

		tiempoF = System.nanoTime();
		tiempoT = (double) (tiempoF-tiempoI)/1000000;

		System.out.println("El total de accidentes ocurridos el " + fecha + " es de: " + listaAcci.size());
		System.out.println("La cantidad de accidentes de severidad 1 es de: " + gradoUno);
		System.out.println("La cantidad de accidentes de severidad 2 es de: " + gradoDos);
		System.out.println("La cantidad de accidentes de severidad 3 es de: " + gradoTres);
		System.out.println("La cantidad de accidentes de severidad 4 es de: " + gradoCuatro);
		//System.out.println("El tiempo de ejecucion fue de: " + tiempoT + " milisegundos" + "\n");

	}

	/*public void conocerAccidentesFechaBST(String fecha)
	{	
		long tiempoI;
		long tiempoF;
		double tiempoT;



		int totalAccidentes = 0;
		int gradoUno = 0;
		int gradoDos = 0;
		int gradoTres = 0;
		int gradoCuatro = 0;

		tiempoI = System.nanoTime();
		for (Accidente actual: datosBST.get(fecha)) {
			totalAccidentes++;
			if(actual.getSeverity().equals("1"))
				gradoUno++;
			else if(actual.getSeverity().equals("2"))
				gradoDos++;
			else if(actual.getSeverity().equals("3"))
				gradoTres++;
			else
				gradoCuatro++;
		}

		tiempoF = System.nanoTime();
		tiempoT = (double) (tiempoF-tiempoI)/1000000;

		System.out.println("El total de accidentes ocurridos el " + fecha + " es de:" + totalAccidentes);
		System.out.println("La cantidad de accidentes de severidad 1 es de: " + gradoUno);
		System.out.println("La cantidad de accidentes de severidad 2 es de: " + gradoDos);
		System.out.println("La cantidad de accidentes de severidad 3 es de: " + gradoTres);
		System.out.println("La cantidad de accidentes de severidad 4 es de: " + gradoCuatro);
		System.out.println("El tiempo de ejecucion fue de: " + tiempoT + " milisegundos" + "\n");

	}

	/**
	 * Conocer accidentes antes de una fecha
	 * Resuelve el requerimiento 2 del Reto 3
	 * @param fecha, fecha tope
	 */
	public void conocerAccidentesAnterioresFecha(String fechaFin) {
		// devuelve el rango de accidentes antes de la fecha pasada por parametro
		LinkedList<Accidente> accidentes = (LinkedList<Accidente>) datosRBT.valuesInRange(minKey, fechaFin);

		// imprime el numero de accidentes antes de la fecha pasada por parametro
		System.out.println("Se encontraron " + accidentes.size() + " accidentes antes de la fecha " + fechaFin);

		String fecha = "";
		boolean first = true;
		int counter = 0;
		int max = 0;
		String fechaMax = "";

		for(Accidente accidente : accidentes) {
			if (first) {
				fecha = accidente.getStartDate();
				counter ++;
				first = false;
			} else {
				if (fecha.equals(accidente.getStartDate())) {
					counter ++;
				} else {
					if (counter > max) {
						max = counter;
						fechaMax = fecha;
					}
					fecha = accidente.getStartDate();
					counter = 1;
				}
			}
		}

		System.out.println("La fecha en la que mas accidentes se reportaron fue: " + fechaMax + " con un total de: " + max + " accidentes");
	}

	/**
	 * Conocer accidentes en un rango de fechas
	 * Resuelve el requerimiento 3 del Reto 3.
	 * @param fechaInit fecha inicial
	 * @param fechaEnd fecha final.
	 */
	public void conocerAccidentesRangoFechas(String fechaInit, String fechaEnd ) {

		LinkedList<Accidente> result = (LinkedList<Accidente>) datosRBT.valuesInRange(fechaInit, fechaEnd);

		System.out.println("Se encontraron " + result.size() + " en el rango solicitado.");

		int gradoUno = 0;
		int gradoDos = 0;
		int gradoTres = 0;
		int gradoCuatro = 0;

		for (Accidente actual : result) {

			if(actual.getSeverity().equals("1"))
				gradoUno++;
			else if(actual.getSeverity().equals("2"))
				gradoDos++;
			else if(actual.getSeverity().equals("3"))
				gradoTres++;
			else
				gradoCuatro++;
		}


		int max = 0;
		int max2 = 0;
		int indicador =0;
		int indicador2 =0;
		if(gradoUno>gradoDos) {
			max = gradoUno;
			indicador = 1;
		}
		else {
			max = gradoDos;
			indicador = 2;
		}
		if(gradoTres>gradoCuatro) {
			max2 = gradoTres;
			indicador2 = 3;
		}
		else {
			max2 = gradoCuatro;
			indicador2 = 4;
		}

		if(max>max2) {
			System.out.println("La categoria de accidentes mas reportada es: " + indicador + " con " + max + " accidentes.");

		}
		else
			System.out.println("La categoria de accidentes mas reportada es " + indicador2 + " con " + max2 + " accidentes.");		
	}

	public void estadoConMasAccidentes (String fechaInicial, String fechaFinal)
	{
		//datosRBT.keysInRange(fechaInicial, fechaFinal);
		Map<String, Integer> repeticiones = new HashMap<String, Integer>();
		Map<String, Integer> repeticiones2 = new HashMap<String, Integer>();
		for (Accidente accidente : datosRBT.valuesInRange(fechaInicial, fechaFinal)) {
			Integer veces = repeticiones.get(accidente.getState());
			Integer veces2 = repeticiones2.get(accidente.getStartDate());
			if(veces == null)
				veces = 0;
			if(veces2 == null)
				veces2 = 0;
			repeticiones.put(accidente.getState(), veces+1);
			repeticiones2.put(accidente.getStartDate(), veces2+1);
		}

		String estadoMax = null;
		String fechaMax = null;

		for (String  estado : repeticiones.keySet()) {
			if(estadoMax==null)
				estadoMax = estado;
			else if(repeticiones.get(estadoMax)<repeticiones.get(estado))
				estadoMax = estado;
			//System.out.println( "Max: " + estadoMax + repeticiones.get(estadoMax) + " Otro: " +estado + repeticiones.get(estado));
		}	

		for (String  fecha : repeticiones2.keySet()) {
			if(fechaMax==null)
				fechaMax = fecha;
			else if(repeticiones2.get(fechaMax)<repeticiones2.get(fecha))
				fechaMax = fecha;
			//System.out.println( "Max: " + fechaMax + repeticiones2.get(fechaMax) + " Otro: " +fecha + repeticiones2.get(fecha));
		}	

		if(estadoMax == null)
			System.out.println("ERROR: no existe el estado. Revise las fechas ingresadas"); 
		else
			System.out.println("La fecha con mas accidentes reportados es " + fechaMax + " con " + repeticiones2.get(fechaMax) + " accidentes.");
		System.out.println("El estado con mas accidentes es " + estadoMax + " con " + repeticiones.get(estadoMax) + " accidentes."); 


		repeticiones = null;
		repeticiones2 = null;
	}

	/**
	 * Resuelve el requerimento 5: Conocer los accidentes por rango de horas.
	 * @param horaInit
	 * @param horaEnd
	 */
	public void accidentesPorRangoHoras(String horaInit, String horaEnd) {

		/*for (int i = 0; i < 20; i++) {
			String star[] = horas.get(i).getStartHour().split(":");
			String hora = star[0];
			String minutos = star[1];
			int miutosN = Integer.parseInt(minutos);
			int horaN = Integer.parseInt(hora);
			System.out.println(horaN);
			System.out.println(miutosN);
			if(miutosN>30) {
				horaN++;
				miutosN=0;
			}
			else if(miutosN<30)
				miutosN=0;
			if(horaN<10)
				System.out.println( "0"+Integer.toString(horaN));
			else
				System.out.println(Integer.toString(horaN));
			if(miutosN!=30)
				System.out.println(Integer.toString(miutosN)+"0");
			else
				System.out.println(Integer.toString(miutosN));
		}*/

		Map<String, Integer> severidad = new HashMap<String, Integer>();
		if(accidentesHoras.isEmpty()!=false) {
			for (Accidente accidente : datosRBT.valuesInRange(minKey, maxKey)) {
				accidentesHoras.put(accidente.getStartHour(), accidente);
			}
		}

		LinkedList<Accidente> result = (LinkedList<Accidente>) accidentesHoras.valuesInRange(horaInit, horaEnd);
		
		for (Accidente accidente : result) {
			Integer veces = severidad.get(accidente.getSeverity());
			if(veces == null)
				veces = 0;
			severidad.put(accidente.getSeverity(), veces+1);
		}

		int s1 = 0; int s2 = 0; int s3 = 0; int s4 = 0;		
		for (String  actual : severidad.keySet()) {
			if(actual.equals("1"))
				s1 = severidad.get(actual);
			else if(actual.equals("2"))
				s2 = severidad.get(actual);
			else if(actual.equals("3"))
				s3 = severidad.get(actual);
			else
				s4 = severidad.get(actual);
		}

		System.out.println("El total de accidentes es " + result.size());
		System.out.println("Accidentes de severidad 1:" + s1);
		System.out.println("Accidentes de severidad 2:" + s2);
		System.out.println("Accidentes de severidad 3:" + s3);
		System.out.println("Accidentes de severidad 4:" + s4);
		System.out.println("El porcentaje de " + result.size() + " contra el total(" + datosRBT.size() +") de accidentes reportados es: " + (result.size()/datosRBT.size())*100 + "%");

		severidad = null;
		result = null;

	}



	/**
	 * Importa, lee y guarda los datos necesarios
	 */
	public void leerDatos(String anno)
	{			
		long tiempoI;
		long tiempoF;
		double tiempoT;

		if (anno.equals("2016")) { ruta = ruta2016; }
		if (anno.equals("2017")) { ruta = ruta2017; }
		if (anno.equals("2018")) { ruta = ruta2018; }
		if (anno.equals("2019")) { ruta = ruta2019; }
		if (anno.equals("Todos")) { ruta = rutaTodos; }

		String lineaDatos;
		int contador = 0;

		try
		{			
			
			FileReader fr = new FileReader(ruta);
			BufferedReader br = new BufferedReader(fr);

			// lectura de datos
			br.readLine();
			tiempoI = System.nanoTime();
			while ( (lineaDatos = br.readLine()) != null )
			{
				String[] camposDatos = lineaDatos.split(",");

				// ------
				// CAMPOS
				// ------
				// id
				String id = camposDatos[0];
				// severity
				String severity = camposDatos[3];
				// startDate
				String startDate = camposDatos[4].substring(0, 10);
				//startHour
				String startHour = camposDatos[4].substring(11,16);
				// endTime
				String endDate = camposDatos[5].substring(0, 10);
				// endHour
				String endHour = camposDatos[5].substring(11, 16);
				// startLatitude
				String latitude = camposDatos[6];
				//startLongitude
				String longitude = camposDatos[7];
				//state
				String state = camposDatos[17];


				Accidente accidente = new Accidente(id, severity, startDate, endDate, startHour, endHour, latitude, longitude, state);
				datosRBT.put(startDate,accidente);

				//datosBST.put(startTime, accidente);

				contador ++;

			}
			tiempoF = System.nanoTime();
			tiempoT = (double) (tiempoF-tiempoI)/1000000000;

			// Cierra el lector
			br.close();
			System.out.println();
			System.out.println("Existen " + contador + " accidentes en el anno " + anno + "\n");
			// Imprime la información del arbol RBT
			System.out.println("***** INFORMACION DE LA LECTURA DE DATOS (RBT) *****"+ "\n");
			System.out.println("El numero total de llaves ingresadas en el arbol fueron: " + (((LinkedList<String>) datosRBT.keySet()).size()));
			System.out.println("La altura del arbol es: " + datosRBT.height());
			// guarda la key minima en el atributo
			minKey = datosRBT.min();
			System.out.println("Valor minimo de llave en el arbol: " + minKey);
			//guarda la key maxima en el atributo
			maxKey = datosRBT.max();
			System.out.println("Valor maximo de llave en el arbol: " + maxKey+ "\n");
			System.out.println("Tiempo de carga es de: " + tiempoT + " Segundos."+ "\n");
			// Imprimne la informacion del arbol BST
			//			System.out.println("***** INFORMACION DEL BinarySearchTree (BST) *****");
			//			System.out.println("El numero total de llaves ingresadas en el arbol fueron: " + (((LinkedList<String>) datosBST.keySet()).size()));
			//			System.out.println("La altura del arbol es: " + datosBST.height());
			//			System.out.println("Valor minimo de llave en el arbol: " + datosBST.min());
			//			System.out.println("Valor maximo de llave en el arbol: " + datosBST.max() + "\n");



		} catch (Exception e)
		{
			System.out.println("Error al cargar los datos: " + e.getMessage());
		}

	}


	/**
	 * 
	 */
	public boolean correctFormat(String fechaInit, String fechaEnd) {

		if(fechaInit == null) {
			fechaInit = datosRBT.min();
		}

		// verifica formato y la entrada de datos.
		if((fechaInit=="" || fechaEnd=="")){
			System.out.println("ninguna de las fechas debe ser vacia");
			return false;
		}

		if(fechaInit.compareTo(fechaEnd)>0) {
			System.out.println("la fecha inferior no debe ser mayor a la superior");
		}

		String[] split = fechaInit.split("-");
		String[] split2 = fechaEnd.split("-");

		if(split.length != 3 || split2.length !=3 || Integer.parseInt(split[0])<2015 ||
				Integer.parseInt(split[0])>2020 || Integer.parseInt(split[1])<=0 || 
				Integer.parseInt(split[1])>12 || Integer.parseInt(split[2])<=0 || 
				Integer.parseInt(split[2])>31 || Integer.parseInt(split2[0])<2015 ||
				Integer.parseInt(split2[0])>2020 || Integer.parseInt(split2[1])<=0 ||
				Integer.parseInt(split2[1])>12 || Integer.parseInt(split2[2])<=0 ||
				Integer.parseInt(split2[2])>31) {
			System.out.println("formato incorrecto");
			return false;

		}
		else
			return true;

	}
	/**
	 * Resuelve el primer bono: Conocer la zona geografica mas accidentada
	 * utilizamos una formula llamada Haversine para calcular distancias esfericas.
	 * @param lat
	 * @param log
	 * @param radius
	 */
	public void conocerAccidentesZona(double lat, double lon, double radius ) {

		double p = Math.PI/180;
		LinkedList<Accidente> accidentes = (LinkedList<Accidente>) datosRBT.valuesInRange(minKey, maxKey);

		int domingo = 0;int lunes = 0;int martes = 0;int miercoles =0;
		int jueves =0;int viernes =0;int sabado =0;
		Calendar c = Calendar.getInstance();
		double lat2=0.0;
		double lon2=0.0;
		for(Accidente acci : accidentes) {

			// latitud y longitud del accidente a comparar.
			lat2 = acci.getLat();
			lon2 = acci.getlon();

			// p = pi/180
			//a = 0.5 - cos((lat2-lat1)*p)/2 + cos(lat1*p) * cos(lat2*p) * (1-cos((lon2-lon1)*p))/2
			//	    return 12742 * asin(sqrt(a)) #2*R*asin...

			// formula de Haversine:
			double a = 0.5 - Math.cos((lat2-lat)*p)/2 + Math.cos(lat*p) * Math.cos(lat2*p) * (1- Math.cos(((lon2-lon)*p)))/2;
			double radii = 12742 * a * Math.sin(Math.sqrt(a)); //respuesta en Kilometros.


			if(radii <= radius) {
				c.setTime(acci.toDate());
				int dia = c.get(Calendar.DAY_OF_WEEK);
				if(dia==1) {
					domingo++;
				}
				if(dia==2) {
					lunes ++;
				}
				if(dia==3) {
					martes++;
				}
				if(dia==4) {
					miercoles ++;
				}
				if(dia==5) {
					jueves++;
				}
				if(dia==6) {
					viernes ++;
				}
				if(dia==7) {
					sabado++;
				}
			}

		}

		int total = domingo + lunes + martes + miercoles + jueves + viernes + sabado;
		System.out.println();
		System.out.println("El total de accidentes ocurridos en el radio especificado es de: " + total);
		System.out.println("Accidentes por dia de la semana:"+ "\n");
		System.out.println("-Lunes: " + lunes);
		System.out.println("-Martes: " + martes);
		System.out.println("-Miercoles: " + miercoles);
		System.out.println("-Jueves: " + jueves);
		System.out.println("-Viernes: " + viernes);
		System.out.println("-Sabado: " + sabado);
		System.out.println("-Domingo: " + domingo);

	}



}