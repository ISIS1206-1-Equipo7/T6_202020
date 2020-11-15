package model.data_structures;

import java.util.LinkedList;

public class Vertex <K extends Comparable<K>, V>
{

	//---------------------
	// ATRIBUTOS
	//---------------------
	
	private LinkedList<Edge<K,V>> edges;
	private LinkedList<Vertex<K,V>> vertices;

	
	//---------------------
	// CONSTRUCTOR
	//---------------------
	/**
	 * Crea un vertice con identificador unico y valor (informacion asociada), el vertice inicia desmarcado
	 * @param id
	 * @param value
	 */
	public Vertex(K id, V value) {
		
	}
	
	
	//---------------------
	// METODOS
	//---------------------
	/**
	 * devuelve el identificador del vertice.
	 * @return K id del vertice (Nodo)
	 */
	public K getId()
	{
		return null;
	}
	
	/**
	 * Devuelve el valor asociado al vértice
	 * @return V valor asociado al vertice (Nodo)
	 */
	public V getInfo() {
		return null;
	}
	
	/**
	 * Retorna si el vertice esta marcado o no
	 * @return True si el vertice esta marcado, false si no.
	 */
	public boolean getMark() {
		return false;
		
	}
	/**
	 * Agrega un arco adyacente al vertice
	 * @param edge
	 */
	public void addEdge(Edge<K,V> edge) {
		
		edges.add(edge); // agrega el arco a la lista de arcos salientes de este vertice
		Vertex<K,V> adjacente = edge.getDest();
		vertices.add(adjacente); // agrega el vertice destino a la lista de vertices adyacentes a este.
		
		
	}
	
	/**
	 * Marca el vertice
	 */
	public void mark() {
		
	}
	
	/**
	 * Desmarca el vertice
	 */
	public void unmark() {
		
	}
	
	/**
	 * Retorna el numero de arcos (salientes) del vertice,
	 * @return Int numero de arcos salientes del vertice.
	 */
	public int outdegree() {
		return 0;
	}
	
	/**
	 * Retorna el numero de arcos (entrantes) del vertice
	 * @return Int numero de arcos entrantes del vertice.
	 */
	public int indegree() {
		return 0;
	}
	
	/**
	 * Retorna el arco con el vertice vertex (si existe). Retorna null si no existe.
	 * @param vertex
	 * @return El arco entre este vertice y el que se pasa por parametro.
	 */
	public Edge<K,V> getEdge(K vertex){
		return null;
	}
	
	/**
	 * Retorna una lista con sus vertices adyacentes (salientes)
	 * @return LinkedList con los vertices adyacentes (salientes a este)
	 */
	public LinkedList<Vertex<K,V>> vertices(){
		return null;
		
	}
	/**
	 * Retorna una lista con sus arcos adyacentes (salientes)
	 * @return LinkedList con los arcos adyacentes (salientes) de este vertice (Nodo)
	 */
	public LinkedList<Edge<K,V>> edges(){
		return null;
		
	}

}
