package leetCode30Day;

public class D19_SearchRotatedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(search(new int[] {3,1},1));

	}
	public static int search(int[] nums, int target) {
        if(nums.length ==0)
            return -1;
        
        
        
        int minId= findMinIdx(nums);
        int low=0; // search space is before the min elt
        int high= minId-1;
        if(nums[minId]== target)   
            return minId;
        
        if(target < nums[0]){  // if the search space is after the min elt
            low= minId;
            high= nums.length-1;
            //System.out.println("hh");
        }
        
        if(nums[0]< nums[nums.length-1])  // when non rotated then the entire thing is checked
        {
            high= nums.length-1;
        }
        System.out.println(low);
        System.out.println("hi"+high);
        while(low<=high){
            int mid= low+(high-low)/2;
            if(nums[mid]==target)
                return mid;
            if(nums[mid] < target)
                low= mid+1;
            else
                high=mid-1;
        }
        
        return -1;
        
    }

	public static int findMinIdx(int[] nums) {
		int low = 0;
		int high = nums.length - 1;
		int mid = 0;
		// System.out.println(mid);
		while (low <= high) {
			mid = low + (high - low) / 2;

			if (nums[mid] >= nums[high]) // equal to also included cos if only 1 elt then if we dont add equal we wont increment low hence infi loop
				low = mid + 1;
			else
				high = mid;
		}
		 //System.out.println(nums[mid]);
		return mid;
	}

}
