package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import collections.AVLNode;
import collections.AVLTree;
import collections.Abb;
import collections.AbbNode;
import collections.IAVLTree;
import collections.IRBTree;
import collections.RBNode;
import collections.RBTree;

public class FIBA {

	private IAVLTree<Double, Integer> reboundsAVLTree;
	private IAVLTree<Double, Integer> stealAVLTree;
	private IRBTree<Double, Integer> stealRBTree;
	private IRBTree<Double, Integer> locksRBTree;
	private Abb<Double, Integer> reboundsABBTree;
	private Abb<Double, Integer> assistsABBTree;

	private FileReader fr;
	private BufferedReader br;
	private FileWriter fw;
	private BufferedWriter bw;
	private Integer playerAmount;

	public FIBA() throws ClassNotFoundException, IOException {

		reboundsAVLTree = new AVLTree<Double, Integer>();
		stealAVLTree = new AVLTree<Double, Integer>();
		locksRBTree = new RBTree<Double, Integer>();
		stealRBTree = new RBTree<Double, Integer>();
		reboundsABBTree = new Abb<Double, Integer>();
		assistsABBTree = new Abb<Double, Integer>();

//		deStealAVLTree();
//	    deStealRBTree();
//		deReboundsAVLTree();
//		deLocksRBTree();
//		deAssistsABBTree();
//		deReboundsABBTree();
//		deAssistsABBTree();
		playerAmount = 199999;

	}

	public int getPlayerAmount() {
		return playerAmount;
	}

	public void setPlayerAmount(int playerAmount) {
		this.playerAmount = playerAmount;
	}

	public IAVLTree<Double, Integer> getReboundsAVLTree() {
		return reboundsAVLTree;
	}

	public void setReboundsAVLTree(IAVLTree<Double, Integer> reboundsAVLTree) {
		this.reboundsAVLTree = reboundsAVLTree;
	}

	public IAVLTree<Double, Integer> getStealAVLTree() {
		return stealAVLTree;
	}

	public void setStealAVLTree(IAVLTree<Double, Integer> stealAVLTree) {
		this.stealAVLTree = stealAVLTree;
	}

	public IRBTree<Double, Integer> getLocksRBTree() {
		return locksRBTree;
	}

	public void setLocksRBTree(IRBTree<Double, Integer> locksRBTree) {
		this.locksRBTree = locksRBTree;
	}

	public Abb<Double, Integer> getReboundsABBTree() {
		return reboundsABBTree;
	}

	public void setReboundsABBTree(Abb<Double, Integer> reboundsABBTree) {
		this.reboundsABBTree = reboundsABBTree;
	}

	public Abb<Double, Integer> getAssistsABBTree() {
		return assistsABBTree;
	}

	public void setAssistsABBTree(Abb<Double, Integer> assistsABBTree) {
		this.assistsABBTree = assistsABBTree;
	}

	public IRBTree<Double, Integer> getRBLocksTree() {
		return locksRBTree;
	}

	public void setRBLocksTree(IRBTree<Double, Integer> locksRBTree) {
		this.locksRBTree = locksRBTree;
	}

	public void insertLocks(Double key, Integer value) {
		locksRBTree.RBInsert(key, value);
	}

	public IRBTree<Double, Integer> getStealRBTree() {
		return stealRBTree;
	}

	public void setStealRBTree(IRBTree<Double, Integer> stealRBTree) {
		this.stealRBTree = stealRBTree;
	}

	public void deleteStealAVL(double key) {


		stealAVLTree.remove(key, stealAVLTree.getRoot());
	}

	public void deleteReboundsAVL(double key) {

		reboundsAVLTree.remove(key, reboundsAVLTree.getRoot());
	}

	public void insertStealAVL(Double key, Integer value) {
		stealAVLTree.insert(key, value);
	}

	public void deleteLocks(Double key) {
		locksRBTree.RBDelete(key);
	}

	public Player searchReboundsAVL(Double key) throws Exception {

		Integer num = reboundsAVLTree.search(key, reboundsAVLTree.getRoot()).getValue();

		return searchTxtPlayer(num + "");
	}

	public Player searchReboundsABB(Double key) throws IOException, Exception {

		System.out.println(reboundsABBTree.searchAbb(key));
//		System.out.println(reboundsABBTree.searchAbb(key).getDate());
		Integer num = reboundsABBTree.searchAbb(key).getValue();

		return searchTxtPlayer(num + "");
	}

	public Player searchAssistsABB(Double key) throws IOException {

		Integer num = assistsABBTree.searchAbb(key).getValue();

		return searchTxtPlayer(num + "");
	}

	public Player searchStealAVL(Double key) throws IOException {

//		System.out.println(key+ " Valor a buscar");
		Integer num = stealAVLTree.search(key, stealAVLTree.getRoot()).getValue();
//		System.out.println(num +" NUM");
		return searchTxtPlayer(num + "");
	}

	public Player searchLocksRB(Double key) throws IOException {

		Integer num = locksRBTree.RBSearch(locksRBTree.getRoot(), key).getValue();

		return searchTxtPlayer(num + "");
	}

	public Player searchStealRB(Double key) throws IOException {

		Integer num = stealRBTree.RBSearch(stealRBTree.getRoot(), key).getValue();

		return searchTxtPlayer(num + "");
	}


	public Player searchTxtPlayer(String value) throws IOException {

		File f = new File("PlayersData/" + value + ".txt/");
		System.out.println("VALUE TXT " + value);
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

		writeNewPlayer(newPlayer, playerAmount);
		locksRBTree.RBInsert(newPlayer.getLocks(), playerAmount);
		stealRBTree.RBInsert(newPlayer.getSteal(), playerAmount);
		stealAVLTree.insert(newPlayer.getSteal(), playerAmount);
		reboundsAVLTree.insert(newPlayer.getRebounds(), playerAmount);
		reboundsABBTree.addAbb(newPlayer.getRebounds(), playerAmount);
		assistsABBTree.addAbb(newPlayer.getAssists(), playerAmount);

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

		for (int i = 0; i < 199999; i++) {
			File actual = new File("PlayersData/" + i + ".txt/");
			System.out.println(actual.getName() + " Nombre file");
			fr = new FileReader(actual);
			br = new BufferedReader(fr);
			String line = br.readLine();
			String[] info = line.split(",");
			double d = Double.parseDouble(info[5]);
			assistsABBTree.addAbb(d, (Integer) i);
//			Integer d=Integer.parseInt(info[3]);
//			pointsABBTree.addAbb(d, (Integer)1);

		}
		System.out.println("listo");
		serializar();

	}

	public void serializar() throws IOException {

		FileOutputStream fout = new FileOutputStream("ArbolesSerializados/assistsABBTree.dat");
		ObjectOutputStream obj = new ObjectOutputStream(fout);
		obj.writeObject(assistsABBTree.getRoot());

		obj.close();
		fout.close();

	}

	public void deStealAVLTree() throws IOException, ClassNotFoundException {
		FileInputStream fi = new FileInputStream("ArbolesSerializados/stealAVLTree.dat");
		ObjectInputStream obj = new ObjectInputStream(fi);

		AVLNode<Double, Integer> newRoot = (AVLNode<Double, Integer>) obj.readObject();

		stealAVLTree.setRoot(newRoot);

		obj.close();
		fi.close();

	}

	public void deStealRBTree() throws IOException, ClassNotFoundException {
		FileInputStream fi = new FileInputStream("ArbolesSerializados/stealRBTree.dat");
		ObjectInputStream obj = new ObjectInputStream(fi);

		RBNode<Double, Integer> newRoot = (RBNode<Double, Integer>) obj.readObject();

		stealRBTree.setRoot(newRoot);

		obj.close();
		fi.close();

	}

	public void deReboundsAVLTree() throws IOException, ClassNotFoundException {
		FileInputStream fi = new FileInputStream("ArbolesSerializados/reboundsAVLTree.dat");
		ObjectInputStream obj = new ObjectInputStream(fi);

		AVLNode<Double, Integer> newRoot = (AVLNode<Double, Integer>) obj.readObject();
		System.out.println(newRoot.getKey() + "nueva root");
		reboundsAVLTree.setRoot(newRoot);

		obj.close();
		fi.close();

	}

	public void deLocksRBTree() throws IOException, ClassNotFoundException {
		FileInputStream fi = new FileInputStream("ArbolesSerializados/locksRBTree.dat");
		ObjectInputStream obj = new ObjectInputStream(fi);

		RBNode<Double, Integer> newRoot = (RBNode<Double, Integer>) obj.readObject();

		locksRBTree.setRoot(newRoot);

		obj.close();
		fi.close();

	}

	public void deReboundsABBTree() throws IOException, ClassNotFoundException {
		FileInputStream fi = new FileInputStream("ArbolesSerializados/reboundsABBTree.dat");
		ObjectInputStream obj = new ObjectInputStream(fi);

		AbbNode<Double, Integer> newRoot = (AbbNode<Double, Integer>) obj.readObject();

		reboundsABBTree.setRoot(newRoot);

		obj.close();
		fi.close();

	}

	public void deAssistsABBTree() throws IOException, ClassNotFoundException {
		FileInputStream fi = new FileInputStream("ArbolesSerializados/assistsABBTree.dat");
		ObjectInputStream obj = new ObjectInputStream(fi);

		AbbNode<Double, Integer> newRoot = (AbbNode<Double, Integer>) obj.readObject();

		assistsABBTree.setRoot(newRoot);

		obj.close();
		fi.close();

	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {

//		FIBA fi= new FIBA();
//		fi.cargarRebotes();
//		fi.getStealRBTree().RBInsert(35.75075961202617, 1);
//		System.out.println(fi.getStealRBTree().getRoot().getKey());
//		fi.insertPoints(100, value);
//		fi.searchPointsRB(10.2);

	}

}
