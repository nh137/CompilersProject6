package Translate.Absyn;

public class ArrayType extends Type{
	public Type base;
	public ArrayType(Type e1){
		this.base = e1;
	
	}
	
	public String toString()
	  {   return "";   }
	public Translate.Tree.Exp accept(Translate.Translate v) { return v.visit(this); }
	 public void accept(Semant.Visit.Visitor v)      {          v.visit(this);   }
	 public Semant.Types.Type accept(Semant.Visit.Visitor2 v) { return v.visit(this); }
}
