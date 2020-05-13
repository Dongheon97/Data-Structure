
public class LinkedList<E> {
	//����� �ν��Ͻ� ����
	private int _size;	//����Ʈ�� ũ��(������ ����)
	private LinkedNode<E> _head;	//����ü���� �� �� ��带 ����
	
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
	
	//������
	public LinkedList() {
		this.setSize(0);
		this.setHead(null);
	}
	
	//���� �˾ƺ���
	public boolean isEmpty() {
		return (this.size()==0);
	}
	
	public boolean isFull() {	
		//LinkedList�� ������ full�� �ƴϴ�(�ý��� �޸𸮰� ���ڶ�� ���� ���ٰ� ����).
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
		if(this.isEmpty()) {	//������ ���Ұ� ������ �� �����Ƿ�
			return null;
		}
		else {
			return this.elementAt(0);
		}
	}
	
	public E lastElement() {
		if(this.isEmpty()) {	//������ ���Ұ� ������ �� �����Ƿ�
			return null;
		}
		else {
			return this.elementAt(this.size()-1);
		}
	}
	
	public int orderOf(E anElement) {	//���� �˻�
		int order=0;
		LinkedNode<E> currentNode = this.head();
		while(currentNode != null && (!currentNode.element().equals(anElement))) {
			currentNode = currentNode.next();
			order++;
		}
		if(currentNode == null) {	//Not Found
			return -1; //�������� ������ -1�� �����ֱ�� �Ѵ�.
		}
		else {
			return order;
		}
	}
	
	public boolean addTo(E anElement, int anOrder) {
		if(anOrder<0 || anOrder > this.size()) {	//anOrder�� ��ȿ���� �˻�
			return false;
		}
		else if(this.isFull()) {
			return false;
		}
		else {
			LinkedNode<E> nodeForAdd = new LinkedNode<E> (anElement, null);
			if(anOrder ==0) { //�� �� ������ ����. ��(previous)��尡 �������� �ʴ´�.
				nodeForAdd.setNext(this.head());		
				this.setHead(nodeForAdd);
			}
			else { //������ �� ���� �ƴϹǷ�, �ݵ�� ��(previous)��尡 �����Ѵ�.
				LinkedNode<E> previousNode = this.head();
				for (int i=1; i<anOrder; i++) {
					previousNode = previousNode.next();	//������ ��ġ�� �� ��带 ã�´�.
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
		return this.addToFirst(anElement);	//�� addToFirst?
	}
	
	public E removeFrom(int anOrder) {
		if(! this.anElementDoesExistAt(anOrder)) { 
			//������ ���Ұ� ���ų� �߸��� ��ġ
			return null;
		}
		else {
			//����Ʈ�� ������� ������ ������ ���Ұ� ����.
			LinkedNode<E> removed = null;
			if(anOrder == 0) {	
				//������ ���Ұ� �� �� ����
				removed = this.head();
				this.setHead(this.head().next());
			}
			else {
				//������ ������ ��ġ�� �� ���� �ƴϸ�, ���� ���Ұ� 2�� �̻�
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
	
	public E removeAny() {	//�� removeFirst?
		return this.removeFirst();
	}
	
	public boolean remove(E anElement) {
		//�ܰ� 1 : �־��� ������ ��ġ�� ã�´�.
		LinkedNode<E> previousNode = null;
		LinkedNode<E> currentNode = this.head();
		while((currentNode != null) &&(!currentNode.element().equals(anElement)) ) {
			previousNode = currentNode;
			currentNode = currentNode.next();
		}
		//�ܰ� 2 : �־��� ���Ұ� �����ϸ� �����Ѵ�.
		if(currentNode == null) {
			return false;	//Not Found
		}
		else {
			if(currentNode == this.head()) {
				//������ ��尡 �� �� ���
				this.setHead(this.head().next());
			}
			else {
				//������ ��� �տ� ���(previous)�� ����
				previousNode.setNext(currentNode.next());
			}
			this.setSize(this.size()-1);
			return true;
		}
		
	}
	
	public boolean replaceAt(E anElement, int anOrder) {
		if(!this.anElementDoesExistAt(anOrder)) {
			//��ü�� ��尡 ������, �߸��� ��ġ
			return false;
		}
		else {
			LinkedNode<E> currentNode = this.head();
			for(int i=0; i<anOrder; i++) {
				currentNode = currentNode.next();
				//���Ҹ� ��ü�� ��带 ã�´�.
			}
			currentNode.setElement(anElement);
			return true;
		}
	}
	
	public void clear() {
		this.setHead(null);
		this.setSize(0);
	}
	
	//ListIterator �����Ͽ� ���
	public Iterator<E> iterator(){
		return (new ListIterator());
	}
	
	public interface Iterator<E>{
		public boolean hasNext();
		public E next();
	}
		
	private class ListIterator implements Iterator<E>{
		//����� ����
		private LinkedNode<E> _nextNode; //����ü�ο��� ���� ���Ҹ� �����ϰ� �ִ� ���
		
		//Getter/Setter
		private LinkedNode<E> nextNode() {
			return this._nextNode;
		}
		private void setNextNode(LinkedNode<E> newNextNode) {
			this._nextNode = newNextNode;
		}
		
		//������
		private ListIterator() {
			this.setNextNode(LinkedList.this.head());
		}
		
		@Override
		public boolean hasNext() {
			//���� ���Ұ� �����ϴ����� �˾Ƴ���.
			return(this.nextNode() != null);
		}
		
		@Override
		public E next() {
			//���� ���Ҹ� ��´�, ������ null
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
