
public class SortedArrayList<E extends Comparable<E>> {
	//����� ���, ������
	private static final int DEFAULT_CAPACITY = 100;
	
	private int _capacity;
	private int _size;
	private E[] _elements;
	
	//Getter/Setter
	private int capacity() {
		return this._capacity;
	}
	private void setCapacity(int newCapacity) {
		this._capacity = newCapacity;
	}
	
	public int size() {
		return this._size;
	}
	private void setSize(int newSize) {
		this._size = newSize;
	}
	
	private E[] elements() {
		return this._elements;
	}
	private void setElements(E[] newElements) {
		this._elements = newElements;
	}
	
	//������
	public SortedArrayList() {
		this.setCapacity(DEFAULT_CAPACITY);
	}
	
	@SuppressWarnings("unchecked")
	public SortedArrayList(int givenCapacity) {
		this.setCapacity(givenCapacity);
		this.setElements((E[]) new Comparable[this.capacity()] );
	}
	
	private boolean isEmpty() {
		return (this.size() ==0);
	}
	
	private void makeRoomAt(int aPosition) {
		for(int i =this.size(); i>aPosition; i--) {
			this.elements()[i] = this.elements()[i-1];
		}
	}
	
	public void add(E anElement) {
		if(this.size() == 0) {
			this.elements()[this.size()] = anElement;
		}
		else {
			int order=0;
			for(int i = order; i<this.size();i++) {
				if(this.elements()[i].compareTo(anElement)>0) {
					break;
				}
			}
			if(order == this.size()) {
				this.elements()[order] = anElement;
			}
			else {
				this.makeRoomAt(order);
				this.elements()[order] = anElement;
			}
		}	
		this.setSize(this.size()+1);
	}
	
	public E max() {
		//SortedArrayList���� ���� ū ���� �� �ڿ� �ִ�.
		if(this.isEmpty()) {
			return null;
		}
		else {
			return this.elements()[this.size()-1];
		}
	}
}
