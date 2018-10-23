package collections;

public class Abb<T extends Comparable<? super T>,V> implements IAbb<T> {

	/**
	 * Relation with the AbbNode class. It's the root of our search binary tree.
	 */
	private AbbNode<T,V> root;
	
	/**
	 * Save the weight of the tree.
	 */
	private int weight;

	/**
	 * Builder method.
	 */
	public Abb() {
		root = null;
		weight = 0;
	}

	// ******************
	// OVERWRITTEN METHODS
	// *******************

	/**
	 * It is responsible for checking if the root is a leaf.
	 */
	@Override
	public boolean isLeaf() {
		return (root.isLeafLeftSon() && root.isLeafRightSon());
	}

	/**
	 * Check if the tree is empty.
	 */
	@Override
	public boolean isEmpty() {
		return (root == null);
	}

	/**
	 * Add an element to the tree.
	 */
	@Override
	public void addAbb(T element) {
		
		if (root == null) {
			root = new AbbNode<T,V>(element);
		} else {
			root.addAbb(element);
		}
		weight++;
	}
 
	/**
     * It's responsible for removing a node from the tree.
     * @param element
     * @return
     */
	@Override
	public void deleteAbb(T element) {
     root = root.deleteAbb(element);
	}
    
	/**
     * It is responsible for removing a node from the tree.
     * @param element
     * @return
     */
	@Override
	public T searchAbb(T a) {
		AbbNode<T,V> aux = new AbbNode<T,V>(a);
		
		if(root != null) {
			if((Double)root.getDate() == (Double)aux.getDate()) {
				return root.getDate();
			}else {
				return root.searchElement(a);
			}
		}else {
			return null;
		}
	}
	/**
	 * Returns the height of the tree. <br>
	 * @return Height of the tree.
	 */
	@Override
	public int giveHeight() {
		return (root != null) ? root.giveHeight() : 0;
	}

	/**
	 * Returns the weight of the tree.
	 * @return
	 */
	@Override
	public int giveWeight() {
		return weight;
	}
	
	/**
	 * Returns the minor element since the root.
	 * @return
	 */
	@Override
	public T giveMaximum() {
		return (root != null) ? root.giveMaximum(): null;
	}
	
	/**
	 * Returns the maximum element since the root.
	 * @return
	 */
	@Override
	public T giveMinimum() {
		return (root != null) ? root.giveMinimum(): null;
	}
	// *************************
	// GETS AND SETTERS METHODS
	// *************************

	public AbbNode<T,V> getRoot() {
		return root;
	}

	public void setRoot(AbbNode<T,V> root) {
		this.root = root;
	}

}
