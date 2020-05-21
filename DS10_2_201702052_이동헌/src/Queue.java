
public interface Queue<E> {

	//반두시 필요한 method
	public int size();
	public boolean isFull();
	public boolean isEmpty();
	
	public E front();
	public E rear();
	
	public boolean enQueue(E anElement);
	public E deQueue();
	
	public void clear();
	
	//편의성을 위한 method
	public E elementAt(int anOrder);
	public Iterator<E> iterator();

}