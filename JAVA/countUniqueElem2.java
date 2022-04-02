import java.util.*;

class countUniqueElem2 {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int arr[] = { 1, 2, 3, 4, 5, -1, 0, 2, 3, 4, 5 };

        for (int key : arr) {
            if (map.containsKey(key)) {
                int frequency = map.get(key);
                map.put(key, frequency + 1);
            } else {
                map.put(key, 1);
            }
        }
        int count = 0;
        for (Integer key : map.keySet()) {
            int frequency = map.get(key);
            if (frequency == 1) {
                System.out.println("KEY : " + key + "  VALUE :" + frequency);
                count++;
            }
        }

        System.out.println("COUNT = " + count);
    }
}
