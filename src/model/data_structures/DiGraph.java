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

		if(inicio <0 || destino <0 || inicio > initialSize || destino > initialSize ) // valida entradas de parametros
			throw new  IllegalArgumentException("Id de inicio o de fin tienen que estar dentro de los limites.");
		
		Vertex<K,V> nodoSource = adj.get(inicio);
		Vertex<K,V> nodoDestino = adj.get(destino);
		Edge<K,V> nuevoArco = new Edge<K,V>(nodoSource, nodoDestino, weight); // crea el objeto arco
		
		nodoSource.addEdge(nuevoArco);// pasa el objeto arco al nodo origen para que se guarde la asociacion entre ambos vertices.
		nodoDestino.addInDegree();	 // suma al numero de arcos entrantes al nodoDestino.
		
	}

	@Override
	public Vertex<K, V> getVertex(K id) {
		
		int pos = Integer.parseInt((String) id);
		return adj.get(pos);
	}

	@Override
	public Edge<K, V> getEdge(K idS, K idD) {
		
		int posSource = Integer.parseInt((String) idS);
		int posDestiny = Integer.parseInt((String) idD);
		
		if(posSource <0 || posDestiny <0 || posSource > initialSize || posDestiny > initialSize )
			throw new  IllegalArgumentException("Id de inicio o de fin tienen que estar dentro de los limites.");
		
		Vertex<K,V> source = adj.get(posSource); // guarda el vertice de source en una variable
									
		return source.getEdge(idD);				// busca y retorna el arco entre este vertice y el idD. 
		
	}

	@Override
	public LinkedList<Edge<K, V>> adjacentEdges(K id) {
		
		int pos = Integer.parseInt((String)id);
		return adj.get(pos).edges();
	}

	@Override
	public LinkedList<Vertex<K, V>> adjacentVertex(K id) {
		
		int pos = Integer.parseInt((String)id);
		return adj.get(pos).vertices();
	}

	@Override
	public int indegree(K idVertex) {
		int pos = Integer.parseInt((String) idVertex);
		return adj.get(pos).indegree();
	}

	@Override
	public int outdegree(K idVertex) {
		int pos = Integer.parseInt((String) idVertex);
		return adj.get(pos).outdegree();
	}

	@Override
	public LinkedList<Edge<K, V>> edges() {
	
		LinkedList<Edge<K,V>> result = new LinkedList<Edge<K,V>>();
		Vertex<K,V> vertex;
		for(int i=0; i < initialSize; i++) {
			
			if((vertex = adj.get(i))==null) {
				continue;
			}
			else {
				for(Edge<K,V> edge : vertex.edges() ) {
					
					result.add(edge);
				}
			}
		}
		
		return result;
	}

	@Override
	public LinkedList<Vertex<K, V>> vertices() {

		LinkedList<Vertex<K,V>> result = new LinkedList<Vertex<K,V>>();
		Vertex<K,V> vertex;
		for(int i=0; i < initialSize; i++) {
			
			if((vertex = adj.get(i))==null) {
				continue;
			}
			else {
				result.add(vertex);
			}
		}
		
		return result;
	}

}
