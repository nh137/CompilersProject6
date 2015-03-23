package Translate.Tree;

public class CONST extends Exp{
	int value;
	public CONST(int v){
		value = v;
	}
	
	@Override
	public void accept(IntVisitor v, int d) {
		// TODO Auto-generated method stub
		v.visit(this, d);
	}
}
