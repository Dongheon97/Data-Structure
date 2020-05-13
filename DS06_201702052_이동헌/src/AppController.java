
public class AppController {
	//����� �ν��Ͻ� ����
	private Experiment _experiment;
	
	//Getter/Setter
	private Experiment experiment() {
		return this._experiment;
	}
	private void setExperiment(Experiment newExperiment) {
		this._experiment = newExperiment;
	}
	
	//������
	public AppController() {
		this.setExperiment(new Experiment());	
		this.experiment().generateData();	
	}
	
	public void run() {
		AppView.outputLine("<<< ����Ʈ ���� ���� ���α׷��� �����մϴ�. >>>");
		AppView.outputLine("! ����Ʈ�� ������ ���� �ð��� ���̸� �˾ƺ��ϴ�: (����: Micro Second)");
		
		AppView.outputLine("");
		AppView.outputLine("<Unsorted Array List>");
		this.experiment().measureForUnsortedArrayList();
		this.showExperimentResults();
		
		AppView.outputLine("");
		AppView.outputLine("<Sorted Array List>");
		this.experiment().measureForSortedArrayList();
		this.showExperimentResults();
		
		AppView.outputLine("");
		AppView.outputLine("<Unsorted Linked List>");
		this.experiment().measureForUnsortedLinkedList();
		this.showExperimentResults();
		
		AppView.outputLine("");
		AppView.outputLine("<Sorted Linked List>");
		this.experiment().measureForSortedLinkedList();
		this.showExperimentResults();
		
		AppView.outputLine("");
		AppView.outputLine("<<< ����Ʈ ���� ���� ���α׷��� �����մϴ�. >>>");
	}
	
	private void showExperimentResults() {
		MeasuredResult[] results = this.experiment().measuredResults();
		for(int i = 0; i < this.experiment().numberOfIteration(); i++) {
			AppView.outputResult(results[i].size(), 
					results[i].durationForAdd() / 1000, 	//Nano�� Micro�� ��ȯ
					results[i].durationForMax() / 1000);	//Nano�� Micro�� ��ȯ
		}
	}
}
