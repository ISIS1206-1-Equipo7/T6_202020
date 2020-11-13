package view;


public class View 
{
	    /**
	     * Metodo constructor
	     */
	    public View()
	    {
	    	
	    }
	    
	    /**
	     * Imprime el menu
	     */
		public void printMenu()
		{
			System.out.println("********* Escriba el número correspondiente a lo que desea hacer *********");
			System.out.println("0. Importar Datos");
			System.out.println("1. Conocer los accidentes en una fecha.");
			System.out.println("2. Conocer accidentes anteriores a una fecha.");
			System.out.println("3. Conocer los accidentes en un rango de fechas.");
			System.out.println("4. Conocer el estado con mas accidentes.");
			System.out.println("5. Conocer los accidentes por rango de horas.");
			System.out.println("6. Conocer la zona geografica mas accidentada");

		}

		/**
		 * Imprime un mensaje pasado por parametro
		 * @param mensaje
		 */
		public void printMessage(String mensaje) {

			System.out.println(mensaje);
		}
		
		
}