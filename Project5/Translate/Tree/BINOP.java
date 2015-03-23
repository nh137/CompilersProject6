package Translate.Tree;

public class BINOP extends Exp{

	static int PLUS = 0;
	static int MINUS = 1;
	static int MUL = 2;
	static int DIV = 3;
	static int AND = 4;
	static int OR = 5;
	static int LSHIFT = 6;
	static int RSHIFT = 7;
	static int ARSHIFT = 8;
	static int BITAND = 9;
	static int BITOR = 10;
	static int BITXOR = 11;
	
	public int binop;
	public Exp left;
	public Exp right;
	
	public BINOP(int b, Exp l, Exp r){
		binop = b;
		left = l;
		right = r;
	
	}

	@Override
	public void accept(IntVisitor v, int d) {
		// TODO Auto-generated method stub
		v.visit(this, d);
		
	}


}
