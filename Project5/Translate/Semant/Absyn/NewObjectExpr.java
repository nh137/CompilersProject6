package Semant.Absyn;

public class NewObjectExpr extends Expr{
	public Type type;
	public NewObjectExpr(Type t){
		this.type = t;
		
	}
	
	public String toString()
	  {   return "";   }
	
	public void accept(Semant.Visit.Visitor v)      {          v.visit(this);   }
	public Semant.Types.Type accept(Semant.Visit.Visitor2 v) { return v.visit(this); }
}
