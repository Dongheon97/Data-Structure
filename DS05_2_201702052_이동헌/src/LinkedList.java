
public class LinkedList<E> {
	//비공개 인스턴스 변수
	private int _size;	//리스트의 크기(원소의 개수)
	private LinkedNode<E> _head;	//연결체인의 맨 앞 노드를 소유
	
	//Getter/Setter
	public int size() {
		return this._size;
	}
	private void setSize(int newSize) {
		this._size = newSize;
	}
	private LinkedNode<E> head() {
		return this._head;
	}
	private void setHead(LinkedNode<E> newHead) {
		this._head = newHead;
	}
	
	//생성자
	public LinkedList() {
		this.setSize(0);
		this.setHead(null);
	}
	
	//상태 알아보기
	public boolean isEmpty() {
		return (this.size()==0);
	}
	
	public boolean isFull() {	
		//LinkedList는 언제나 full이 아니다(시스템 메모리가 모자라는 경우는 없다고 가정).
		return false;
	}
	
	private boolean anElementDoesExistAt(int anOrder) {
		return ((anOrder>=0) && (anOrder<this.size()));
	}
	
	public boolean doesContain(E anElement) {
		boolean found = false;
		LinkedNode<E> currentNode = this.head();
		while(!found && currentNode != null) {
			if(currentNode.element().equals(anElement)) {
				found = true;
				break;
			}
			currentNode = currentNode.next();
		}
		return found;
	}
	
	public E elementAt(int anOrder) {
		if(this.anElementDoesExistAt(anOrder)) {
			LinkedNode<E> currentNode = this.head();
			int nodeCount = 0;
			while(nodeCount < anOrder) {
				currentNode = currentNode.next();
				nodeCount++;
			}
			return currentNode.element();
		}
		else {
			return null;
		}
	}
	
	public E firstElement() {
		if(this.isEmpty()) {	//마지막 원소가 존재할 수 없으므로
			return null;
		}
		else {
			return this.elementAt(0);
		}
	}
	
	public E lastElement() {
		if(this.isEmpty()) {	//마지막 원소가 존재할 수 없으므로
			return null;
		}
		else {
			return this.elementAt(this.size()-1);
		}
	}
	
	public int orderOf(E anElement) {	//순차 검색
		int order=0;
		LinkedNode<E> currentNode = this.head();
		while(currentNode != null && (!currentNode.element().equals(anElement))) {
			currentNode = currentNode.next();
			order++;
		}
		if(currentNode == null) {	//Not Found
			return -1; //존재하지 않으면 -1을 돌려주기로 한다.
		}
		else {
			return order;
		}
	}
	
	public boolean addTo(E anElement, int anOrder) {
		if(anOrder<0 || anOrder > this.size()) {	//anOrder가 유효한지 검사
			return false;
		}
		else if(this.isFull()) {
			return false;
		}
		else {
			LinkedNode<E> nodeForAdd = new LinkedNode<E> (anElement, null);
			if(anOrder ==0) { //맨 앞 순서에 삽입. 앞(previous)노드가 존재하지 않는다.
				nodeForAdd.setNext(this.head());		
				this.setHead(nodeForAdd);
			}
			else { //순서가 맨 앞이 아니므로, 반드시 앞(previous)노드가 존재한다.
				LinkedNode<E> previousNode = this.head();
				for (int i=1; i<anOrder; i++) {
					previousNode = previousNode.next();	//삽입할 위치의 앞 노드를 찾는다.
				}
				nodeForAdd.setNext(previousNode.next());
				previousNode.setNext(nodeForAdd);
			}
			this.setSize(this.size()+1);
			return true;
		}
	}
	
	public boolean addToFirst(E anElement) {
		return this.addTo(anElement, 0);
	}
	
	public boolean addToLast(E anElement) {
		return this.addTo(anElement, this.size());
	}
	
	public boolean add(E anElement) {
		return this.addToFirst(anElement);	//왜 addToFirst?
	}
	
	public E removeFrom(int anOrder) {
		if(! this.anElementDoesExistAt(anOrder)) { 
			//삭제할 원소가 없거나 잘못된 위치
			return null;
		}
		else {
			//리스트는 비어있지 않으며 삭제할 원소가 있음.
			LinkedNode<E> removed = null;
			if(anOrder == 0) {	
				//삭제할 원소가 맨 앞 원소
				removed = this.head();
				this.setHead(this.head().next());
			}
			else {
				//삭제할 원소의 위치는 맨 앞이 아니며, 따라서 원소가 2개 이상
				LinkedNode<E> previousNode = this.head();
				for(int i=1; i<anOrder; i++) {
					previousNode = previousNode.next();							
				}
				removed = previousNode.next();
				previousNode.setNext(removed.next());
			}
			this.setSize(this.size()-1);
			return removed.element();
		}
	}
	
	public E removeFirst() {
		return this.removeFrom(0);
	}
	
	public E removeLast() {
		return this.removeFrom(this.size()-1);
	}
	
	public E removeAny() {	//왜 removeFirst?
		return this.removeFirst();
	}
	
	public boolean remove(E anElement) {
		//단계 1 : 주어진 원소의 위치를 찾는다.
		LinkedNode<E> previousNode = null;
		LinkedNode<E> currentNode = this.head();
		while((currentNode != null) &&(!currentNode.element().equals(anElement)) ) {
			previousNode = currentNode;
			currentNode = currentNode.next();
		}
		//단계 2 : 주어진 원소가 존재하면 삭제한다.
		if(currentNode == null) {
			return false;	//Not Found
		}
		else {
			if(currentNode == this.head()) {
				//삭제할 노드가 맨 앞 노드
				this.setHead(this.head().next());
			}
			else {
				//삭제할 노드 앞에 노드(previous)가 존재
				previousNode.setNext(currentNode.next());
			}
			this.setSize(this.size()-1);
			return true;
		}
		
	}
	
	public boolean replaceAt(E anElement, int anOrder) {
		if(!this.anElementDoesExistAt(anOrder)) {
			//대체할 노드가 없가나, 잘못된 위치
			return false;
		}
		else {
			LinkedNode<E> currentNode = this.head();
			for(int i=0; i<anOrder; i++) {
				currentNode = currentNode.next();
				//원소를 대체할 노드를 찾는다.
			}
			currentNode.setElement(anElement);
			return true;
		}
	}
	
	public void clear() {
		this.setHead(null);
		this.setSize(0);
	}
	
	//ListIterator 생성하여 얻기
	public Iterator<E> iterator(){
		return (new ListIterator());
	}
	
	public interface Iterator<E>{
		public boolean hasNext();
		public E next();
	}
		
	private class ListIterator implements Iterator<E>{
		//비공개 변수
		private LinkedNode<E> _nextNode; //연결체인에서 다음 원소를 소유하고 있는 노드
		
		//Getter/Setter
		private LinkedNode<E> nextNode() {
			return this._nextNode;
		}
		private void setNextNode(LinkedNode<E> newNextNode) {
			this._nextNode = newNextNode;
		}
		
		//생성자
		private ListIterator() {
			this.setNextNode(LinkedList.this.head());
		}
		
		@Override
		public boolean hasNext() {
			//다음 원소가 존재하는지를 알아낸다.
			return(this.nextNode() != null);
		}
		
		@Override
		public E next() {
			//다음 원소를 얻는다, 없으면 null
			if(this.nextNode() ==null) {
				return null;
			}
			else {
				E e = this.nextNode().element();
				this.setNextNode(this.nextNode().next());
				return e;
			}
		}
	}
}
