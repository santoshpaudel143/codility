package codility.lessons.timecomplexity;

public class FrogJmp {

    public static void main(String[] args) {
        int x = 10;// frog initial position
        int y = 100;// frog target
        int d = 1;// frog can jump
        System.out.println(frogJumpCount(x, y, d));
    }

    private static int frogJumpCount(int x, int y, int d) {
        if (x >= y)
            return 0;
        else {
            int count = 0;
            for (int i = 0; x <= y; i++) {
                x = x + d;
                count++;
            }
            return count;
        }
    }
}