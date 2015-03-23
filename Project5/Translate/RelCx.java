package Translate.Translate;

import Translate.Temp.Label;

public class RelCx extends Cx{
	private Exp le;
	private int operator;
	private Exp re;
	
	public RelCx(int op, Exp l, Exp r){
		operator = op;
		le = l;
		re = r;
	}
	@Override
	Stm unCx(Label t, Label f) {
		// TODO Auto-generated method stub
		return null;
	}

}
