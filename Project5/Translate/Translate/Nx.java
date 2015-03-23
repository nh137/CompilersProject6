package Translate.Translate;

import Translate.Temp.Label;
import Translate.Tree.*;

public class Nx extends Exp{
	
	Stm stm;
	Nx(Stm s) {stm=s;}
	
	Translate.Tree.Exp unEx() { 
		return null;
	}
	Stm unNx() {return stm;}

	@Override
	Stm unCx(Label t, Label f) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
