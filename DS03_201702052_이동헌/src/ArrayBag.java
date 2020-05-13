
public class ArrayBag<E> {

	//����� �ν��Ͻ� ����
	private static final int DEFAULT_CAPACITY = 100;
	private int _capacity;
	private int _size; //�迭�� ���� ������ �ִ� ������ ����
	private E _element[]; //ArrayBag�� ���ҵ��� ���� java�迭
	
	//������1
	@SuppressWarnings("unchecked")
	public ArrayBag() {
		this.setCapacity(ArrayBag.DEFAULT_CAPACITY);
		this.setElements((E[]) new Object[this.capacity()] );
		this.setSize(0);
	}
	//������2
	@SuppressWarnings("unchecked")
	public ArrayBag(int givenCapacity) {
		this.setCapacity(givenCapacity);
		this.setElements((E[]) new Object[givenCapacity]);
		this.setSize(0);
	}
	
	private int capacity() { //class ���ο����� ���
		return this._capacity;
	}
	private void setCapacity(int newCapacity) { //class ���ο����� ���
		this._capacity = newCapacity;
	}
	
	public int size() { //�����Լ� 
		return this._size;
	}
	private void setSize(int newSize) { //class ���ο����� ���
		this._size = newSize;
	}
	
	private E[] elements() { //class ���ο����� ���
		return this._element;
	}
	private void setElements(E[] newElements) { //class ���ο����� ���
		this._element = newElements;
	}
	
	public boolean isEmpty() {
		return(this.size()==0);
	}
	
	public boolean isFull() {
		return(this.size()==this.capacity());
	}
	
	public boolean doesContain(E anElement) { //�־��� ���Ҹ� bag�� �����ϰ� �ִ��� �˷��ش�.
		boolean found = false;
		for(int order=0; order<this.size(); order++) {
			if(this.elements()[order].equals(anElement)) {
				found = true;
				break;
			}
		}
		return found;
	}
	
	public int frequencyOf(E anElement) { //�־��� ���Ұ� �� �� �ִ��� �˷��ش�.
		int frequencyCount = 0;
		for(int order=0; order<this.size(); order++) {
			if(this.elements()[order].equals(anElement)) {
				frequencyCount ++;
			}
		}
		return frequencyCount;
	}
	
	public boolean add(E anElement) {
		if(this.isFull()) {
			return false;
		}
		else {
			this.elements()[this.size()] = anElement;
			this.setSize(this.size() +1);
			return true;
		}
	}
	
	public boolean remove(E anElement) {	//bag���� ������ ���Ҹ� ã�Ƽ� ������ �����Ѵ�.
		int foundIndex = -1;
		boolean found = false;
		
		if(this.isEmpty()) {
			return false;
		}
		
		else {
			//�ܰ�1 : �־��� ������ ��ġ�� ã�´�.
			for(int order=0; order<this.size() && !found; order++) {
				if(this.elements()[order].equals(anElement)) {
					foundIndex = order;
					found = true;
				}
			}
			//�ܰ�2 : ������ ���� ������ ��� ���Ҹ� �������� ��ĭ�� �̵���Ų��.
			if(!found) {
				return false;
			}
			else {
				for(int i=foundIndex; i<this.size()-1; i++) {
					this.elements()[i] = this.elements()[i+1];
				}
				this.elements()[this.size()-1] = null; //���̻� �Ǹ��� ���� �������� null
				this.setSize(this.size()-1);
				return true;
			}
		}
	}
	
	public void clear() {	//bag�� ����.
		for(int order=0; order<this.size(); order++) {
			this.elements()[order] = null;
		}
		this.setSize(0);
	}
	
	public E elementAt(int anOrder) {	//anOrder ��°�� � ���Ұ� �ִ��� �˷��ش�.
		if ( (0 <= anOrder) && (anOrder < this.size())) {
			return this.elements()[anOrder];
		}
		else {
			return null;
		}
	}
}
