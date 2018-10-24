package collections;

public interface IAbb<T extends Comparable<? super T>,V> {

	public boolean isLeaf();
	public boolean isEmpty();
	public void addAbb(T element, V value);
	public void deleteAbb(T element);
	public AbbNode<T,V> searchAbb(T a);
	public int giveHeight();
	public int giveWeight();
	public T giveMaximum();
	public T giveMinimum();
	
}
