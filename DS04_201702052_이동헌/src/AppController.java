
public class AppController {

	//상수
	private static final int MENU_ADD = 1;
	private static final int MENU_REMOVE = 2;
	private static final int MENU_SEARCH = 3;
	private static final int MENU_FREQUENCY = 4;
	private static final int MENU_END_OF_RUN = 9;
	//비공개 인스턴스 변수
	private LinkedBag<Coin> _coinBag;
	//Getter
	private LinkedBag<Coin> coinBag() {
		return this._coinBag;
	}
	//Setter
	private void setCoinBag(LinkedBag<Coin> newCoinBag) {
		this._coinBag = newCoinBag;
	}
	
	//생성자
	public AppController(){
	}
	
	public void run() {
		AppView.outputLine("<<< 동전 가방 프로그램을 시작합니다 >>>");
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
		AppView.outputLine("<<< 동전 가방 프로그램을 종료합니다 >>>");
	}
		
	private void addCoin() {
		int coinValue = AppView.inputCoinValue();
		if(this.coinBag().add(new Coin(coinValue))) {
			AppView.outputLine("- 주어진 값을 갖는 동전을 가방에 성공적으로 넣었습니다.");
			AppView.outputLine("");
		}
		else {
			AppView.outputLine("- 주어진 값을 갖는 동전을 가방에 넣는데 실패하였습니다.");
			AppView.outputLine("");
		}
	}
	
	private void removeCoin() {
		int coinValue = AppView.inputCoinValue();
		if(! this.coinBag().remove(new Coin(coinValue))) {
			AppView.outputLine("- 주어진 값을 갖는 동전은 가방 안에 존재하지 않습니다.");
			AppView.outputLine("");
		}
		else {
			AppView.outputLine("- 주어진 값을 갖는 동전 하나가 가방에서 정상적으로 삭제되었습니다.");
			AppView.outputLine("");
		}
	}
	
	private void searchForCoin() {
		int coinValue = AppView.inputCoinValue();
		if(this.coinBag().doesContain(new Coin(coinValue))) {
			AppView.outputLine("- 주어진 값을 갖는 동전이 가방 안에 존재합니다.");
			AppView.outputLine("");
		}
		else {
			AppView.outputLine("- 주어진 값을 갖는 동전은 가방 안에 존재하지 않습니다.");
			AppView.outputLine("");
		}
	}
	
	private void frequencyOfCoin() {
		int coinValue = AppView.inputCoinValue();
		int frequency = this.coinBag().frequencyOf(new Coin(coinValue));
		AppView.outputLine("- 주어진 값을 갖는 동전의 개수는 " + frequency + " 개 입니다.");
		AppView.outputLine("");
	}
	
	private void undefinedMenuNumber(int aMenuNumber) {
		AppView.outputLine("- 선택된 메뉴 번호 " + aMenuNumber + " 는 잘못된 번호입니다.");
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
		AppView.outputLine("- 가방에 대한 수행을 종료합니다.");
		AppView.outputLine("");
		AppView.outputLine("가방에 들어 있는 동전의 개수 : " + this.coinBag().size() );
		AppView.outputLine("동전 중에서 가장 큰 값 : " + this.maxCoinValue());
		AppView.outputLine("모든 동전들의 값의 합: " + this.sumOfCoinValues());
	}
}
