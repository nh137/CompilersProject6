package Translate.Absyn;

public class AssignableExpr extends Expr{
	
	public AssignableExpr(){
		
	
	}
	
	public String toString()
	  {   return "";   }
	
	 public void accept(Semant.Visit.Visitor v)      {          v.visit(this);   }
	 public Translate.Tree.Exp accept(Translate.Translate v) { return v.visit(this); }
	public Semant.Types.Type accept(Semant.Visit.Visitor2 v) { return v.visit(this); }
	 
}
