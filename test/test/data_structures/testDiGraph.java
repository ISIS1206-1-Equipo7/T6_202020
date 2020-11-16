package test.data_structures;

import org.junit.*;

import model.data_structures.DiGraph;
import model.data_structures.Vertex;

public class testDiGraph {

	private DiGraph<Integer, Integer> grafo;
	
	@Before
	public void SetUp1() {
		grafo = new DiGraph<>(0);
		grafo.insertVertex(0, 0);
		grafo.insertVertex(1, 1);
		grafo.insertVertex(2, 2);
		grafo.insertVertex(3, 3);
		grafo.insertVertex(4, 4);
		grafo.insertVertex(5, 5);
		grafo.insertVertex(6, 6);
		grafo.insertVertex(7, 7);
		grafo.insertVertex(8, 8);
		grafo.insertVertex(9, 9);
		grafo.insertVertex(10, 10);
		grafo.insertVertex(11, 11);
		grafo.insertVertex(12, 12);		
	}
	
	@Test
	public void testContainsVertex() {
		
	}
}
