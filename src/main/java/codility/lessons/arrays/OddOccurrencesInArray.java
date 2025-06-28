package codility.lessons.arrays;

import java.util.ArrayList;
import java.util.List;

public class OddOccurrencesInArray {

    public static void main(String[] args) {
        int[] arrays = {2, 3, 8, 9, 7, 6, 3, 8, 9, 7, 6, 2, 3, 8, 9, 7, 6, 3, 8, 9, 7, 6, 2, 9, 9, 12, 15, 26, 26, 15, 14, 12};
        System.out.println(rotateArray(arrays));
    }

    private static String rotateArray(int[] arrays) {
        int length = arrays.length;
        List<Integer> list = new ArrayList<>();
        for (int j = 0; j < length; j++) {
            if (j == 0) {
                list.add(arrays[j]);
            } else {
                if (list.contains(arrays[j])) {
                    list.remove((Integer) arrays[j]);
                } else {
                    list.add(arrays[j]);
                }
            }
        }
        return list.toString();
    }
}