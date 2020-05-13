public class AppController {
	public static final int MIN_ORDER = 3;		
	public static final int MAX_ORDER = 99;		//�ٸ� class������ ����ϱ⿡ public���� ����
	
	private MagicSquare	_magicSquare;
	
	public AppController() {		//������
		this._magicSquare = new MagicSquare(AppController.MAX_ORDER);
	}
	
	private void showOrderValidityErrorMessage(OrderValidity orderValidity) {
		switch(orderValidity) {
			case TooSmall:
				AppView.outputLine("[����] ������ �ʹ� �۽��ϴ�. "+AppController.MIN_ORDER+ "���� ũ�ų� �۾ƾ��մϴ�.");
				break;
			case TooLarge:
				AppView.outputLine("[����] ������ �ʹ� �۽��ϴ�. "+AppController.MAX_ORDER+ "���� ũ�ų� �۾ƾ��մϴ�.");
				break;
			case NotOddNumber:
				AppView.outputLine("[����] ������ ¦���Դϴ�. Ȧ���̾�� �մϴ�.");
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
		AppView.output("      ");		//��ĭ 6��
		for(int col = 0; col <order; col++) {
			AppView.output(String.format(" [%3d] ", col));
		}
		AppView.outputLine("");
	}
	
	public void run() {		//���� �Լ��� ����
		AppView.outputLine("<<< ������ Ǯ�̸� �����մϴ� >>>");
		AppView.outputLine("");
		
		int currentOrder = AppView.inputOrder();	// �޽����� �������� ���� �Է� ����
		OrderValidity currentValidity = OrderValidity.validitiyOf(currentOrder);
		while (currentValidity != OrderValidity.EndOfRun) {		// ������ �����̸� ���α׷� ����
			if (currentValidity == OrderValidity.Valid) {		// ������ ��ȿ���� �˻�
				AppView.outputTitleWithOrder(currentOrder);
				Board solvedBoard = this._magicSquare.solve(currentOrder);	//_magicSquare ��ü���� �־��� ������ �������� Ǯ���� ��Ű�� ������ ���� ��´�.
				this.showBoard(solvedBoard);		//�������� ȭ�鿡 �����ش�.
			}
			else {
				this.showOrderValidityErrorMessage(currentValidity);
			}
			currentOrder = AppView.inputOrder();	// ���� �������� ���� �Է� ����
			currentValidity = OrderValidity.validitiyOf(currentOrder);
		}
		AppView.outputLine("");
		AppView.outputLine("<<< ������ Ǯ�̸� �����մϴ� >>>");
	}
	
	
	
	
	
	
}