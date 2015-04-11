package Translate.Translate;

import Translate.Temp.Label;
import Translate.Temp.Temp;
import Translate.Tree.CONST;
import Translate.Tree.ESEQ;
import Translate.Tree.LABEL;
import Translate.Tree.MOVE;
import Translate.Tree.SEQ;
import Translate.Tree.Stm;
import Translate.Tree.TEMP;import Translate.Tree.CJUMP;

public class RelCx extends Cx{
	public  Translate.Tree.Exp le;
	public  int operator;
	public  Translate.Tree.Exp re;
	
	public RelCx(int op, Translate.Tree.Exp l, Translate.Tree.Exp r){
		operator = op;
		le = l;
		re = r;
	}
	@Override
	public Stm unCx(Label t, Label f) {
		// TODO Auto-generated method stub
		return new CJUMP(operator, le , re, t, f);
	}
	
	@Override
	public Stm unNx() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
