
public class ArrayList<E> {
	//����� ���,����
	private static final int DEFAULT_CAPACITY = 100;
	private int _capacity;
	private int _size;
	private E[] _elements;
	
	//Getters/Setters
	public int capacity() {
		return this._capacity;
	}
	public void setCapacity(int newCapacity) {
		this._capacity = newCapacity;
	}
	
	public int size() {
		return this._size;
	}
	private void setSize(int newSize) {
		this._size = newSize;
	}
	
	private E[] elements() {
		return this._elements;
	}
	private void setElement(E[] newElements) {
		this._elements = newElements;
	}
	
	//������
	@SuppressWarnings("unchecked")
	public ArrayList(int givenCapacity) {
		this.setCapacity(givenCapacity);
		this.setSize(0);
		this.setElement((E[]) new Object[this.capacity()]);
	}
	public ArrayList() {
		this(ArrayList.DEFAULT_CAPACITY);
	}
	
	//���� �˾ƺ���
	public boolean isEmpty() {
		return (this.size()==0);
	}
	
	public boolean isFull() {
		return (this.size() == this.capacity());
	}
	
	private boolean anElementDoesExistAt(int anOrder) {
		return ((anOrder >=0) && (anOrder < this.size())); 
		//������ this.size()�� ���ϴ� ��. empty�� size=0�̹Ƿ� false ��ȯ
	}
	
	public E elementAt(int anOrder) {
		int position = anOrder;
		if (this.anElementDoesExistAt(position)) {
			return this.elements()[position];
		}
		else {
			return null;
		}
	}
	
	public E first() {
		if(this.isEmpty()) { //? ����Ʈ�� empty���?
			return null;
		}
		else {
			return this.elements()[0];
		}
	}
	
	public E last() {
		if(this.isEmpty()) {
			return null;
		}
		else {
			return this.elements()[this.size()-1];
		}
	}
	
	public boolean doesContain(E anElement) {
		//���� anElement�� ����Ʈ �ȿ� �����ϸ� true�� ��ȯ�Ѵ�.
		boolean found = false;
		for (int i=0; i<this.size(); i++) {
			if(this.elements()[i].equals(anElement)){
				found = true;
				break;
			}
		}
		return found; //anElement�� �������� ������ false�� ��ȯ�ȴ�.
	}
	
	public int frequencyOf(E anElement) {
		int count = 0;
		for(int i=0; i<this.size(); i++) {
			if(this.elements()[i].equals(anElement)) {
				count++;
			}
		}
		return count;
	}
	
	public int orderOf(E anElement) {
		//���� anElement�� ����Ʈ �ȿ� �����ϸ� �ش� ��ġ�� �����ش�
		//�������� ������ -1�� �����ش�.
		for(int order=0; order<this.size(); order++) {
			if(this.elements()[order].equals(anElement)) {
				return order;
			}
		}
		return -1; //�־��� ���� anElement�� ����Ʈ �ȿ� ����
	}
	
	private void makeRoomAt(int aPosition) {
		for(int i=this.size(); i>aPosition; i--) {
			this.elements()[i] = this.elements()[i-1];
		}
	}
	public boolean addTo(E anElement, int anOrder) {
		if(this.isFull()) {
			return false;
		}
		//�߸��� ���� ��ġ
		else if(anOrder<0 || anOrder>this.size()) { 
			//>=�� �ƴϰ� >�� ������? anOrder = this.size()��� ���� �迭�� �� �������� �����Ѵٴ� �Ͱ� ����
			return false;
		}
		else {
			this.makeRoomAt(anOrder);
			this.elements()[anOrder]= anElement;
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
	
	public boolean add(E anElement) { //ȿ������ �� : �� ��
		return this.addToLast(anElement);
	}
	
	private void removeGapAt(int aPosition) {
		for(int i = aPosition+1; i < this.size(); i++ ) {
			this.elements()[i-1] = this.elements()[i]; 
		}
		this.elements()[this.size()-1] = null; //�Ǹ����� �� �ʱ�ȭ
	}
	
	public E removeFrom(int anOrder) { //version ��
		//�־��� ��ġ anOrder�� ���Ұ� ������ null�� ��ȯ�Ѵ�.
		//���Ұ� ������ ����Ʈ���� �����Ͽ� ��ȯ�Ѵ�.
		if(this.isEmpty()) { //�� �˻簡 �� �ʿ��Ѱ�?
			return null;
		}
		else{
			E removedElement=null;
			if(this.anElementDoesExistAt(anOrder)) { 
				//���ǿ��� empty �˻��ϱ� ������ �������� �� �ʿ� ����.
				removedElement = this.elements()[anOrder];
				this.removeGapAt(anOrder);
				this.setSize(this.size()-1);
			}
			return removedElement;
		}
		
	}
	
	public E removeFirst() {
		return this.removeFrom(0);
	}
	
	public E removeLast() {
		return this.removeFrom(this.size()-1);
	}
	
	public E removeAny() {
		return this.removeLast();
	}
	
	public boolean remove(E anElement) {
		int orderOfRemove = this.orderOf(anElement);
		if(orderOfRemove < 0) {
			return false;
		}
		else {
			this.removeGapAt(orderOfRemove);
			this.setSize(this.size()-1);
			return true;
		}
	}
	
	public boolean replaceAt(E anElement, int anOrder) { //version ��
		if(this.isEmpty()) {
			return false;
		}
		else {
			if(this.anElementDoesExistAt(anOrder)) {
				this.elements()[anOrder] = anElement;
				return true;
			}
			else {
				return false;
			}
		}
	}
	
	public void clear() {
		for(int i=0; i<this.size(); i++) {
			this.elements()[i]=null;
		}
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
		private int _nextPosition; //�迭���� ���� ���� ��ġ
		
		//Getter/Setter
		private int nextPosition() {
			return this._nextPosition;
		}
		private void setNextPosition(int newNextPosition) {
			this._nextPosition = newNextPosition;
		}
		
		//������
		private ListIterator() {
			this.setNextPosition(0);
		}
		
		@Override
		public boolean hasNext() { //���� ���Ұ� �����ϴ����� �˾Ƴ���
			return(this.nextPosition() < ArrayList.this.size());
		}
		
		@Override
		public E next() { //���� ���Ҹ� ��´�, ������ null
			E nextElement = null;
			if(this.hasNext()) {
				nextElement = ArrayList.this.elements()[this.nextPosition()];
				this.setNextPosition(this.nextPosition()+1);
			}
			return nextElement;
		}
	}
}
