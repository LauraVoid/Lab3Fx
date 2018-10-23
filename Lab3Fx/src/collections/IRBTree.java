package collections;

import collections.RBNode;

public interface IRBTree<K,V> {
	
	public RBNode<K, V> getRoot();
	public void setRoot(RBNode<K, V> root);
	 public int getAmountNodes();
	public void leftRotate(RBNode<K,V> x);
	public void rightRotate(RBNode<K,V> y);
	public RBNode<K,V> RBSearch(RBNode<K,V> searched, K k);
	public RBNode<K,V> RBMaximum(RBNode<K,V> maximum) ;
	public RBNode<K,V> RBMinimum(RBNode<K,V> minimum) ;
	public RBNode<K,V> RBSuccessor(RBNode<K,V> successor);
    public RBNode<K,V> RBPredecessor(RBNode<K,V> predecessor);
	public void RBInsert(K key, V value );
    public void RBInsertFixUp(RBNode<K,V> newNode ) ;
    public RBNode<K,V> RBDelete(K key );

 
	








}
