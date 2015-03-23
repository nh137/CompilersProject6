package Translate.Tree;

public class NAME extends Exp{

	Translate.Temp.Label label;
	
	public NAME(Translate.Temp.Label l){
		label = l;
	}

	@Override
	public void accept(IntVisitor v, int d) {
		// TODO Auto-generated method stub
		v.visit(this, d);
	}
	
}
