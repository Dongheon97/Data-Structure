
public class AppController {

	//����� ���
	private static final int TEST_SIZE = 10;
	private static final int FIRST_PART_SIZE = 5;
	private static final InsertionSort<Integer> INSERTION_SORT = new InsertionSort<Integer>();
	private static final QuickSort<Integer> QUICK_SORT = new QuickSort<Integer>();
	
	//����� �ν��Ͻ� ����
	private Integer[] _list;
	private ListOrder _listOrder; 
	
	//Getter / Setter
	private Integer[] list() {
		return this._list;
	}
	private void setList(Integer[] newList) {
		this._list = newList;
	}
	
	private ListOrder listOrder() {
		return this._listOrder;
	}
	private void setListOrder(ListOrder newListOrder) {
		this._listOrder = newListOrder;
	}
	
	//������
	public AppController() {
		
	}
	
	//���� �Լ��� ����
	public void run() {
		AppView.outputLine("<<< ���� �˰����� ���� ����� �����ϴ� ���α׷��� �����մϴ� >>>");
		AppView.outputLine("");
		
		AppView.outputLine("> ���� ����� ����: ");
		AppView.outputLine("");
		
		this.validateWithAscendingList();
		this.validateWithDescendingList();
		this.validateWithRandomList();
		
		AppView.outputLine("<<< ���� �˰����� ���� ����� �����ϴ� ���α׷��� �����մϴ� >>>");
	}
	
	//����� �Լ��� ����
	private void validateWithAscendingList() {
		this.setListOrder(ListOrder.Ascending);
		this.setList(DataGenerator.asceningList(TEST_SIZE));
		this.showFirstPartOfDataList();
		this.validateSortsAndShowResult();
	}
	
	private void validateWithDescendingList() {
		this.setListOrder(ListOrder.Descending);
		this.setList(DataGenerator.descendingList(TEST_SIZE));
		this.showFirstPartOfDataList();
		this.validateSortsAndShowResult();
	}
	
	private void validateWithRandomList() {
		this.setListOrder(ListOrder.Random);
		this.setList(DataGenerator.randomList(TEST_SIZE));
		this.showFirstPartOfDataList();
		this.validateSortsAndShowResult();
	}
	
	private void showFirstPartOfDataList() {
		AppView.output("[" + this.listOrder().orderName() + " ����Ʈ] �� �� �κ�: ");
		for(int i=0; i < AppController.FIRST_PART_SIZE; i++) {
			AppView.output(this.list()[i] + " ");
		}
		AppView.outputLine("");
	}
	
	private void validateSortsAndShowResult() {
		this.validateSort(AppController.INSERTION_SORT);
		this.validateSort(AppController.QUICK_SORT);
		AppView.outputLine("");
	}
	
	private void validateSort(Sort<Integer> aSort) {
		Integer[] list = this.copyList(this.list()); 
			//������ ����Ʈ�� ���� �� (�����δ� 2��) �����ϰ� �ȴ�.
			//�Ź� ���� ����Ʈ�� �����Ͽ� �����Ѵ�.
		aSort.sort(list, list.length);
		this.showValidationMessage(aSort, list);
	}
	
	private Integer[] copyList(Integer[] aList) {
		//�־��� �迭 ��ü aList[] �� ���纻�� ����� �����ش�.
		//aList[] ��ü�� ����������,
		//�迭�� ���� ��ü ��ü�� �������� �ʰ� �����Ѵ�.
		
		Integer[] copiedList = new Integer[aList.length];
		for(int i=0; i<this.list().length; i++) {
			copiedList[i] = this.list()[i];
		}
		return copiedList;
	}
	
	private boolean sortedListIsValid(Integer[] aList) {
		//�־��� aList�� ���ҵ��� ������������ �Ǿ� ������ true�� �����ش�.
		for(int i=0; i<(aList.length-1); i++) {
			if(aList[i].compareTo(aList[i+1]) > 0) {
				return false; //���������� �ƴ� ������ �߰�
			}
		}
		return true; //����Ʈ ��ü�� ������������ �Ǿ� �ִ�.
	}
	
	private void showValidationMessage(Sort<Integer> aSort, Integer[] aList) {
		AppView.output("[" + this.listOrder().orderName() + " ����Ʈ]�� [" 
						+ aSort.getClass().getSimpleName() + "] �� ����� " );
		if(this.sortedListIsValid(aList)) {
			AppView.outputLine("�ùٸ��ϴ�.");
		}
		else {
			AppView.outputLine("�ùٸ��� �ʽ��ϴ�.");
		}
	}
	
}
