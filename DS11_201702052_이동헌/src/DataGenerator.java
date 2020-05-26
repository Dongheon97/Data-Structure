import java.util.Random;

public final class DataGenerator {
	//Static class
	//�� �̻� ����� �ʿ䰡 �����Ƿ� "final"���� ����
	
	//������
	private DataGenerator() {
		
	}
	
	//��� �����Լ��� static
	public static Integer[] asceningList(int aSize) {
		Integer[] list = null;
		if(aSize > 0) {
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
				list[(aSize-1) - i] = i;
			}
		}
		return list;
	}
	
	public static Integer[] randomList(int aSize) {
		//��ġ�� ���Ұ� ���� ������ ����Ʈ�� �����Ͽ� �����ش�.
		Integer[] list = null;
		if(aSize>0) {
			//�ϴ� Ascending order List�� �����.
			list = new Integer[aSize];
			for(int i=0; i<aSize; i++) {
				list[i] = i;
			}
			
			//�� ���� list[i]�� ���� ������ ��ġ r�� �����Ͽ� list[i]�� list[r]�� �¹ٲ۴�.
			Random random = new Random();
			for(int i=0; i<aSize; i++) {
				int r = random.nextInt(aSize);
				Integer temp = list[i];
				list[i] = list[r];
				list[r] = temp;
			}
		}
		return list;
	}	
}
