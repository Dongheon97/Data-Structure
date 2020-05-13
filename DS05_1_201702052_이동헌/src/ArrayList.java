
public class ArrayList<E> {
	//비공개 상수,변수
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
	
	//생성자
	@SuppressWarnings("unchecked")
	public ArrayList(int givenCapacity) {
		this.setCapacity(givenCapacity);
		this.setSize(0);
		this.setElement((E[]) new Object[this.capacity()]);
	}
	public ArrayList() {
		this(ArrayList.DEFAULT_CAPACITY);
	}
	
	//상태 알아보기
	public boolean isEmpty() {
		return (this.size()==0);
	}
	
	public boolean isFull() {
		return (this.size() == this.capacity());
	}
	
	private boolean anElementDoesExistAt(int anOrder) {
		return ((anOrder >=0) && (anOrder < this.size())); 
		//조건이 this.size()와 비교하는 것. empty면 size=0이므로 false 반환
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
		if(this.isEmpty()) { //? 리스트가 empty라면?
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
		//원소 anElement가 리스트 안에 존재하면 true를 반환한다.
		boolean found = false;
		for (int i=0; i<this.size(); i++) {
			if(this.elements()[i].equals(anElement)){
				found = true;
				break;
			}
		}
		return found; //anElement가 존재하지 않으면 false가 반환된다.
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
		//원소 anElement가 리스트 안에 존재하면 해당 위치를 돌려준다
		//존재하지 않으면 -1을 돌려준다.
		for(int order=0; order<this.size(); order++) {
			if(this.elements()[order].equals(anElement)) {
				return order;
			}
		}
		return -1; //주어진 원소 anElement가 리스트 안에 없다
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
		//잘못된 삽입 위치
		else if(anOrder<0 || anOrder>this.size()) { 
			//>=가 아니고 >인 이유는? anOrder = this.size()라는 뜻은 배열의 맨 마지막에 삽입한다는 것과 같음
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
	
	public boolean add(E anElement) { //효율적인 곳 : 맨 뒤
		return this.addToLast(anElement);
	}
	
	private void removeGapAt(int aPosition) {
		for(int i = aPosition+1; i < this.size(); i++ ) {
			this.elements()[i-1] = this.elements()[i]; 
		}
		this.elements()[this.size()-1] = null; //맨마지막 값 초기화
	}
	
	public E removeFrom(int anOrder) { //version 비교
		//주어진 위치 anOrder에 원소가 없으면 null을 반환한다.
		//원소가 있으면 리스트에서 제거하여 반환한다.
		if(this.isEmpty()) { //이 검사가 꼭 필요한가?
			return null;
		}
		else{
			E removedElement=null;
			if(this.anElementDoesExistAt(anOrder)) { 
				//조건에서 empty 검사하기 때문에 이중으로 할 필요 없음.
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
	
	public boolean replaceAt(E anElement, int anOrder) { //version 비교
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
	
	//ListIterator 생성하여 얻기
	public Iterator<E> iterator(){
		return (new ListIterator());
	}
	
	public interface Iterator<E>{
		public boolean hasNext();
		public E next();
	}
	
	private class ListIterator implements Iterator<E>{
		//비공개 변수
		private int _nextPosition; //배열에서 다음 원소 위치
		
		//Getter/Setter
		private int nextPosition() {
			return this._nextPosition;
		}
		private void setNextPosition(int newNextPosition) {
			this._nextPosition = newNextPosition;
		}
		
		//생성자
		private ListIterator() {
			this.setNextPosition(0);
		}
		
		@Override
		public boolean hasNext() { //다음 원소가 존재하는지를 알아낸다
			return(this.nextPosition() < ArrayList.this.size());
		}
		
		@Override
		public E next() { //다음 원소를 얻는다, 없으면 null
			E nextElement = null;
			if(this.hasNext()) {
				nextElement = ArrayList.this.elements()[this.nextPosition()];
				this.setNextPosition(this.nextPosition()+1);
			}
			return nextElement;
		}
	}
}
