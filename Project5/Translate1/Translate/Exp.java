package Translate.Translate;
import Translate.Temp.*;
import Translate.Tree.*;
public abstract class Exp {
	
	abstract Tree.Exp unEx();
	
	abstract Tree.Stm unNx();
	
	abstract Tree.Stm unCx(Label t, Label f);
}
