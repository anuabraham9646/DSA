package java8;
import java.util.function.*;

public class training {
	public interface x{
		int doSomething(int y);
	}
	public int armstrong (int y) {
		y*=y;
		return y;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Function<Integer,Integer>f= n -> n*n;
		System.out.println(f.apply(5));
		training demo= new training();
		x a= b -> demo.armstrong(b);
		System.out.println(a.doSomething(10));

	}

}
