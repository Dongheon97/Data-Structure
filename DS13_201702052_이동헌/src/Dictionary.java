
public abstract class Dictionary<Key extends Comparable<Key>, Obj extends Comparable<Obj>> {

	//private instance variable
	private int _size;
	
	//Getter / Setter
	public int size() {
		return this._size;
	}
	protected void setSize(int newSize) {
		//사전의 크기를 변경시키는 함수. 삽입과 삭제가 일어날 때 변경된다.
		//외부에 공개되면 안되기 때문에 public은 아니다.
		//상속 받는 class에서 사용가능하게 protected로 선언.
		this._size = newSize;
	}
	
	//Constructor
	public Dictionary() {
		this.setSize(0);
		//상속 받는 class의 생성자는 암묵적으로 상위 class의 생성자를 call 한다는 것을 잊지 말 것
	}
	
	//public non-abstract method
	public boolean isEmpty() {
		return (this.size() == 0);
	}
	
	//public abstract methods
	public abstract boolean isFull();
	public abstract boolean keyDoesExist(Key aKey);
	public abstract Obj objectForKey(Key aKey);
	public abstract boolean addKeyAndObject(Key aKey, Obj anObject);
	public abstract Obj removeObjectForKey(Key aKey);
	public abstract void clear();
	public abstract Iterator<DictionaryElement<Key, Obj>> iterator();
}//End of class "Dictionary"
