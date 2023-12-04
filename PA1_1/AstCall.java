

public class AstCall {
	public boolean isDouble(String s) {
	    try {
	        Double.parseDouble(s);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	  }
	
	public void Call(ExprNode node, int level) {
		for (int i=0; i<level; i++) {
			System.out.printf("\t");
		}
		if (node != null) {
			if(node.getOperator()!=null) {
				if(node.getValue().equals("ASSIGN")) {
					System.out.printf(node.getValue()+'\n');
					Call(node.getLeftNode(), ++level);
					Call(node.getRightNode(), level--);
				}else {
					System.out.printf(node.getOperator()+'\n');
					Call(node.getLeftNode(), ++level);
					Call(node.getRightNode(), level--);
				}
			}else if(isDouble(node.getValue())==true) {
				System.out.println(Double.parseDouble(node.getValue()));
			}else {
				System.out.printf(node.getValue()+'\n');
			}
		}
	}		
	
}
	


