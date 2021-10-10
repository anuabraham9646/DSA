package leetCode30Day;

import java.util.*;

public class D6_GroupAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] str= new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};
		HashMap<String,Integer>hm = new HashMap<>();
		List<List<String>> res= new ArrayList<>();
		//res.add(0, new ArrayList<>());
		//System.out.println(res.get(0));
		int i=0;
		for(String s: str) {
			char [] c= s.toCharArray();
			Arrays.sort(c);
			String s1= new String(c);
			if(!hm.containsKey(s1)) {
				//res.get(i).add(new ArrayList<String>(s));
				hm.put(s1, i);
				res.add(i,new ArrayList<>());
				res.get(i).add(s);
				i++;
			}else {
				int loc= hm.get(s1);
				res.get(loc).add(s);
			}
		}
		System.out.println(res);
		
		
		
		
		List<List<String>> res1= new ArrayList<>();
		res1=optimalSoln(str);
		System.out.println(res1);
		//arr

	}

	private static List<List<String>> optimalSoln(String[] str) {
		// TODO Auto-generated method stub
		HashMap<String,List> hm= new HashMap<>();
		int [] table= new int[26]; 
		for(String s: str) {
			Arrays.fill(table, 0);
			for(int i=0;i< s.length();i++) {
				table[s.charAt(i)-'a']++;
			}
			StringBuilder sb= new StringBuilder();
			for(int i=0; i<26;i++) {
				sb.append('#');
				sb.append(table[i]);
				
			}
			if(!hm.containsKey(sb.toString())) {
				hm.put(sb.toString(), new ArrayList<>());
			}
			hm.get(sb.toString()).add(s);
			
			
		}
		return new ArrayList<>(hm.values());
	}

}
