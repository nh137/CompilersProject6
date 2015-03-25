package Translate.Absyn;

public class AddExpr extends BinOpExpr {

	public AddExpr(Expr e1, Expr e2){
		super(e1, e2);
		
		
	}
	
	 public String toString()
	  {   return this.e1 + " + " + this.e2;   }
	
	 public void accept(Semant.Visit.Visitor v)      {          v.visit(this);   }
	 public Translate.Tree.Exp accept(Translate.Translate v) { return v.visit(this); }
	 public Semant.Types.Type accept(Semant.Visit.Visitor2 v) { return v.visit(this); }
}
