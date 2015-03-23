package Translate.Translate;

import Translate.Temp.Label;
import Translate.Temp.Temp;
import Translate.Tree.CONST;
import Translate.Tree.ESEQ;
import Translate.Tree.LABEL;
import Translate.Tree.MOVE;
import Translate.Tree.SEQ;
import Translate.Tree.Stm;
import Translate.Tree.TEMP;

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
	@Override
	Translate.Tree.Exp unEx() {
		return null;
	}
	
	Translate.Tree.Stm unNx(){
		return null;
	}

}
