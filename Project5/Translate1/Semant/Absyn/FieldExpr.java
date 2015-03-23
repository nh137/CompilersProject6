package Semant.Absyn;

public class FieldExpr extends AssignableExpr{
	public Expr target;
	public java.lang.String field;
	public FieldExpr(Expr target, java.lang.String field){
		this.target = target;
		this.field = field;
	}
	
	public String toString()
	  {   return "";   }
	
	public void accept(Semant.Visit.Visitor v)      {          v.visit(this);   }
	public Semant.Types.Type accept(Semant.Visit.Visitor2 v) { return v.visit(this); }
}
