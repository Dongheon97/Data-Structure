import java.util.Random;

public final class DataGenerator {

	
	//Constructor
	private DataGenerator() {
		
	}
	
	public static Integer[] aescendingList(int aSize) {
		Integer[] list = null;
		if(aSize>0) {
			list = new Integer[aSize];
			for(int i=0; i<aSize; i++) {
				list[i] = i;
			}
		}
		return list;
	}
	
	public static Integer[] descendingList(int aSize) {
		Integer[] list = null;
		if(aSize > 0) {
			list = new Integer[aSize];
			for(int i = 0; i<aSize; i++) {
				list[(aSize-1)-i] = i;
			}
		}
		return list;
	}
	
	public static Integer[] randomListWithoutDuplication(int aSize) {
		//겹치는 원소가 없는 무작위 리스트를 생성하여 돌려준다.
		Integer[] list = null;
		if(aSize > 0) {
			//먼저 오름차순 리스트를 생성한다.
			list = new Integer[aSize];
			for(int i=0; i<aSize; i++) {
				list[i] = i;
			}
			
			//각 원소 list[i]에 대해 무작위 위치 r을 생성하여 list[i]와 list[r]을 맞바꾼다.
			Random random = new Random();
			for(int i=0; i<aSize; i++) {
				int randomIndex = random.nextInt(aSize);
				Integer temp = list[i];
				list[i] = list[randomIndex];
				list[randomIndex] = temp;
			}
		}
		return list;
	}
}
