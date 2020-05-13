
public class UnsortedLinkedList<E extends Comparable<E>> {
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
		public UnsortedLinkedList() {
			this.setSize(0);
			this.setHead(null);
		}
		
		//���� �˾ƺ���
		public boolean isEmpty() {
			return (this.size()==0);
		}
				
		public void add(E anElement) {
			//���Ḯ��Ʈ�� �� �տ� �����Ѵ�.
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
				//����Ʈ�� ��尡 �ϳ��� ��, �ش� ��尡 �ִ밪
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
