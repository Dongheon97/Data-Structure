
public abstract class Dictionary<Key extends Comparable<Key>, Obj extends Comparable<Obj>> {

	//private instance variable
	private int _size;
	
	//Getter / Setter
	public int size() {
		return this._size;
	}
	protected void setSize(int newSize) {
		//������ ũ�⸦ �����Ű�� �Լ�. ���԰� ������ �Ͼ �� ����ȴ�.
		//�ܺο� �����Ǹ� �ȵǱ� ������ public�� �ƴϴ�.
		//��� �޴� class���� ��밡���ϰ� protected�� ����.
		this._size = newSize;
	}
	
	//Constructor
	public Dictionary() {
		this.setSize(0);
		//��� �޴� class�� �����ڴ� �Ϲ������� ���� class�� �����ڸ� call �Ѵٴ� ���� ���� �� ��
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
