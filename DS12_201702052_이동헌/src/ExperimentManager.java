
public class ExperimentManager {
	//Constants for the parameters
	private static final int DEFAULT_NUMBER_OF_SIZE_INCREASING_STEPS = 10;
	private static final int DEFAULT_INCREMENT_SIZE = 1000;
	private static final int DEFAULT_STARTING_SIZE = DEFAULT_INCREMENT_SIZE;
	
	//Constants : ���迡�� ����� ���ĵ��� ��� ��ü�� ����
	private static InsertionSort<Integer> INSERTION_SORT = new InsertionSort<Integer>();
	private static QuickSort<Integer> QUICK_SORT = new QuickSort<Integer>();
	
	//private instance variables
	private Experiment _experiment;			//���� ������ �ǽ��� ��ü
	private ParameterSet _parameterSet;		//���� ���迡 ����� �Ű����� ����
	private Integer[] _ascendingList;		//�������� ���Ŀ� ����� �������� ������ ����Ʈ
	private Integer[] _descendingList;		//�������� ���Ŀ� ����� �������� ������ ����Ʈ
	private Integer[] _randomList;			//�������� ���Ŀ� ����� ������ ������ ����Ʈ
	private long[] _measuredResultForInsertionSort;	//���� ������ ���� ��� ������ ��
	private long[] _measuredResultForQuickSort; 	//�� ���� ���� ��� ������ ��
	
	//Getter / Setter
	private Experiment experiment() {
		return this._experiment;
	}
	private void setExperiment(Experiment newExperiment) {
		this._experiment = newExperiment;
	}
	
	public ParameterSet parameterSet() {
		return this._parameterSet;
	}
	private void setParameterSet(ParameterSet newParameterSet) {
		this._parameterSet = newParameterSet;
	}
	
	private Integer[] ascendingList() {
		return this._ascendingList;
	}
	private void setAscendingList(Integer[] newAscendingList) {
		this._ascendingList = newAscendingList;
	}
	
	private Integer[] descendingList() {
		return this._descendingList;
	}
	private void setDescendingList(Integer[] newDescendingList) {
		this._descendingList = newDescendingList;
	}
	
	private Integer[] randomList() {
		return this._randomList;
	}
	private void setRandomList(Integer[] newRandomList) {
		this._randomList = newRandomList;
	}
	
	private long[] measuredResultForInsertionSort() {
		return this._measuredResultForInsertionSort;
	}
	private void setMeasuredResultForInsertionSort(long[] newMeasuredResultForInsertionSort) {
		this._measuredResultForInsertionSort = newMeasuredResultForInsertionSort;
	}
	
	private long[] measuredResultForQuickSort() {
		return this._measuredResultForQuickSort;
	}
	private void setMeasuredResultForQuickSort(long[] newMeasuredResultForQuickSort) {
		this._measuredResultForQuickSort = newMeasuredResultForQuickSort;
	}
	
	//Constructor
	public ExperimentManager() {
		this.setParameterSetWithDefaults();
	}
	
	//private methods
	private void setParameterSetWithDefaults(){
		this.setParameterSet(new ParameterSet(ExperimentManager.DEFAULT_STARTING_SIZE, 
				ExperimentManager.DEFAULT_NUMBER_OF_SIZE_INCREASING_STEPS,
				ExperimentManager.DEFAULT_INCREMENT_SIZE));
	}
	
	private void prepareExperimentList() {
		int maxDataSize = this.parameterSet().maxDataSize();
		
		this.setAscendingList(DataGenerator.aescendingList(maxDataSize));
		this.setDescendingList(DataGenerator.descendingList(maxDataSize));
		this.setRandomList(DataGenerator.randomList(maxDataSize));
	}
	
	
	private Integer[] experimentListOrder(ListOrder anOrder) {
		//�־��� anOrder�� �ش��ϴ� ����Ʈ�� �����ش�.
		
		switch(anOrder) {
		case AscendingList:
			return this.ascendingList();
		case DescendingList:
			return this.descendingList();
		default:
			return this.randomList();
		}
	}
	
	//public method
	public void prepareExperiment(ParameterSet aParameterSet) {
		//������ �غ��Ѵ�. 
		
		if(aParameterSet != null) {
			//��ü ������ ��, �Ű����� ������ �⺻ ������ �����Ǿ� �ִ�.
			//���� �غ� �ܰ迡��, �̷��� ���ο� �Ű����� ������ �־� ������ �� �ִ�.
			this.setParameterSet(aParameterSet);
		}
		
		this.setExperiment(new Experiment (this.parameterSet()));
			//���� ������ �Ű����� ������ ����Ͽ� Experiment ��ü�� �����Ѵ�.
		
		this.prepareExperimentList();
			//���� ���迡�� ���Ŀ� ����� ������ ����Ʈ�� �����Ͽ� �����Ѵ�.
		
		//������ ������ ���� ������, ���������δ� �ǹ̰� ���� �����̴�.
		//���� ���� ����� ����ȭ��Ű�� ���� �����̴�.
		this.performExperiment(ListOrder.RandomList);
		this.performExperiment(ListOrder.RandomList);
	}
	
	public long measuredResultForInsertionSortAt(int sizeStep) {
		return this.measuredResultForInsertionSort()[sizeStep];
	}
	public long measuredResultForQuickSortAt(int sizeStep) {
		return this.measuredResultForQuickSort()[sizeStep];
	}
	
	public void performExperiment(ListOrder anOrder) {
		//���� ������ �����Ѵ�.
		//�־��� anOrder�� ���� ����Ʈ�� ��´�.
		Integer[] experimentList = this.experimentListOrder(anOrder);
		
		//�� ���� ����Ʈ�� ���԰� �� ������ ������ ������ �����Ͽ� �� ����� ��´�.
		this.setMeasuredResultForInsertionSort(
				this.experiment().durationsOfSort(INSERTION_SORT, experimentList));
		this.setMeasuredResultForQuickSort(
				this.experiment().durationsOfSort(QUICK_SORT, experimentList));
	}
}
