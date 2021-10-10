package binarysearch;

public class FindSmallestLetterGreaterThanTarget {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char [] letters = new char [] {'c','f', 'j'};
		char target= 'k';
		int v= target;
		int l=0,h=letters.length-1;
		char result=letters[0];
		while(l <= h) {
			int mid= (h+l)/2;
			int m = letters[mid];
			
			if(m > v) {
				result=letters[mid];
				h=mid-1;
			}
			else
				l=mid+1;
		}
		
		System.out.println(result);

	}

}
