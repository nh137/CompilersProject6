package Translate.Tree;
public class Print implements IntVisitor{
    private java.io.PrintWriter out;
    private int indent = 0;
    private Stm s;

    public Print(){this.out = new java.io.PrintWriter(System.out);}

    public Print(java.io.PrintWriter out, Stm s){
	this.out = out;
	this.s = s;
    }

    private void printIndent(){
	for(int i=0; i<indent/2; i++)
	    out.print(" ");
    }

@Override
public void visit(BINOP n) {
// TODO Auto-generated method stub
    out.println("BINOP("+n.binop);
    indent +=2; printIndent();
    n.left.accept(this);
    out.println();
    n.right.accept(this);
    indent -= 2;
    out.println(")");
}
@Override
public void visit(CALL n) {
// TODO Auto-generated method stub
    out.println("CALL(");
    indent += 2; printIndent();
    n.func.accept(this);
    out.println();
    for(int i=0; i<n.args.size(); i++){
	n.args.get(i).accept(this);
	out.println();
    }
    indent -= 2;
    out.println(")");
}
@Override
public void visit(CJUMP n) {
// TODO Auto-generated method stub
    out.println("CJUMP("+n.relop);
    indent += 2; printIndent();
    n.left.accept(this);
    out.println();
    n.right.accept(this);
    out.println();
    n.iftrue.toString();
    out.println();
    n.iffalse.toString();
    indent =-2;
    out.println(")");
}
@Override
public void visit(CONST n) {
// TODO Auto-generated method stub
    out.print("CONST("+n.value+")");
}
@Override
public void visit(ESEQ n) {
// TODO Auto-generated method stub
    out.println("ESEQ(");
    indent += 2; printIndent();
    n.stm.accept(this);
    out.println();
    n.exp.accept(this);
    indent -= 2;
    out.println(")");
}
@Override
public void visit(EXP n) {
// TODO Auto-generated method stub
    out.println("EXP(");
    indent += 2; printIndent();
    n.exp.accept(this);
    indent -= 2;
    out.println(")");
}
@Override
public void visit(JUMP n) {
// TODO Auto-generated method stub
    out.println("JUMP(");
    indent += 2; printIndent();
    n.exp.accept(this);
    out.println();
    for(int i=0; i<n.targets.size(); i++){
	n.targets.get(i).toString();
	out.println();
    }
    indent -= 2;
    out.println(")");
}
@Override
public void visit(LABEL n) {
// TODO Auto-generated method stub
    out.print("LABEL("+n.label.name+")");
}
@Override
public void visit(MEM n) {
// TODO Auto-generated method stub
    out.println("MEM(");
    indent += 2; printIndent();
    n.exp.accept(this);
    indent -= 2;
    out.println(")");
}
@Override
public void visit(MOVE n) {
// TODO Auto-generated method stub
 out.println("MOVE(");
    indent += 2; printIndent();
    n.dst.accept(this);
    out.println();
    n.src.accept(this);
    indent -= 2;
    out.println(")");
}
@Override
public void visit(NAME n) {
// TODO Auto-generated method stub
    out.print("NAME"+n.label.name+")");
}
@Override
public void visit(SEQ n) {
// TODO Auto-generated method stub
    out.println("SEQ(");
    indent += 2; printIndent();
    n.left.accept(this);
    out.println();
    n.right.accept(this);
    indent -= 2;
    out.println(")");
}
@Override
public void visit(TEMP n) {
// TODO Auto-generated method stub
 out.print("TEMP("+n.temp.num+")");
}
}
