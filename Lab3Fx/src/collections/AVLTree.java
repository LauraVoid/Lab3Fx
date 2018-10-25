package collections;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

//
public class AVLTree<Q, K> implements IAVLTree<Q, K> {
//
	private AVLNode<Q, K> root;
	private int amountNode;

	public AVLTree() {
		super();
		amountNode = -1;
		this.root = null;

	}

//
	@Override
	public AVLNode<Q, K> getRoot() {
		return root;
	}

//
	@Override
	public void setRoot(AVLNode<Q, K> root) {
		this.root = root;
	}

	@Override
	public int getAmountNode() {
		return amountNode;
	}

	public void setAmountNode(int amountNode) {
		this.amountNode = amountNode;
	}

	//
	/**
	 * @return retorna la nueva raiz del arbol balanceado
	 */
	@Override
	public AVLNode<Q, K> add(Q key, K value, AVLNode<Q, K> ele) {

		if (ele == null) {

//			amountNodes(root);
//			int index=getAmountNode();
			amountNode++;

			return new AVLNode<Q, K>(key, value);

		}
		AVLNode<Q, K> element = new AVLNode<Q, K>(key, value);

		if (element.compareTo(ele) < 0) {
			ele.setLeft(add(key, value, ele.getLeft()));
		} else if (element.compareTo(ele) > 0) {
			ele.setRight(add(key, value, ele.getRight()));
		}
		/**
		 * No es posible almacenar un value duplicado
		 */
		else {
			return ele;
		}

		ele.setHeight(1 + max(treeHeight(ele.getLeft()), treeHeight(ele.getRight())));

		int balance = getBalance(ele);
//		System.out.println(balance + " Factor de balanceo" + ele.getValue());

		/**
		 * Case 1: left left
		 */
		if (balance > 1 && element.compareTo(ele.getLeft()) < 0) {
//			System.out.println("1 case");
			return simpleRightRotate(ele);
		}

		/**
		 * Case 2: rigth right
		 */
		if (balance < -1 && element.compareTo(ele.getRight()) > 0) {
//			System.out.println("2 case ");

			return simpleLeftRotate(ele);
		}

		/**
		 * Case 3: Left right
		 */
		if (balance > 1 && element.compareTo(ele.getLeft()) > 0) {
//			System.out.println("3 case");
//			ele.setLeft(simpleLeftRotate(ele.getLeft()));
//			return simpleRightRotate(ele);
			return doubleRightRotate(ele);
		}

		/**
		 * Case 4: Right left
		 */
		if (balance < -1 && element.compareTo(ele.getRight()) < 0) {
//			System.out.println("4 case");
			return doubleLeftRotate(ele);
		}

		return ele;
	}

	public void insert(Q key, K value) {
		setRoot(add(key, value, root));
	}

	@Override
	public AVLNode<Q, K> remove(Q key, K value, AVLNode<Q, K> root) {

		AVLNode<Q, K> element = new AVLNode<Q, K>(key, value);
		if (root == null) {
			return root;
		}
		if (element.compareTo(root) < 0) {
			root.setLeft(remove(key, value, root.getLeft()));
		}

		else if (element.compareTo(root) > 0) {
			System.out.println(root.getKey() + " here");
			root.setRight(remove(key, value, root.getRight()));
		}

		else {
//			System.out.println(root.getKey()+ " ROOT KEY");
			if ((root.getLeft() == null) || (root.getRight() == null)) {

				AVLNode<Q, K> temp = null;
				if (temp == root.getLeft())
					temp = root.getRight();
				else
					temp = root.getLeft();

				if (temp == null) {
					temp = root;
					root = null;
				} else
					root = temp;
			} else {

				AVLNode<Q, K> temp = minValueNode(root.getRight());

				root = temp;

				root.setRight(remove(temp.getKey(), temp.getValue(), root.getRight()));
			}

		}
		if (root == null) {

			return root;
		}

		root.setHeight(max(treeHeight(root.getLeft()), treeHeight(root.getRight())) + 1);
		int balance = getBalance(root);

		if (balance > 1 && getBalance(root.getLeft()) >= 0) {
			return simpleRightRotate(root);
		}
		if (balance > 1 && getBalance(root.getLeft()) < 0) {
			root.setLeft(simpleLeftRotate(root.getLeft()));
			return simpleRightRotate(root);
		}
		if (balance < -1 && getBalance(root.getRight()) <= 0) {
			return simpleLeftRotate(root);
		}
		if (balance < -1 && getBalance(root.getRight()) > 0) {

			root.setRight(simpleRightRotate(root.getRight()));
			return simpleLeftRotate(root);
		}
		return root;

	}

	@Override
	public AVLNode<Q, K> minValueNode(AVLNode<Q, K> node) {
		AVLNode<Q, K> n = node;

		while (n.getLeft() != null) {
			n = n.getLeft();
		}

		return n;

	}

	@Override
	public AVLNode<Q, K> search(Q element, AVLNode<Q, K> root) {

//		System.out.println(root.getKey()+ "VALUE SEARCH");
		if (((Double) root.getKey()).equals((Double) element)) {
//			System.out.println(root.getValue()+ " found txt");
			return root;
		}

		else if ((Double) element < (Double) root.getKey()) {
			return search(element, root.getLeft());
		} else
			return search(element, root.getRight());

	}

	/***
	 * Get the Balance factor of node
	 */
	@Override
	public int getBalance(AVLNode<Q, K> node) {

		if (node == null)
			return 0;

		return treeHeight(node.getLeft()) - treeHeight(node.getRight());
	}

	@Override
	public AVLNode<Q, K> simpleRightRotate(AVLNode<Q, K> node) {
		// TODO Auto-generated method stub
//		System.out.println(node.getValue()+ "NODE");
//		System.out.println(node.getLeft().getValue()+ "NODE IZQ");
		AVLNode<Q, K> a = node.getLeft();
		AVLNode<Q, K> b = a.getRight();

		a.setRight(node);
		node.setLeft(b);

		node.setHeight(max(treeHeight(node.getLeft()), treeHeight(node.getRight())) + 1);
		a.setHeight(max(treeHeight(a.getLeft()), treeHeight(a.getRight())) + 1);

		return a;
	}

	@Override
	public AVLNode<Q, K> simpleLeftRotate(AVLNode<Q, K> node) {
		// TODO Auto-generated method stub

		AVLNode<Q, K> a = node.getRight();
		AVLNode<Q, K> b = a.getLeft();

		a.setLeft(node);
		node.setRight(b);

		node.setHeight(max(treeHeight(node.getLeft()), treeHeight(node.getRight())) + 1);
		a.setHeight(max(treeHeight(a.getLeft()), treeHeight(a.getRight())) + 1);
		return a;
	}

	@Override
	public int max(int hA, int hB) {
		// TODO Auto-generated method stub
		return (hA > hB) ? hA : hB;
	}

	@Override
	public int treeHeight(AVLNode<Q, K> node) {
		// TODO Auto-generated method stub
		if (node == null)
			return 0;

		return node.getHeight();
	}

	@Override
	public AVLNode<Q, K> doubleRightRotate(AVLNode<Q, K> node) {

		node.setLeft(simpleLeftRotate(node.getLeft()));
		return simpleRightRotate(node);

		// TODO Auto-generated method stub

	}

	@Override
	public AVLNode<Q, K> doubleLeftRotate(AVLNode<Q, K> node) {
		// TODO Auto-generated method stub
//		ele.setRight(simpleRightRotate(ele.getRight()));
//	     return simpleLeftRotate(ele);
		node.setRight(simpleRightRotate(node.getRight()));
		return simpleLeftRotate(node);

	}

	@Override
	public void amountNodes(AVLNode<Q, K> node) {

		// TODO Auto-generated method stub
		if (node != null) {

			amountNode++;
			System.out.println(amountNode + " AMOUNT ");
			amountNodes(node.getLeft());
			amountNodes(node.getRight());

		}

	}

	@Override
	public boolean isLeave(AVLNode<Q, K> node) {
		boolean val = false;

		if (node.getLeft() == null && node.getRight() == null) {
			val = true;
		}

		return val;
	}

//	public void deserializar() throws IOException, ClassNotFoundException {

//	}

}
