import java.util.*;
//https://practice.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1#
class LongestSubarrayWithSumK {

    // Function for finding maximum and value pair
    public static int lenOfLongSubarr(int nums[], int N, int k) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        int prefixSum = 0;
        int ans = 0;
        // since we have to found the length which involves index we cant put 0 here so
        // -1
        memo.put(prefixSum, -1);
        // array traversal
        for (int i = 0; i < N; i++) {
            // prefoxSum
            prefixSum += nums[i];

            // if it continas prefixSum -k then that sibarray is a ans
            if (memo.containsKey(prefixSum - k))
                ans = Math.max(ans, i - memo.get(prefixSum - k));
            // if not in map then put it with its leftmost frequency
            // we are not increasing index so we have leftmost index only
            if (!memo.containsKey(prefixSum))
                memo.put(prefixSum, i);

        }

        return ans;
    }

}