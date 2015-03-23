package Translate.Tree;

public class JUMP extends Stm{
	
	Exp exp;
	java.util.LinkedList<Translate.Temp.Label> targets;
	
	public JUMP(Exp e, java.util.LinkedList<Translate.Temp.Label> t){
		exp =e;
		targets = t;
	}
	
	public JUMP(Translate.Temp.Label target){
		targets = new java.util.LinkedList<Translate.Temp.Label>();
		targets.add(target);
	}

	@Override
	public void accept(IntVisitor v, int d) {
		// TODO Auto-generated method stub
		v.visit(this, d);
	}

}
