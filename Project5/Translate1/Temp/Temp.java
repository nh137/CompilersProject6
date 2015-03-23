package Translate.Temp;

public class Temp {

	private static int count;
	private int num;
	public Temp(){
		num = count+1;
		count++;
	}
	
	public String toString(){
		return new String("t" + num);
	}
}
