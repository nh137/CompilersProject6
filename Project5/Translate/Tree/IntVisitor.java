package Translate.Tree;

public interface IntVisitor {
	
	public void visit(BINOP n, int s);
	public void visit(CALL n, int s);
	public void visit(CJUMP n, int s);
	public void visit(CONST n, int s);
	public void visit(ESEQ n, int s);
	public void visit(EXP n, int s);
	public void visit(JUMP n, int s);
	public void visit(LABEL n, int s);
	public void visit(MEM n, int s);
	public void visit(MOVE n, int s);
	public void visit(NAME n, int s);
	public void visit(SEQ n, int s);
	public void visit(TEMP n, int s);

}
