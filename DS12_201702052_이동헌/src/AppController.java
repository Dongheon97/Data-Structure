
public class AppController {

	//private instance variable
	private ExperimentManager _manager;
	
	//Getter / Setter
	private ExperimentManager manager() {
		return this._manager;
	}
	private void setManager(ExperimentManager newExperimentManager) {
		this._manager = newExperimentManager;
	}
	
	//Constructor
	public AppController() {
		this.setManager(new ExperimentManager());
	}
	
	//private methods
	private void showTableTitle(ListOrder anOrder) {
		AppView.outputLine("> " + anOrder.orderName() + "�����͸� ����Ͽ� ������ ����:");
	}
	
	private void showTableHead() {
		AppView.outputLine(String.format("%8s", " ") + String.format("%16s", "<Insertion Sort>") 
							+ String.format("%16s", "<Quick Sort>") );
	}
	
	private void showTableContent() {
		int startingSize = this.manager().parameterSet().startingSize();
		int incrementSize = this.manager().parameterSet().incrementSize();
		int numberOfSteps = this.manager().parameterSet().numberOfSizeIncreasingSteps();
		
		for(int step=0; step<numberOfSteps; step++) {
			int sortingSize = startingSize + (incrementSize*step);
			AppView.outputLine("[" + String.format("%5d", sortingSize) + "]" 
			                    + String.format("%16d", this.manager().measuredResultForInsertionSortAt(step))
			                    + String.format("%16d", this.manager().measuredResultForQuickSortAt(step)));
		}
	}
	
	private void showResultTable(ListOrder anOrder) {
		//�־��� anOrder�� ���Ͽ�, ���� ���� ����� �����ش�.
		this.showTableTitle(anOrder);
		this.showTableHead();
		this.showTableContent();
		AppView.outputLine("");
	}
	
	private void measureAndShowFor(ListOrder anOrder) {
		this.manager().performExperiment(anOrder);
		this.showResultTable(anOrder);
	}
	
	//public method
	public void run() {
		AppView.outputLine("<<< ���� ���� �� ���α׷��� �����մϴ� >>>");
		AppView.outputLine("");
		{
			AppView.outputLine(">> 2���� ������ ���� �� : ����, �� <<");
			this.manager().prepareExperiment(null);
				//ExperimentManager ��ü���� ������ �غ��Ų��.
				//�̹� ���迡���� �Ű����� ������ �⺻ ���� ���� ����Ѵ�.
				//�⺻ ���� ���� Class "ExperimentManager"�� ����Ǿ� �ִ�.
			
			this.measureAndShowFor(ListOrder.AscendingList);
			this.measureAndShowFor(ListOrder.DescendingList);
			this.measureAndShowFor(ListOrder.RandomList);
		}
		AppView.outputLine("<<< ���� ���� �� ���α׷��� �����մϴ� >>>");
	}
}
