package Semant.Types;

import java.util.Iterator;

//import Semant.Visitor;

public class RECORD extends Type implements java.lang.Iterable<FIELD>{
	
	public java.util.LinkedList<FIELD> fields;
	public int counter;

	public RECORD(){
		this.fields = new java.util.LinkedList<FIELD>();
		counter = 0;
	}
	
	public FIELD get(Semant.Symbol.Symbol name){
		for (int i = 0; i < fields.size(); i++)
		{
			FIELD f = fields.get(i);
			if (f.name == name)
				return f;
		}
		return null;
	}
	
	public Iterator<FIELD> iterator(){
		
		return fields.descendingIterator();
		
	}
	
	public FIELD put(Type type, Semant.Symbol.Symbol name){
		//tb.put(name,type);
		FIELD field = new FIELD(type,counter++,name);
		this.fields.add(field);
		return field;
	}

	@Override
	public void accept(Semant.Visit.Visitor v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean coerceTo(Type t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
