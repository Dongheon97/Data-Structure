import java.util.Arrays;

public class Calculator {
	//비공개 상수
	private static final int MAX_EXPRESSION_LENGTH =10;
	
	//비공개 인스턴스 상수
	private Stack<Character> _operatorStack;
	private String _infixExpression;
	private String _postfixExpression;
	private PostfixCalculator _postfixCalculator;
	
	//Getter/Setter
	private String infixExpression() {
		return this._infixExpression;
	}
	private void setInfixExpression(String newInfixExpression) {
		this._infixExpression = newInfixExpression;
	}
	
	private String postfixExpression() {
		return this._postfixExpression;
	}
	private void setPostfixExpression(String newPostfixExpression) {
		this._postfixExpression = newPostfixExpression;
	}
	
	private PostfixCalculator postfixCalculator() {
		return this._postfixCalculator;
	}
	private void setPostfixCalculator(PostfixCalculator newPostfixCalculator) {
		this._postfixCalculator = newPostfixCalculator;
	}
	
	private Stack<Character> operatorStack(){
		return this._operatorStack;
	}
	private  void setOperatorStack(Stack<Character> newOperatorStack) {
		this._operatorStack = newOperatorStack;
	}
	
	//생성자
	public Calculator() {
		this.setOperatorStack( new ArrayList<Character>(Calculator.MAX_EXPRESSION_LENGTH));
		this.setPostfixCalculator(new PostfixCalculator(Calculator.MAX_EXPRESSION_LENGTH));
	}
	
	private void showOperatorStack(String anOperationLabel) {
		AppView.outputDebugMessage("  : " + anOperationLabel + " OperatorStack <Bottom> ");
		for(int i=0; i<this.operatorStack().size(); i++) {
			AppView.outputDebugMessage( ((ArrayList<Character>)this.operatorStack()).elementAt(i).charValue() + " ");
		}
		AppView.outputLineDebugMessage("<Top>");
	}
	
	private void showTokenAndPostfixExpression(char aToken, char[] aPostfixExpressionArray) {
		AppView.outputDebugMessage(aToken + " : (Postfix 수식으로 출력) ");
		AppView.outputLineDebugMessage(new String(aPostfixExpressionArray));
	}
	
	private void showTokenAndMessage(char aToken, String aMessage) {
		AppView.outputLineDebugMessage(aToken + " : (" + aMessage +") ");
	}
	
	private int inComingPrecedence(Character aToken) {
		switch(aToken.charValue()) {
		case '(' : return 20;
		case ')' : return 19;
		case '^' : return 17;
		case '*' : return 13;
		case '/' : return 13;
		case '%' : return 13;
		case '+' : return 12;
		case '-' : return 12;
		default:
			return -1; //알수없는 연산자
		}
	}
	
	private int inStackPrecedence(Character aToken) {
		switch(aToken.charValue()) {
		case '(' : return 0;
		case ')' : return 19;
		case '^' : return 16;
		case '*' : return 13;
		case '/' : return 13;
		case '%' : return 13;
		case '+' : return 12;
		case '-' : return 12;
		default:
			return -1; //알수없는 연산자
		}
	}
	
	private CalculatorError infixToPostfix() {
		char[] postfixExpressionArray = new char[this.infixExpression().length()];
		Arrays.fill(postfixExpressionArray, ' '); //모든 칸을 공백 문자로 채운다.
		
		Character currentToken, poppedToken, topToken;
		this.operatorStack().clear(); //연산자 스택 초기화
		int p=0; //postfix 수식에 token을 출력할 위치
		for(int i=0; i < this.infixExpression().length(); i++) {
			currentToken = this.infixExpression().charAt(i);
			if(Character.isDigit(currentToken.charValue())) {
				//currentToken 이 operand (숫자 값) 이다.
				//postfix 수식으로 출력한다.
				postfixExpressionArray[p++] = currentToken;
				this.showTokenAndPostfixExpression(currentToken, postfixExpressionArray);
			}
			else { //currentToken 이 operator이다.
				if(currentToken == ')') { //currentToken이 오른쪽 괄호이다.
					this.showTokenAndMessage(currentToken, "왼쪽 괄호가 나타날 때까지 스택에서 꺼내어 출력");
					poppedToken = this.operatorStack().pop();
					while(poppedToken != null && poppedToken.charValue() != '(') {
						postfixExpressionArray[p++] = poppedToken.charValue();
						this.showOperatorStack("Popped");
						this.showTokenAndPostfixExpression(poppedToken, postfixExpressionArray);
						poppedToken = this.operatorStack().pop();
					}
					if(poppedToken == null) {
						return CalculatorError.InfixError_MissingLeftParen;
					}
					this.showOperatorStack("Popped");
				}
				else {	//currentToken이 일반 연산자이다.
					int inComingPrecedence = this.inComingPrecedence(currentToken.charValue());
					if(inComingPrecedence < 0) {
						//알수없는 연산자.
						AppView.outputLineDebugMessage(currentToken + " : (Unknown Operator)");
						return CalculatorError.InfixError_UnknownOperator;
					}
					this.showTokenAndMessage(currentToken, "입력 연산자보다 순위가 높지 않은 연산자를 스택에서 꺼내어 출력");
					topToken = this.operatorStack().peek();
					while(topToken != null && this.inStackPrecedence(topToken) >= inComingPrecedence) {
						poppedToken = this.operatorStack().pop();
						postfixExpressionArray[p++] = poppedToken;
						this.showOperatorStack("Popped");
						this.showTokenAndPostfixExpression(poppedToken, postfixExpressionArray);
						topToken = this.operatorStack().peek();
					}
					if(this.operatorStack().isFull()) {
						this.showOperatorStack("Fulled");
						return CalculatorError.InfixError_TooLongExpression;
					}
					this.operatorStack().push(currentToken);
					this.showOperatorStack("Pushed");
				}
			}
		}//end of for
			AppView.outputLineDebugMessage("(End of infix expression: 스택에서 모든 연산자를 꺼내어 출력)");
			
			while(!this.operatorStack().isEmpty()) {
				poppedToken = this.operatorStack().pop();
				this.showOperatorStack("Popped");
				if(poppedToken == '(') {
					return CalculatorError.InfixError_MissingRightParen;
				}
				postfixExpressionArray[p++] = poppedToken;
				this.showTokenAndPostfixExpression(poppedToken, postfixExpressionArray);
			}
			
			this.setPostfixExpression(new String(postfixExpressionArray).trim());
			return CalculatorError.InfixError_None;
	}
	
	public int evaluate(String anInfixExpression) throws CalculatorException{
		this.setInfixExpression(anInfixExpression);
		AppView.outputLineDebugMessage("[Infix to Postfix] " + anInfixExpression);
		if(this.infixExpression() == null || this.infixExpression().length() == 0) {
			throw new CalculatorException(CalculatorError.InfixError_NoExpression);
		}
		
		CalculatorError infixError = this.infixToPostfix();
		if(infixError == CalculatorError.InfixError_None) {
			AppView.outputLine("");
			AppView.outputLineDebugMessage("[Evaluate Postfix] " + this.postfixExpression());
			return this.postfixCalculator().evaluate(this.postfixExpression());
		}
		else {
			throw new CalculatorException(infixError);
		}
	}
	
}
