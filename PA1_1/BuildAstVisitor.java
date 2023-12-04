import java.util.HashMap;
import java.util.Map;

public class BuildAstVisitor extends ExprBaseVisitor<ExprNode> {
	public boolean isDouble(String s) {
	    try {
	        Double.parseDouble(s);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	  }

	@Override
	public ExprNode visitProg(ExprParser.ProgContext ctx) {
		Map <String, Double> variableList=new HashMap<>();
		final ExprTree exprTree = new ExprTree(null, null,null, null, null, variableList);
		for (int i=0; i<ctx.getChildCount(); i++) {
			exprTree.children.add(visit(ctx.getChild(i)));
		}
		return exprTree;
	}

	@Override
	public ExprNode visitVariableExpr(ExprParser.VariableExprContext ctx) {
		String variable = ctx.getText();
		String num=ExprTree.getValueOfVariable(variable)+"";
		return new ExprNode(variable, num, null, null, null);
	}

	@Override
	public ExprNode visitInfixExpr(ExprParser.InfixExprContext ctx) {
		ExprNode leftExpr=visit(ctx.getChild(0));
		ExprNode rightExpr=visit(ctx.getChild(2));
		double leftNum;
		double rightNum;
		if(isDouble(leftExpr.getValue())==true) {
			leftNum=Double.parseDouble(leftExpr.getValue());
		}else {
			leftNum=ExprTree.getValueOfVariable(leftExpr.getValue());
		}
		if(isDouble(rightExpr.getValue())==true) {
			rightNum=Double.parseDouble(rightExpr.getValue());
		}else {
			rightNum=ExprTree.getValueOfVariable(rightExpr.getValue());
		}
		double finalValue=0;
		String operator=ctx.getChild(1).getText();
		String operatorStr = "ADD";
		if (operator.equals("+")) {
			operatorStr = "ADD";
			finalValue=leftNum+rightNum;
		}else if (operator.equals("-")) {
			operatorStr="SUB";
			finalValue=leftNum-rightNum;
		}else if (operator.equals("*")) {
			operatorStr="MUL";
			finalValue=leftNum*rightNum;
		}else if (operator.equals("/")) {
			operatorStr="DIV";
			finalValue=leftNum/rightNum;
		}
		return new ExprNode(finalValue+"",null, operatorStr, leftExpr, rightExpr);
	}

	@Override
	public ExprNode visitNumberExpr(ExprParser.NumberExprContext ctx) {
		String num=ctx.getChild(0).getText();
		return new ExprNode(num, null, null, null, null);
	}

	@Override
	public ExprNode visitParensExpr(ExprParser.ParensExprContext ctx) {
		if (ctx.expr().getChildCount()==3) {
			ExprNode leftExpr=visit(ctx.expr().getChild(0));
			ExprNode rightExpr=visit(ctx.expr().getChild(2));
			double leftNum;
			double rightNum;
			if(isDouble(leftExpr.getValue())==true) {
				leftNum=Double.parseDouble(leftExpr.getValue());
			}else {
				leftNum=ExprTree.getValueOfVariable(leftExpr.getValue());
			}
			if(isDouble(rightExpr.getValue())==true) {
				rightNum=Double.parseDouble(rightExpr.getValue());
			}else {
				rightNum=ExprTree.getValueOfVariable(rightExpr.getValue());
			}
			double finalValue=0;
			String operator=ctx.expr().getChild(1).getText();
			String operatorStr = "ADD";
			if (operator.equals("+")) {
				operatorStr = "ADD";
				finalValue=leftNum+rightNum;
			}else if (operator.equals("-")) {
				operatorStr="SUB";
				finalValue=leftNum-rightNum;
			}else if (operator.equals("*")) {
				operatorStr="MUL";
				finalValue=leftNum*rightNum;
			}else if (operator.equals("/")) {
				operatorStr="DIV";
				finalValue=leftNum/rightNum;
			}
	;		return new ExprNode(finalValue+"",null, operatorStr, leftExpr, rightExpr);
		}
		else {
			String num=ctx.expr().getChild(0).getText();
			return new ExprNode(num, null, null, null, null);
		}
		
	}

	@Override
	public ExprNode visitAssignExpr(ExprParser.AssignExprContext ctx) {
		String assignVar=ctx.getChild(0).getText();
		ExprNode leftNode=new ExprNode(assignVar, null, null, null, null);
		String assignNum=ctx.getChild(2).getText();
		ExprNode rightNode=new ExprNode(assignNum, null, null, null, null);
		ExprTree.setVariable(assignVar, Double.parseDouble(assignNum));
		return new ExprNode("ASSIGN",null, "ASSIGN", leftNode, rightNode);
	}

	@Override
	public ExprNode visitNum(ExprParser.NumContext ctx) {
		String num=ctx.getChild(0).getText();
		return new ExprNode(num,null, null, null, null);
	}

}