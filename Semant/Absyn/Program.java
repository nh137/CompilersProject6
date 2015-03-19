package Semant.Absyn;

import java.util.AbstractList;

public class Program extends Absyn{
	public AbstractList<ClassDecl> classes;
	
	public Program(AbstractList<ClassDecl> a2){

		classes = a2;
	}
	
	public String toString(){
		if(classes != null){
			return classes.toString();
		}else{
			return null;
		}
	}
	
	public void accept(Semant.Visit.Visitor v){v.visit(this);}
	public Semant.Types.Type accept(Semant.Visit.Visitor2 v) { return v.visit(this); }
}
