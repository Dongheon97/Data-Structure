
public class CircularlyLinkedQueue<E> implements Queue<E> {

	//비공개 인스턴스 변수
	private int _size;
	private LinkedNode<E> _rearNode;
	
	//Getter / Setter
	@Override
	public int size() {
		return this._size;
	}
	private void setSize(int newSize) {
		this._size = newSize;
	}
	
	private LinkedNode<E> rearNode(){
		return this._rearNode;
	}
	private void setRearNode(LinkedNode<E> newRearNode) {
		this._rearNode = newRearNode;
	}
	
	//생성자
	public CircularlyLinkedQueue() {
		this.setSize(0);
		this.setRearNode(null);
	}
	
	@Override
	public boolean isFull() {
		return false; 
		
	}
	@Override
	public boolean isEmpty() {
		return (this.rearNode()==null); 
	}
	
	@Override
	public E front() {
		if(this.isEmpty()) {
			return null;
		}
		else {
			LinkedNode<E> frontNode = this.rearNode().next();
			return frontNode.element();
		}
	}
	@Override
	public E rear() {
		if(this.isEmpty()) {
			return null;
		}
		else {
			return (this.rearNode().element());
		}
	}
	
	@Override
	public boolean enQueue(E anElement) {
		if(this.isFull()) {
			return false;
		}
		else {
			LinkedNode<E> newNode = new LinkedNode<E> (anElement, null) ;
			if(this.isEmpty()) {
				this.setRearNode(newNode);
				newNode.setNext(newNode);
			}
			else {
				newNode.setNext(this.rearNode().next());
				this.rearNode().setNext(newNode);
			}
			this.setRearNode(newNode);
			this.setSize(this.size()+1);
			
			return true;
		}
	}
	
	@Override
	public E deQueue() {
		if(this.isEmpty()) {
			return null;
		}
		else {
			E frontNode = this.rearNode().next().element();
			if(this.rearNode() == this.rearNode().next()) {
				//노드가 한개 : self Loop인 경우
				this.setRearNode(null);
			}
			else {
				//노드가 한개 이상
				this.rearNode().setNext(this.rearNode().next().next());
			}
			this.setSize(this.size()-1);
			
			return frontNode;
		}
	}
	
	@Override
	public void clear() {
		this.setRearNode(null);
		this.setSize(0);
	}
	
	@Override
	public E elementAt(int anOrder) {
		if((anOrder < 0) && (anOrder >= this.size()) ) {
			return null;
		}
		else {
			LinkedNode<E> currentNode = this.rearNode().next();
			if(anOrder == 0) {
				return currentNode.element();
			}
			else {
				int count=0;
				while(count<anOrder){
					currentNode = currentNode.next();
					count ++;
				}
				return currentNode.element();
			}
		}
	}
	
	@Override
	public Iterator<E> iterator() {
		return (new CircularlyLinkedQueueIterator());
	}
	
	private class CircularlyLinkedQueueIterator implements Iterator<E>{

		//비공개 인스턴스 변수
		private LinkedNode<E> _nextNode;
		private int _count;	//아직 반복에 사용되지 않고 남아 있는 원소의 개수
		
		//Getter / Setter
		private LinkedNode<E> nextNode(){
			return this._nextNode;
		}
		private void setNextNode(LinkedNode<E> newNextNode) {
			this._nextNode = newNextNode;
		}
		
		private int count() {
			return this._count;
		}
		private void setCount(int newCount) {
			this._count = newCount;
		}
		
		//생성자
		private CircularlyLinkedQueueIterator() {
			//큐의 원소의 개수로 초기화
			this.setCount(CircularlyLinkedQueue.this.size());
			//큐의 rearNode로 초기화
			this.setNextNode(CircularlyLinkedQueue.this.rearNode());
		}
		
		@Override
		public boolean hasNext() {
			return (this.count()>0);
		}

		@Override
		public E next() {
			if(this.hasNext()) {
				this.setNextNode(this.nextNode().next());
				E nextElement = this.nextNode().element();
				this.setCount(this.count()-1);
				return nextElement;
			}
			else {
				return null;
			}
		}
	}	
}
