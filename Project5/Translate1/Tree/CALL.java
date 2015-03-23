package Tree;

public class CALL extends Exp{

public java.util.List<Exp> args;
public Exp func;

public CALL(Exp f, java.util.List<Exp> a){
	func = f;
	args = a;
}

public void accept(IntVisitor v, int d){
	v.visit(this,d);
}
}
