
public class CircularlyLinkedQueue<E> implements Queue<E> {

	//����� �ν��Ͻ� ����
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
	
	//������
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
				//��尡 �Ѱ� : self Loop�� ���
				this.setRearNode(null);
			}
			else {
				//��尡 �Ѱ� �̻�
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

		//����� �ν��Ͻ� ����
		private LinkedNode<E> _nextNode;
		private int _count;	//���� �ݺ��� ������ �ʰ� ���� �ִ� ������ ����
		
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
		
		//������
		private CircularlyLinkedQueueIterator() {
			//ť�� ������ ������ �ʱ�ȭ
			this.setCount(CircularlyLinkedQueue.this.size());
			//ť�� rearNode�� �ʱ�ȭ
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
