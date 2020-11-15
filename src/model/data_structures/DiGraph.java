package model.data_structures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

public class DiGraph <K extends Comparable<K>, V> implements IDiGraph< K, V>
{
	//--------------------
	//ATRIBUTOS
	//--------------------


    private int edges;              // numero de arcos en este digrafo
   // private int vertices;			// numero de vertices en este digrafo
    private ArrayList<Vertex<K,V>> adj;
    private int initialSize;
    
	//--------------------
	//CONSTRUCTOR
	//--------------------
    
    public DiGraph (int size) {
    	
    	adj = new ArrayList<Vertex<K,V>>(size);
    	initialSize = size;
    }
    
    
	@Override
	public boolean containsVertex(K id) {
		
		int pos = Integer.parseInt((String) id);
		return adj.get(pos)!=null;
	
	}

	@Override
	public int numVertices() {
		// TODO Auto-generated method stub
		return adj.size();
		
	}

	@Override
	public int numEdges() {
		
		return edges;
	}

	@Override
	public void insertVertex(K id, V value) {
		
		Vertex<K,V> nuevo = new Vertex<K,V>(id, value);
		int pos = Integer.parseInt((String) id);
		adj.add(pos, nuevo); // agrega a la lista en la posicion del Id, automticamente se actualiza el numVertices.
		
	}

	@Override
	public void addEdge(K source, K dest, double weight) {
		
		int inicio = Integer.parseInt((String) source);
		int destino = Integer.parseInt((String) dest);

		if(inicio <0 || destino <0 || inicio > initialSize || destino > initialSize )
			throw new  IllegalArgumentException("Id de inicio o de fin tienen que estar dentro de los limites.");
		
		Vertex<K,V> NodoSource = adj.get(inicio);
		Vertex<K,V> NodoDestino = adj.get(destino);
		Edge<K,V> nuevoArco = new Edge<K,V>(NodoSource, NodoDestino, weight);
		
		NodoSource.addEdge(nuevoArco);
		
	}

	@Override
	public Vertex<K, V> getVertex(K id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Edge<K, V> getEdge(K idS, K idD) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedList<Edge<K, V>> adjacentEdges(K id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedList<Vertex<K, V>> adjacentVertex(K id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indegree(K vertex) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int outdegree(K vertex) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public LinkedList<Edge<K, V>> edges() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedList<Vertex<K, V>> vertices() {
		// TODO Auto-generated method stub
		return null;
	}


}
