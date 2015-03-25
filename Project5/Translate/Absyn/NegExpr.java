package Translate.Absyn;

public class NegExpr extends Expr{
	public Expr e1;
	public NegExpr(Expr e1){
		this.e1 = e1;
	}
	
	public String toString()
	  {   return "";   }
	public Translate.Tree.Exp accept(Translate.Translate v) { return v.visit(this); }
	public void accept(Semant.Visit.Visitor v)      {          v.visit(this);   }
	public Semant.Types.Type accept(Semant.Visit.Visitor2 v) { return v.visit(this); }
}
