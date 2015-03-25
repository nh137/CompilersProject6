package Translate.Absyn;

public class XinuCallExpr extends Expr{
	public String method;
	public java.util.LinkedList<Expr> args;
	public XinuCallExpr(java.lang.String method, java.util.LinkedList<Expr> args){
		this.method = method;
		this.args = args;
	}
	
	public String toString()
	  {   return "";   }
	public Translate.Tree.Exp accept(Translate.Translate v) { return v.visit(this); }
	 public void accept(Semant.Visit.Visitor v)      {          v.visit(this);   }
	 public Semant.Types.Type accept(Semant.Visit.Visitor2 v) { return v.visit(this); }
	
}
