package Semant.Types;

//import Semant.Types.Visitable;
//import Semant.Types.Visitor;

public class ARRAY extends Type  {
	public Type element;
	
	public ARRAY(Type e){
		this.element = e;
	}

	@Override
	public void accept(Semant.Visit.Visitor v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public
	boolean coerceTo(Type t) {
		if( t.getClass().getName() == element.getClass().getName() ){
			return true;
		}
		return false;

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
	//public abstract void accept(Visitor v);
}
