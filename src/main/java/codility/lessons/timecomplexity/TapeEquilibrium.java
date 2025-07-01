package codility.lessons.timecomplexity;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;

public class TapeEquilibrium {

    public static void main(String[] args) {
//        int[] arrays = {4, 5, 1, 2, 3, 8, 9, 7, 6,4, 5, 1, 2, 3, 8, 9, 7, 6,4, 5, 1, 2, 3, 8, 9, 7, 6,4, 5, 1, 2, 3, 8, 9, 7, 6,4, 5, 1, 2, 3, 8, 9, 7, 6};
//        int[] arrays = {3, 1, 2, 4, 3};
        int start = -10000000;
        int end = 10000000;
        int i1 = Math.abs(start) + Math.abs(end)+1;
        int[] arrays = new int[i1];
        for (int i = 0; i < i1; i++) {
            arrays[i] = start+i;
        }
        LocalDateTime startTime = LocalDateTime.now();
        System.out.println(startTime);
        System.out.println(findMinimalDifference(arrays));
        LocalDateTime endTime = LocalDateTime.now();
        System.out.println(endTime);
        System.out.println(Duration.between(startTime, endTime));
        System.out.println(Duration.between(startTime, endTime).toMillis());
    }

    private static int findMinimalDifference(int[] arrays) {
        int totalSum = Arrays.stream(arrays).sum();
        int leftSum = arrays[0];
        int minimalDifference = Integer.MAX_VALUE;
        for (int array : arrays) {
            leftSum = leftSum + array;
            int rightSum = totalSum-leftSum;
            int difference = Math.abs(leftSum-rightSum);
            minimalDifference = Math.min(minimalDifference, difference);
        }
        return minimalDifference;
    }
}
