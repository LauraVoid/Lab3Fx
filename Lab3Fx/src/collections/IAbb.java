package collections;

public interface IAbb<T> {

	public boolean isLeaf();
	public boolean isEmpty();
	public void addAbb(T element);
	public void deleteAbb(T element);
	public T searchAbb(T a);
	public int giveHeight();
	public int giveWeight();
	public T giveMaximum();
	public T giveMinimum();
	
}
