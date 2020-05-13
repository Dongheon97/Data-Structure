import java.util.Random;

public class Experiment {
	//����� ���, ������
	private static final int DEFAULT_OF_ITERATION = 5;
	private static final int DEFAULT_FIRST_SIZE = 10000; //ù��° ���� ������ ũ��
	private static final int DEFAULT_SIZE_INCREMENT = 10000; //���� ������ ũ�� ������
	
	private int _numberOfIteration;
	private int _firstSize;
	private int _sizeIncrement;
	private Coin[] _data;
	private MeasuredResult[] _measuredResults;
	
	//Getter/Setter
	public int numberOfIteration() {
		return this._numberOfIteration;
	}
	public void setNumberOfIteration(int newNumberOfIteration) {
		this._numberOfIteration = newNumberOfIteration;
	}
	
	public int firstSize() {
		return this._firstSize;
	}
	public void setFirstSize(int newFirstSize) {
		this._firstSize = newFirstSize;
	}
	
	public int sizeIncrement() {
		return this._sizeIncrement;
	}
	public void setSizeIncrement(int newSizeIncrement) {
		this._sizeIncrement = newSizeIncrement;
	}
	
	public Coin[] data() {
		return this._data;
	}
	public void setData(Coin[] newData) {
		this._data = newData;
	}
	
	public MeasuredResult[] measuredResults() {
		return this._measuredResults;
	}
	public void setMeasuredResults(MeasuredResult[] newMeasuredResults) {
		this._measuredResults = newMeasuredResults;
	}
	
	//������
	public Experiment() {
		this.setFirstSize(DEFAULT_FIRST_SIZE);
		this.setNumberOfIteration(DEFAULT_OF_ITERATION);
		this.setSizeIncrement(DEFAULT_SIZE_INCREMENT);
		this.setData(new Coin[this.maxSize()]);
		this.setMeasuredResults(new MeasuredResult[this.numberOfIteration()]);
	}
	public Experiment
		(int givenNumberOfIteration, int givenFirstSize, int givenSizeIncrement) {
		this.setFirstSize(givenFirstSize);
		this.setNumberOfIteration(givenNumberOfIteration);
		this.setSizeIncrement(givenSizeIncrement);
		this.setData(new Coin[this.maxSize()]); //���赥���͸� ���� �迭 ���� Ȯ��
		this.setMeasuredResults(new MeasuredResult[this.numberOfIteration()]);	//�������� ������ �迭 ���� Ȯ��
	}
	
	public int maxSize() {
		return ( this.firstSize() + this.sizeIncrement() * (this.numberOfIteration()-1) );
	}
	
	public void generateData() {
		Random random = new Random();
		for (int i = 0; i < this.maxSize(); i++) {
			int randomCoinValue = random.nextInt(this.maxSize());
			this.data()[i] = new Coin(randomCoinValue);
		}
	}
	
	public void measureForUnsortedArrayList() {
		//Unsorted Array�� ������ List�� ������ �����Ѵ�.
		
		@SuppressWarnings("unused")
		Coin maxCoin;
		
		long durationForAdd, durationForMax;
		long start, stop;
		
		int dataSize = this.firstSize();
		for( int iteration = 0; iteration < this.numberOfIteration(); iteration++) {
			UnsortedArrayList<Coin> list = new UnsortedArrayList<Coin>(dataSize);
			durationForAdd = 0;
			durationForMax = 0;
			for (int i =0; i<dataSize; i++) {
				start = System.nanoTime();
				list.add(this.data()[i]);
				stop = System.nanoTime();
				durationForAdd += (stop - start);
				
				start = System.nanoTime();
				maxCoin = list.max();
				stop = System.nanoTime();
				durationForMax += (stop-start);
			}
			this.measuredResults()[iteration] = new MeasuredResult(dataSize, durationForAdd, durationForMax);
			dataSize += this.sizeIncrement();
		}
	}

	
	public void measureForSortedArrayList() {
		//Sorted Array�� ������ List�� ������ �����Ѵ�.
		
		
		@SuppressWarnings("unused")
		Coin maxCoin;
		
		long durationForAdd, durationForMax;
		long start, stop;
		
		int dataSize = this.firstSize();
		for( int iteration = 0; iteration < this.numberOfIteration(); iteration++) {
			SortedArrayList<Coin> list = new SortedArrayList<Coin>(dataSize);
			durationForAdd = 0;
			durationForMax = 0;
			for (int i =0; i<dataSize; i++) {
				start = System.nanoTime();
				list.add(this.data()[i]);
				stop = System.nanoTime();
				durationForAdd += (stop - start);
				
				start = System.nanoTime();
				maxCoin = list.max();
				stop = System.nanoTime();
				durationForMax += (stop-start);
			}
			this.measuredResults()[iteration] = new MeasuredResult(dataSize, durationForAdd, durationForMax);
			dataSize += this.sizeIncrement();
		}
	}
	
	public void measureForUnsortedLinkedList() {
		//Unsorted LinkedList�� ������ List�� ������ �����Ѵ�.
		
		@SuppressWarnings("unused")
		Coin maxCoin;
			
		long durationForAdd, durationForMax;
		long start, stop;
		
		int dataSize = this.firstSize();
		for( int iteration = 0; iteration < this.numberOfIteration(); iteration++) {
			UnsortedLinkedList<Coin> list = new UnsortedLinkedList<Coin>();
			durationForAdd = 0;
			durationForMax = 0;
			for (int i =0; i<dataSize; i++) {
				start = System.nanoTime();
				list.add(this.data()[i]);
				stop = System.nanoTime();
				durationForAdd += (stop - start);
					
				start = System.nanoTime();
				maxCoin = list.max();
				stop = System.nanoTime();
				durationForMax += (stop-start);
			}
			this.measuredResults()[iteration] = new MeasuredResult(dataSize, durationForAdd, durationForMax);
			dataSize += this.sizeIncrement();
		}
	}
	
	public void measureForSortedLinkedList() {
		//Unsorted LinkedList�� ������ List�� ������ �����Ѵ�.
		
		@SuppressWarnings("unused")
		Coin maxCoin;
			
		long durationForAdd, durationForMax;
		long start, stop;
				
		int dataSize = this.firstSize();
		for( int iteration = 0; iteration < this.numberOfIteration(); iteration++) {
			SortedLinkedList<Coin> list = new SortedLinkedList<Coin>();
			durationForAdd = 0;
			durationForMax = 0;
			for (int i =0; i<dataSize; i++) {
				start = System.nanoTime();
				list.add(this.data()[i]);
				stop = System.nanoTime();
				durationForAdd += (stop - start);
							
				start = System.nanoTime();
				maxCoin = list.max();
				stop = System.nanoTime();
				durationForMax += (stop-start);
			}	
			this.measuredResults()[iteration] = new MeasuredResult(dataSize, durationForAdd, durationForMax);
			dataSize += this.sizeIncrement();
		}
	}
}
