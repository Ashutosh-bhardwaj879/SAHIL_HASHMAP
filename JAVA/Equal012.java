import java.util.*;
//https://practice.geeksforgeeks.org/problems/equal-0-1-and-23208/1/
class equal012 {
    long getSubstringWithEqual012(String s) {
        int z0 = 0;
        int z1 = 0;
        int z2 = 0;
        int ans = 0;

        HashMap<String, Integer> memo = new HashMap<String, Integer>();
        // this is key for 0#0
        // with freq as 1
        String key = (z1 - z0) + "#" + (z2 - z1);
        memo.put(key, 1);

        for (int i = 0; i < s.length(); i++) {
            // increasing o 1 2 count
            if (s.charAt(i) == '0') {
                z0 += 1;
            } else if (s.charAt(i) == '1') {
                z1 += 1;
            } else {
                z2 += 1;
            }
            // making new key
            key = (z1 - z0) + "#" + (z2 - z1);
            // if map contains key then find old freq
            // and put it in asnwer and after that only increase the old_freq
            if (memo.containsKey(key)) {
                int old_freq = memo.get(key);
                ans += old_freq;
                memo.put(key, old_freq + 1);
            } else {
                memo.put(key, 1);
            }
        }
        return ans;
    }
}