
public class UnsortedArrayList<E extends Comparable<E>> {
	//비공개 상수,변수
	private static final int DEFAULT_CAPACITY = 100;
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
	
	public int size() {
		return this._size;
	}
	private void setSize(int newSize) {
		this._size = newSize;
	}
	
	public E[] elements() {
		return this._elements;
	}
	protected void setElements(E[] newElements) {
		this._elements = newElements;
	}
	
	//생성자
	public UnsortedArrayList() {
		this.setCapacity(UnsortedArrayList.DEFAULT_CAPACITY);
	}
	@SuppressWarnings("unchecked")
	public UnsortedArrayList(int givenCapacity) {
		this.setCapacity(givenCapacity);
		this.setElements((E[]) new Comparable[this.capacity()]);
	}
	
	//비공개 함수
	private void makeRoomAt(int aPosition) {
		for(int i = this.size(); i>aPosition; i--) {
			this.elements()[i] = this.elements()[i-1];
		}
	}
	
	private void removeGapAt(int aPosition) {
		for(int i=0; i<this.size(); i++) {
			this.elements()[this.size()-1] = this.elements()[i];
		}
		this.elements()[this.size()-1] = null;
	}
	
	//공개 함수
	public boolean isEmpty() {
		return (this.size() == 0);
	}
	public boolean isFull() {
		return (this.size() == this.capacity());
	}
	
	public int orderOf(E anElement) {
		//If anElement does not exist, then return -1;
		//If found, return the index of the found element inside _elements[].
		int order = -1;
		for(int index=0; index<this.size() && order <0; index++) {
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
		if(anOrder < 0 || anOrder >= this.size()) {
			return null;
		}
		else {
			return this.elements()[anOrder];
		}
	}
	protected void setElementAt(int anOrder, E anElement) {
		if(anOrder < 0 || anOrder >= this.size()) {
			return ;
		}
		else {
			this.elements()[anOrder] = anElement;
		}
	}
	
	public boolean addToFirst(E anElement) {
		if(this.isFull()) {
			return false;
		}
		else {
			this.makeRoomAt(0);
			this.elements()[0] = anElement;
			this.setSize(this.size()+1);
			return true;
		}
	}
	
	public boolean addToLast(E anElement) {
		if(this.isFull()) {
			return false;
		}
		else {
			this.elements()[this.size()] = anElement;
			this.setSize(this.size()+1);
			return true;
		}
	}
	
	public boolean add(E anElement) {
		return this.addToLast(anElement);
	}
	
	public E removeFirst() {
		if(this.isEmpty()) {
			return null;
		}
		else {
			E removedElement = this.elements()[0];
			this.removeGapAt(0);
			this.setSize(this.size()-1);
			return removedElement;
		}
	}
	
	public E removeLast() {
		if(this.isEmpty()) {
			return null;
		}
		else {
			E removedElement = this.elements()[this.size()-1];
			this.setSize(this.size()-1);
			return removedElement;
		}
	}
	
	public E removeAny() {
		return this.removeLast();
	}
	
	public boolean remove(E anElement) {
		//단계1 : 주어진 원소의 위치를 찾는다.
		int foundIndex = this.orderOf(anElement);
		
		//단계2 : 주어진 원소가 존재하면 삭제를 실행한다.
		if(foundIndex < 0) {
			return false; 	//not found.
		}
		else {
			//삭제된 원소 이후의 모든 원소를 앞쪽으로 한 칸씩 이동시킨다.
			this.removeGapAt(foundIndex);
			this.setSize(this.size()-1);
			this.elements()[this.size()-1]=null;
			return true;
		}
	}
	
	public Iterator<E> iterator(){
		return (new ListIterator());
	}
	
	private class ListIterator implements Iterator<E>{
		//비공개 인스턴스 변수
		private int _nextPosition;
		
		//Getter/Setter
		private int nextPosition() {
			return this._nextPosition;
		}
		private void setNextPosition(int newNextPosition) {
			this._nextPosition = newNextPosition;
		}
		
		//생성자
		private ListIterator() {
			this.setNextPosition(0);
		}
		
		@Override
		public boolean hasNext() {
			return(this.nextPosition() < UnsortedArrayList.this.size());
		}
		
		@Override
		public E next() {
			E nextElement = null;
			if(this.hasNext()) {
				nextElement = UnsortedArrayList.this.elements()[this.nextPosition()];
				this.setNextPosition(this.nextPosition()+1);
			}
			return nextElement;
		}
	}
}
