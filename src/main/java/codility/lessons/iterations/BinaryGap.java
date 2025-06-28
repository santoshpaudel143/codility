package codility.lessons.iterations;

public class BinaryGap {

    public static void main(String[] args) {
        String binary = convertToBase2(1041);
        System.out.println(binary);
        int maxGap = getMaxGap(binary);
        System.out.println(maxGap);
    }

    private static int getMaxGap(String binary) {
        int counter;
        int finalCount = 0;
        StringBuilder storage = new StringBuilder();
        for (int i = 0; i < binary.length(); i++) {
            char char2 = binary.charAt(i);
            String previous = i == 0 ? "2" : String.valueOf(binary.charAt(i - 1));
            if (previous.equals("2")) {
                storage.append(char2);
            } else {
                if (previous.equals("1")) {
                    counter = storage.length() - 1;
                    if (finalCount < counter) {
                        finalCount = counter;
                    }
                    storage = new StringBuilder();
                    storage.append(char2);
                } else {
                    storage.append(char2);
                }
            }
        }
        return finalCount;
    }


    private static String convertToBase2(int base10) {
        return Integer.toBinaryString(base10);
    }

}
