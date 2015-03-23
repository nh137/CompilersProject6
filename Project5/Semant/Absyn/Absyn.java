package Semant.Absyn;

public abstract class Absyn implements Semant.Visit.Visitable{

	public abstract String toString();
	
	public void accept(Semant.Visit.Visitor v){v.visit(this);}
	

	public Semant.Types.Type accept(Semant.Visit.Visitor2 v) { return v.visit(this); }
}
