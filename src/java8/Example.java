package java8;
import java.util.*;
class Person{
	int age;
	String name;
	int score;
	public Person(int a, String b, int c) {
		age=a;
		name=b;
		score=c;
	}
	public Person() {
		// TODO Auto-generated constructor stub
	}
	public int getAge() 	{return this.age;}
	public String getName() {return this.name;}
	public int getScore() 	{return this.score;}
}
public class Example {
	
	
	public static void main(String[] args) {
		ArrayList<Person> log= new ArrayList<>();
		Person pp= new Person();
		log.add(new Person(10,"anu",15));
		log.add(new Person(100,"zhhh",150));
		log.add(new Person(1,"anjj",16));
		log.add(new Person(11,"bhat",15));
		log.add(new Person(7,"chetan",1));
		log.sort((p1,p2)-> p1.getAge()-p2.getAge());
		log.forEach(p -> System.out.println(p.getAge()+" "+p.getName()+ " "+p.getScore()));
		Comparator.comparingInt(Person::getScore);
	}

}
