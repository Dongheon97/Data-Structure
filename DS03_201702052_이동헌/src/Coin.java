
public class Coin {
	//���
	private static final int DEFAULT_VALUE = 0;
	
	//private instance ����
	private int _value; //������ �ݾ�
	
	//������
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
		else { //aCoin�� class�� �����ϰ� Coin class�� �� ��ȯ ����.
			return (this.value()==((Coin) otherCoin).value());
		}
	}
	
	
}
