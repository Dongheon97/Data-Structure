
public class LinkedNode<E> {
	//����� �ν��Ͻ� ����
	private E _element;			 //���� ��忡 �ִ� ����
	private LinkedNode<E> _next; //���� ���
	
	//������
	public LinkedNode() {
		this.setElement(null);
		this.setNext(null);
	}
	public LinkedNode(E givenElement) {
		this.setElement(givenElement);
		this.setNext(null);
	}
	
	public LinkedNode(E givenElement, LinkedNode<E> givenNext) {
		this.setElement(givenElement);
		this.setNext(givenNext);
	}
		
	//element�� Getter
	public E element() {							
		return this._element;
	}
	//element�� Setter
	public void setElement(E newElement) {			
		this._element = newElement;
	}
	
	//next�� Getter
	public LinkedNode<E> next(){					
		return this._next;
	}
	//next�� Setter
	public void setNext(LinkedNode<E> newNext) {	
		this._next = newNext;
	}
}
