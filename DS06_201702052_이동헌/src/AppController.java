
public class AppController {
	//비공개 인스턴스 변수
	private Experiment _experiment;
	
	//Getter/Setter
	private Experiment experiment() {
		return this._experiment;
	}
	private void setExperiment(Experiment newExperiment) {
		this._experiment = newExperiment;
	}
	
	//생성자
	public AppController() {
		this.setExperiment(new Experiment());	
		this.experiment().generateData();	
	}
	
	public void run() {
		AppView.outputLine("<<< 리스트 성능 측정 프로그램을 시작합니다. >>>");
		AppView.outputLine("! 리스트의 구현에 따른 시간의 차이를 알아봅니다: (단위: Micro Second)");
		
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
		AppView.outputLine("<<< 리스트 성능 측정 프로그램을 종료합니다. >>>");
	}
	
	private void showExperimentResults() {
		MeasuredResult[] results = this.experiment().measuredResults();
		for(int i = 0; i < this.experiment().numberOfIteration(); i++) {
			AppView.outputResult(results[i].size(), 
					results[i].durationForAdd() / 1000, 	//Nano를 Micro로 변환
					results[i].durationForMax() / 1000);	//Nano를 Micro로 변환
		}
	}
}
