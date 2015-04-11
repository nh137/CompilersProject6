package Assem.Translate.Translate;
import Assem.Translate.Temp.Label;
import Assem.Translate.Tree.*;
import Assem.Translate.Frame.*;
import java.util.ArrayList;
public class DataFrag extends Frag{
	public String data;
	public Label label;
	public ArrayList<Assem.Translate.Types.FUNCTION> flist;
	public Assem.Translate.Types.CLASS c;
	
	public DataFrag(String s){
		data = s;
		flist = new ArrayList<Assem.Translate.Types.FUNCTION>();
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
			for(Assem.Translate.Types.FUNCTION f : flist){
				Assem.Translate.Types.OBJECT o = (Assem.Translate.Types.OBJECT)f.self;
				Assem.Translate.Types.CLASS c = o.myClass;
				s+="\t.word "+c.name+"."+f.name;
				s+="\n";
			}
		}else{

			s+= label+":\t.asciiz\t"+ data;
		}
		return s;
	}
	

}