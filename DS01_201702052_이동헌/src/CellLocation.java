public class CellLocation {
	
	private static final int UndefinedIndex = -1;	//상수 설정
	private int _row;
	private int _col;
	
	public CellLocation() {
		this.setRow(UndefinedIndex);
		this.setCol(UndefinedIndex);	//셀 좌표가 주어지지 않으면 (-1,-1)로 설정
	}
	
	public CellLocation (int givenRow, int givenCol) {		//셀 좌표 주어지는 생성자
		this.setRow(givenRow);
		this.setCol(givenCol);
	}
	
	public void setRow(int newRow) {
		this._row = newRow;
	}
	public int row() {
		return this._row;
	}
	
	public void setCol(int newCol) {
		this._col = newCol;
	}
	public int col() {
		return this._col;
	}
	
}
