
public class SortedLinkedList<E extends Comparable<E>> {
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
		public SortedLinkedList() {
			this.setSize(0);
			this.setHead(null);
		}
		
		//상태 알아보기
		public boolean isEmpty() {
			return (this.size()==0);
		}
		public boolean isFull() {
			return false;
		}
				
		
		public boolean add(E anElement) {
			//전달 받은 anElement을 배열의 sort 순서에 맞는 위치를 찾아 삽입
			if (this.isFull()) {
				return false;
			}
			else {
				LinkedNode<E> nodeForAdd = new LinkedNode<E>(anElement, null);
				if(this.isEmpty()) {
					//리스트에 노드가 아무 것도 없다.
					this.setHead(nodeForAdd);
				}
				else {
					//리스트에 적어도 하나의 노드가 있다.
					LinkedNode<E> current = this.head(); //현재 비교하는 노드
					LinkedNode<E> previous = null;	//current의 앞 노드, 삽입하려면 앞 노드를 알아야한다.
					while(current !=null) {
						//리스트의 끝에 도달할 때까지 비교 검색한다.
						if(current.element().compareTo(anElement) > 0) {
							//현재의 원소가 삽입할 anElement보다 크면
							//삽입할 위치를 찾은 것이므로 비교 검색 중지
							break;
						}
						previous = current; //못 찾았을 경우 previous를 current로 변경
						current = current.next();	//current를 다음 노드로 이동
					}
					if(previous == null) {
						//anElement가 가장 작으므로 맨 앞에 삽입한다.
						nodeForAdd.setNext(this.head());
						this.setHead(nodeForAdd);
					}
					else {
						//중간에 삽입한다.
						nodeForAdd.setNext(current);
						previous.setNext(nodeForAdd);
					}
				}				
				this.setSize(this.size()+1);	//크기를 하나 증가시킨다.
				return true;
			}
			
		}
		
		public E max() {
			//연결 리스트의 마지막 원소가 가장 크다.
			
			if(this.isEmpty()) {
				return null;
			}
			else if(this.size() == 1) {
				return this.head().element(); 
			}
			else {
				LinkedNode<E> currentNode = this.head();
				while(currentNode.next() != null) {
					currentNode = currentNode.next();
				}
				return currentNode.element();
			}
		}
}