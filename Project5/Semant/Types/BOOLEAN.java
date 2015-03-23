package Semant.Types;

//import Semant.Types.Visitor;

public class BOOLEAN extends Type {
	public BOOLEAN(){
		;
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
		if( t.getClass().getName() == this.getClass().getName() ){
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
