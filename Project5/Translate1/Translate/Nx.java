package Translate.Translate;

import Translate.Temp.Label;
import Tree.*;

public class Nx extends Exp{
	
	Tree.Stm stm;
	Nx(Tree.Stm s) {stm=s;}
	
	Tree.Exp unEx() { 
		;
	}
	Tree.Stm unNx() {return stm;}

	@Override
	Stm unCx(Label t, Label f) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
