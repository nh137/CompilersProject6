package Semant.Absyn;

public class NewArrayExpr extends Expr{
	public Type type;
	public java.util.LinkedList<Expr> dimensions;
	
	public NewArrayExpr(Type type, java.util.LinkedList<Expr> dimensions){
		this.type = type;
		this.dimensions = dimensions;
	}
	
	public String toString()
	  {   return "";   }
	
	public void accept(Semant.Visit.Visitor v)      {          v.visit(this);   }
	
	public Semant.Types.Type accept(Semant.Visit.Visitor2 v) { return v.visit(this); }
}
