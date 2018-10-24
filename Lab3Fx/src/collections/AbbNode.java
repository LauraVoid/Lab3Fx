package collections;

import java.io.Serializable;

public class AbbNode<T extends Comparable<? super T>, V>  implements Serializable{

	/**
	 * Save the left son.
	 */
	private AbbNode<T, V> left;

	/**
	 * Save the right son.
	 */
	private AbbNode<T, V> right;

	/**
	 * It's the attribute of the stored object.
	 */
	private T date;

	/**
	 * 
	 */
	private V value;

	/**
	 * Builder method.
	 */
	public AbbNode(T date) {
		this.date = date;
		left = null;
		right = null;
	}

	/**
	 * Check if left son is null.
	 * 
	 * @return
	 */
	public boolean isLeafLeftSon() {
		return (left == null);
	}

	/**
	 * Check if right son is null.
	 * 
	 * @return
	 */
	public boolean isLeafRightSon() {
		return (right == null);
	}

	/**
	 * Add an element to the tree.
	 */
	public void addAbb(T newElement) {
		AbbNode<T, V> newElement2 = new AbbNode<T, V>(newElement);
		int result = date.compareTo(newElement);

		if (result < 0) {
			if (right == null) {
				right = newElement2;
			} else {
				right.addAbb(newElement);
			}

		}

		if (result > 0) {

			if (left == null) {
				left = newElement2;
			} else {
				left.addAbb(newElement);
			}

		}
	}

	/**
	 * Method that is responsible for returning the Selection to the left.
	 * 
	 * @return
	 */
	public AbbNode<T, V> giveLess() {
		if (left == null) {
			return this;
		} else {
			return left.giveLess();
		}
	}

	/**
	 * It's responsible for removing a node from the tree.
	 * 
	 * @param element
	 * @return
	 */
	public AbbNode<T, V> deleteAbb(T element) {
		
		int result = date.compareTo(element);
		
		if (result == 0) {

			if (left == null) 
				return right;
		
			else if (right == null) 
				return left;

			else {
                date = left.giveMaximum();
                left = left.deleteAbb(date);
				return this;
			}

		}else if(result > 0) {
			
			if(left == null) {
				return null;
			}else {
				left = left.deleteAbb(element);
				return this;
			}
			
		}else {
			if(right == null) {
				return null;
			}else {
				right = right.deleteAbb(element);
				return this;
			}
			
		}
	}

	/**
	 * It is responsible for removing a node from the tree.
	 * @param element
	 * @return Searched element
	 */
	public T searchElement(T element) {
        int result = date.compareTo(element);
		if (result == 0) {
			return date;
		} else {
			if (result > 0) {
				return (left != null) ? left.searchElement(element) : null;
			} else {
				return (right != null) ? right.searchElement(element): null;
			}

		}
	}

	/**
	 * Returns the largest element of the tree whose root is the current node.<br>
	 * <b>post<\b> The largest element of the tree whose root is the current node or null was returned if the tree is empty.
	 * @return Element greater than the tree whose root is the current node or null if the tree is empty
	 */
	public T giveMaximum() {
		AbbNode<T,V> aux = maximumElement();
		return (aux == null) ? null: aux.giveRoot();
	}
	
	/**
	 * Returns the smallest element of the tree whose root is the current node. <br>
	 * <b>post<\<b> Se retornó el elemento menor del árbol cuya raíz es el nodo actual o null si el árbol es vacio.
	 * @return Minor element of the tree whose root is the current node or null if the tree is empty
	 */
	public T giveMinimum() {
		AbbNode<T,V> aux = minimumElement();
		return (aux == null)? null: aux.giveRoot();
	}
	
	/**
	 * Returns the height of the tree whose root is the current node. <br>
	 * <b>post<\b> The height of the tree whose root is the current node was returned. Integer greater than or equal to 1.
	 * @return Height of the tree whose root is the current node.
	 */
	public int giveHeight() {
		int left1 = (left == null) ? 0: left.giveHeight( );
		int right1 = (right == null) ? 0: right.giveHeight( );
		return (left1 >= right1) ? left1 + 1: right1 + 1;
	}
	
	/**
	 * Return the maximum element of the tree.
	 * <b>post<\b> The node with the largest element of the tree was returned
	 * @return Node
	 */
	public AbbNode<T,V> maximumElement() {
	 return (right == null) ? this: right.maximumElement();
	}
	
	/**
	 * Return the minimun element of the tree.
	 * <b>post<\b> The node with the smallest element of the tree was returned
	 * @return Node
	 */
	public AbbNode<T,V> minimumElement(){
		return (left == null) ? this: left.minimumElement();
	}
	
	/**
	 * Return the root of the tree.
	 * @return
	 */
	public T giveRoot() {
		return date;
	}
	// *************************
	// GETS AND SETTERS METHODS
	// *************************

	public AbbNode<T, V> getLeft() {
		return left;
	}

	public void setLeft(AbbNode<T, V> left) {
		this.left = left;
	}

	public AbbNode<T, V> getRight() {
		return right;
	}

	public void setRight(AbbNode<T, V> right) {
		this.right = right;
	}

	public T getDate() {
		return date;
	}

	public void setDate(T date) {
		this.date = date;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public String toString() {
		return "The value is "+date;
	}

}
