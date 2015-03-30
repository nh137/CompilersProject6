package Translate.Absyn;

public abstract class Absyn implements Translate.Visit.Visitable{

	public abstract String toString();
	
	public void accept(Translate.Visit.Visitor v){v.visit(this);}
	

	//public Translate.Types.Type accept(Translate.Visit.Visitor2 v) { return v.visit(this); }
	
	public Translate.Translate.Exp accept(Translate.Translator.Translator  v) { return v.visit(this); }
}
