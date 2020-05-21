
public class CircularlyArrayQueue<E> implements Queue<E> {

	//비공개 상수
	private static final int DEFAULT_CAPACITY = 100;
	
	//비공개 변수
	private int _maxLength; // capacity + 1
	private int _frontPosition;
	private int _rearPosition;
	private E[] _elements;
	
	//Getter / Setter
	private int maxLength() {
		return this._maxLength;
	}
	private void setMaxLength(int newMaxLength) {
		this._maxLength = newMaxLength;
	}
	
	private int frontPosition() {
		return this._frontPosition;
	}
	private void setFrontPosition(int newFrontPosition) {
		this._frontPosition = newFrontPosition;
	}
	
	private int rearPosition() {
		return this._rearPosition;
	}
	private void setRearPosition(int newRearPosition) {
		this._rearPosition = newRearPosition;
	}
	
	private E[] elements() {
		return this._elements;
	}
	private void setElements(E[] newElements) {
		this._elements = newElements;
	}
	
	//생성자
	public CircularlyArrayQueue() {
		this.setFrontPosition(0);
		this.setRearPosition(0);
		this.setMaxLength(CircularlyArrayQueue.DEFAULT_CAPACITY);
	}
	@SuppressWarnings("unchecked")
	public CircularlyArrayQueue(int givenCapacity) {
		this.setFrontPosition(0);
		this.setRearPosition(0);
		this.setMaxLength(givenCapacity+1);
		this.setElements((E[]) new Object[this.maxLength()]);
	}
	
	//공개함수의 구현
	public int capacity() {
		return (this.maxLength()-1);
	}
	
	@Override
	public int size() {
		if( this.rearPosition() >= this.frontPosition() ) {
			return (this.rearPosition() - this.frontPosition());
		}
		else {
			return (this.rearPosition() + this.maxLength() - this.frontPosition());
		}
	}
	
	@Override
	public boolean isEmpty() {
		return (this.rearPosition() == this.frontPosition());
	}
	@Override
	public boolean isFull() {
		int nextRearPosition = (this.rearPosition()+1) % this.maxLength();
		return (nextRearPosition == this.frontPosition());
	}
	
	@Override
	public E front() {
		if(this.isEmpty()) {
			return null;
		}
		else {
			E frontElement = this.elements()[this.frontPosition()+1];
			return frontElement;
		}
	}
	@Override
	public E rear() {
		if(this.isEmpty()) {
			return null;
		}
		else {
			E rearElement = this.elements()[this.rearPosition()];
			return rearElement;
		}
	}
	
	@Override
	public boolean enQueue(E anElement) {
		if(this.isFull()) {
			return false;
		}
		else {
			this.setRearPosition((this.rearPosition()+1) % this.maxLength());
			this.elements()[this.rearPosition()] = anElement;
			return true;
		}
	}
	
	@Override
	public E deQueue() {
		if(this.isEmpty()) {
			return null;
		}
		else {
			//this.frontPosition()은 항상 front 원소의 직전위치를 가리킨다.
			this.setFrontPosition((this.frontPosition()+1) % this.maxLength());
			E frontElement = this.elements()[this.frontPosition()];
			this.elements()[this.frontPosition()] = null;
			return frontElement;
		}
	}
	
	@Override
	public void clear() {
		this.setFrontPosition(0);
		this.setRearPosition(0);
		for(int i=0; i<this.maxLength(); i++) {
			this.elements()[i] = null;
		}
	}
	
	@Override
	public E elementAt(int anOrder) {
		return this.elements()[(this.frontPosition() +1 +anOrder) % this.maxLength()];
	}
	
	@Override
	public Iterator<E> iterator() {
		return (new CircularArrayQueueIterator());
	}
	
	private class CircularArrayQueueIterator implements Iterator<E>{
		
		//비공개 변수
		private int _nextOrder;
		
		//Getter / Setter
		private int nextOrder() {
			return this._nextOrder;
		}
		private void setNextOrder(int newNextOrder) {
			this._nextOrder = newNextOrder;
		}
		
		//생성자
		private CircularArrayQueueIterator() {
			this.setNextOrder(0);
		}
		
		@Override
		public boolean hasNext() {
			return (this.nextOrder() < CircularlyArrayQueue.this.size());
		}
		
		@Override
		public E next() {
			E nextElement = null;
			if(this.hasNext()) {
				nextElement = CircularlyArrayQueue.this.elementAt(this.nextOrder());
				this.setNextOrder(this.nextOrder()+1);
			}
			return nextElement;
		}
	}
}
