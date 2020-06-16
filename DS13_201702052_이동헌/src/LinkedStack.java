
public class LinkedStack<E> implements Stack<E> {

	//private instance variable
	private int _size;
	private LinkedNode<E> _head;
	
	//Getter / Setter
	@Override
	public int size() {
		return this._size;
	}
	private void setSize(int newSize) {
		this._size = newSize;
	}
	
	private LinkedNode<E> head(){
		return this._head;
	}
	private void setHead(LinkedNode<E> newHead) {
		this._head = newHead;
	}
	
	//Constructor
	public LinkedStack() {
		this.setHead(null);
		this.setSize(0);
	}
	
	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}
	
	@Override
	public boolean isFull() {
		return false;
	}
	
	@Override
	public boolean push(E anElement) {
		// TODO Auto-generated method stub
		if(this.isFull()) {
			return false;
		}
		else {
			LinkedNode<E> addedNode = new LinkedNode<E> (anElement, null);
			if(this.isEmpty()) {
				this.setHead(addedNode);
			}
			else {
				LinkedNode<E> currentNode = this.head();
				int count = 1;
				while(count < this.size()) {
					currentNode = currentNode.next();
					count ++;
				}
				addedNode.setNext(currentNode.next());
				currentNode.setNext(addedNode);
				
			}
			this.setSize(this.size()+1);
			return true;
		}
		
	}
	@Override
	public E pop() {
		// TODO Auto-generated method stub
		if(this.isEmpty()) {
			return null;
		}
		else {
			LinkedNode<E> currentNode = this.head();
			int count = 1 ;
			while(count < this.size()) {
				currentNode = currentNode.next(); // 끝노드의
				count ++;
			}
			E removedNode = currentNode.element(); // 지울노드에 tailnode를 복사
			currentNode = null; // tail node를 삭제
			this.setSize(this.size()-1);
			return removedNode;
		}
	}
	
	
	@Override
	public E peek() {
		// TODO Auto-generated method stub
		if(this.isEmpty()) {
			return null;
		}
		else {
			LinkedNode<E> lastNode = this.head();
			while(lastNode.next() != null) {
				lastNode = lastNode.next();						
			}
			return lastNode.element();
		}
	}
	
}
