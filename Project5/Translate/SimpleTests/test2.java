class test1{

	public static void main(String[] args){
		yellow y = new yellow();
		int k = y.one();
		int j = y.two();
		int h = y.q;
		int a = y.t + h;
		int b = y.p + y.t;
	}


}

class yellow{
	
	int q;
	int t;
	int p;
	public int one(){
		t = this.two();
		return 6+1;
	}

	public int two(){
		return 7;
	}

}
