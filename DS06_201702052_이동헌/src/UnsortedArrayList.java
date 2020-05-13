
public class UnsortedArrayList<E extends Comparable<E>> {
	//비공개 상수, 변수들
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
		
	//생성자
	public UnsortedArrayList() {
		this.setCapacity(DEFAULT_CAPACITY);
	}
	@SuppressWarnings("unchecked")
	public UnsortedArrayList(int givenCapacity) {
		this.setCapacity(givenCapacity);
		this.setElements((E[]) new Comparable[this.capacity()] );
	}
	
	private boolean isEmpty() {
		return (this.size() ==0);
	}
	
	public void add(E anElement) {
		this.elements()[this.size()] = anElement;
		this.setSize(this.size()+1);
	}
	
	public E max() {
		if(this.isEmpty()) {
			return null;
		}
		else {
			E maxElement=this.elements()[0];
			for(int order = 1; order < this.size(); order++) {
				if(maxElement.compareTo(this.elements()[order]) < 0) {
					maxElement = this.elements()[order];
				}
			}
			return maxElement;
		}
	}
}
