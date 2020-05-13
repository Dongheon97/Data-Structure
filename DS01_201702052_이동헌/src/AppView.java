import java.util.Scanner;

public class AppView {
	private static Scanner scanner = new Scanner(System.in);
	private AppView() {		//생성자
	
	}
	
	public static int inputOrder() {
		AppView.outputLine("");
		AppView.output("? 마방진 차수를 입력하시오 (음수를 입력하면 종료합니다): ");
		return AppView.scanner.nextInt();		//차수 입력 받음
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


