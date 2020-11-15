package test.data_structures;

import static org.junit.Assert.*;

import org.junit.*;

import model.data_structures.Edge;
import model.data_structures.Vertex;

public class testVertex {

	private Vertex<Integer, String> vertice;
	private Edge<Integer, String> arco;
	private Edge<Integer, String> arco2;
	private Edge<Integer, String> arco3;
	
	@Before
	public void Setup1() {
		vertice = new Vertex<>(1, "Uno");
		Vertex source = new Vertex<Integer, String>(2, "Dos");
		Vertex dest = new Vertex<Integer, String>(3, "Tres");
		double weight = 0.5;
		arco = new Edge<>(source, dest, weight);
		Vertex source2 = new Vertex<Integer, String>(4, "Cuatro");
		Vertex dest2 = new Vertex<Integer, String>(5, "Cinco");
		double weight2 = 0.10;
		arco2 = new Edge<>(source2, dest2, weight2);
		Vertex source3 = new Vertex<Integer, String>(6, "Seis");
		Vertex dest3 = new Vertex<Integer, String>(7, "Siete");
		double weight3 = 0.15;
		arco3 = new Edge<>(source3, dest3, weight3);
	}
	
	@Test
	public void testGetId(){
		assertTrue(vertice.getId()==1);
	}
	
	@Test
	public void testGetInfo() {
		assertTrue(vertice.getInfo().equals("Uno"));
	}
	
	@Test
	public void testGetMark() {
		assertFalse(vertice.getMark());
		vertice.mark();
		assertTrue(vertice.getMark());
		vertice.unmark();
		assertFalse(vertice.getMark());
	}
	
	@Test
	public void testAddEdge() {
		assertTrue(vertice.edges().isEmpty()); //La lista de arcos debe estar vacia
		assertTrue(vertice.vertices().isEmpty());//La lista de vertices
		vertice.addEdge(arco);				   //Se agrega el arco, arco
		assertFalse(vertice.edges().isEmpty());//La lista de arcos ya no debe estar vacia
		assertFalse(vertice.vertices().isEmpty());//La lista de vertices ya no debe estar vacia
		assertTrue(vertice.edges().contains(arco));//La lista debe contener el arco previamente agregado
		assertFalse(vertice.edges().contains(arco2));// La lista no debe contener el arco no agregado
		assertTrue(vertice.vertices().getFirst()==arco.getDest());
		vertice.addEdge(arco2);
		vertice.addEdge(arco3);
		assertTrue(vertice.edges().size()==3);
	}
	
	@Test
	public void testGetEdge() {
		assertNull(vertice.getEdge(1));
		vertice.addEdge(arco);
		vertice.addEdge(arco2);
		vertice.addEdge(arco3);
		assertTrue(vertice.getEdge(1)==arco);
		assertTrue(vertice.getEdge(2)==arco2);
		assertTrue(vertice.getEdge(3)==arco3);
	}
}
