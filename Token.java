
public class Token {

	public enum Type { OPERATOR, OPERAND, PAREN };
	public Type type;

	private String operator;
	private float operand;

	private int precedence;

	public Token(float op) {

		this.type = Type.OPERAND;
		operand = op;
	}

	public Token(int op) {

		this.type = Type.OPERAND;
		operand = op;
	}

	public Token(String op) {

		String[] operatorList = {"^", "*", "/", "+", "-"};
		int[] operatorPrecedenceList = {2, 1, 1, 0, 0};
		String[] parenthesesList = {"(", ")"};
		final int PARENTHESESPRECEDENCE = 3;

		for (int i=0; i < operatorList.length; i++){

			if (op.equals(operatorList[i])){
				operator = op;
				this.type = Type.OPERATOR;
				precedence = operatorPrecedenceList[i];
				break;
			}
		}

		for (int i=0; i < parenthesesList.length; i++){
			
			if(op.equals(parenthesesList[i])){
				operator = op;
				this.type = Type.PAREN;
				precedence = PARENTHESESPRECEDENCE;
				break;
			}
		}
	}

	public Token(Token other) {
		this.operand = other.operand;
		this.operator = other.operator;
		this.precedence = other.precedence;
		this.type = other.type;
	}

	public String getOperator() {
		return operator;
	}
	public float getOperand() {
		return operand;
	}
	public int getPrecedence() {
		return precedence;
	}

	@Override
	public boolean equals(Object obj) {

		if(obj instanceof Token){
			Token objCast = (Token)obj;
			if (objCast.hashCode() == this.hashCode()){
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		if (this.type == Type.OPERAND){
			return (int) operand;
		}
		else if (this.type == Type.OPERATOR || this.type == Type.PAREN){
			return operator.hashCode();
		}

		else{
			return 0;
		}
	}

	public String toString() {
		if (this.type.equals(Type.OPERATOR)){
			return this.operator;
		}
		else if (this.type.equals(Type.OPERAND)){
			return String.valueOf(this.operand);
		}
		return null;
	}
}
