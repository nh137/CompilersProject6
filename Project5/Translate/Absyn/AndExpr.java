package Translate.Absyn;

public class AndExpr extends BinOpExpr{

	public AndExpr(Expr e1, Expr e2){
		super(e1, e2);
	}
	
	 public String toString()
	  {   return this.e1 + " && " + this.e2;   }
	public Translate.Tree.Exp accept(Translate.Translate v) { return v.visit(this); }
	 public void accept(Semant.Visit.Visitor v)      {          v.visit(this);   }
	 public Semant.Types.Type accept(Semant.Visit.Visitor2 v) { return v.visit(this); }
}
