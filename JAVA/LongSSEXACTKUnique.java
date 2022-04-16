import java.util.*;

//Longest K unique characters substring
//https://practice.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1/
class LongestKUniqueCharactersSubstring {
    public int longestkSubstr(String s, int k) {
        int n = s.length();
        HashMap<Character, Integer> memo = new HashMap<>();
        int release = 0;
        int answer = 0;
        int distinct = 0;

        for (int acq = 0; acq < n; acq++) {
            Character currentChar = s.charAt(acq);
            if (memo.containsKey(currentChar)) {
                // char present increase its freq only
                // no harm in it since it wont inc the distinct //count
                memo.put(currentChar, memo.get(currentChar) + 1);
            } else {
                // fresh char found ake its freq 1 also //increase distinct count by 1
                memo.put(currentChar, 1);
                distinct += 1;
            }

            // while loop for releaseing elemnt
            // we have to remove char till the distinct count //is greater than k
            while (release <= acq && distinct > k) {

                Character discardChar = s.charAt(release);
                // decreasing the freq
                memo.put(discardChar, memo.get(discardChar) - 1);
                // if freq becomes 0 then remove from map
                if (memo.get(discardChar) == 0) {
                    memo.remove(discardChar);
                    distinct -= 1;
                }
                release += 1;
            }
            if (distinct == k) {
                answer = Math.max(answer, acq - release + 1);
            }
        }

        return answer == 0 ? -1 : answer;
    }
}