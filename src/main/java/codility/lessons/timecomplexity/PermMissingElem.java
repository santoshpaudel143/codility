package codility.lessons.timecomplexity;

import java.util.Arrays;

public class PermMissingElem {

    public static void main(String[] args) {
        int[] arrays = {4, 5, 1, 2, 3, 8, 9, 7, 6};
        System.out.println(findMissionElement(arrays));
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
