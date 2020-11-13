package controller;


import java.util.Scanner;


import model.logic.Modelo;
import view.View;

public class Controller {

	/* declaracion del Modelo*/
	private Modelo modelo;

	/* declaracion de la Vista*/
	private View view;
	
	/**
	 * boolean para verificar si los datos fueron previamente cargados
	 */
	private boolean cargados;

	/**
	 * Crea la vista y el modelo del proyecto
	 */
	public Controller ()
	{
		view = new View();
		modelo = new Modelo();
	}

	/** 
	 * metodo run de la Clase Controller
	 * inicia la aplicacion
	 */
	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;

		while( !fin )
		{
			view.printMenu();
			
			int option=0;
			try {
				 option = lector.nextInt();
			}
			catch(Exception e)
			{
				view.printMessage("Opcion invalida. Debe digitar un numero. Vuelva a intentar");
				lector.nextLine();
				 option = lector.nextInt();
			}
			
			switch(option)
			{

			// Importa los datos
			case 0:
				view.printMessage("¿De que anno desea la informacion de los accidentes? (Todos si desea cargar el conjuto completo).");
				String periodo = lector.next();
				view.printMessage("Importando datos para el periodo: " + periodo + "...");
				
				//checks format:
				try {
					if(Integer.parseInt(periodo)<2016 || Integer.parseInt(periodo)>2019) {
						view.printMessage("Error: año invalido para cargar...");
						view.printMessage("el año debe estar entre el 2016 y 2019");
						view.printMessage("vuelva a intentarlo.");
						break;
					}
				}
				catch( Exception e) {
					if(periodo.equalsIgnoreCase("Todos")==false) {
						view.printMessage("Error: intentelo nuevamente, esta vez digite: Todos");
						break;
					}
				}
				
				modelo.leerDatos(periodo);
				view.printMessage("Datos importados correctamente.");
				cargados = true;
				break;
				
			// resuelve requerimiento 1:
			case 1:
				if(!cargados) {
					view.printMessage("Debe cargar los datos primero");
					break;
				}
				view.printMessage("Ingrese la fecha que desea consultar");
				String st = lector.next();
				modelo.conocerAccidentesFechaRBT(st);
//				modelo.conocerAccidentesFechaBST(st);
				break;
				
			// Resuelve el requerimiento 2:
			case 2:
				if(!cargados) {
					view.printMessage("Debe cargar los datos primero");
					break;
				}
				view.printMessage("Ingrese la fecha para la cual desea consultar los accidentes anteriores");
				String fecha = lector.next();
				
				// verifica que el formato esta correcto
				if(modelo.correctFormat(null, fecha)==false) {
					break;
				}
				modelo.conocerAccidentesAnterioresFecha(fecha);
				break;
				
			//Resuelve el requerimiento 3:
			case 3:
				if(!cargados) {
					view.printMessage("Debe cargar los datos primero");
					break;
				}
				view.printMessage("Ingrese la fecha del limite inferior");
				String fechaInit = lector.next();
				view.printMessage("Ingrese la fecha del limite superior");
				String fechaEnd = lector.next();
				
				// verifica que el formato esta correcto
				if(modelo.correctFormat(fechaInit, fechaEnd)==false) {
					break;
				}
				modelo.conocerAccidentesRangoFechas(fechaInit, fechaEnd);
				break;
			
			//Resuelve el requerimiento 4:
			case 4:
				if(!cargados) {
					view.printMessage("Debe cargar los datos primero");
					break;
				}
				view.printMessage("Ingrese la fecha del limite inferior");
				String fechaInit4 = lector.next();
				view.printMessage("Ingrese la fecha del limite superior");
				String fechaEnd4 = lector.next();
				modelo.estadoConMasAccidentes(fechaInit4, fechaEnd4);
				break;
				
			//Resuelve el requerimiento 5:
			case 5:
				if(!cargados) {
					view.printMessage("Debe cargar los datos primero");
					break;
				}
				view.printMessage("Ingrese la hora del limite inferior");
				String horaInit = lector.next();
				view.printMessage("Ingrese la hora del limite superior");
				String hotaEnd = lector.next();
				modelo.accidentesPorRangoHoras(horaInit, hotaEnd);
				break;
			// resuelve el bono del requerimiento 6:
			case 6:
				if(!cargados) {
					view.printMessage("Debe cargar los datos primero");
					break;
				}
				view.printMessage("dar latitud centro");
				double latitude = Double.parseDouble(lector.next());
				view.printMessage("dar longitud centro");
				double longitude = Double.parseDouble(lector.next());
				view.printMessage("dar el radio (en Km)");
				double radius = Double.parseDouble(lector.next());
				
				modelo.conocerAccidentesZona(latitude, longitude, radius);
				break;

			default: 
				view.printMessage("--------- \n Opcion Invalida !! \n---------");
				fin = true;
				break;
			}
		}

		lector.close();

	}	
}