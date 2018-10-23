package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import collections.AVLNode;
import collections.AVLTree;
import collections.IAVLTree;
import collections.IRBTree;
import collections.RBTree;

public class FIBA {

	private IAVLTree<Double, Integer> reboundsAVLTree;
	private IAVLTree<Double, Integer> stealAVLTree;
	private IRBTree<Integer,Integer> locksRBTree;
	private FileReader fr;
	private BufferedReader br;
	private FileWriter fw;
	private BufferedWriter bw;
//	private int playerAmount;

	public FIBA() throws ClassNotFoundException, IOException {

		reboundsAVLTree = new AVLTree<Double, Integer>(); 	
		stealAVLTree = new AVLTree<Double, Integer>();
		locksRBTree= new RBTree<Integer,Integer>();
		
//		deStealTree();
//		deReboundsTree();
//		playerAmount = reboundsAVLTree.getAmountNode();

	}
	

	public IRBTree<Integer, Integer> getRBTree() {
		return locksRBTree;
	}


	public void setRBTree(IRBTree<Integer, Integer> rbTree) {
		this.locksRBTree = rbTree;
	}


	public void insert(int key, int value) {
		locksRBTree.RBInsert(key, value);
	}
	public Integer search(int key) {
		return locksRBTree.RBSearch(locksRBTree.getRoot(),key).getValue();
	}
	
	public void delete(int key) {
		locksRBTree.RBDelete(key);
	}
	

	public Player searchReboundsAVL(Double key) throws IOException {

		Integer num = reboundsAVLTree.search(key, reboundsAVLTree.getRoot()).getValue();

		return searchTxtPlayer(num + "");
	}

	public Player searchStealAVL(Double key) throws IOException {

		System.out.println(key+ " Valor a buscar");
		Integer num = stealAVLTree.search(key, stealAVLTree.getRoot()).getValue();
		System.out.println(num +" NUM");
		return searchTxtPlayer(num + "");
	}

	public Player searchTxtPlayer(String value) throws IOException {

		File f = new File("PlayersData/" + value + ".txt/");
		System.out.println("VALUE TXT "+value);
		fr = new FileReader(f);
		br = new BufferedReader(fr);

		String line = br.readLine();
		String[] info = line.split(",");
		Player found = new Player(info[0], Integer.parseInt(info[1]), info[2], Integer.parseInt(info[3]),
				Double.parseDouble(info[4]), Double.parseDouble(info[5]), Double.parseDouble(info[6]),
				Double.parseDouble(info[7]));

		return found;

	}

	public void addNewPlayer(Player newPlayer) throws IOException {

		reboundsAVLTree.amountNodes(reboundsAVLTree.getRoot());
		int index = reboundsAVLTree.getAmountNode() + 1;
		reboundsAVLTree.insert(newPlayer.getRebounds(), index);
		stealAVLTree.insert(newPlayer.getSteal(), index);
		writeNewPlayer(newPlayer, index);

	}

	public void writeNewPlayer(Player player, int index) throws IOException {

		File file = new File("PlayersData/" + index + ".txt/");
		fw = new FileWriter(file);
		bw = new BufferedWriter(fw);

		bw.write(player.getName() + "," + player.getEdad() + "," + player.getTeam() + "," + player.getPoints() + ","
				+ player.getRebounds() + "," + player.getAssists() + "," + player.getSteal() + "," + player.getLocks());
		bw.close();

	}

	public long executionTime(long startTime, long endTime) {
		return endTime - startTime;
	}
	
	public void cargarRebotes() throws IOException {
		
		
		
		for (int i = 0; i < 199997; i++) {
			File actual = new File("PlayersData/"+i+".txt/");
			System.out.println(actual.getName()+ " Nombre file");
			fr= new FileReader(actual);
			br=new BufferedReader(fr);
			String line= br.readLine();
			String [] info= line.split(",");
//			System.out.println(info[4]);
			Double d=Double.parseDouble(info[4]);
			reboundsAVLTree.insert(d, (Integer)i);
			
			
		}
		System.out.println("listo");
		serializar();
		
		
	}
	public void serializar() throws IOException {
		
		FileOutputStream fout=new FileOutputStream("ArbolesSerializados/reboundsAVLTree.dat");
		ObjectOutputStream obj= new ObjectOutputStream(fout);
		obj.writeObject(reboundsAVLTree.getRoot());
		
		obj.close();
		fout.close();
		
	}
	public void deStealTree() throws IOException, ClassNotFoundException {
		FileInputStream fi= new FileInputStream("ArbolesSerializados/stealAVLTree.dat");
		ObjectInputStream obj= new ObjectInputStream(fi);
		
		AVLNode<Double, Integer> newRoot=(AVLNode<Double, Integer>)obj.readObject();
		
		stealAVLTree.setRoot(newRoot);
		
		obj.close();
		fi.close();
	
		

	}
	public void deReboundsTree() throws IOException, ClassNotFoundException {
		FileInputStream fi= new FileInputStream("ArbolesSerializados/reboundsAVLTree.dat");
		ObjectInputStream obj= new ObjectInputStream(fi);
		
		IAVLTree<Double, Integer> newRoot=(IAVLTree<Double, Integer>)obj.readObject();
		
		reboundsAVLTree.setRoot(newRoot.getRoot());
		
		obj.close();
		fi.close();
	
		

	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		FIBA fi= new FIBA();
//		fi.cargarRebotes();
		
		
	
	}
	

}
