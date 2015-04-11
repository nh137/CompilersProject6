package Translate.Translate;

import Translate.Temp.Label;
import Translate.Tree.*;

public class Nx extends Exp{
	
	public Stm stm;
	public Nx(Stm s) {stm=s;}
	
	public Translate.Tree.Exp unEx() { 
		return null;
	}
	public Stm unNx() {return stm;}

	@Override
	public Stm unCx(Label t, Label f) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
