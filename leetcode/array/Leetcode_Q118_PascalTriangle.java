package array;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_Q118_PascalTriangle {
	//https://leetcode.com/problems/pascals-triangle/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numRows=5;
		generate(numRows);
	}
	public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res= new ArrayList<>();
        
        for(int i=0;i<numRows;i++){
            List<Integer> temp= new ArrayList<>();
            for(int j=0;j<=i;j++){
                
                if(j==0 || j==i || i==0)
                    temp.add(1);
                else{
                    int hasLeftUp=res.get(i-1).get(j-1);
                    int hasRightUp=res.get(i-1).get(j);
                    temp.add(hasLeftUp+hasRightUp);
                }
                
            }
            
            res.add(temp);
        }
        
        return res;
        
    }

}
