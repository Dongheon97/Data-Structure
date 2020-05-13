
public class UnsortedLinkedList<E extends Comparable<E>> {
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
		public UnsortedLinkedList() {
			this.setSize(0);
			this.setHead(null);
		}
		
		//상태 알아보기
		public boolean isEmpty() {
			return (this.size()==0);
		}
				
		public void add(E anElement) {
			//연결리스트의 맨 앞에 삽입한다.
			LinkedNode<E> nodeForAdd = new LinkedNode<E>(anElement, null);
			nodeForAdd.setNext(this.head());
			this.setHead(nodeForAdd);
			this.setSize(this.size()+1);
		}
		
		public E max() {
			if(this.isEmpty()) {
				return null;
			}
			else if(this.size() == 1) {
				//리스트의 노드가 하나일 때, 해당 노드가 최대값
				return this.head().element();
			}
			else {
				LinkedNode<E> maxNode = this.head();
				LinkedNode<E> currentNode = this.head().next();
				
				while(currentNode!=null) {
					if(maxNode.element().compareTo(currentNode.element()) < 0) {
						maxNode = currentNode;
					}
					currentNode = currentNode.next();
				}
				return maxNode.element();
			}
		}		
}
