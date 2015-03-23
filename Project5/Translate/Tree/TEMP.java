package Translate.Tree;

public class TEMP extends Exp{

	Translate.Temp.Temp temp;
	public TEMP(Translate.Temp.Temp t){
		temp = t;
	}
	@Override
	public void accept(IntVisitor v, int d) {
		// TODO Auto-generated method stub
		v.visit(this, d);
	}
}
