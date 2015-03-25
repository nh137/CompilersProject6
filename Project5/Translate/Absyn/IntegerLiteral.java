package Translate.Absyn;

public class IntegerLiteral extends Expr{
	public int value;
	public IntegerLiteral( int value){
		this.value = value;
	}
	public IntegerLiteral( Integer value){
		this.value = value;
	}
	
	public String toString()
	  {   return "";   }
	public Translate.Tree.Exp accept(Translate.Translate v) { return v.visit(this); }
	public void accept(Semant.Visit.Visitor v)      {          v.visit(this);   }
	public Semant.Types.Type accept(Semant.Visit.Visitor2 v) { return v.visit(this); }
}
