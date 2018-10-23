package collections;

import collections.RBNode;

public class RBNode<K,V> implements Comparable<RBNode<K,V>> {
	public static final String RED= "Red";
	public static final String BLACK= "Black";
	private RBNode<K,V> right;
	private RBNode<K,V> left;
	private RBNode<K,V> father;
	private K key;
	private V value;
	private String color;
	
	public RBNode(K key,V value, String color) {
		this.key= key;
		this.value=value;
		this.color=color;
		right=null;
		left=null;
		father=null;
	}

	public RBNode(K key,V value) {
		this.key= key;
		this.value=value;
		right=null;
		left=null;
		father=null;
	}

	public RBNode<K, V> getRight() {
		return right;
	}

	public void setRight(RBNode<K, V> right) {
		this.right = right;
	}

	public RBNode<K, V> getLeft() {
		return left;
	}

	public void setLeft(RBNode<K, V> left) {
		this.left = left;
	}

	public RBNode<K, V> getFather() {
		return father;
	}

	public void setFather(RBNode<K, V> father) {
		this.father = father;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	@Override
	public int compareTo(RBNode<K,V> node) {
		int contador=0;
		if((double)key<(double)node.getKey()) {
			contador= -1;
		}
		else contador= 1;
		return contador;
	}
	
	

	

	
	
	
	
	
	

}
