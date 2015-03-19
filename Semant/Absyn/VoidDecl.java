package Semant.Absyn;

public class VoidDecl extends MethodDecl{
	
	//TODO: Another Constructor problem
	public VoidDecl(java.lang.String name, java.util.LinkedList<VarDecl> locals, java.util.LinkedList<Stmt> stmts){
		super(null, false, name,null,  locals, stmts, null);
	}
	
	public String toString()
	  {   return "";   }
	
	 public void accept(Semant.Visit.Visitor v)      {          v.visit(this);   }
	 public Semant.Types.Type accept(Semant.Visit.Visitor2 v) { return v.visit(this); }
}
