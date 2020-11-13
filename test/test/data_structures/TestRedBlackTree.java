package test.data_structures;


import static org.junit.Assert.assertTrue;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import model.data_structures.RedBlackTree;
import model.data_structures.RedBlackTree.Node;

public class TestRedBlackTree {
	
	/**
	 * atributo del árbol
	 */
	private RedBlackTree<String, Integer> rbt;
	
	@Before
	public void Setup1() {
		rbt = new RedBlackTree<String, Integer>();
		rbt.put("a", 1);
		rbt.put("c", 2);
		rbt.put("e", 3);
		rbt.put("j", 4);
		rbt.put("g", 5);
		rbt.put("d", 6);
		rbt.put("c", 22);
		
	}
	
	
	@Test
	public void testSize() {
		   assertTrue(checkSize());
	}
    private boolean checkSize() { return checkSize(rbt.root); }
    
	private boolean checkSize(Node x) {
	        if (x == null) return true;
	        if (x.size != rbt.size(x.left) + rbt.size(x.right) + x.values.size()) return false;
	        return checkSize(x.left) && checkSize(x.right);
	    } 
	
	@Test
	public void testHeight(){

		assertTrue(rbt.height()==3);
		rbt.put("h", 7);
		assertTrue(rbt.height()==3);
		rbt.put("l", 8);
		rbt.put("n", 9);
		rbt.put("m", 10);
		rbt.put("k", 11);
		assertTrue(rbt.height()==4);
	}
	
	@Test
	public void testGetHeight(){
		assertTrue(rbt.getHeight("j")==1);
		assertTrue(rbt.getHeight("a")==2);
		assertTrue(rbt.getHeight("d")==3);
	}
	
	@Test
	public void testGet(){
		assertTrue(rbt.get("d").getFirst()==6);
		assertTrue(rbt.get("a").getFirst()==1);
		assertTrue(rbt.get("g").getFirst()==5);
	}
	


	// verifica que el arbol no tenga enlaces rojos inclinados a la derecha
	// y como maximo 1 enlace rojo (a la izquierda) seguidos en cualquier camino.
	@Test
    public void testEsRBT() {
    	assertTrue(esRBT(rbt.root)); 
    }
    
    private boolean esRBT(Node x) {
        if (x == null) return true;
        if (rbt.isRed(x.right)) return false;
        if (x != rbt.root && rbt.isRed(x) && rbt.isRed(x.left))
            return false;
        return esRBT(x.left) && esRBT(x.right);
    } 

    // verifica que todos los caminos desde la raiz a una hoja tengan el mismo numero de enlaces negros
    @Test
    public void testEstaBalanceado() {
    	assertTrue(isBalanced());
    }
    private boolean isBalanced() { 
        int black = 0;     // numero de enlaces negros en caminos desde raiz a min
        Node x = rbt.root;
        while (x != null) {
            if (!rbt.isRed(x)) black++;
            x = x.left;
        }
        return isBalanced(rbt.root, black);
    }

    // verifica que cada camino desde la raiz a alguna hoja tenga el mismo numero de enlaces negros.
    private boolean isBalanced(Node x, int black) {
        if (x == null) return black == 0;
        if (!rbt.isRed(x)) black--;
        return isBalanced(x.left, black) && isBalanced(x.right, black);
    } 

	@Test
	public void testKeySet(){
		
		LinkedList<String> listaLlaves =  (LinkedList<String>) rbt.keySet();
		assertTrue(listaLlaves.size()==6);
		int correct =0;
		boolean Inorden = true;
		String first = "a";
		for(String key: listaLlaves) {
			
			if(first.compareTo(key)>0) {Inorden= false;}
			first = key;
			if(key=="a") correct ++;
			if(key=="c") correct ++;
			if(key=="d") correct ++;
			if(key=="e") correct ++;
			if(key=="g") correct ++;
			if(key=="j") correct ++;
		}
		assertTrue(correct==6);
		assertTrue(Inorden);

	}
	
	@Test
	public void testKeysInRange(){
		
		LinkedList<String> listaLlaves =  (LinkedList<String>) rbt.keysInRange("a", "e");
		assertTrue(listaLlaves.size()==4);
		int correct =0;
		boolean Inorden = true;
		String first = "a";
		for(String key: listaLlaves) {
			
			if(first.compareTo(key)>0) {Inorden= false;}
			first = key;
			if(key=="a") correct ++;
			if(key=="c") correct ++;
			if(key=="d") correct ++;
			if(key=="e") correct ++;
		}
		assertTrue(correct==4);
		assertTrue(Inorden);

	}
	
	@Test
	public void testValuesInRange(){
		
		LinkedList<Integer> listaValues =  (LinkedList<Integer>) rbt.valuesInRange("a", "e");
		assertTrue(listaValues.size()==5);
		int correct =0;
		for(int values: listaValues) {
		
			if(values==1) correct ++;
			if(values==2) correct ++;
			if(values==3) correct ++;
			if(values==6) correct ++;
			if(values==22) correct ++;
		}
		assertTrue(correct==5);

	}
	
	@Test
	public void min() {
		assertTrue(rbt.min().compareTo("a")==0);
	}
	@Test
	public void max() {
		assertTrue(rbt.max().compareTo("j")==0);
	}
	
	@Test
	public void cointains() {
		assertTrue(rbt.contains("a"));
	}
	
	@Test
	public void isEmpty() {
		assertTrue(rbt.isEmpty()==false);
	}
	
	
	

	

}
