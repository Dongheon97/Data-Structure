
public class AppController {
			
	//����� ������
	private Queue<Character> _queue;
	
	private int _inputChars;	//�Էµ� ������ ����
	private int _addedChars;	//���Ե� ������ ����
	private int _ignoredChars;	//���õ� ������ ����
	
	//Getter / Setter
	private Queue<Character> queue(){
		return this._queue;
	}
	private void setQueue(Queue<Character> newQueue) {
		this._queue = newQueue;
	}
	
	private int inputChars() {
		return this._inputChars;
	}
	private void setInputChars(int newInputChars) {
		this._inputChars = newInputChars;
	}
	
	private int addedChars() {
		return this._addedChars;
	}
	private void setAddedChars(int newAddedChars) {
		this._addedChars = newAddedChars;
	}
	
	private int ignoredChars() {
		return this._ignoredChars;
	}
	private void setIgnoredChars(int newIgnoredChars) {
		this._ignoredChars = newIgnoredChars;
	}
	
	//������
	public AppController() {
		this.setQueue(new CircularlyLinkedQueue<Character>());
		this.setInputChars(0);
		this.setAddedChars(0);
		this.setIgnoredChars(0);
	}
	
	//����� �Լ�
	//Ƚ�� ���
	private void countInputChars() {
		this.setInputChars(this.inputChars()+1);
	}
	private void countAddedChars() {
		this.setAddedChars(this.addedChars()+1);
	}
	private void countIgnoredChars() {
		this.setIgnoredChars(this.ignoredChars()+1);
		}
	
	//ť ���� ����
	private void addToQueue(char aCharForAdd) {
		if(this.queue().isFull()) {
			AppView.outputLine("[EnQ.Full] ť�� �� ���� �� �̻� ���� ���� �����ϴ�.");
		}
		else {
			Character charObjectForAdd = Character.valueOf(aCharForAdd);
			if(this.queue().enQueue(charObjectForAdd)) {
				AppView.outputLine("[EnQ] ���Ե� ���Ҵ� '" + charObjectForAdd + "' �Դϴ�.");
				}
			else {
				AppView.outputLine("(����) ť�� �ִ� ���ȿ� ������ �߻��Ͽ����ϴ�.");
			}
			this.countAddedChars();
		}
	}
	
	private void removeOne() {
		if(this.queue().isEmpty()) {
			AppView.outputLine("[DeQ.Empty] ť�� ������ ���Ұ� �����ϴ�.");
			}
		else {
			Character charForRemove = this.queue().deQueue();
			if(charForRemove == null) {
				AppView.outputLine("(����) ť���� �����ϴ� ���ȿ� ������ �߻��Ͽ����ϴ�.");
			}
			else {
				AppView.outputLine("[Deq] ������ ���Ҵ� '" + charForRemove + "' �Դϴ�.");
			}
		}
	}
	private void removeN(int numberOfCharsToBeRemoved) {
		if(numberOfCharsToBeRemoved == 0) {
			AppView.outputLine("[DeQs] ������ ������ ������ 0 �� �Դϴ�.");
		}
		else {
			int count = 0;
			while(count < numberOfCharsToBeRemoved && (!this.queue().isEmpty()) ) {
				Character charForRemove = this.queue().deQueue();
				if(charForRemove == null) {
					AppView.outputLine("(����) ť���� �����ϴ� ���ȿ� ������ �߻��Ͽ����ϴ�.");
				}
				else {
					AppView.outputLine("[DeQ] ������ ���Ҵ� '" + charForRemove + "' �Դϴ�.");
				}
				count++;
			}
			if(count < numberOfCharsToBeRemoved) {
			//ť�� ��� �� �̻� ������ �Ұ�����.
			AppView.outputLine("[DeQs.Empty] ť�� �� �̻� ������ ���Ұ� �����ϴ�.");
			}
		}
	}
	
	private void quitQueueProcessing() {
		AppView.outputLine("");
		AppView.outputLine("<ť�� ���� ����� �����մϴ�>");
		this.showAllFromFront();
		this.removeN(this.queue().size());
	}
	
	//��� ����
	private void showAllFromFront() {
		//ť�� ��� ���Ҹ� front���� rear ���� ����Ѵ�.
		//Iterator�� ����Ѵ�
		
		AppView.output("[Queue] <Front> ");
		Iterator<Character> queueIterator = this.queue().iterator();
		
		while(queueIterator.hasNext()) {
			Character element = queueIterator.next();
			AppView.output(element.toString() + " ");
		}
		AppView.outputLine("<Rear>");
	}
	
	private void showAllFromRear() {
		//ť�� ��� ���Ҹ� rear ���� front ���� ����Ѵ�.
		//elementAt()�� ����Ѵ�.
		AppView.output("[Queue] <Rear> ");
		for(int order=this.queue().size()-1; order>=0; order--) {
			AppView.output(this.queue().elementAt(order).toString() + " ");
		}
		AppView.outputLine("<Front>");
	}
	
	private void showFrontElement() {
		if(this.queue().isEmpty()) {
			AppView.outputLine("[Front.Empty] ť�� �� �� �� ���Ұ� �������� �ʽ��ϴ�.");
		}
		else {
			AppView.outputLine("[Front] ť�� �� �� ���Ҵ� '" + this.queue().front() + "' �Դϴ�.");
		}
	}
	
	private void showRearElement() {
		if(this.queue().isEmpty()) {
			AppView.outputLine("[Rear.Empty] ť�� �� �� �� ���Ұ� �������� �ʽ��ϴ�.");
		}
		else {
			AppView.outputLine("[Rear] ť�� �� �� ���Ҵ� '" + this.queue().rear() + "' �Դϴ�.");
		}
	}
	private void showQueueSize() {
		AppView.outputLine("[Size] ť���� ���� " + this.queue().size() + " ���� ���Ұ� �ս��ϴ�.");
	}
	private void showStatistics() {
		AppView.outputLine("");
		AppView.outputLine("<ť ��� ���>");
		AppView.outputLine("- �Էµ� ���ڴ� " + this.inputChars() + " �� �Դϴ�.");
		AppView.outputLine("- ���� ó���� ���ڴ� " + (this.inputChars() - this.ignoredChars()) + " �� �Դϴ�.");
		AppView.outputLine("- ���õ� ���ڴ� " + this.ignoredChars() + " �� �Դϴ�.");
		AppView.outputLine("- ���Ե� ���ڴ� " + this.addedChars() + " �� �Դϴ�.");
		
	}
	
	//�Է� ����
	private char inputChar() {
		AppView.output("? ���ڸ� �Է��Ͻÿ�: ");
		return AppView.inputChar();
	}
	
	//���� �Լ��� ����
	public void run() {
		AppView.outputLine("<<< ť ��� Ȯ�� ���α׷��� �����մϴ� >>>");
		AppView.outputLine("");
		
		char input = this.inputChar();
		while(input != '!') {
			this.countInputChars();
			if( (Character.isAlphabetic(input)) ) {
				this.addToQueue(Character.valueOf(input));
				this.countAddedChars();
			}
			else if(Character.isDigit(input)) {
				this.removeN(Character.getNumericValue(input));
			}
			else if(input == '-') {
				this.removeOne();
			}
			else if(input == '#') {
				this.showQueueSize();
			}
			else if(input == '/' ) {
				this.showAllFromFront();
			}
			else if(input == '\\') {
				this.showAllFromRear();
			}
			else if(input == '<') {
				this.showFrontElement();
			}
			else if(input == '>') {
				this.showRearElement();
			}
			else {
				AppView.outputLine("[Ignore] �ǹ� ���� ���ڰ� �ԷµǾ����ϴ�.");
				this.countIgnoredChars();
			}
			input = this.inputChar();
		}
		this.quitQueueProcessing();
		
		this.showStatistics();
		AppView.outputLine("");
		AppView.outputLine("<<< ť ��� Ȯ�� ���α׷��� �����մϴ� >>>");
	}
}
