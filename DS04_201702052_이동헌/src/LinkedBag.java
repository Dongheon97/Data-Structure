
public class LinkedBag<E> {
	//비공개 인스턴스 변수
	private int _size; //가방이 가지고 있는 원소의 개수
	private LinkedNode<E> _head; //연결체인의 맨 앞 노드를 소유한다
	
	//생성자
	public LinkedBag() {
		this.setSize(0);
		this.setHead(null);
	}
	
	//size의 Getter
	public int size() {
		return this._size;
	}
	//size의 Setter
	private void setSize(int newSize) {
		this._size = newSize;
	}
	
	//head의 Getter
	private LinkedNode<E> head(){
		return this._head;
	}
	//head의 Setter
	private void setHead(LinkedNode<E> newHead){
		this._head = newHead;
	}
	
	public boolean isEmpty() {
		return (this.size() == 0); //또는 return (this.head() == null);
	}
	
	public boolean isFull() {	
		return false;	//원소 저장 개수의 제한이 없다. (메모리 부족 오류는 없다고 가정)
	}
	
	public boolean doesContain(E anElement) {
		boolean found = false;
		LinkedNode<E> currentNode = this.head();
		while(currentNode != null && !found) {
			if(currentNode.element().equals(anElement)) {
				found = true;
				break;
			}
			currentNode = currentNode.next();
		}
		return found;
	}	
	
	public int frequencyOf(E element) {
		int frequencyCount = 0;
		LinkedNode<E> currentNode = this.head();
		while(currentNode != null) {
			if(currentNode.element().equals(element)) {
				frequencyCount++;	
			}
			currentNode = currentNode.next();
		}
		return frequencyCount;
	}
	
	public E elementAt(int anOrder) {
		if (anOrder < 0 || this.size() <= anOrder ) {
			return null;	//anOrder가 적정 범위를 벗어나 있다.
		}
		else {	//anOrder가 적정 범위 안에 있다.
			LinkedNode<E> currentNode = this.head();
			for(int i = 0; i<anOrder; i++) {
				currentNode = currentNode.next();
			}
			return currentNode.element();
		}
	}
	
	public boolean add(E anElement) {
		if(this.isFull()) {
			return false;
		}
		else {
			LinkedNode<E> newNode = new LinkedNode<E>();
			newNode.setElement(anElement);
			newNode.setNext(this.head());
			this.setHead(newNode);
			this.setSize(this.size() + 1);
			return true;
		}
		
	}
	
	public boolean remove(E anElement) {
		if(this.isEmpty()) {
			return false;
		}
		else {
			LinkedNode<E> previousNode = new LinkedNode<E>();
			LinkedNode<E> currentNode = this._head;
			boolean found = false;
			//Step 1 : 삭제할 위치 찾기
			while(currentNode != null && !found) {
				if(currentNode.element().equals(anElement)) {
					found = true;
				}
				else {
					previousNode = currentNode;
					currentNode = currentNode.next();
				}
			}
			//Step 2 : 삭제하기
			if(!found) {
				return false;
			}
			else {
				if(currentNode == this.head()) {
					this.setHead(this.head().next());
				}
				else {
					previousNode.setNext(currentNode.next());
				}
				this.setSize(this.size()-1);
				return true;
			}
		}
	}
	
	public E removeAny() {
		if(this.isEmpty()) {
			return null;
		}
		else {
			E removedElement = this.head().element();
			this.setHead(this.head().next());
			this.setSize(this.size()-1);
			return removedElement;			
		}
	}
	
	public void clear() {
		this.setSize(0);
		this.setHead(null);
	}
}
