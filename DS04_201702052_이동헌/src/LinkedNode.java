
public class LinkedNode<E> {
	//비공개 인스턴스 변수
	private E _element;			 //현재 노드에 있는 코인
	private LinkedNode<E> _next; //다음 노드
	
	//생성자
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
		
	//element의 Getter
	public E element() {							
		return this._element;
	}
	//element의 Setter
	public void setElement(E newElement) {			
		this._element = newElement;
	}
	
	//next의 Getter
	public LinkedNode<E> next(){					
		return this._next;
	}
	//next의 Setter
	public void setNext(LinkedNode<E> newNext) {	
		this._next = newNext;
	}
}
