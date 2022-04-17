import java.util.*;

//https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/longest-subarray-with-equal-number-of-0s-1s-and-2s-official/ojquestion
class LargestSubarrayWithequal012 {

    public static int solution(int[] s) {
        int z0 = 0;
        int z1 = 0;
        int z2 = 0;
        int ans = 0;

        HashMap<String, Integer> memo = new HashMap<String, Integer>();
        // this is key for 0#0
        // with length as -1
        String key = (z1 - z0) + "#" + (z2 - z1);
        memo.put(key, -1);

        for (int i = 0; i < s.length; i++) {
            // increasing o 1 2 count
            if (s[i] == 0) {
                z0 += 1;
            } else if (s[i] == 1) {
                z1 += 1;
            } else {
                z2 += 1;
            }
            // making new key
            key = (z1 - z0) + "#" + (z2 - z1);
            // if map contains key then update ans
            // we subtracted i with leftmost occcurence
            // we are not increasing the index also
            if (memo.containsKey(key)) {
                ans = Math.max(ans, i - memo.get(key));
            } else {
                memo.put(key, i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
        scn.close();
    }

}
