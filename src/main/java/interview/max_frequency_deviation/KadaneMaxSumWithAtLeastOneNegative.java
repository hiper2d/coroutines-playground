package interview.max_frequency_deviation;

/**
 * This is a slightly modified Kadane's Algorithm.
 * It makes sures that the max sum includes at least one "-1"
 */
public class KadaneMaxSumWithAtLeastOneNegative {
    public static int maxSumByKadaneAlgorithm(int[] t) {
        int bestMax = Integer.MIN_VALUE;
        int currentMax = 0;
        boolean hasMinus = false;
        for (int k: t) {
            if (k < 0) {
                hasMinus = true;
            }
            currentMax += k;
            if (bestMax < currentMax && hasMinus) {
                bestMax = currentMax;
            }
            if (currentMax < 0) {
                currentMax = 0;
                hasMinus = false;
            }
        }
        return bestMax;
    }

    public static void main(String[] args) {
        int[] input1 = {1, 0, 1, -1, 0};
        System.out.println(maxSumByKadaneAlgorithm(input1));

        int[] input2 = {-1, -1, 1, 0, -1, 3, -1, 2, 0};
        System.out.println(maxSumByKadaneAlgorithm(input2));
    }
}
