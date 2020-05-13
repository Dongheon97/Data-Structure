import java.util.Scanner;

public class AppView {
	//����� ���/������
	private static Scanner scanner = new Scanner(System.in);

	public AppView() {
	}
	
	//�Է��� ���� �����Լ�
	public static int inputInt() throws NumberFormatException {
		return Integer.parseInt(AppView.scanner.nextLine());
	}
	public static int inputScore() {
		while (true) {
			try {
				AppView.output("- ������ �Է��Ͻÿ� (0..100): ");
				int score = AppView.inputInt();
				return score;
			}
			catch(NumberFormatException e){
				AppView.outputLine("(����) ������ �Էµ��� �ʾҽ��ϴ�.");
			}
		}
	}
	
	//����� ���� �����Լ�
	public static void outputLine(String message) {
		System.out.println(message);
	}
	public static void output(String message) {
		System.out.print(message);
	}
	
	//�б� �л� �� ���
	public static void outputNumberOfStudents(int aNumberOfStudents) {
		AppView.outputLine("�б� �л� ��: " + aNumberOfStudents );
	}
	
	//�б� �ְ� ���� ���
	public static void outputHighestScore(int aScore) {
		AppView.outputLine("�б� �ְ� ����: " + aScore );
	}
	
	//�б� ���� ���� ���
	public static void outputLowestScore(int aScore) {
		AppView.outputLine("�б� ���� ����: " + aScore );
	}
	
	//��հ��� ���
	public static void outputAverageScore(double anAverageScore) {
		AppView.outputLine("�б� ���: " + anAverageScore );
	}
	
	//��� �̻��� �л� �� ���
	public static void outputNumberOfStudentsAboveAverage(int anNumberOfStudents) {
		AppView.outputLine("��� �̻��� �л� ��: " + anNumberOfStudents );
	}
	
	//�� ������ ���� �л� �� ���
	public static void outputNumberOfStudentsForGrade(char aGrade, int aNumberOfStudents) {
		AppView.outputLine(aGrade + " ������ �л� ���� " + aNumberOfStudents + " �Դϴ�.");
	}
	
	//�л����� ���� ���
	public static void outputScore(int aScore) {
		AppView.outputLine("����: " + aScore);
	}
	
	public static boolean doesContinueToInputStudent() {
		AppView.output("������ �Է��Ϸ��� 'Y' �Ǵ� 'y'��, �����Ϸ��� �ٸ� �ƹ� Ű�� ġ�ÿ�: ");
		String line = null;
		do {
			line = AppView.scanner.nextLine();
		}while(line.equals(""));
		char answer = line.charAt(0);
		return ((answer == 'Y') || (answer == 'y'));
	}
}
