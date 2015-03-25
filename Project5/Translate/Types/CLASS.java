package Translate.Types;

//import Semant.Visitor;

public class CLASS extends Type{
	
	public RECORD fields;
	public OBJECT instance;
	public RECORD methods;
	public Semant.Symbol.Symbol name;
	public CLASS parent;
	
	public CLASS(Semant.Symbol.Symbol s){
		this.name = s;
		
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
