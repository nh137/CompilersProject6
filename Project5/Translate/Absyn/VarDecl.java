package Translate.Absyn;

public class VarDecl extends Absyn{
	public Type type;
	public String name;
	public Expr init;

	public VarDecl(Type type, java.lang.String name, Expr init){
		this.type = type;
		this.name = name;
		this.init = init;
	}
	
	public String toString()
	  {   return "";   }
	public Translate.Tree.Exp accept(Translate.Translate v) { return v.visit(this); }
	 public void accept(Semant.Visit.Visitor v)      {          v.visit(this);   }
	 public Semant.Types.Type accept(Semant.Visit.Visitor2 v) { return v.visit(this); }
}
