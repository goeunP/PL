
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ExprTree extends ExprNode{
	public ArrayList <ExprNode> children ;
	public static Map <String, Double> variableList;
	public ExprTree(String value, String operator, ExprNode leftNode, ExprNode rightNode, ArrayList<ExprNode> children, Map<String, Double> variableList) {
		super(value, null, null, leftNode, rightNode);
		this.children = new ArrayList<ExprNode>();
		ExprTree.variableList=new HashMap<>();
	}

	public ArrayList<ExprNode> getChildren() {
		return children;
	}

	public void setChildren(ArrayList<ExprNode> children) {
		this.children = children;
	}

	public Map<String, Double> getVariableList() {
		return variableList;
	}

	public static void setVariableList(Map<String, Double> variableList) {
		ExprTree.variableList = variableList;
	}

	public static double getValueOfVariable(String variable) {
		double value=variableList.get(variable);
		return value;
	}

	public static void setVariable(String variable, Double value) {
		variableList.put(variable, value);
	}

}