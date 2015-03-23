package Translate.Tree;

public class MEM extends Exp{
	Exp exp;
	public MEM(Exp e){
		exp = e;
	}
	@Override
	public void accept(IntVisitor v, int d) {
		// TODO Auto-generated method stub
		v.visit(this, d);
	}

}
