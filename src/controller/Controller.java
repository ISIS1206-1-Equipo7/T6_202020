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
				view.printMessage("Desea importar todos los datos (4 archivos)?");
				String todos = lector.next();
				boolean bool = false;
				if (todos.toUpperCase().equals("SI")) {
					bool = true;
				}
				modelo.leerDatos(bool);
				view.printMessage("Datos importados correctamente.");
				cargados = true;
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