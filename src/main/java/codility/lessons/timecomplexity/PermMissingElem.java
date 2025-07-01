package codility.lessons.timecomplexity;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;

public class PermMissingElem {

    public static void main(String[] args) {
//        int[] arrays = {4, 5, 1, 2, 3, 8, 9, 7, 6};
        int start = 1;
        int end = 100000;
        int i1 = Math.abs(start) + Math.abs(end)+1;
        int[] arrays = new int[i1];
        for (int i = 0; i < i1; i++) {
            arrays[i] = start+i;
        }
        LocalDateTime startTime = LocalDateTime.now();
        System.out.println(startTime);
        System.out.println(findMissionElement(arrays));
        LocalDateTime endTime = LocalDateTime.now();
        System.out.println(endTime);
        System.out.println(Duration.between(startTime, endTime));
        System.out.println(Duration.between(startTime, endTime).toMillis());
    }

    private static int findMissionElement(int[] arrays) {
        int[] sorted = Arrays.stream(arrays).sorted().toArray();
        int count = 1;
        for (int j : sorted) {
            if (count == sorted.length) {
                count = 0;
                break;
            }
            if (count == j)
                count++;
            else
                break;
        }
        return count;
    }
}
