
public interface Stack<E> {
	
	public int size();
	public boolean push(E anElement);
	public E pop();
	public E peek();
	public boolean isEmpty();
	public boolean isFull();
	
}
