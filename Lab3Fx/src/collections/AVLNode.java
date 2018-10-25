package collections;

import java.io.Serializable;

public class AVLNode<V, E> implements Comparable<AVLNode<V, E>>, Serializable {

	private E value;
	private V key;
	private AVLNode<V, E> left;
	private AVLNode<V, E> right;
	private int height;

	public AVLNode(V key, E value) {
		super();
		this.key = key;
		this.value = value;
		this.left = null;
		this.right = null;
		height = 1;
	}

	public V getKey() {
		return key;
	}

	public void setKey(V key) {
		this.key = key;
	}

	public E getValue() {
		return value;
	}

	public void setValue(E value) {
		this.value = value;
	}

	public AVLNode<V, E> getLeft() {
		return left;
	}

	public void setLeft(AVLNode<V, E> left) {
		this.left = left;
	}

	public AVLNode<V, E> getRight() {
		return right;
	}

	public void setRight(AVLNode<V, E> right) {
		this.right = right;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public int compareTo(AVLNode<V, E> node) {

		int v = 0;
		if ((double) this.getKey() > (double) node.getKey()) {
			v = 1;
		} else if ((double) this.getKey() < (double) node.getKey()) {
			v = -1;
		}

		return v;
	}

}
