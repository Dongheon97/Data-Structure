
public class AppController {

	//���
	private static final int MENU_ADD = 1;
	private static final int MENU_REMOVE = 2;
	private static final int MENU_SEARCH = 3;
	private static final int MENU_FREQUENCY = 4;
	private static final int MENU_END_OF_RUN = 9;
	//����� �ν��Ͻ� ����
	private LinkedBag<Coin> _coinBag;
	//Getter
	private LinkedBag<Coin> coinBag() {
		return this._coinBag;
	}
	//Setter
	private void setCoinBag(LinkedBag<Coin> newCoinBag) {
		this._coinBag = newCoinBag;
	}
	
	//������
	public AppController(){
	}
	
	public void run() {
		AppView.outputLine("<<< ���� ���� ���α׷��� �����մϴ� >>>");
		AppView.outputLine("");
		
		this.setCoinBag(new LinkedBag<Coin> ());
		
		int menuNumber = AppView.inputMenuNumber();
		while(menuNumber != MENU_END_OF_RUN) {
			switch(menuNumber) {
			case MENU_ADD:
				this.addCoin();
				break;
			case MENU_REMOVE:
				this.removeCoin();
				break;
			case MENU_SEARCH:
				this.searchForCoin();
				break;
			case MENU_FREQUENCY:
				this.frequencyOfCoin();
				break;
			default:
				this.undefinedMenuNumber(menuNumber);
			}
			menuNumber = AppView.inputMenuNumber();	
		}
		this.showStatistics();
		AppView.outputLine("<<< ���� ���� ���α׷��� �����մϴ� >>>");
	}
		
	private void addCoin() {
		int coinValue = AppView.inputCoinValue();
		if(this.coinBag().add(new Coin(coinValue))) {
			AppView.outputLine("- �־��� ���� ���� ������ ���濡 ���������� �־����ϴ�.");
			AppView.outputLine("");
		}
		else {
			AppView.outputLine("- �־��� ���� ���� ������ ���濡 �ִµ� �����Ͽ����ϴ�.");
			AppView.outputLine("");
		}
	}
	
	private void removeCoin() {
		int coinValue = AppView.inputCoinValue();
		if(! this.coinBag().remove(new Coin(coinValue))) {
			AppView.outputLine("- �־��� ���� ���� ������ ���� �ȿ� �������� �ʽ��ϴ�.");
			AppView.outputLine("");
		}
		else {
			AppView.outputLine("- �־��� ���� ���� ���� �ϳ��� ���濡�� ���������� �����Ǿ����ϴ�.");
			AppView.outputLine("");
		}
	}
	
	private void searchForCoin() {
		int coinValue = AppView.inputCoinValue();
		if(this.coinBag().doesContain(new Coin(coinValue))) {
			AppView.outputLine("- �־��� ���� ���� ������ ���� �ȿ� �����մϴ�.");
			AppView.outputLine("");
		}
		else {
			AppView.outputLine("- �־��� ���� ���� ������ ���� �ȿ� �������� �ʽ��ϴ�.");
			AppView.outputLine("");
		}
	}
	
	private void frequencyOfCoin() {
		int coinValue = AppView.inputCoinValue();
		int frequency = this.coinBag().frequencyOf(new Coin(coinValue));
		AppView.outputLine("- �־��� ���� ���� ������ ������ " + frequency + " �� �Դϴ�.");
		AppView.outputLine("");
	}
	
	private void undefinedMenuNumber(int aMenuNumber) {
		AppView.outputLine("- ���õ� �޴� ��ȣ " + aMenuNumber + " �� �߸��� ��ȣ�Դϴ�.");
		AppView.outputLine("");
	}
	
	private int sumOfCoinValues() {
		int sum = 0;
		for(int order=0; order<this.coinBag().size(); order++) {
			sum = sum + this.coinBag().elementAt(order).value();
		}
		return sum;
	}
	
	private int maxCoinValue() {
		int maxValue = 0;
		for(int order=0; order<this.coinBag().size(); order++) {
			if(maxValue < this.coinBag().elementAt(order).value()) {
				maxValue = this.coinBag().elementAt(order).value();
			}
		}
		return maxValue;	
	}
	
	private void showStatistics() {
		AppView.outputLine("- ���濡 ���� ������ �����մϴ�.");
		AppView.outputLine("");
		AppView.outputLine("���濡 ��� �ִ� ������ ���� : " + this.coinBag().size() );
		AppView.outputLine("���� �߿��� ���� ū �� : " + this.maxCoinValue());
		AppView.outputLine("��� �������� ���� ��: " + this.sumOfCoinValues());
	}
}
