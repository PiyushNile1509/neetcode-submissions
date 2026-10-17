class Solution {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        s=s.replaceAll("[,;: ?!`'./]","");
        StringBuilder str=new StringBuilder();
        for(int i=0;i<s.length();i++){
            str=str.append(s.charAt(i));
        }

        System.out.println(str);
        int left=0;
        int right=str.length()-1;

        while(left<right){
            if(str.charAt(left)!=str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}