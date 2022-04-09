import java.util.*;
//https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/count-of-substrings-having-all-unique-characters-official/ojquestion
class countSSAlUniqChar {

    public static int solution(String s) {
        int ans = 0;
        HashMap<Character, Integer> memo = new HashMap<>();
        int release = 0;

        for (int acq = 0; acq < s.length(); acq++) {

            Character currentChar = s.charAt(acq);

            while (release < acq && memo.containsKey(currentChar)) {
                Character disChar = s.charAt(release);
                memo.remove(disChar);
                release++;
            }
            memo.put(currentChar, 1);

            ans += (acq - release) + 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(solution(str));
        scn.close();
    }

}