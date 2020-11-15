package model.data_structures;

public class Edge <K extends Comparable<K>, V>
{
	
	
	//---------------------
	// CONSTRUCTOR
	//---------------------
	/**
	 * Crea el arco desde el vertice source al vertice dest con peso weight
	 * @param source
	 * @param dest
	 * @param weight
	 */
	public Edge(Vertex<K,V> source, Vertex<K,V> dest, double weight) {
		
	}
	
	
	//---------------------
	// METODOS
	//---------------------
	/**
	 * Devuelve el vertice origen
	 * @return Vertex (Nodo) de origen.
	 */
	public Vertex<K,V> getSource(){
		return null;
	}
	
	/**
	 * Devuelve el vertice destino.
	 * @return vertice de destino.
	 */
	public Vertex<K,V> getDest(){
		return null;
		
	}
	
	/**
	 * Devuelve el peso del arco
	 * @return peso (tiempo) del arco.
	 */
	public double weight() {
		return 0;
		
	}
	
	/**
	 * Modifica el peso del arco.
	 * @param weight
	 */
	public void setWeight(double weight) {
		
	}
	
}
