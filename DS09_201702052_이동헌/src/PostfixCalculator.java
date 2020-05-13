
public class PostfixCalculator {

	//비공개 상수
	private static final int DEFAULT_MAX_EXPRESSION_LENGTH = 10;
	
	//비공개 인스턴스 변수
	private int _maxExpressionLength;
	private Stack<Integer> _valueStack;
	
	//Getter/Setter
	public int maxExpressionLength() {
		return this._maxExpressionLength;
	}
	private void setMaxExpressionLength(int newMaxExpressionLength) {
		this._maxExpressionLength = newMaxExpressionLength;
	}
	
	private Stack<Integer> valueStack(){
		return this._valueStack;
	}
	private void setValueStack(Stack<Integer> newValueStack) {
		this._valueStack = newValueStack;
	}
	
	//생성자
	public PostfixCalculator() {
		this.setMaxExpressionLength(PostfixCalculator.DEFAULT_MAX_EXPRESSION_LENGTH);
	}
	public PostfixCalculator(int givenMaxExpressionLength) {
		this.setMaxExpressionLength(givenMaxExpressionLength);
		this.setValueStack(new ArrayList<Integer>(this.maxExpressionLength()));
	}
	
	public int evaluate(String aPostfixExpression) throws CalculatorException{
		if(aPostfixExpression == null || aPostfixExpression.length() == 0) {
			throw new CalculatorException(CalculatorError.PostfixError_NoExpression);
		}
		this.valueStack().clear();
		char token;
		for(int current=0; current < aPostfixExpression.length(); current++) {
			token = aPostfixExpression.charAt(current);
			if(Character.isDigit(token)) {
				int tokenValue = Character.getNumericValue(token);
				if(this.valueStack().isFull()) {
					//[오류] 수식이 너무 길어 처리가 불가능합니다.
					throw new CalculatorException(CalculatorError.PostfixError_TooLongExpression);
				}
				else {
					this.valueStack().push(Integer.valueOf(tokenValue));
				}
			}
			else {		//연산자
				CalculatorError error = this.executeBinaryOperator(token);
				if(error != CalculatorError.PostfixError_None) {
					throw new CalculatorException(error);
				}
			}
			this.showTokenAndValueStack(token);
		}	//end of for
		if(this.valueStack().size() == 1) {
			return (this.valueStack().pop().intValue());
		}
		else {
			throw new CalculatorException(CalculatorError.PostfixError_TooManyValues);
		}
	}
	
	private  CalculatorError executeBinaryOperator(char anOperator) {
		if(this.valueStack().size() < 2) {
			return CalculatorError.PostfixError_TooFewValues;
		}
		//Binary operator 만 처리 가능하다.
		int operand1 = this.valueStack().pop().intValue();
		int operand2 = this.valueStack().pop().intValue();
		int calculated = 0;
		switch(anOperator) {
		case '^':
			calculated = (int) Math.pow((double)operand2, (double)operand1);
			break;
		case '*':
			calculated = operand2 * operand1;
			break;
		case '/':
			if(operand1 ==0) {
				AppView.outputLineDebugMessage
					(anOperator + " (DivideByZero "+ operand2 + " " + anOperator + " " + operand1);
				return CalculatorError.PostfixError_DivideByZero;
			}
			else {
				calculated = operand2 / operand1;
			}
			break;
		case '%':
			if(operand1 ==0) {
				AppView.outputLineDebugMessage
					(anOperator + " (DivideByZero "+ operand2 + " " + anOperator + " " + operand1);
				return CalculatorError.PostfixError_DivideByZero;
			}
			else {
				calculated = operand2 % operand1;
			}
			break;
		case '+':
			calculated = operand2 + operand1;
			break;
		case '-':
			calculated = operand2 - operand1;
			break;
		default:
			return CalculatorError.PostfixError_UnknownOperator;
		}
		this.valueStack().push(Integer.valueOf(calculated));
		//isFull() 검사 불필요 : 2개를 pop했으므로, 스택에 한 개를 push 할 여유 있음.
		return CalculatorError.PostfixError_None;
	}
	
	private void showTokenAndValueStack(char aToken) {
		AppView.outputDebugMessage(aToken + " : ValueStack <Bottom> ");
		for(int i=0; i<this.valueStack().size(); i++) {
			AppView.outputDebugMessage( ((ArrayList<Integer>)this.valueStack()).elementAt(i).intValue() + " ");
		}
		AppView.outputLineDebugMessage("<Top>");
	}
}
