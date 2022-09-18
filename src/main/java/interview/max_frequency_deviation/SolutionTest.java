package interview.max_frequency_deviation;

public class SolutionTest {

    public static void main(String[] args) {
        EasyTests.runAllTests();
        AdvancedTests.runAllTests();
    }

    private static class EasyTests {

        private final static Solution solution = new Solution();

        public static void runAllTests() {
            testExample1();
            testExample2();
            testExample3();
            testExample4();
            testExample5();
            testExample6();
            testExample7();
            testExample8();
            testExample9();
        }

        private static void testExample1() {
            String input = "bbacccabab";
            int expectedOut = 2;
            int actualOut = solution.maxDeviation(input);
            printTestResult(input, expectedOut, actualOut);
        }

        private static void testExample2() {
            String input = "aaaaaa";
            int expectedOut = 0;
            int actualOut = solution.maxDeviation(input);
            printTestResult(input, expectedOut, actualOut);
        }

        private static void testExample3() {
            String input = "abdbcdacbcadbbc";
            int expectedOut = 3;
            int actualOut = solution.maxDeviation(input);
            printTestResult(input, expectedOut, actualOut);
        }

        private static void testExample4() {
            String input = "cccaabbccc";
            int expectedOut = 4;
            int actualOut = solution.maxDeviation(input);
            printTestResult(input, expectedOut, actualOut);
        }

        private static void testExample5() {
            String input = "z";
            int expectedOut = 0;
            int actualOut = solution.maxDeviation(input);
            printTestResult(input, expectedOut, actualOut);
        }

        private static void testExample6() {
            String input = "acbbc";
            int expectedOut = 1;
            int actualOut = solution.maxDeviation(input);
            printTestResult(input, expectedOut, actualOut);
        }

        private static void testExample7() {
            String input = "baccabcbc";
            int expectedOut = 3;
            int actualOut = solution.maxDeviation(input);
            printTestResult(input, expectedOut, actualOut);
        }

        private static void testExample8() {
            String input = "beaffcabaecdeadccedaadaeddbfccfdfadcfbccebdbcdbcacbeecaabfccccddbcafcf";
            int expectedOut = 36;
            int actualOut = solution.maxDeviation(input);
            printTestResult(input, expectedOut, actualOut);
        }

        private static void testExample9() {
            String input = "bbacccababcabaaccbaaaaabaabccccacaaccbccbbabcabcacbbbcaabcccccaabca";
            int expectedOut = 41;
            int actualOut = solution.maxDeviation(input);
            printTestResult(input, expectedOut, actualOut);
        }
    }

    private static class AdvancedTests {

        private final static Solution solution = new Solution();

        public static void runAllTests() {
            testExample1();
        }

        private static void testExample1() {
            String input = "lshpdygqfgdpxrvjafngxjibtlmkfpyyxyniiacatimnjhdbdcqnrwehmhlxsxrreiwgotl";
            int expectedOut = 88;
            int actualOut = solution.maxDeviation(input);
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
