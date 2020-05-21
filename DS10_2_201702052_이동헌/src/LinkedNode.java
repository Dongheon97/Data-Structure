
public class LinkedNode<E> {
	
	//비공개 인스턴스 변수
	private E _element;
	private LinkedNode<E> _next;
	
	//Getter / Setter
	public E element() {
		return this._element;
	}
	public void setElement(E newElement) {
		this._element = newElement;
	}
	
	public LinkedNode<E> next(){
		return this._next;
	}
	public void setNext(LinkedNode<E> newNext) {
		this._next = newNext;
	}
	
	//생성자
	public LinkedNode() {	//비어 있을 때
		this.setElement(null);
		this.setNext(null);
	}
	public LinkedNode(E givenElement) {	//원소가 하나만 있을 때
		this.setElement(givenElement);
		this.setNext(null);
	}
	public LinkedNode(E givenElement, LinkedNode<E> givenNext) {	//원소가 하나 이상일 때
		this.setElement(givenElement);
		this.setNext(givenNext);
	}


}
