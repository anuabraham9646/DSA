package leetCode30Day;

public class D14_StringShift {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*"yisxjwry"
		[[1,8],[1,4],[1,3],[1,6],[0,6],[1,4],[0,2],[0,1]]
		*/
		String s = "yisxjwry";
		int[][] arr = new int[][] { { 1,8 }, { 1, 4 }, { 1,3}, { 1,6 },{ 0,6 },{ 1,4 },{ 0,2 },{ 0,1 } };
		System.out.println(stringShift(s,arr));

	}

	public static String stringShift(String s, int[][] shift) {
		
		int count=0;
		for(int i=0;i<shift.length;i++) {
			if(shift[i][0]==0)
				count-=shift[i][1];
			else
				count+=shift[i][1];
		}
		
		count= count%s.length();
		System.out.println(count);
		StringBuilder ss= new StringBuilder();
		if(count ==0 )
			return s;
		else if(count >0 ) {
			for(int i= s.length()-count; i <s.length();i++)
				ss.append(s.charAt(i));
			for(int i= 0; i <s.length()-count;i++)
				ss.append(s.charAt(i));
		}
		else {
			for(int i= -count; i <s.length();i++)
				ss.append(s.charAt(i));
			for(int i= 0; i <-count;i++)
				ss.append(s.charAt(i));
		}
		System.out.println(count);
		return ss.toString();
		
		//0123456

	}

}
