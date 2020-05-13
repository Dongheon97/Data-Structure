
public class Board{
	//���
	private static int EMPTY_CELL = -1;		
	
	//private instance variables
	private int _order;	
	private int[][] _cells;
	
	//getter ������ ���� ��´�.
	public int order() {		
		return this._order;
	}
	
	//setter ������ ������ �־��� ������ �����Ѵ�.
	private void setOrder(int newOrder) {		
		this._order = newOrder;
	}
	
	//�⺻ ������
	public Board (int givenOrder) {		
		this.setOrder(givenOrder);
		this.setCells(new int[givenOrder][givenOrder]);
		for (int row=0; row < givenOrder; row++) {
			for(int col=0; col < givenOrder; col++) {
				this.setCellValue(row, col, Board.EMPTY_CELL);
			}
		}
	}
	
	private void setCells(int[][] newCells) {
		this._cells = newCells;
	}
	
	public int cellValue(CellLocation location) {
		//�־��� location�� cell ���� ��´�.
		return this._cells[location.row()][location.col()];
	}
	
	public void setCellValue(CellLocation location, int value) {
		//�־��� location �� cell �� �־��� value�� �ִ´�.
		this._cells[location.row()][location.col()] = value;
	}
	
	private void setCellValue (int row, int col, int value) {
		// �� method�� class ���ο����� ����Ѵ�.
		// �־��� ��ġ (row, col)�� cell�� �־��� �� value�� �ִ´�.
		this._cells[row][col] = value;
	}
	
	//public methods
	public boolean cellsEmpty (CellLocation location) {
		return(this.cellValue(location)== EMPTY_CELL);
	}

}