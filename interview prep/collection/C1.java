package collection;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
//import java.util.concurrent.CopyOnWriteArrayList;

public class C1 {
	int a;
	int b;
	C1(){
		a=10;
		b=5;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * C1 a= new C1(); C1 b= a; b.a=55; System.out.println(a.a);
		 * //ArrayList<Integer> c= new ArrayList<>(); CopyOnWriteArrayList<Integer> c=
		 * new CopyOnWriteArrayList<>(); c.add(1); c.add(2); c.add(3);
		 * ListIterator<Integer> itr= c.listIterator(); int i=0; while(itr.hasNext()) {
		 * 
		 * if(i==2) c.remove(2); itr.next(); i++; } System.out.println(i);
		 * System.out.println(c); Map<String,String> hash= new HashMap<>();
		 * hash.put("kk", "ll"); hash.put("kk1", "l2l"); Iterator <Map.Entry<String,
		 * String>> it = hash.entrySet().iterator(); while(it.hasNext()) {
		 * Map.Entry<String, String> ent=it.next(); System.out.println(ent.getKey());
		 * it.remove(); } System.out.println(hash.toString());
		 */
		/*int arr[]= new int[] {1,6,3,5};
		Arrays.sort(arr);
		int ans=1;
		//System.out.println(arr[1]);
		for(int i: arr) {
			if(i<=0)
				continue;
			if(i > ans)
				System.out.println("final ans= "+ans);
			else if(ans >i)
				ans++;
		}*/
		
		
		String s="aaaabbcdfff";
		int[] alphaCount= new int[26];
		Arrays.fill(alphaCount, 0);
		int a= 'z'-97;
		System.out.println(a);
		
		for(char c : s.toCharArray()) {
			int id= c-97;
			
			alphaCount[id]++;
		}
		Integer[]counts=Arrays.stream(alphaCount).filter(val -> val >0).boxed().sorted(Comparator.reverseOrder()).toArray(Integer []::new);
		for(int i=0;i<counts.length;i++) {
			System.out.println(counts[i]);
		}
		int deletions=0;
		for (int i = 0; i <counts.length-1 ; i++) {
            for (int j = i+1; j <counts.length ; j++) {
                if (counts[i]>0 && counts[i]==counts[j]){
                    int count = counts[j];
                    counts[j] = count - 1;
                    deletions++;
                }else
                    break;
            }
        }
		

	}
	
	public int solution(int N) {
        // write your code in Java SE 8
        int initialSum=deriveSum(N);
        int requiredSum= initialSum*2;
        int startFrom=N+1;
        while(true){

            if(deriveSum(startFrom) == requiredSum)
                return startFrom;
            else 
                startFrom++;

        }
        
    }
	public int deriveSum(int a){
        int sum=0;
		while(a>0) {
			int val = a%10;
			sum+=val;
			a= a/10;
			
		}
        return sum;
    }

}
