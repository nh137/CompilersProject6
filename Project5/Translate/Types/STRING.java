package Translate.Types;

//import Semant.Visitor;

public class STRING extends Type{
	
	public STRING(){
		;
	}

	@Override
	public void accept(Semant.Visit.Visitor v) {
		v.visit(this);
		
	}

	@Override
	public boolean coerceTo(Type t) {
		// TODO Auto-generated method stub
		if( t.getClass().getName() == this.getClass().getName() ){
			return true;
		}
		return false;
	}
	
	public Semant.Types.Type accept(Semant.Visit.Visitor2 v) { return v.visit(this); }

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
