import java.util.Scanner;

public class AppView {

		//비공개 상수,변수들
		private static Scanner scanner = new Scanner(System.in);
		
		//생성자
		private AppView() {
		}
		
		//출력관련 공개함수
		public static void output(String message) {
			System.out.print(message);
		}
		
		public static void outputLine(String message) {
			System.out.println(message);
		}
		
		//입력 관련 공개함수
		public static int inputMenuNumber() {
			output("? 수행하려고 하는 메뉴 번호를 선택하시오 (add: 1, remove: 2, search: 3, frequency: 4, exit: 9) :  ");
			return scanner.nextInt();
		}
		
		public static int inputCoinValue() {
			output("? 동전 값을 입력하시오: ");
			return scanner.nextInt();
		}
		
}
