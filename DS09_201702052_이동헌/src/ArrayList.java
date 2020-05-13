
public class ArrayList<E> implements Stack<E> {
	//비공개 상수
	private static final int DEFAULT_CAPACITY = 5;
		
	//비공개 변수
	private int _capacity;
	private int _size;
	private E[] _elements;
	
	//Getter/Setter
	public int capacity() {
		return this._capacity;
	}
	private void setCapacity(int newCapacity) {
		this._capacity = newCapacity;
	}
	
	@Override
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
	public ArrayList() {
		this(ArrayList.DEFAULT_CAPACITY);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList(int givenCapacity) {
		this.setCapacity(givenCapacity);
		this.setElements((E[]) new Comparable[this.capacity()]);
		
	}
	
	//Private Methods
	private void makeRoomAt(int aPosition) {
		for(int i=this.size(); i>aPosition; i--) {
			this.elements()[i] = this.elements()[i-1];
		}
	}
	
	private void removeGapAt(int aPosition) {
		for(int i=aPosition+1; i<this.size(); i++) {
			this.elements()[i-1] = this.elements()[i];
		}
		this.elements()[this.size()-1] = null;	//맨 마지막 값 초기화
	}
	
	//Public Methods
	@Override
	public boolean isEmpty() {
		return (this.size() == 0);
	}
	
	@Override
	public boolean isFull() {
		return (this.size() == this.capacity());
	}
	
	public int orderOf(E anElement) {
		//원소 anElement가 리스트안에 존재하면 해당위치를 돌려주고,
		//존재하지 않으면 -1을 돌려준다
		int order = -1;
		for(int index=0; index<this.size() && order<0; index++) {
			if(this.elements()[index].equals(anElement)) {
				order = index;
			}
		}
		return order;
	}
	
	public boolean doesContain(E anElement) {
		return (this.orderOf(anElement) >= 0);
	}
	
	public E elementAt(int anOrder) {
		if(anOrder < 0 || anOrder > this.size()) {
			return null;
		}
		else {
			return this.elements()[anOrder];
		}
	}
	
	public void setElementAt(int anOrder, E anElement) {
		if(anOrder < 0 || anOrder >= this.size()) {
			return ;
		}
		else {
			this.elements()[anOrder] = anElement;
		}
	}
	
	public boolean addTo(int anOrder, E anElement) {
		if(this.isFull()) {
			return false;
		}
		else if(anOrder<0 || anOrder > this.size()) {
			return false;
		}
		else {
			this.makeRoomAt(anOrder);
			this.elements()[anOrder] = anElement;
			this.setSize(this.size()+1);
			return true;
		}
	}
	
	public boolean addToFirst(E anElement) {
		return this.addTo(0, anElement);
	}
	
	public boolean addToLast(E anElement) {
		return this.addTo(this.size(), anElement);
	}
	
	public E removeFrom(int anOrder) {
		//주어진 위치 anOrder에 원소가 없으면 null을 반환한다.
		//원소가 있으면 리스트에서 제거하여 반환한다.
		if(this.isEmpty()) {
			return null;
		}
		else if(anOrder<0 || anOrder >= this.size()) {
			return null;
		}
		else {
			E removedElement = this.elementAt(anOrder);
			this.removeGapAt(anOrder);
			this.setSize(this.size()-1);
			return removedElement;
		}
	}
		
	public E removeFirst() {
		return this.removeFrom(0);
	}
	
	public E removeLast() {
		return this.removeFrom(this.size()-1);
	}
	
	@Override
	public boolean push(E anElement) {
		return this.addToLast(anElement);
	}
	
	@Override
	public E pop() {
		return this.removeLast();
	}
	
	@Override
	public E peek() {
		if(this.isEmpty()) {
			return null;
		}
		else {
			return this.elementAt(this.size()-1); 	//Last element
		}
	}
	
	@Override
	public void clear() {
		for(int i=0; i<this.size(); i++) {
			this.elements()[i] = null;
		}
		this.setSize(0);
	}
}
