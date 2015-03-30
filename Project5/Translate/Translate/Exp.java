package Translate.Translate;
import Translate.Temp.*;
import Translate.Tree.*;
public abstract class Exp {
	
	public abstract Translate.Tree.Exp unEx();
	
	public abstract Translate.Tree.Stm unNx();
	
	public abstract Translate.Tree.Stm unCx(Label t, Label f);
}
