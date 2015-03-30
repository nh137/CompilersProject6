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
	public  Exp le;
	public  int operator;
	public  Exp re;
	
	public RelCx(int op, Exp l, Exp r){
		operator = op;
		le = l;
		re = r;
	}
	@Override
	public Stm unCx(Label t, Label f) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Translate.Tree.Exp unEx() {
		return null;
	}
	
	public Translate.Tree.Stm unNx(){
		return null;
	}

}
