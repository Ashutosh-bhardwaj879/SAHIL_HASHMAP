
//https://leetcode.com/problems/subarray-sums-divisible-by-k/
import java.util.*;

class CountSubarraySumDivisibleByK {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        int currentRem = 0;
        // we have used 0 to handle case when the whole array sum is divisible be k
        memo.put(currentRem, 1);
        //TC O(N) SC O(K)
        int ans = 0;
        int prefixSum = 0;
        for (int currentNums : nums) {

            prefixSum += currentNums;
            currentRem = ((prefixSum % k) + k) % k;

            if (memo.containsKey(currentRem)) {
                // adding answer to frequency
                ans += memo.get(currentRem);
                // increasing frequeny after addinf frequency to answer
                memo.put(currentRem, memo.get(currentRem) + 1);
            } else {
                memo.put(currentRem, 1);
            }
        }

        return ans;
    }
}