package array;

public class Leetcode_Q121_BestTimeToBuyAndSellStock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int prices[]= new int [] {7,1,5,3,6,4};

	}
	public int maxProfit(int[] prices) {
	       	int min=Integer.MAX_VALUE;
	        int profit=0;
	        for(int i=0;i<prices.length;i++){
	            min=Math.min(prices[i],min);
	            
	            if(prices[i] < min){
	                min= prices[i];
	            }
	            else if(prices[i]-min > profit){
	                
	                profit= prices[i]-min;
	                
	            }
	            
	        }
	        return profit;
	        
	        
	        // another method usin kadanes algo
	       /* if(prices.length <=1)
	            return 0;
	        int temp=prices[0];
	        int temp2;
	        for(int i=1; i<prices.length;i++){
	            temp2=prices[i];
	            prices[i]= prices[i]-temp;
	            temp=temp2;
	        }
	        
	        prices[0]=0;
	        
	        we are calculating the matrx of price differences
	        suppose between 2 price there is increase eg  0 8 therefore total max= max+8 we add the profit maximum subarray
	          but suppose then there is a sharp decrease 0 8 -15  hence -15 is the point which means the price is very low 
	          so we should buy at that point hence we save the profit till 0 and 8  and make our current profit as 0 
	          cos we are buying we are not selling now for profit hence it becomes 0
	        
	        
	        int max= prices[0];
	        int profit=0;
	        for(int i=1 ;i < prices.length;i++){
	            max= Math.max(max+prices[i],0);
	            profit= Math.max(max,profit);
	        }
	        
	        return profit;*/
	    }

}
