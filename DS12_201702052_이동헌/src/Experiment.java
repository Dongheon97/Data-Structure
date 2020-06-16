
public class Experiment {

	private final ParameterSet _parameterSet;
		//Class�� �Լ����� �� ���� ������ �� ����.
		//������, ������ �ȿ����� ���� ������ �� �ִ�.
		//��, ��ü�� ������ �� ������ ���� �״�� �����Ѵ�.
	
	//Getter
	private ParameterSet parameterSet() {
		return this._parameterSet;
	}
	
	//Constructor
	public Experiment(ParameterSet givenParameterSet) {
		this._parameterSet = givenParameterSet;
	}
	
	//private Methods
	private Integer[] copyListOfGivenSize(Integer[] aList, int copiedSize) {
		Integer[] copiedList = null;
		if (copiedSize > 0) {
			copiedList = new Integer[copiedSize];
			for(int i=0; i<copiedSize; i++) {
				copiedList[i] = aList[i];
			}
		}
		return copiedList;
	}
	
	private long durationOfSingleSort(Sort<Integer> aSort, Integer[] aList) {
		Timer timer = new Timer();
		timer.start();
		{
			aSort.sort(aList, aList.length);
		}
		timer.stop();
		return timer.duration();
	}
	
	//public methods
	public long[] durationsOfSort(Sort<Integer> aSort, Integer[] experimentList) {
		int numberOfSteps = this.parameterSet().numberOfSizeIncreasingSteps();
			//ũ�� ���� ������ ���� Ƚ��
		long[] durations = new long[numberOfSteps];				//���� ����� ������ ��
		
		int sortingSize = this.parameterSet().startingSize(); 	//���� �������� ���� ũ��
		int incrementSize = this.parameterSet().incrementSize(); //���� ������ ���� ũ��
		
		for(int step=0; step<numberOfSteps; step++) {
			Integer[] listForSorting = this.copyListOfGivenSize(experimentList, sortingSize);
				//������ ���� ������ ����Ʈ ����
			durations[step] = this.durationOfSingleSort(aSort, listForSorting);
				//�����Ͽ� �� ����� ����
			sortingSize += incrementSize;
				//���� �ܰ��� ���� ������ ũ�⸦ ��´�.
		}
		return durations;
	}
}//End of Experiment
