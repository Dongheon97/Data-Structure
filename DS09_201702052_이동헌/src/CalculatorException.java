
public class CalculatorException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//비공개 인스턴스 변수
	private CalculatorError _error;
	
	//Getter/Setter
	public CalculatorError error() {
		return this._error;
	}
	public void setError(CalculatorError newError) {
		this._error = newError;
	}
	
	//생성자
	public CalculatorException() {
		this.setError(CalculatorError.Undefined);
	}
	public CalculatorException(CalculatorError givenError) {
		this.setError(givenError);
	}
}
