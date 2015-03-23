package Translate.Translate;
import Translate.Temp.*;
import Translate.Tree.*;
public abstract class Exp {
	
	abstract Translate.Tree.Exp unEx();
	
	abstract Translate.Tree.Stm unNx();
	
	abstract Translate.Tree.Stm unCx(Label t, Label f);
}
