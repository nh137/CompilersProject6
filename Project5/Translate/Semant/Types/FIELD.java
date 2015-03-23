package Semant.Types;

//import Semant.Visitor;

public class FIELD extends Type{
	public int index;
	public Semant.Symbol.Symbol name;
	public Type type;

	public FIELD(Type t, int i, Semant.Symbol.Symbol n){
		this.index = i;
		this.name = n;
		this.type = t;
	}

	@Override
	public void accept(Semant.Visit.Visitor v) {
		v.visit(this);
	}
	
	public Semant.Types.Type accept(Semant.Visit.Visitor2 v) { return v.visit(this); }

	@Override
	public
	boolean coerceTo(Type t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
