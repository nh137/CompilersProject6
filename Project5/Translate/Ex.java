package Translate.Translate;

import Translate.Temp.Label;
import Tree.*;

public class Ex extends Exp{
	
	Tree.Exp exp;
	Ex(Tree.Exp e) {exp=e;}
	
	Tree.Exp unEx() {return exp;}
	
	Tree.Stm unNx() { 
		return new Tree.EXP(exp);
	}

	@Override
	
	Tree.Stm unCx(Label t, Label f) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
