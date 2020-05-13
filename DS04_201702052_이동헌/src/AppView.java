import java.util.Scanner;

public class AppView {

		//����� ���,������
		private static Scanner scanner = new Scanner(System.in);
		
		//������
		private AppView() {
		}
		
		//��°��� �����Լ�
		public static void output(String message) {
			System.out.print(message);
		}
		
		public static void outputLine(String message) {
			System.out.println(message);
		}
		
		//�Է� ���� �����Լ�
		public static int inputMenuNumber() {
			output("? �����Ϸ��� �ϴ� �޴� ��ȣ�� �����Ͻÿ� (add: 1, remove: 2, search: 3, frequency: 4, exit: 9) :  ");
			return scanner.nextInt();
		}
		
		public static int inputCoinValue() {
			output("? ���� ���� �Է��Ͻÿ�: ");
			return scanner.nextInt();
		}
		
}
