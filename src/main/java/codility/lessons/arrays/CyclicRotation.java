package codility.lessons.arrays;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;

public class CyclicRotation {

    public static void main(String[] args) {
//        int[] arrays = {3, 8, 9, 7, 6};
        int start = -1000000;
        int end = 1000000;
        int i1 = Math.abs(start) + Math.abs(end)+1;
        int[] arrays = new int[i1];
        for (int i = 0; i < i1; i++) {
            arrays[i] = start+i;
        }
        int round = 100;
        LocalDateTime startTime = LocalDateTime.now();
        System.out.println(startTime);
        System.out.println(rotateArray(arrays, round));
        LocalDateTime endTime = LocalDateTime.now();
        System.out.println(endTime);
        System.out.println(Duration.between(startTime, endTime));
        System.out.println(Duration.between(startTime, endTime).toMillis());
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