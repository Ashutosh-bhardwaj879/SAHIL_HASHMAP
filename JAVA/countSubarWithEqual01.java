import java.util.*;
//https://practice.geeksforgeeks.org/problems/count-subarrays-with-equal-number-of-1s-and-0s-1587115620/1/
class CountSubarrayWithEqual0s1s {
    // Function to count subarrays with 1s and 0s.
    static int countSubarrWithEqualZeroAndOne(int arr[], int n) {
        int prefixSum = 0;
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        map.put(prefixSum, 1);

        for (int i = 0; i < n; i++) {

            if (arr[i] == 0)
                prefixSum += -1;
            else
                prefixSum += 1;

            if (map.containsKey(prefixSum)) {

                int oldFreq = map.get(prefixSum);

                ans += oldFreq;
                map.put(prefixSum, oldFreq + 1);

            } else {
                map.put(prefixSum, 1);
            }
        }
        return ans;
    }
}
