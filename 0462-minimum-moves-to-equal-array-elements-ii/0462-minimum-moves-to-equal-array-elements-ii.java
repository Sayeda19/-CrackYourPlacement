class Solution {
    public int minMoves2(int[] nums) {
        int i,sum=0;
        Arrays.sort(nums);
        int median=nums[nums.length/2];
        for(i=0;i<nums.length;i++)
        {
            sum=sum+Math.abs(median-nums[i]);
        }
        return sum;
    }
}