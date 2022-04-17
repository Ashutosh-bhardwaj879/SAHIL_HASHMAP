//https://www.lintcode.com/problem/substring-with-at-least-k-distinct-characters/description
import java.util.*;

class LintCode1375 {
    public long kDistinctCharacters(String s, int k) {
        // Write your code here
        long ans = AtMostkDistinctCharacters(s, k - 1);
        long n = s.length();
        long totalSubstringofString = n * (n + 1) / 2;
        // for atleast k we have to subtract (all substring) count from (at most k)
        return (totalSubstringofString - ans);
    }

    private long AtMostkDistinctCharacters(String s, int k) {
        HashMap<Character, Integer> memo = new HashMap<>();
        long ans = 0;
        int release = 0;
        long distinct = 0;
        long n = s.length();

        for (int acq = 0; acq < n; acq++) {
            Character currentChar = s.charAt(acq);

            if (memo.containsKey(currentChar)) {
                memo.put(currentChar, memo.get(currentChar) + 1);
            } else {
                memo.put(currentChar, 1);
                distinct += 1;
            }

            while (release <= acq && distinct > k) {
                Character discard = s.charAt(release);
                memo.put(discard, memo.get(discard) - 1);

                if (memo.get(discard) == 0) {
                    memo.remove(discard);
                    distinct -= 1;
                }

                release += 1;
            }

            ans += (acq - release + 1);
        }
        return ans;
    }
}