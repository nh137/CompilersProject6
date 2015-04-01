package Translate.Translate;
import Translate.Temp.Label;
import Translate.Tree.*;
import Translate.Frame.*;
import java.util.ArrayList;
public class DataFrag extends Frag{
	public String data;
	public Label label;
	public ArrayList<Translate.Types.FUNCTION> flist;
	public Translate.Types.CLASS c;
	
	public DataFrag(String s){
		data = s;
		flist = new ArrayList<Translate.Types.FUNCTION>();
		label = null;
	}
	
	public DataFrag(String s, Label l){
		data = s;
		label = l;
	}
	
	
	
	public String getData(){
		return data;
	}
	
	public String toString(){
		String s;
		s = "\t.data";
		if(label == null){
			s+="\n";
			s+=data+"_vtable:\n";
			for(Translate.Types.FUNCTION f : flist){
				s+="\t.word "+data+"."+f.name;
				s+="\n";
			}
		}else{
			//String case
		}
		return s;
	}
	

}