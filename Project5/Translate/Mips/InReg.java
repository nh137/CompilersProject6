package Translate.Mips;
import Translate.Frame.*;
import Translate.Temp.*;
import Translate.Tree.Exp;
public class InReg extends Access{
	Temp temp;
	
	public InReg(Temp t){
	 temp = t;
	}
	
	@Override
	public Exp exp(Exp framePtr) {
		// TODO Auto-generated method stub
		return null;
	}

}