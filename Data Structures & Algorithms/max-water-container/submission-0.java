class Solution {
    public int maxArea(int[] nums) {
        int left=0;
        int right=nums.length-1;
        int maxArea=0;

        while(left<right){
            int width=right-left;
            int height=Math.min(nums[left],nums[right]);
            int area=height*width;
            maxArea=Math.max(maxArea,width*height);
            if(nums[left]<nums[right]){
                left++;
            }else {
                right--;
            }
        }
        return maxArea;
    }
}
