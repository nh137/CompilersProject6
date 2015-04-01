class test1{

	public static void main(String[] args){
		yellow y = new yellow();
		int k = y.one();
		int j = y.two();
		int h = y.q;
		int a = y.t;
		int b = y.p;
	}


}

class yellow{
	
	int q;
	int t;
	int p;
	public int one(){
		q = 2;
		return 6;
	}

	public int two(){
		return 7;
	}

}
