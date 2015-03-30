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
		return null;
	}
	public Translate.Tree.Exp unEx() {
		return null;
	}
	public Stm unNx() {
		return null;
	}
}
