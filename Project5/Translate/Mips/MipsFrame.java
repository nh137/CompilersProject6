package Translate.Mips;
import Translate.Frame.*;
import Translate.Temp.Label;
import Translate.Util.*;
import Translate.Temp.*;
import java.util.ArrayList;
//import Translate.Tree.*;
public class MipsFrame extends Frame{
	public Temp FP;
	public int wordsize;
	public Label badPtr;
	public Label badSub;
	public Label name;
	public ArrayList<Access> formals;
	
	//public MipsFrame(Label n, int numOfBools){
	//	this.name = n;
	//}
	
	public MipsFrame(){
		//this.name = n;
		for(int i = 0; i < 32; i++){
			Temp temp = new Temp();
		}
		badPtr = new Label("BADPTR");
		badSub = new Label("BADSUB");
	}
	@Override
	public Frame newFrame(Label name, int k) {
		// TODO Auto-generated method stub
		this.name = name;
		FP = new Temp();
		formals = new ArrayList<Access>();
		return this;
	}
	
	//private MipsFrame(name, k){
		
	//}
	
	public Label badPtr(){
		
		return badPtr;
	}
	
	public Label badSub(){
		
		return badSub;
	}
	
	public int wordsize(){
		
		return 4;
	}

	@Override
	public Access alloclLocal(boolean escape) {
		// TODO Auto-generated method stub
		Temp t = new Temp();
		return new InReg(t);
	}
	
	public Access allocFormal(boolean escape) {
		// TODO Auto-generated method stub
		Temp t = new Temp();
		InReg r = new InReg(t);
		formals.add(r);
		return null;
	}
	
	public void printFrame(java.io.PrintWriter writer){
		writer.print("MipsFrame(\n");
		writer.print(name+"\n");
		writer.print("Formals(" + "InReg()"+FP+")\n");
		int i = 4;
		for(Access a : formals){
			writer.print("\tInReg(t"+((InReg)a).temp+")\n");
			writer.print("\tInReg(t"+i+")\n");
			i++;
			
		}
		writer.print("\t)\n");
		writer.print("BadPtr(_BADPTR)\n");
		writer.print("BadSub(_BADSUB)\n");
		writer.print(")\n");
		
		
	}
	

}
