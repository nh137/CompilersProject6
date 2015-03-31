package Translate.Translate;
import Translate.Temp.*;
import Translate.Tree.*;

public class IfThenElseExp extends Exp{
	public Exp cond, a, b;
	public Label t = new Label();
	public Label f = new Label();
	public Label join = new Label();
	public IfThenElseExp(Exp cc, Exp aa, Exp bb) {
	cond=cc; a=aa; b=bb;
	}
	public Stm unCx(Label tt, Label ff) {
		Stm tStm = a.unCx(tt, ff);
		Stm fStm = b.unCx(tt, ff);
		CJUMP cj = new CJUMP(CJUMP.NE, cond.unEx(), new CONST(0), t, f);
		SEQ s1 = new SEQ(t, tStm);
		SEQ s2 = new SEQ(f, fStm);
		return new SEQ(cj, new SEQ(s1, s2));
	}
	public Translate.Tree.Exp unEx() {
		Translate.Tree.Exp tExp = a.unEx();
		Translate.Tree.Exp fExp = b.unEx();
		Stm c = cond.unCx(t, f);
		TEMP r = new Translate.Temp.Temp();
		
		SEQ s1 = new SEQ(f, new SEQ(new MOVE(r, fExp), new JUMP(fExp, join)));
		
		SEQ s2 = new SEQ(c, new SEQ(t, new SEQ(new MOVE(r, tExp), new JUMP(tExp, join))), s1));
		
		return new ESEQ(new SEQ(s2, join), r);
	}
	public Stm unNx() {
		return null;
	}
}
