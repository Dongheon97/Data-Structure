
public class MeasuredResult {
	//����� �ν��Ͻ� ����
	private int _size;
	private long _durationForAdd;
	private long _durationForMax;
	
	//Getter/Setter	
	public int size() {
		return this._size;
	}
	public void setSize(int newSize) {
		this._size = newSize;
	}
	
	public long durationForAdd() {
		return this._durationForAdd;
	}
	public void setDurationForAdd(long newDurationForAdd) {
		this._durationForAdd = newDurationForAdd;
	}
	
	public long durationForMax() {
		return this._durationForMax;
	}
	public void setDurationForMax(long newDurationForMax) {
		this._durationForMax = newDurationForMax;
	}
	
	//������
	public MeasuredResult() {
		this.setSize(0);
		this.setDurationForAdd(0);
		this.setDurationForMax(0);
	}
	public MeasuredResult(int givenSize, long givenDurationForAdd, long givenDurationForMax) {
		this.setSize(givenSize);
		this.setDurationForAdd(givenDurationForAdd);
		this.setDurationForMax(givenDurationForMax);
	}
	
	
}
