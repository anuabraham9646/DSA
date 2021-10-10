package leetCode30Day;

public class D3_MaxSubarray {
	int max= Integer.MIN_VALUE;
	int maxrec= Integer.MIN_VALUE;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums= new int[] {-2,1,-3,4,-1,2,1,-5,4};
		D3_MaxSubarray m = new D3_MaxSubarray();
		
		System.out.println(maxDP(nums));


		m.subarrayRec(nums,nums.length);
		System.out.println(m.getMax());

	}

	private int getMax() {
		// TODO Auto-generated method stub
		return maxrec;
	}

	private static int maxDP(int[] nums) {
		// TODO Auto-generated method stub
		int sum= Integer.MIN_VALUE;
		int curr= nums[0];
		for(int i=1;i<nums.length;i++) {
			curr=Math.max(curr+nums[i], nums[i]);
			
			sum= Math.max(sum, curr);
		}
			
		return sum;
	}

	private int subarrayRec(int[] nums, int index) {
		// TODO Auto-generated method stub
		
		if(index <=0)
			return 0;
		
		int curr=nums[index-1]+subarrayRec(nums,index-1);
		int curr1= nums[index-1];
		
		int maxCur= Math.max(curr, curr1);
		
		maxrec=Math.max(maxrec	, maxCur);
		
		return maxCur;
	}

}
