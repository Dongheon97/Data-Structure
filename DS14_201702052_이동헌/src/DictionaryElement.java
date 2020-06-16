
public class DictionaryElement<Key extends Comparable<Key>, Obj extends Comparable<Obj>> {

	//private instance variable
	private Key _key;
	private Obj _object;
	
	//Getter / Setter
	public Key key() {
		return this._key;
	}
	public void setKey(Key newKey) {
		this._key = newKey;
	}
	
	public Obj object() {
		return this._object;
	}
	public void setObject(Obj newObject) {
		this._object = newObject;
	}
	
	//Constructor
	public DictionaryElement() {
		this.setKey(null);
		this.setObject(null);
	}
	public DictionaryElement(Key givenKey, Obj givenObject) {
		this.setKey(givenKey);
		this.setObject(givenObject);
	}
}
