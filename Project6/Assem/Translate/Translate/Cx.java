package Assem.Translate.Translate;

import Assem.Translate.Temp.Label;
import Assem.Translate.Temp.Temp;
import Assem.Translate.Tree.*;

public abstract class Cx extends Exp{
	
	Cx(){
		;
	}

	//@Override
	//abstract Stm unCx(Label t, Label f);
	
	@Override
	public Assem.Translate.Tree.Exp unEx() {
		Temp r = new Temp();
		Label t = new Label();
		Label f = new Label();
		return new ESEQ(
				new SEQ(new MOVE(new TEMP(r),new CONST(1)),
						new SEQ(unCx(t,f),
								new SEQ(new LABEL(f),
										new SEQ(new MOVE(new TEMP(r),
												new CONST(0)),
												new LABEL(t))))),
												new TEMP(r));
	}
	//@Override
	//Translate.Tree.Stm unNx(){
	//	return null;
	//}

}
