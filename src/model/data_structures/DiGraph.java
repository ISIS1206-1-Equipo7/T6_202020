package model.data_structures;

import java.util.LinkedList;

public class DiGraph <K extends Comparable<K>, V> implements IDiGraph<Comparable<K>, V>
{

	@Override
	public boolean containsVertex(Comparable<K> id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int numVertices() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int numEdges() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void insertVertex(Comparable<K> id, V value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addEdge(Comparable<K> source, Comparable<K> dest, double weight) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vertex<Comparable<K>, V> getVertex(Comparable<K> id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Edge<Comparable<K>, V> getEdge(Comparable<K> idS, Comparable<K> idD) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedList<Edge<Comparable<K>, V>> adjacentEdges(Comparable<K> id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedList<Vertex<Comparable<K>, V>> adjacentVertex(Comparable<K> id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indegree(Comparable<K> vertex) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int outdegree(Comparable<K> vertex) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public LinkedList<Edge<Comparable<K>, V>> edges() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedList<Vertex<Comparable<K>, V>> vertices() {
		// TODO Auto-generated method stub
		return null;
	}

}
