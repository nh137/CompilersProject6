package Translate.Absyn;

public class WhileStmt extends Stmt{
	public Expr test;
	public Stmt body;
	
	public WhileStmt(Expr test, Stmt body){
		this.test = test;
		this.body = body;
		
	}
	
	public String toString()
	  {   return "";   }
	public Translate.Tree.Exp accept(Translate.Translate v) { return v.visit(this); }
	 public void accept(Semant.Visit.Visitor v)      {          v.visit(this);   }
	 public Semant.Types.Type accept(Semant.Visit.Visitor2 v) { return v.visit(this); }
}
