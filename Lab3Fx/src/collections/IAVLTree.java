package collections;

public interface IAVLTree<Q,K>{
	
	public AVLNode<Q,K> add( Q key, K value, AVLNode<Q,K>  ele);
	public void insert(Q key,K value);
	public AVLNode<Q,K> remove( Q key,K value, AVLNode<Q,K>  root);
	public AVLNode<Q,K> search(Q element, AVLNode<Q,K> root);
	public  AVLNode<Q,K>  simpleRightRotate( AVLNode<Q,K>  node);
	public AVLNode<Q,K>  simpleLeftRotate( AVLNode<Q,K>  node);
	public int max(int hA, int hB);
	public AVLNode<Q,K> getRoot();
	public void setRoot(AVLNode<Q,K> node);
	public int treeHeight( AVLNode<Q,K>  node);
	public  AVLNode<Q,K>  doubleRightRotate( AVLNode<Q,K> node);
	public AVLNode<Q,K>  doubleLeftRotate( AVLNode<Q,K>  node);
	public int getBalance( AVLNode<Q,K>  node);
	public AVLNode<Q,K>  minValueNode( AVLNode<Q,K>  node);
	public void amountNodes( AVLNode<Q,K> node);
	public boolean isLeave(AVLNode<Q,K>  node);
	public int getAmountNode();
	
	

}


