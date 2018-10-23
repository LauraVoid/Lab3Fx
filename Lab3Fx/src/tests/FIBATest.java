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
		fiba.insertPoints(100.0, player1);
		fiba.insertPoints(92.0, player2);
		fiba.insertPoints(93.0, player3);
		fiba.insertPoints(105.0, player4);
		fiba.insertPoints(102.0, player5);
		fiba.insertPoints(91.0, player6);
	
	}
	@Test
	public void insertTest() throws ClassNotFoundException, IOException {
		setUp1();
		fiba.insertPoints(100.0, player1);
		fiba.insertPoints(92.0, player2);
		fiba.insertPoints(93.0, player3);
		fiba.insertPoints(105.0, player4);
		fiba.insertPoints(102.0, player5);
		fiba.insertPoints(91.0, player6);
		assertEquals(fiba.getRBPointsTree().getRoot().getValue(),player3);
		assertEquals(fiba.getRBPointsTree().getRoot().getLeft().getValue(),player2);
		assertEquals(fiba.getRBPointsTree().getRoot().getRight().getColor(),RBNode.BLACK);
	}
	
	@Test
	public void deleteTest() throws ClassNotFoundException, IOException {
		setUp2();
	
		fiba.deletePoints(102.0);
		assertEquals(fiba.getRBPointsTree().getRoot().getRight().getValue(),player1);
	}
	
	@Test
	public void searchTest() throws ClassNotFoundException, IOException {
		setUp2();
		assertEquals(fiba.getRBPointsTree().getRoot().getRight().getValue(),fiba.searchPoints(102.0));
		assertEquals(fiba.getRBPointsTree().getRoot().getValue(),fiba.searchPoints(93.0));
	}

}
