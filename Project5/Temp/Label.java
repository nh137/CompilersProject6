package Translate.Temp;
import Translate.Symbol.*;
public class Label {
	private static int count;
	private String name;
	public Label(){
		
	}
	public Label(String s){
		name = s;
	}
	public Label(Symbol s){
		//believe this needs to look up name from symbol table
	}
	
	public String toString(){
		System.out.println(name + ":");
	}
}
