import java.util.*;
//https://leetcode.com/problems/subarray-sum-equals-k/
class Leetcode560 {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> memo = new HashMap<>();
        int prefixSum =0;
        int ans = 0;
        
        memo.put(prefixSum,1);
        //array traversal
        for(int currentVal : nums){
            //prefoxSum
            prefixSum += currentVal;
            
            //if it continas prefixSum -k then that sibarray is a ans
            if(memo.containsKey(prefixSum - k))
                ans += memo.get(prefixSum-k);
            //it may happent that arr may have negaitve elemnt 
            //which can repeat the prefix sum so inc the frequency
            if(memo.containsKey(prefixSum))
                memo.put(prefixSum,memo.get(prefixSum) + 1);
            //if prefixSum occ 1st time then put 1 as freq
            else
                memo.put(prefixSum,1);
        }
        
        return ans;
    }
}
