class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer,Integer>map=new HashMap<>();
        map.put(0,1);
        int sum=0;
        int count=0;

        for(int x:nums){
            sum=sum+x;
            int rem=sum%k;

            if(rem<0){
                rem=rem+k;
            }

            count=count+map.getOrDefault(rem,0);
            map.put(rem,map.getOrDefault(rem,0)+1);
        }

        return count;
    }
}