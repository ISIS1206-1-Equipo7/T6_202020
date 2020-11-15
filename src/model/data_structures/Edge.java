package model.data_structures;

public class Edge <K extends Comparable<K>, V>
{
	//Atributos
	private Vertex<K,V> source;
	private Vertex<K,V> dest;
	private double weight;
	
	//---------------------
	// CONSTRUCTOR
	//---------------------
	/**
	 * Crea el arco desde el vertice source al vertice dest con peso weight
	 * @param source
	 * @param dest
	 * @param weight
	 */
	public Edge(Vertex<K,V> pSource, Vertex<K,V> pDest, double pWeight) {
		this.source = pSource;
		this.dest = pDest;
		this.weight = pWeight;
	}
	
	
	//---------------------
	// METODOS
	//---------------------
	/**
	 * Devuelve el vertice origen
	 * @return Vertex (Nodo) de origen.
	 */
	public Vertex<K,V> getSource(){
		return source;
	}
	
	/**
	 * Devuelve el vertice destino.
	 * @return vertice de destino.
	 */
	public Vertex<K,V> getDest(){
		return dest;
		
	}
	
	/**
	 * Devuelve el peso del arco
	 * @return peso (tiempo) del arco.
	 */
	public double weight() {
		return weight;
		
	}
	
	/**
	 * Modifica el peso del arco.
	 * @param weight
	 */
	public void setWeight(double pWeight) {
		this.weight = pWeight;
	}
	
}
