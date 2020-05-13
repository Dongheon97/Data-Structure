
public class SortedLinkedList<E extends Comparable<E>> {
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
		public SortedLinkedList() {
			this.setSize(0);
			this.setHead(null);
		}
		
		//���� �˾ƺ���
		public boolean isEmpty() {
			return (this.size()==0);
		}
		public boolean isFull() {
			return false;
		}
				
		
		public boolean add(E anElement) {
			//���� ���� anElement�� �迭�� sort ������ �´� ��ġ�� ã�� ����
			if (this.isFull()) {
				return false;
			}
			else {
				LinkedNode<E> nodeForAdd = new LinkedNode<E>(anElement, null);
				if(this.isEmpty()) {
					//����Ʈ�� ��尡 �ƹ� �͵� ����.
					this.setHead(nodeForAdd);
				}
				else {
					//����Ʈ�� ��� �ϳ��� ��尡 �ִ�.
					LinkedNode<E> current = this.head(); //���� ���ϴ� ���
					LinkedNode<E> previous = null;	//current�� �� ���, �����Ϸ��� �� ��带 �˾ƾ��Ѵ�.
					while(current !=null) {
						//����Ʈ�� ���� ������ ������ �� �˻��Ѵ�.
						if(current.element().compareTo(anElement) > 0) {
							//������ ���Ұ� ������ anElement���� ũ��
							//������ ��ġ�� ã�� ���̹Ƿ� �� �˻� ����
							break;
						}
						previous = current; //�� ã���� ��� previous�� current�� ����
						current = current.next();	//current�� ���� ���� �̵�
					}
					if(previous == null) {
						//anElement�� ���� �����Ƿ� �� �տ� �����Ѵ�.
						nodeForAdd.setNext(this.head());
						this.setHead(nodeForAdd);
					}
					else {
						//�߰��� �����Ѵ�.
						nodeForAdd.setNext(current);
						previous.setNext(nodeForAdd);
					}
				}				
				this.setSize(this.size()+1);	//ũ�⸦ �ϳ� ������Ų��.
				return true;
			}
			
		}
		
		public E max() {
			//���� ����Ʈ�� ������ ���Ұ� ���� ũ��.
			
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