package Translate.Absyn;

public class ClassDecl extends Absyn{
	public java.lang.String name;
	public java.lang.String parent;
	public java.util.LinkedList<VarDecl> fields;
	public java.util.LinkedList<MethodDecl> methods;
	public ClassDecl(java.lang.String name, java.lang.String parent, java.util.LinkedList<VarDecl> fields, java.util.LinkedList<MethodDecl> methods) { 
		this.name = name;
		this.parent = parent;
		this.fields = fields;
		this.methods = methods;
		
		
	}
	
	public String toString()
	  {   return "";   }
	public Translate.Tree.Exp accept(Translate.Translate v) { return v.visit(this); }
	 public void accept(Semant.Visit.Visitor v)      {          v.visit(this);   }
	 public Semant.Types.Type accept(Semant.Visit.Visitor2 v) { return v.visit(this); }
}
