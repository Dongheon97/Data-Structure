import java.util.Scanner;

public class AppView {
	//����� ����
	private static Scanner scanner = new Scanner(System.in);
		
	//������
	private AppView() {
		
	}
	
	//��� ���� ���� �Լ�
	/*public static void outputDebugMessage(String message) {
		System.out.print(message);
	}*/	
	public static void outputLine(String message) {
		System.out.println(message);
	}	
	public static void output(String message) {
		System.out.print(message);
	}
		
	//�Է� ���� ���� �Լ�
		
	public static int inputInteger() throws NumberFormatException{
		//������ �ƴ� ����� ����ó���� ������ �� : exception throws
		return Integer.parseInt(AppView.scanner.next());
	}
}
