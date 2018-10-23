package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import collections.RBNode;
import modelo.FIBA;


class RBTreeTest {

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
		fiba.insert(100, player1);
		fiba.insert(92, player2);
		fiba.insert(93, player3);
		fiba.insert(105, player4);
		fiba.insert(102, player5);
		fiba.insert(91, player6);
	
	}
	@Test
	public void insertTest() throws ClassNotFoundException, IOException {
		setUp1();
		fiba.insert(100, player1);
		fiba.insert(92, player2);
		fiba.insert(93, player3);
		fiba.insert(105, player4);
		fiba.insert(102, player5);
		fiba.insert(91, player6);
		assertEquals(fiba.getRBTree().getRoot().getValue(),player3);
		assertEquals(fiba.getRBTree().getRoot().getLeft().getValue(),player2);
		assertEquals(fiba.getRBTree().getRoot().getRight().getColor(),RBNode.BLACK);
	}
	
	@Test
	public void deleteTest() throws ClassNotFoundException, IOException {
		setUp2();
	
		fiba.delete(102);
		assertEquals(fiba.getRBTree().getRoot().getRight().getValue(),player1);
	}
	
	@Test
	public void searchTest() throws ClassNotFoundException, IOException {
		setUp2();
		assertEquals(fiba.getRBTree().getRoot().getRight().getValue(),fiba.search(102));
		assertEquals(fiba.getRBTree().getRoot().getValue(),fiba.search(93));
	}

}
