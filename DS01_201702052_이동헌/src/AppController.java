public class AppController {
	public static final int MIN_ORDER = 3;		
	public static final int MAX_ORDER = 99;		//다른 class에서도 사용하기에 public으로 선언
	
	private MagicSquare	_magicSquare;
	
	public AppController() {		//생성자
		this._magicSquare = new MagicSquare(AppController.MAX_ORDER);
	}
	
	private void showOrderValidityErrorMessage(OrderValidity orderValidity) {
		switch(orderValidity) {
			case TooSmall:
				AppView.outputLine("[오류] 차수가 너무 작습니다. "+AppController.MIN_ORDER+ "보다 크거나 작아야합니다.");
				break;
			case TooLarge:
				AppView.outputLine("[오류] 차수가 너무 작습니다. "+AppController.MAX_ORDER+ "보다 크거나 작아야합니다.");
				break;
			case NotOddNumber:
				AppView.outputLine("[오류] 차수가 짝수입니다. 홀수이어야 합니다.");
				break;
			default:
				break;
		}
	}
	
	private void showBoard(Board board) {
		CellLocation currentLoc = new CellLocation();
		this.showTitleForColumeIndexes(board.order());
		for (int row=0; row < board.order(); row++) {
			AppView.outputRowNumber(row);
			for(int col=0; col <board.order(); col++) {
				currentLoc.setRow(row);
				currentLoc.setCol(col);
				AppView.outputCellValue(board.cellValue(currentLoc));
			}
		AppView.outputLine("");
		}
	}
	
	private void showTitleForColumeIndexes(int order) {
		AppView.output("      ");		//빈칸 6개
		for(int col = 0; col <order; col++) {
			AppView.output(String.format(" [%3d] ", col));
		}
		AppView.outputLine("");
	}
	
	public void run() {		//공개 함수의 구현
		AppView.outputLine("<<< 마방진 풀이를 시작합니다 >>>");
		AppView.outputLine("");
		
		int currentOrder = AppView.inputOrder();	// 메시지를 내보내고 차수 입력 받음
		OrderValidity currentValidity = OrderValidity.validitiyOf(currentOrder);
		while (currentValidity != OrderValidity.EndOfRun) {		// 차수가 음수이면 프로그램 종료
			if (currentValidity == OrderValidity.Valid) {		// 차수가 유효한지 검사
				AppView.outputTitleWithOrder(currentOrder);
				Board solvedBoard = this._magicSquare.solve(currentOrder);	//_magicSquare 객체에게 주어진 차수의 마방진을 풀도록 시키고 마방진 판을 얻는다.
				this.showBoard(solvedBoard);		//마방진을 화면에 보여준다.
			}
			else {
				this.showOrderValidityErrorMessage(currentValidity);
			}
			currentOrder = AppView.inputOrder();	// 다음 마방진의 차수 입력 받음
			currentValidity = OrderValidity.validitiyOf(currentOrder);
		}
		AppView.outputLine("");
		AppView.outputLine("<<< 마방진 풀이를 종료합니다 >>>");
	}
	
	
	
	
	
	
}