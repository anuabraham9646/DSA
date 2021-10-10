package arrays;

public class PreviousPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s= "4321";
		System.out.println(prevPermutation(s));

	}
	public static String prevPermutation(String s1)
    {
        StringBuilder s= new StringBuilder(s1);
        if(s.length()<2)
			return s1;
		/*
		 * here the idea is to visualize the peaks
		 * ideally to find increase number by smallest margin we should find the rightmost place hence we find the rightmost peak
		 * as step1 and try to move it 1 step left we have atleast 1 elt in peak
		 */
		int peakPos=s.length()-1;
		for(int j=s.length()-2; j>=0 ;j--){
		    int l= Integer.parseInt(String.valueOf(s.charAt(j)));
		    int r= Integer.parseInt(String.valueOf(s.charAt(j+1)));
		    if(l <= r)
		        peakPos=j;
		    else
		        break;
		}
			
		if(peakPos==0) {
			
			return "None";
		}
		
		int leftToPeakVal=Integer.parseInt(String.valueOf(s.charAt(peakPos-1)));
		int leftToPeakPos=peakPos-1;
		/*
		 * currently we are 1 elt before the peak to make it next permutation we must find greater number in the right side
		 * such that it is the smallest num greater than it  eg 2	4	5	3	6
		 * suppose elt is 2  we can swap with 4 but we want the smallest possible increase so we must swap 2 with 3
		 */
		
		int nextGreatPos=s.length()-1;;
		for(int j=s.length()-1; j>=0 ;j--) {
		    
		    int l= Integer.parseInt(String.valueOf(s.charAt(j)));
		    if(l < leftToPeakVal)
		        nextGreatPos=j;
		  
		}
		
		s.setCharAt(leftToPeakPos,s.charAt(nextGreatPos));
		s.setCharAt(nextGreatPos,(char)(leftToPeakVal+'0'));
		int i=peakPos;
		int j=s.length()-1;
		while(i<j) {
		    int l= Integer.parseInt(String.valueOf(s.charAt(i)));
		    int r= Integer.parseInt(String.valueOf(s.charAt(j)));
			int temp= l;
			s.setCharAt(i,(char)(r+'0'));
			s.setCharAt(j,(char)(temp+'0'));
			i++;
			j--;
		}
		
		return s.toString();
		
	}

}
