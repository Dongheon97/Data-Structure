
public class LinkedBag<E> {
	//����� �ν��Ͻ� ����
	private int _size; //������ ������ �ִ� ������ ����
	private LinkedNode<E> _head; //����ü���� �� �� ��带 �����Ѵ�
	
	//������
	public LinkedBag() {
		this.setSize(0);
		this.setHead(null);
	}
	
	//size�� Getter
	public int size() {
		return this._size;
	}
	//size�� Setter
	private void setSize(int newSize) {
		this._size = newSize;
	}
	
	//head�� Getter
	private LinkedNode<E> head(){
		return this._head;
	}
	//head�� Setter
	private void setHead(LinkedNode<E> newHead){
		this._head = newHead;
	}
	
	public boolean isEmpty() {
		return (this.size() == 0); //�Ǵ� return (this.head() == null);
	}
	
	public boolean isFull() {	
		return false;	//���� ���� ������ ������ ����. (�޸� ���� ������ ���ٰ� ����)
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
			return null;	//anOrder�� ���� ������ ��� �ִ�.
		}
		else {	//anOrder�� ���� ���� �ȿ� �ִ�.
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
			//Step 1 : ������ ��ġ ã��
			while(currentNode != null && !found) {
				if(currentNode.element().equals(anElement)) {
					found = true;
				}
				else {
					previousNode = currentNode;
					currentNode = currentNode.next();
				}
			}
			//Step 2 : �����ϱ�
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
