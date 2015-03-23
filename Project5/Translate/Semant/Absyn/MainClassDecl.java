package Semant.Absyn;

public class MainClassDecl extends Absyn{
	public java.lang.String name;
	public java.lang.String parent;
	public java.util.LinkedList<VarDecl> fields;
	public java.util.LinkedList<Stmt> stmts;

	public MainClassDecl(java.lang.String name, java.lang.String parent, java.util.LinkedList<VarDecl> fields, java.util.LinkedList<Stmt> stmts) { 
			this.name = name;
			this.parent = parent;
			this.fields = fields;
			this.stmts = stmts;
			
			
		}

	public String toString()
	{
		return "";
	}
	
	public void accept(Semant.Visit.Visitor v){         v.visit(this);   }
	public Semant.Types.Type accept(Semant.Visit.Visitor2 v) { return v.visit(this); }
}
