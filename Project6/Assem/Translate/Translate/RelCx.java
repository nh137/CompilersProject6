package Assem.Translate.Translate;

import Assem.Translate.Temp.Label;
import Assem.Translate.Temp.Temp;
import Assem.Translate.Tree.CONST;
import Assem.Translate.Tree.ESEQ;
import Assem.Translate.Tree.LABEL;
import Assem.Translate.Tree.MOVE;
import Assem.Translate.Tree.SEQ;
import Assem.Translate.Tree.Stm;
import Assem.Translate.Tree.TEMP;import Translate.Tree.CJUMP;

public class RelCx extends Cx{
	public  Assem.Translate.Tree.Exp le;
	public  int operator;
	public  Assem.Translate.Tree.Exp re;
	
	public RelCx(int op, Assem.Translate.Tree.Exp l, Assem.Translate.Tree.Exp r){
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
