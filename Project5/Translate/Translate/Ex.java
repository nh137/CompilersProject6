package Translate.Translate;

import Translate.Temp.Label;
import Translate.Tree.Stm;
import Translate.Tree.*;

public class Ex extends Exp{
	
	Translate.Tree.Exp exp;
	Ex(Translate.Tree.Exp e) {exp=e;}
	
	Translate.Tree.Exp unEx() {return exp;}
	
	Stm unNx() { 
		return new EXP(exp);
	}

	@Override
	
	Stm unCx(Label t, Label f) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
