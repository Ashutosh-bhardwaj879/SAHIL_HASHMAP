//https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/

class Solution1497 {
    public boolean canArrange(int[] arr, int k) {
        int[]  memo = new int[k];

        for(int currentVal : arr){
            int currentRem = ((currentVal % k) + k)%k;
            
            memo[currentRem] += 1;
        }
        
        if( memo[0]%2 != 0 )
            return false;//for checking the 0th va;ue it should be even becuase k - k = 0 it wont have pair so it should be even
        
        
        for(int i=1;i<=k/2;i++){
            //of pair didnt matched for i k-i then false 
            if(memo[i] != memo[k-i])
                return false;
        }
        
        return true;
    }
}
//TC - O(n+k)
//sc - O(k)