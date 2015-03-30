package Translate.Frame;
import Translate.Util.BoolList;
import java.util.ArrayList;
import Translate.Temp.*;

public abstract class Frame {
	abstract public Frame newFrame(Label name, int numOfBools);
	public Label name;
	public ArrayList<Access> formals;
	abstract public Access alloclLocal(boolean escape);
	abstract public Access allocFormal(boolean escape);
	abstract public void printFrame(java.io.PrintWriter writer);
	
}
