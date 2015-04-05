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
		s = "\t.data\n";
		if(label == null){
			
			s+=data+"_vtable:\n";
			for(Translate.Types.FUNCTION f : flist){
				Translate.Types.OBJECT o = (Translate.Types.OBJECT)f.self;
				Translate.Types.CLASS c = o.myClass;
				s+="\t.word "+c.name+"."+f.name;
				s+="\n";
			}
		}else{

			s+= label+":\t.asciiz\t"+ data;
		}
		return s;
	}
	

}