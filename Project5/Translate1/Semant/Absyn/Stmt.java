package Semant.Absyn;

public class Stmt extends Absyn{

	public Stmt(){
		
	}
	
	public String toString()
	  {   return "";   }
	
	public void accept(Semant.Visit.Visitor v)      {          v.visit(this);   }
	public Semant.Types.Type accept(Semant.Visit.Visitor2 v) { return v.visit(this); }
}
