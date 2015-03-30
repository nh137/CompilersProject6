package Translate.Tree;

public class LABEL extends Stm{
	public Translate.Temp.Label label;
	
	public LABEL(Translate.Temp.Label l){
		label = l;
	}

	@Override
	public void accept(IntVisitor v) {
		// TODO Auto-generated method stub
		v.visit(this);
	}
	
}
