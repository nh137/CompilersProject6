package Translate.Absyn;

public class AssignStmt extends Stmt{
	public AssignableExpr lhs; public Expr rhs;
	public AssignStmt(AssignableExpr e1, Expr e2){
		lhs = e1;
		rhs = e2;
	
	}
	
	public String toString()
	  {   return "";   }
	public Translate.Translate.Exp accept(Translate.Translator.Translator  v) { return v.visit(this); }
	 public void accept(Translate.Visit.Visitor v)      {          v.visit(this);   }
	//public Translate.Types.Type accept(Translate.Visit.Visitor2 v) { return v.visit(this); }
	 
}

