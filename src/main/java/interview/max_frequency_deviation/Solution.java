package interview.max_frequency_deviation;

public class Solution {

    /**
     * Brute force solution gives O(n^3) time complexity
     * This solution optimized the search of max and min frequencies es in each substring from O(n) to O(1).
     *
     * It uses the fact that there are only 26 chars in the input.
     * We create a 2-d array with characters frequencies for each prefix in O(n * 26)
     */
    public int maxDeviation(String input) {
        int n = input.length();

        int[][] prefixMatrix = precomputePrefixLetterCount(input);

        int best = 0;
        for (int l=0; l<n; l++) {
            for (int r=l+1; r<n+1; r++) {
                int min = Integer.MAX_VALUE;
                int max = 0;
                for (int k=0; k<26; k++) {
                    int count = prefixMatrix[r][k] - prefixMatrix[l][k];
                    if (count != 0) {
                        min = Math.min(min, count);
                        max = Math.max(max, count);
                    }
                }
                best = Math.max(best, max - min);
            }
        }
        return best;
    }

    /**
     * There is a way to solve this problem in O(n * 26 * 26)
     *
     * The trick is to check each possible pair of letters where one is considered
     * the most frequent and another is the least frequent (26 * 26 combinations).
     * For each pair (max, min) we replace in the original string all max-letters with 1, all min-letters with -1,
     * all other letters with 0. Then use the Kadane's Algorithm to find the largest sum subarray
     *
     * Note that for (max, min) pair you calculate the sum only if 1 and -1 present after the replacement.
     */
    public int superOptimalMaxDeviation(String s) {
        return 0;
    }

    private int[][] precomputePrefixLetterCount(String s) {
        int n = s.length();
        int[][] prefixMatrix = new int[n+1][26];
        int padding = 'a';
        for (int j=0; j<26; j++) {
            char curr = (char) (padding + j);
            int count = 0;
            for (int i=1; i<n+1; i++) {
                if (s.charAt(i-1) == curr) {
                    count++;
                }
                prefixMatrix[i][j] = count;
            }
        }
        return prefixMatrix;
    }
}
