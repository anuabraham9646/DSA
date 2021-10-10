package CoreJava;

public class References implements Ex1,Ex2{
	int a,b;
	public References(int a, int b){
		this.a=a;
		this.b=b;
	}

	@Override
	public String toString() {
		return "References [a=" + a + ", b=" + b + "]";
	}

	

	@Override
	public void present() {
		// TODO Auto-generated method stub
		Ex2.super.present();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		References a= new References(10, 20);
		References b= new References(100, 200);
		System.out.println(a);
		update(a);
		System.out.println(a);
		
		Ex1 x= new References(3, 6);
		x.present();

	}

	private static void update(References a2) {
		// TODO Auto-generated method stub
		a2.a=55;
		a2.b=66;
		
	}

}
