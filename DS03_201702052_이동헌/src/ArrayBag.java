
public class ArrayBag<E> {

	//비공개 인스턴스 변수
	private static final int DEFAULT_CAPACITY = 100;
	private int _capacity;
	private int _size; //배열이 현재 가지고 있는 원소의 개수
	private E _element[]; //ArrayBag의 원소들을 담을 java배열
	
	//생성자1
	@SuppressWarnings("unchecked")
	public ArrayBag() {
		this.setCapacity(ArrayBag.DEFAULT_CAPACITY);
		this.setElements((E[]) new Object[this.capacity()] );
		this.setSize(0);
	}
	//생성자2
	@SuppressWarnings("unchecked")
	public ArrayBag(int givenCapacity) {
		this.setCapacity(givenCapacity);
		this.setElements((E[]) new Object[givenCapacity]);
		this.setSize(0);
	}
	
	private int capacity() { //class 내부에서만 사용
		return this._capacity;
	}
	private void setCapacity(int newCapacity) { //class 내부에서만 사용
		this._capacity = newCapacity;
	}
	
	public int size() { //공개함수 
		return this._size;
	}
	private void setSize(int newSize) { //class 내부에서만 사용
		this._size = newSize;
	}
	
	private E[] elements() { //class 내부에서만 사용
		return this._element;
	}
	private void setElements(E[] newElements) { //class 내부에서만 사용
		this._element = newElements;
	}
	
	public boolean isEmpty() {
		return(this.size()==0);
	}
	
	public boolean isFull() {
		return(this.size()==this.capacity());
	}
	
	public boolean doesContain(E anElement) { //주어진 원소를 bag이 포함하고 있는지 알려준다.
		boolean found = false;
		for(int order=0; order<this.size(); order++) {
			if(this.elements()[order].equals(anElement)) {
				found = true;
				break;
			}
		}
		return found;
	}
	
	public int frequencyOf(E anElement) { //주어진 원소가 몇 개 있는지 알려준다.
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
	
	public boolean remove(E anElement) {	//bag에서 지정된 원소를 찾아서 있으면 제거한다.
		int foundIndex = -1;
		boolean found = false;
		
		if(this.isEmpty()) {
			return false;
		}
		
		else {
			//단계1 : 주어진 원소의 위치를 찾는다.
			for(int order=0; order<this.size() && !found; order++) {
				if(this.elements()[order].equals(anElement)) {
					foundIndex = order;
					found = true;
				}
			}
			//단계2 : 삭제된 원소 이후의 모든 원소를 앞쪽으로 한칸씩 이동시킨다.
			if(!found) {
				return false;
			}
			else {
				for(int i=foundIndex; i<this.size()-1; i++) {
					this.elements()[i] = this.elements()[i+1];
				}
				this.elements()[this.size()-1] = null; //더이상 의마가 없는 소유권은 null
				this.setSize(this.size()-1);
				return true;
			}
		}
	}
	
	public void clear() {	//bag을 비운다.
		for(int order=0; order<this.size(); order++) {
			this.elements()[order] = null;
		}
		this.setSize(0);
	}
	
	public E elementAt(int anOrder) {	//anOrder 번째에 어떤 원소가 있는지 알려준다.
		if ( (0 <= anOrder) && (anOrder < this.size())) {
			return this.elements()[anOrder];
		}
		else {
			return null;
		}
	}
}
