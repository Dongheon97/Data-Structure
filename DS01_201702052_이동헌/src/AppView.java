import java.util.Scanner;

public class AppView {
	private static Scanner scanner = new Scanner(System.in);
	private AppView() {		//������
	
	}
	
	public static int inputOrder() {
		AppView.outputLine("");
		AppView.output("? ������ ������ �Է��Ͻÿ� (������ �Է��ϸ� �����մϴ�): ");
		return AppView.scanner.nextInt();		//���� �Է� ����
	}
	public static void output(String message) {
		System.out.print(message);
	}
	public static void outputLine(String message) {
		System.out.println(message);
	}
	public static void outputTitleWithOrder(int order) {
		AppView.outputLine("Magic Square Board : order " + order);
	}
	public static void outputRowNumber (int number) {
		System.out.printf("[%3d] ", number);
	}
	public static void outputCellValue(int value) {
		System.out.printf(" %3d", value);
	}
}


