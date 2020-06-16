
public enum ListOrder {
	//�̹� ���迡����, 3���� ������ ������ ����Ʈ�� �����ϰ� �ִ�.
	//�� ������ ǥ���� �������� Enum "ListOrder"�� ����Ѵ�.
	
	AscendingList,		//�������� ������ ����Ʈ
	DescendingList,		//�������� ������ ����Ʈ
	RandomList;			// ������ ������ ����Ʈ
	
	public static final String[] ORDER_NAME = {"��������", "��������", "������"};

	//Enum �ȿ� ����� ������ Enum�� ��ü �ν��Ͻ��� �ν�
	
	public String orderName() {
		return ListOrder.ORDER_NAME[this.ordinal()];
		//"ordinal()"�� ��� Enum �� �̸� ���ǵǾ� �ִ� �Լ�
		//����� ���� Enum �ȿ����� ������ ������ ���� �� �ִ�.
		//Ascending.ordinal()�� 0, Descending.ordinal()�� 1,
		//Random.ordinal()�� 2�� ��´�.
	}
}
