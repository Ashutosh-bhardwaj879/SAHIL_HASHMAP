import java.util.*;

//https://practice.geeksforgeeks.org/problems/longest-subarray-with-sum-divisible-by-k1259/1
class LongestSubarrayWithSumDivisibleByK {
    int longSubarrWthSumDivByK(int nums[], int n, int k) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        int currentRem = 0;
        // we have used 0 to handle case when the whole array sum is divisible be k
        memo.put(currentRem, -1);

        int ans = 0;
        int prefixSum = 0;
        for (int i = 0; i < n; i++) {

            prefixSum += nums[i];
            currentRem = ((prefixSum % k) + k) % k;

            if (memo.containsKey(currentRem)) {
                ans = Math.max(ans, i - memo.get(currentRem));
            } else {
                memo.put(currentRem, i);
            }
        }

        return ans;

    }

}