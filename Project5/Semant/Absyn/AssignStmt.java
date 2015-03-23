package Semant.Absyn;

public class AssignStmt extends Stmt{
	public AssignableExpr lhs; public Expr rhs;
	public AssignStmt(AssignableExpr e1, Expr e2){
		lhs = e1;
		rhs = e2;
	
	}
	
	public String toString()
	  {   return "";   }
	
	 public void accept(Semant.Visit.Visitor v)      {          v.visit(this);   }
	public Semant.Types.Type accept(Semant.Visit.Visitor2 v) { return v.visit(this); }
	 
}

