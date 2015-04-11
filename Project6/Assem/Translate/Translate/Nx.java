package Assem.Translate.Translate;

import Assem.Translate.Temp.Label;
import Assem.Translate.Tree.*;

public class Nx extends Exp{
	
	public Stm stm;
	public Nx(Stm s) {stm=s;}
	
	public Assem.Translate.Tree.Exp unEx() { 
		return null;
	}
	public Stm unNx() {return stm;}

	@Override
	public Stm unCx(Label t, Label f) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
