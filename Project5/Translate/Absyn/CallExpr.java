package Translate.Absyn;

public class CallExpr extends Expr{
	public Expr target;
	public java.lang.String method;
	public java.util.LinkedList<Expr> args;
	
	public CallExpr(Expr target, String method, java.util.LinkedList<Expr> args){ 
		this.target = target;
		this.method = method;
		this.args = args;
		
		
	}
	
	 public String toString()
	  {   return "";   }
	public Translate.Tree.Exp accept(Translate.Translate v) { return v.visit(this); }
	 public void accept(Semant.Visit.Visitor v)      {          v.visit(this);   }
	 public Semant.Types.Type accept(Semant.Visit.Visitor2 v) { return v.visit(this); }
}
