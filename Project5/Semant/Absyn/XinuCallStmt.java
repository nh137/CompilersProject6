package Semant.Absyn;

public class XinuCallStmt extends Stmt{
	
	
	public String method;
	public java.util.LinkedList<Expr> args;
	public XinuCallStmt(java.lang.String method, java.util.LinkedList<Expr> args){
		this.method = method;
		this.args = args;
	}
	
	public String toString()
	  {   return "";   }
	
	 public void accept(Semant.Visit.Visitor v)      {          v.visit(this);   }
	 public Semant.Types.Type accept(Semant.Visit.Visitor2 v) { return v.visit(this); }
}
