package Assem.Translate.Translate;
import Assem.Translate.Temp.*;
import Assem.Translate.Tree.*;
public abstract class Exp {
	
	public abstract Assem.Translate.Tree.Exp unEx();
	
	public abstract Assem.Translate.Tree.Stm unNx();
	
	public abstract Assem.Translate.Tree.Stm unCx(Label t, Label f);
}
