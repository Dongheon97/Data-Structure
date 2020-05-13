
public class MagicSquare {
	
	private static final int DEFAULT_MAX_ORDER = 99;
	
	private int _maxOrder ;
	
	public int maxOrder() {							//Getter, �������� �� ������ �ִ� ������ ��´�.
		return this._maxOrder;
	}
	
	private void setMaxOrder(int newMaxOrder) {		//Setter
		this._maxOrder = newMaxOrder;
	}
	
	public MagicSquare() {							//�⺻ ������
		this.setMaxOrder(MagicSquare.DEFAULT_MAX_ORDER);
	}
	
	public MagicSquare(int givenMaxOrder) {			//�ִ� ������ ����ڰ� �����ϴ� ������
		this.setMaxOrder(givenMaxOrder);
	}
	
	public Board solve(int anOrder) {
		if(OrderValidity.validitiyOf(anOrder) != OrderValidity.Valid) {
			return null;
		}
		else {
			Board board = new Board(anOrder);
				//������ �Բ� Board ��ü �����ڸ� call�Ͽ�, Board ��ü�� �����Ѵ�.
			CellLocation currentLoc = new CellLocation(0, anOrder/2); 
				//��� ��ġ (���� �� ���� �� ���)�� ������ ��ġ�� �����Ѵ�.
			CellLocation nextLoc = new CellLocation();
			board.setCellValue(currentLoc, 1);	//������ <�����ġ>�� 1�� ä���.
			
			int lastValue = anOrder * anOrder;
			for(int cellValue =2; cellValue<=lastValue; cellValue++) {
					// �ܰ�1 : <���� ��ġ>�κ��� <���� ��ġ>�� "������ ��" ��ġ�� ����Ѵ�.
				if(currentLoc.row()-1 < 0) {		//���� ���� ��ġ�� ǥ ���� ����� ������ ������ �̵�
					nextLoc.setRow(anOrder -1);
				}
				else {								//���� ���� ��ġ�� ǥ ���� ����� ������ ���� ��ġ���� ��ĭ ���� �̵�
					nextLoc.setRow(currentLoc.row()-1);
				}
					
				if(currentLoc.col()+1 >= anOrder) {	//���� ���� ��ġ�� ǥ ���� ����� ó�� ���� �̵�
					nextLoc.setCol(0);
				}
				else {								//���� ���� ��ġ�� ǥ ���� ����� ������ ���� ������ ��ĭ �������� �̵�
					nextLoc.setCol(currentLoc.col() +1);
				}
					//�ܰ� 2 : <���� ��ġ>�� ä���� ������
					// <���� ��ġ>�� <���� ��ġ>�� �ٷ� ���� �Ʒ� ĭ ��ġ�� �����Ѵ�.
				if(! board.cellsEmpty(nextLoc)) {	//���� ĭ�� ������� ���� ��
					if (currentLoc.row()== anOrder ) {		//���� ���� ������ ���� ��, ù��° ������ �̵��Ѵ�.
						nextLoc.setRow(0);
						nextLoc.setCol(currentLoc.col());
					}
					else {									//���� ���� ������ ���� �ƴ� ��, ��ĭ �Ʒ��� �̵��Ѵ�.
						nextLoc.setRow(currentLoc.row()+1);
						nextLoc.setCol(currentLoc.col());
					}
				}
					//�ܰ� 3 : <���� ��ġ>�� ���ο� <���� ��ġ>�� �Ѵ�.
				currentLoc.setRow(nextLoc.row()); //<���� ��ġ>�� ���� ��ġ�� �Ѵ�.
				currentLoc.setCol(nextLoc.col());
					//�ܰ� 4 : ���ο� <���� ��ġ>�� number ���� �ִ´�.
				board.setCellValue(currentLoc, cellValue); //���ο� <���� ��ġ>�� number ���� �ִ´�.
			}
			return board;
		}
	}
	
}
