package codility.lessons.arrays;

import java.util.Arrays;

public class CyclicRotation {

    public static void main(String[] args) {
        int[] arrays = {3, 8, 9, 7, 6};
        int round = 0;
        System.out.println(rotateArray(arrays, round));
    }

    private static String rotateArray(int[] arrays, int round) {
        if (round == 0)
            return Arrays.toString(arrays);
        int[] storage = new int[arrays.length];
        for (int i = 0; i < round; i++) {
            if (i != 0) {
                arrays = storage.clone();
            }
            int length = arrays.length;
            for (int j = 0; j < length; j++) {
                if (j == 0) {
                    storage[0] = arrays[length - (1 + j)];
                } else {
                    storage[j] = arrays[j - 1];
                }
            }
        }
        return Arrays.toString(storage);
    }

}
