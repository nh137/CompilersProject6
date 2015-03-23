package Semant.Absyn;

public class StringLiteral extends Expr{

	public String value;
	public StringLiteral(String value){
		this.value= value;
	}
	
	public String toString()
	  {   return "";   }
	
	public void accept(Semant.Visit.Visitor v)      {          v.visit(this);   }
	public Semant.Types.Type accept(Semant.Visit.Visitor2 v) { return v.visit(this); }
}
