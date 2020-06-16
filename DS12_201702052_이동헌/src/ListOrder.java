
public enum ListOrder {
	//이번 실험에서는, 3가지 유형의 데이터 리스트를 구분하고 있다.
	//이 구분을 표현할 목적으로 Enum "ListOrder"를 사용한다.
	
	AscendingList,		//오름차순 데이터 리스트
	DescendingList,		//내림차순 데이터 리스트
	RandomList;			// 무작위 데이터 리스트
	
	public static final String[] ORDER_NAME = {"오름차순", "내림차순", "무작위"};

	//Enum 안에 선언된 값들은 Enum의 객체 인스턴스로 인식
	
	public String orderName() {
		return ListOrder.ORDER_NAME[this.ordinal()];
		//"ordinal()"은 모든 Enum 에 미리 정의되어 있는 함수
		//선언된 값의 Enum 안에서의 순서를 정수로 얻을 수 있다.
		//Ascending.ordinal()은 0, Descending.ordinal()은 1,
		//Random.ordinal()은 2를 얻는다.
	}
}
