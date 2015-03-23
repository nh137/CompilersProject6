package Translate.Translate;
import Translate.Temp.*;
import Translate.Tree.*;

public class IfThenElseExp extends Exp{
	Exp cond, a, b;
	Label t = new Label();
	Label f = new Label();
	Label join = new Label();
	IfThenElseExp(Exp cc, Exp aa, Exp bb) {
	cond=cc; a=aa; b=bb;
	}
	Stm unCx(Label tt, Label ff) {
		return null;
	}
	Translate.Tree.Exp unEx() {
		return null;
	}
	Stm unNx() {
		return null;
	}
}
