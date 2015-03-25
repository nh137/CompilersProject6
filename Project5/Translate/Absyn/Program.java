package Translate.Absyn;

import java.util.AbstractList;

public class Program extends Absyn{
	public AbstractList<ClassDecl> classes;
	public java.util.LinkedList<Semant.Types.CLASS> ctl;
	
	public Program(AbstractList<ClassDecl> a2,java.util.LinkedList<Semant.Types.CLASS>classtypes){

		classes = a2;
		ctl = classtypes;
	}
	
	public String toString(){
		if(classes != null){
			return classes.toString();
		}else{
			return null;
		}
	}
	public Translate.Tree.Exp accept(Translate.Translate v) { return v.visit(this); }
	public void accept(Semant.Visit.Visitor v){v.visit(this);}
	public Semant.Types.Type accept(Semant.Visit.Visitor2 v) { return v.visit(this); }
}
