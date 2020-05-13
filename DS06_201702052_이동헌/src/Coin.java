
public class Coin implements Comparable<Coin> {
	//상수
	private static final int DEFAULT_VALUE = 0;
		
	//private instance 변수
	private int _value; //동전의 금액
		
	//생성자
	public Coin() {
		this._value = DEFAULT_VALUE;
	}
	public Coin(int givenValue) {
		this._value = givenValue;
	}
		
	//Getter
	public int value() {
		return this._value;
	}
	
	//Setter
	public void setValue(int newValue) {
		this._value = newValue;
	}
	
	public interface Comparable<E> {
		public int compareTo(Coin aCoin);
	}
	
	@Override
	public int compareTo(Coin aCoin) {
		if(this.value() < aCoin.value()) {
			return -1;
		}
		else if(this.value() > aCoin.value()) {
			return +1;
		}
		else {
			return 0;
		}
	}
}