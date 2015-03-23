package Translate.Frame;
import Translate.Util.BoolList;
import Translate.Temp.*;

public abstract class Frame {
	abstract public Frame newFrame(Label name, BoolList formals);
	public Label name;
	public AccessList formals;
	abstract public Access alloclLocal(boolean escape);
	abstract public Access allocFormal(boolean escape);
}
