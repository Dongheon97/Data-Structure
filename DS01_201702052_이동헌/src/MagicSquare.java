
public class MagicSquare {
	
	private static final int DEFAULT_MAX_ORDER = 99;
	
	private int _maxOrder ;
	
	public int maxOrder() {							//Getter, 마방진의 현 상태의 최대 차수를 얻는다.
		return this._maxOrder;
	}
	
	private void setMaxOrder(int newMaxOrder) {		//Setter
		this._maxOrder = newMaxOrder;
	}
	
	public MagicSquare() {							//기본 생성자
		this.setMaxOrder(MagicSquare.DEFAULT_MAX_ORDER);
	}
	
	public MagicSquare(int givenMaxOrder) {			//최대 차수를 사용자가 지정하는 생성자
		this.setMaxOrder(givenMaxOrder);
	}
	
	public Board solve(int anOrder) {
		if(OrderValidity.validitiyOf(anOrder) != OrderValidity.Valid) {
			return null;
		}
		else {
			Board board = new Board(anOrder);
				//차수와 함께 Board 객체 생성자를 call하여, Board 객체를 생성한다.
			CellLocation currentLoc = new CellLocation(0, anOrder/2); 
				//출발 위치 (판의 맨 윗줄 한 가운데)를 현재의 위치로 설정한다.
			CellLocation nextLoc = new CellLocation();
			board.setCellValue(currentLoc, 1);	//보드의 <출발위치>에 1을 채운다.
			
			int lastValue = anOrder * anOrder;
			for(int cellValue =2; cellValue<=lastValue; cellValue++) {
					// 단계1 : <현재 위치>로부터 <다음 위치>인 "오른쪽 위" 위치를 계산한다.
				if(currentLoc.row()-1 < 0) {		//다음 행의 위치가 표 밖을 벗어나면 마지막 행으로 이동
					nextLoc.setRow(anOrder -1);
				}
				else {								//다음 행의 위치가 표 밖을 벗어나지 않으면 현재 위치에서 한칸 위로 이동
					nextLoc.setRow(currentLoc.row()-1);
				}
					
				if(currentLoc.col()+1 >= anOrder) {	//다음 열의 위치가 표 밖을 벗어나면 처음 열로 이동
					nextLoc.setCol(0);
				}
				else {								//다음 열의 위치가 표 밖을 벗어나지 않으면 현재 열에서 한칸 우측으로 이동
					nextLoc.setCol(currentLoc.col() +1);
				}
					//단계 2 : <다음 위치>가 채워져 있으면
					// <다음 위치>를 <현재 위치>의 바로 한줄 아래 칸 위치로 수정한다.
				if(! board.cellsEmpty(nextLoc)) {	//다음 칸이 비어있지 않을 때
					if (currentLoc.row()== anOrder ) {		//현재 행이 마지막 행일 때, 첫번째 행으로 이동한다.
						nextLoc.setRow(0);
						nextLoc.setCol(currentLoc.col());
					}
					else {									//현재 행이 마지막 행이 아닐 때, 한칸 아래로 이동한다.
						nextLoc.setRow(currentLoc.row()+1);
						nextLoc.setCol(currentLoc.col());
					}
				}
					//단계 3 : <다음 위치>를 새로운 <현재 위치>로 한다.
				currentLoc.setRow(nextLoc.row()); //<다음 위치>를 현재 위치로 한다.
				currentLoc.setCol(nextLoc.col());
					//단계 4 : 새로운 <현재 위치>에 number 값을 넣는다.
				board.setCellValue(currentLoc, cellValue); //새로운 <현재 위치>에 number 값을 넣는다.
			}
			return board;
		}
	}
	
}
