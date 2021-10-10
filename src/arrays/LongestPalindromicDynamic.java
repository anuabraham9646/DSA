package arrays;

public class LongestPalindromicDynamic {

	public static void main(String[] args) {
		System.out.println(longestPalindromeDynamic("cbbd"));
	}

	private static String longestPalindromeDynamic(String string) {
		
		if(string.length() <2)
			return string;
		boolean [][] dpTable = new boolean[string.length()][string.length()] ;
		int start=0,end=0;
		int n= string.length();
		for(int i=0;i< string.length()-1;i++) {
			dpTable[i][i]= true;
			
			if(string.charAt(i)==string.charAt(i+1)) {
				dpTable[i][i+1]= true;
				start=i;
				end=i+1;
			}
		}
		dpTable[string.length()-1][string.length()-1]= true;
		
		for(int i=2;i< string.length();i++) {
			for(int j=0;j<string.length();j++) {
				//System.out.print(dpTable[i][j]+"        ");
				
				if(i+j < n) {
					
					boolean equality= (string.charAt(j)==string.charAt(i+j));
					boolean lookup= j == n-1?false:(dpTable[j+1][i+j-1]);
					dpTable[j][j+i]= equality && lookup;
					if(dpTable[j][j+i] && ((i+1)>(start-end))) {
						start= j;
						end= j+i;
					}
				}
				
			}
			//System.out.println("");
		}
		
		
		
		for(int i=0;i< string.length();i++) {
			for(int j=0;j<string.length();j++) {
				System.out.print(dpTable[i][j]+"        ");
				
				
			}
			System.out.println("");
		}
		//System.out.println(start +" "+end);
		
		return string.substring(start,end+1);
	}

}
