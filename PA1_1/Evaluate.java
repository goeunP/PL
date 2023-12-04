
public class Evaluate{
	public String evaluate(ExprNode node) {
		if(node!=null) {
			if(node.getOperator().equals("ASSIGN")) {
				return "0.0"+'\n';
			}
			else {
				String finalValue=String.format("%.1f", Double.parseDouble(node.getValue()));
				return finalValue+'\n';
			}
		}
		return "";
	}
}
