
public class Coin {
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
	
	@Override
	public boolean equals(Object otherCoin) {
		if(otherCoin.getClass() != Coin.class) {
			return false;
		}
		else { //aCoin의 class를 안전하게 Coin class로 형 변환 가능.
			return (this.value()==((Coin) otherCoin).value());
		}
	}
	
	
}
