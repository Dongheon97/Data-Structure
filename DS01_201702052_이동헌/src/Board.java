
public class Board{
	//상수
	private static int EMPTY_CELL = -1;		
	
	//private instance variables
	private int _order;	
	private int[][] _cells;
	
	//getter 마방진 차수 얻는다.
	public int order() {		
		return this._order;
	}
	
	//setter 마방진 차수를 주어진 값으로 설정한다.
	private void setOrder(int newOrder) {		
		this._order = newOrder;
	}
	
	//기본 생성자
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
		//주어진 location의 cell 값을 얻는다.
		return this._cells[location.row()][location.col()];
	}
	
	public void setCellValue(CellLocation location, int value) {
		//주어진 location 의 cell 에 주어진 value를 넣는다.
		this._cells[location.row()][location.col()] = value;
	}
	
	private void setCellValue (int row, int col, int value) {
		// 이 method는 class 내부에서만 사용한다.
		// 주어진 위치 (row, col)의 cell에 주어진 값 value를 넣는다.
		this._cells[row][col] = value;
	}
	
	//public methods
	public boolean cellsEmpty (CellLocation location) {
		return(this.cellValue(location)== EMPTY_CELL);
	}

}