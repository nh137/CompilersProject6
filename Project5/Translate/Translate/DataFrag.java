package Translate.Translate;
import Translate.Temp.Label;
import Translate.Tree.*;
import Translate.Frame.*;
public class DataFrag extends Frag{
	public String data;
	public Label label;
	
	public DataFrag(String s){
		data = s;
	}
	
	public DataFrag(String s, Label l){
		data = s;
		label = l;
	}
	
	public DataFrag(String s, Frame f, Frag n){
		data = s;
		///...
	}
	
	public String getData(){
		return data;
	}
	

}