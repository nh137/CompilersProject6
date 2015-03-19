package Semant.Absyn;

public class BinOpExpr extends Expr{
	public Expr e1, e2;
	public BinOpExpr(Expr e1, Expr e2){
		this.e1 = e1;
		this.e2 = e2;
		
	}
	
	public String toString()
	  {   return "";   }
	
	 public void accept(Semant.Visit.Visitor v)      {          v.visit(this);   }
	 public Semant.Types.Type accept(Semant.Visit.Visitor2 v) { return v.visit(this); }
	 
}
