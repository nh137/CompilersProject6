package Translate.Mips;
import Translate.Frame.*;
import Translate.Temp.*;
import Translate.Tree.Exp;
public class InFrame extends Access{
	public int offset;
	
	public InFrame(int o){
		offset = o;
	}
	@Override
	public Exp exp(Exp framePtr) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
