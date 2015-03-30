package Translate.Tree;

public class EXP extends Stm{

	Exp exp;
	public EXP(Exp e){
		exp = e;
	}
	@Override
	public void accept(IntVisitor v) {
		// TODO Auto-generated method stub
		v.visit(this);
	}
}
