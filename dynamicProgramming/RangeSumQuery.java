class RangeSumQuery {
	/*303. Range Sum Query - Immutable
	Given an integer array nums, find 
	the sum of the elements between indices
	i and j (i ≤ j), inclusive.
	*/
	// compute all the [0...k] for k=0,1,2,...
	//any [i...j]=[0...j]-[0...i]
public RangeSumQuery(int[] nums) {
    sum = new int[nums.length + 1];
    for (int i = 0; i < nums.length; i++) {
        sum[i + 1] = sum[i] + nums[i];
    }
}

public int sumRange(int i, int j) {
    return sum[j + 1] - sum[i];
}
	
	public static void main(String[] args){
		int[] a={-2, 0, 3, -5, 2, -1};
		System.out.println(new RangeSumQuery(a).sumRange(0,2));
	}
}