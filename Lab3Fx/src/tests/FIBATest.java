package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import collections.RBNode;
import modelo.FIBA;



class FIBATest {

	private FIBA fiba;
	private Integer player1;
	private Integer player2;
	private Integer player3;
	private Integer player4;
	private Integer player5;
	private Integer player6;
	
	public void setUp1() throws ClassNotFoundException, IOException {
		fiba=new FIBA();
		player1=1;
		player2=2;
		player3=3;
		player4=4;
		player5=5;
		player6=6;
	
	}
	
	public void setUp2() throws ClassNotFoundException, IOException {
		fiba=new FIBA();
		player1=1;
		player2=2;
		player3=3;
		player4=4;
		player5=5;
		player6=6;
		fiba.insertLocks(100.0, player1);
		fiba.insertLocks(92.0, player2);
		fiba.insertLocks(93.0, player3);
		fiba.insertLocks(105.0, player4);
		fiba.insertLocks(102.0, player5);
		fiba.insertLocks(91.0, player6);
	
	}
	@Test
	public void insertTestRB() throws ClassNotFoundException, IOException {
		setUp1();
		fiba.insertLocks(100.0, player1);
		fiba.insertLocks(92.0, player2);
		fiba.insertLocks(93.0, player3);
		fiba.insertLocks(105.0, player4);
		fiba.insertLocks(102.0, player5);
		fiba.insertLocks(91.0, player6);
		assertEquals(fiba.getRBLocksTree().getRoot().getValue(),player3);
		assertEquals(fiba.getRBLocksTree().getRoot().getLeft().getValue(),player2);
		assertEquals(fiba.getRBLocksTree().getRoot().getRight().getColor(),RBNode.BLACK);
	}
	
	@Test
	public void deleteTestRB() throws ClassNotFoundException, IOException {
		setUp2();
	
		fiba.deleteLocks(102.0);
		assertEquals(fiba.getRBLocksTree().getRoot().getRight().getValue(),player1);
	}
	
	@Test
	public void searchTestRB() throws ClassNotFoundException, IOException {
		setUp2();
		
		assertEquals(fiba.getRBLocksTree().RBSearch(fiba.getRBLocksTree().getRoot(), 92.0).getValue(),player2);
	}
	
	@Test
	public void insertStealAVL() throws ClassNotFoundException, IOException {
		setUp1();
		
		fiba.insertStealAVL(10.0, player1);
		fiba.insertStealAVL(5.0, player2);
		fiba.insertStealAVL(2.0, player3);
		fiba.insertStealAVL(1.0, player4);
		fiba.insertStealAVL(11.0, player5);
		fiba.insertStealAVL(3.0, player6);
		
		assertEquals(fiba.getStealAVLTree().getRoot().getValue(),player2);
		
	}
	
	
	@Test
	public void deleteStealAVL() throws ClassNotFoundException, IOException {
		setUp1();
		
		fiba.insertStealAVL(10.0, player1);
		fiba.insertStealAVL(5.0, player2);
		fiba.insertStealAVL(2.0, player3);
		fiba.insertStealAVL(1.0, player4);
		fiba.insertStealAVL(11.0, player5);
		fiba.insertStealAVL(3.0, player6);
		
		Integer x= fiba.getStealAVLTree().search(10.0, fiba.getStealAVLTree().getRoot()).getValue();
		
		assertEquals(player1, x);
		
		
		
	}
	

}
