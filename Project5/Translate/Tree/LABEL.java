package Translate.Tree;

public class LABEL extends Stm{
	Translate.Temp.Label label;
	
	public LABEL(Translate.Temp.Label l){
		label = l;
	}

	@Override
	public void accept(IntVisitor v, int d) {
		// TODO Auto-generated method stub
		v.visit(this, d);
	}
	
}
