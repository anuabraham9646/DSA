package abstractFactory;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testAbstractFactory();
	}

	private static void testAbstractFactory() {
		Computer pc = ComputerFactory.getComputer(new PCFactory("2 GB", "500 GB", "2.4 GHz"));
		Computer server = ComputerFactory.getComputer(new ServerFactory("16 GB", "1 TB", "2.9 GHz"));
		System.out.println("AbstractFactory PC Config::" + pc);
		System.out.println("AbstractFactory Server Config::" + server);
	}

}
