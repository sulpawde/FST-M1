import java.util.Arrays;

public class Activity2 {

    public static void main(String[] args) {

        int[] myArray = { 10, 77, 10, 54, -11, 10 };
        System.out.println("Original Array: " + Arrays.toString(myArray));

        int searchNumber = 10;
        int checkSum = 30;
        boolean result;

        result = verifySumMatchForNumber(myArray, searchNumber, checkSum);
        System.out
                .println("search for number: " + searchNumber + " check for sum : " + checkSum + " Result: " + result);
    }

    public static boolean verifySumMatchForNumber(int[] inArray, int sNum, int vSum) {
        int temp_sum = 0;
        for (int number : inArray) {
            if (number == sNum)
                temp_sum = temp_sum + sNum;

            if (temp_sum > vSum)
                break;

        }
        return (temp_sum == vSum);
    }

}
