class ExprNode {
	public String value;
	public String valueOfVar;
	public ExprNode leftNode;
	public ExprNode rightNode;
	public String operator;
	public ExprNode(String value, String valueOfVar, String operator, ExprNode leftNode, ExprNode rightNode) {
		super();
		this.value=value;
		this.operator=operator;
		this.leftNode = leftNode;
		this.rightNode = rightNode;
		this.valueOfVar=valueOfVar;
	}
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public String getOperator() {
		return operator;
	}

	public void setOperator(String value) {
		this.value = value;
	}

	public ExprNode getLeftNode() {
		return leftNode;
	}
	public void setLeftNode(ExprNode leftNode) {
		this.leftNode = leftNode;
	}
	public ExprNode getRightNode() {
		return rightNode;
	}
	public void setRightNode(ExprNode rightNode) {
		this.rightNode = rightNode;
	}
	public String getValueOfVar() {
		return valueOfVar;
	}
	public void setValueOfVar(String valueOfVar) {
		this.valueOfVar = valueOfVar;
	}

}


