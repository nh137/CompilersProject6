package Semant.Absyn;

public class IfStmt extends Stmt{
	public Expr test1;
	public Stmt thenStmt;
	public Stmt elseStmt;
	
	public IfStmt(Expr test1, Stmt y, Stmt u){
		this.test1 = test1;
		this.thenStmt = y;
		this.elseStmt = u;
	}
	
	public String toString()
	  {   return "";   }
	
	public void accept(Semant.Visit.Visitor v)      {          v.visit(this);   }
	public Semant.Types.Type accept(Semant.Visit.Visitor2 v) { return v.visit(this); }
}
