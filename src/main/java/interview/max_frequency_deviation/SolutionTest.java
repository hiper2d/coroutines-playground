package interview.max_frequency_deviation;

import java.util.function.Function;

public class SolutionTest {

    public static void main(String[] args) {
        Solution solution = new Solution();
        EasyTests.runAllTests(solution::superOptimalMaxDeviation);
        AdvancedTests.runAllTests(solution::superOptimalMaxDeviation);
    }

    private static class EasyTests {

        public static void runAllTests(Function<String, Integer> func) {
            testExample1(func);
            testExample2(func);
            testExample3(func);
            testExample4(func);
            testExample5(func);
            testExample6(func);
            testExample7(func);
            testExample8(func);
            testExample9(func);
        }

        private static void testExample1(Function<String, Integer> func) {
            String input = "bbacccabab";
            int expectedOut = 2;
            int actualOut = func.apply(input);
            printTestResult(input, expectedOut, actualOut);
        }

        private static void testExample2(Function<String, Integer> func) {
            String input = "aaaaaa";
            int expectedOut = 0;
            int actualOut = func.apply(input);
            printTestResult(input, expectedOut, actualOut);
        }

        private static void testExample3(Function<String, Integer> func) {
            String input = "abdbcdacbcadbbc";
            int expectedOut = 3;
            int actualOut = func.apply(input);
            printTestResult(input, expectedOut, actualOut);
        }

        private static void testExample4(Function<String, Integer> func) {
            String input = "cccaabbccc";
            int expectedOut = 4;
            int actualOut = func.apply(input);
            printTestResult(input, expectedOut, actualOut);
        }

        private static void testExample5(Function<String, Integer> func) {
            String input = "z";
            int expectedOut = 0;
            int actualOut = func.apply(input);
            printTestResult(input, expectedOut, actualOut);
        }

        private static void testExample6(Function<String, Integer> func) {
            String input = "acbbc";
            int expectedOut = 1;
            int actualOut = func.apply(input);
            printTestResult(input, expectedOut, actualOut);
        }

        private static void testExample7(Function<String, Integer> func) {
            String input = "baccabcbc";
            int expectedOut = 3;
            int actualOut = func.apply(input);
            printTestResult(input, expectedOut, actualOut);
        }

        private static void testExample8(Function<String, Integer> func) {
            String input = "beaffcabaecdeadccedaadaeddbfccfdfadcfbccebdbcdbcacbeecaabfccccddbcafcf";
            int expectedOut = 36;
            int actualOut = func.apply(input);
            printTestResult(input, expectedOut, actualOut);
        }

        private static void testExample9(Function<String, Integer> func) {
            String input = "bbacccababcabaaccbaaaaabaabccccacaaccbccbbabcabcacbbbcaabcccccaabca";
            int expectedOut = 41;
            int actualOut = func.apply(input);
            printTestResult(input, expectedOut, actualOut);
        }
    }

    private static class AdvancedTests {

        public static void runAllTests(Function<String, Integer> func) {
            testExample1(func);
        }

        private static void testExample1(Function<String, Integer> func) {
            String input = "lshpdygqfgdpxrvjafngxjibtlmkfpyyxyniiacatimnjhdbdcqnrwehmhlxsxrreiwgotl";
            int expectedOut = 88;
            int actualOut = func.apply(input);
            printTestResult(input, expectedOut, actualOut);
        }
    }

    private static void printTestResult(String input, int expectedOut, int actualOut) {
        if (actualOut == expectedOut) {
            System.out.printf("PASS: Input '%s', output: %s%n", input, expectedOut);
        } else {
            System.out.printf("FAIL: Input '%s', expected output: %s, actual output: %s%n", input, expectedOut, actualOut);
        }
    }
}
