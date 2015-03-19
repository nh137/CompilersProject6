package Semant.Absyn;

public class IdentifierType extends Type{

	public String id;
	public IdentifierType(String id){
		this.id = id;
	}
	
	public String toString()
	  {   return "";   }
	
	public void accept(Semant.Visit.Visitor v)      {          v.visit(this);   }
	public Semant.Types.Type accept(Semant.Visit.Visitor2 v) { return v.visit(this); }
}
