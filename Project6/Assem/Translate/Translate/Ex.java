package Assem.Translate.Translate;

import Assem.Translate.Temp.Label;
import Assem.Translate.Tree.Stm;
import Assem.Translate.Tree.*;

public class Ex extends Exp{
	
	public Assem.Translate.Tree.Exp exp;
	public Ex(Assem.Translate.Tree.Exp e) {exp=e;}
	
	public Assem.Translate.Tree.Exp unEx() {return exp;}
	
	public Stm unNx() { 
		return new EXP(exp);
	}

	@Override
	
	public Stm unCx(Label t, Label f) {
		// TODO Auto-generated method stub
		// determine whether 0 or not
//		if (exp instanceof BINOP)
//		{
//		//TODO evaluate the binop here?
//		//	if ((exp.binop == 4 && (exp.left && exp.right)|| (exp.binop == 5)
//			return new JUMP(t);
//		}else
//			return new JUMP(f);
		
		if(exp instanceof CONST){
			CONST con = (CONST)exp;
			if(con.value == 0){
				return new JUMP(f);
			}else{
				return new JUMP(t);
			}
		}else{
			return new CJUMP(1,exp, new CONST(0), t,f);
		}
		
		
	}
	
}
