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
			System.out.println("[0] Importar Datos");
		}

		/**
		 * Imprime un mensaje pasado por parametro
		 * @param mensaje
		 */
		public void printMessage(String mensaje) {

			System.out.println(mensaje);
		}
		
		
}