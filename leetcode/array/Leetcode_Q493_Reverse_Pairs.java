package array;

public class Leetcode_Q493_Reverse_Pairs {
//https://www.youtube.com/watch?v=owZhw-A0yWE  similar approach
	public static void main(String[] args) {
		// int arr[]= new int[] {40,25,19,12,9,6,2};
		int arr[] = new int[] { 2,4,3,5,1 };
		int temp[] = new int[arr.length];
		int a = mergeSort(arr, 0, arr.length - 1, temp);
		System.out.println(a);

	}

	private static int mergeSort(int[] arr, int l, int r, int[] temp) {
		int count = 0;
		if (l < r) {
			int mid = l + (r - l) / 2;
			count += mergeSort(arr, l, mid, temp);
			count += mergeSort(arr, mid + 1, r, temp);

			count += merge(arr, l, mid, r);
		}

		return count;
	}

	private static int merge1F(int[] arr, int l, int mid, int r, int[] temp) {
		int count = 0;
		int i = l;
		int j = mid + 1;
		int k = l;
		int rightCount = j;
		while (i <= mid && j <= r) {
			if (arr[i] <= arr[j]) {
				while (rightCount <= r && arr[i] > 2L * arr[rightCount]) {
					count += mid - i + 1;
					rightCount++;
				}
				temp[k++] = arr[i++];
			} else {

				temp[k++] = arr[j++];
			}

		}
		while (i <= mid) {
			while (rightCount <= r && arr[i] > 2L * arr[rightCount]) {
				count += mid - i + 1;
				rightCount++;
			}
			temp[k++] = arr[i++];
		}
		while (j <= r)
			temp[k++] = arr[j++];
		for (int t = l; t <= r; t++)
			arr[t] = temp[t];
		return count;
	}

	private static int merge(int[] nums, int lo, int mid, int hi) {
        int count = 0;
        int[] a = new int[hi - lo + 1];
        int index = 0;
        int p = lo, q = mid + 1;
        while (p <= mid && q <= hi) {
            if ((long) nums[p] > 2 * (long) nums[q]) {
                count += mid - p + 1;
                q++;
            } else {
                p++;
            }
        }
        p = lo;
        q = mid + 1;

        while (p <= mid && q <= hi) {
            if (nums[p] > nums[q]) {
                a[index++] = nums[q];
                q++;
            } else {
                a[index++] = nums[p++];
            }
        }

        while (p <= mid) {
            a[index++] = nums[p++];
        }

        while (q <= hi) {
            a[index++] = nums[q++];
        }

        System.arraycopy(a, 0, nums, lo, hi - lo + 1);
        return count;
    }
	
}
