package Translate.Translate;
import Translate.Tree.*;
import Translate.Frame.*;
public class ProcFrag extends Frag{
	Stm body;
	Frame frame;
	
	public ProcFrag(Stm s, Frame f){
		body = s;
		frame = f;
	}
	
	public ProcFrag(Stm s, Frame f, Frag n){
		body = s;
		frame = f;
		next = n;
	}
	
	public Stm getBody(){
		return body;
	}
	
	public Frame getFrame(){
		return frame;
	}
}
