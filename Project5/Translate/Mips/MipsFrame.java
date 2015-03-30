package Translate.Mips;
import Translate.Frame.*;
import Translate.Temp.Label;
import Translate.Util.*;
import Translate.Temp.*;
import Translate.Tree.*;
public class MipsFrame extends Frame{
	public Temp FP;
	public int wordsize;
	
	
	public MipsFrame(Label n, int numOfBools){
		this.name = n;
	}
	
	public MipsFrame(){
		//this.name = n;
	}
	@Override
	public Frame newFrame(Label name, int k) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Label badPtr(){
		
		return null;
	}
	
	public int wordsize(){
		
		return 4;
	}

	@Override
	public Access alloclLocal(boolean escape) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Access allocFormal(boolean escape) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void printFrame(java.io.PrintWriter writer){
		
		
	}
	

}
