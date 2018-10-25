package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import collections.Abb;

public class testAbb {

	private Abb<Double, Integer> abb;
	
	@Before
	public void inicializate() {
		abb = new Abb<Double, Integer>();
	}

	@Test
	public void testAddAbb() {
		double one = 1.0;
		double two = 2.0;
		double mOne = -1.0;
		
		abb.addAbb(one, 1);
		abb.addAbb(two, 2);
		abb.addAbb(mOne, 3);
		
		
		assertTrue(two == abb.getRoot().getRight().getDate().doubleValue());
	}
	
	@Test
	public void testDelete() {
		double one = 1.0;
		double two = 2.0;
		double mOne = -1.0;
		double mTwo = -2.0;
		double mThree = -3.0;
		
		abb.addAbb(one, 1);
		abb.addAbb(two, 2);
		abb.addAbb(mOne, 3);
		abb.addAbb(mTwo, 4);
		abb.addAbb(mThree, 5);
		
		abb.deleteAbb(one);
		
		assertTrue(abb.getRoot().getDate() == mOne);
		
		System.out.println(abb.getRoot());
		System.out.println(abb.getRoot().getLeft());
		System.out.println(abb.getRoot().getRight());

	}
	
	@Test
    public void testSearch() {
		
		double one = 1.0;
		double two = 2.0;
		double mOne = -1.0;
		double mTwo = -2.0;
		double mThree = -3.0;
		
		abb.addAbb(one, 1);
		abb.addAbb(two, 2);
		abb.addAbb(mOne, 3);
		abb.addAbb(mTwo, 4);
		abb.addAbb(mThree, 5);
		
    	double hope = abb.searchAbb(-3.0).getDate();
    	System.out.println("El resultado is:"+hope);
   	
   	    assertTrue(mThree == hope);
    	
    }
}
