public class MatrixMultiplicationTest {

    static void checkMatrix(int[][] expected, int[][] actual) {
        if (expected.length != actual.length) {
            throw new AssertionError("Different number of rows");
        }

        for (int i = 0; i < expected.length; i++) {
            if (expected[i].length != actual[i].length) {
                throw new AssertionError("Different number of columns");
            }

            for (int j = 0; j < expected[i].length; j++) {
                if (expected[i][j] != actual[i][j]) {
                    throw new AssertionError(
                        "Expected " + expected[i][j] +
                        ", but got " + actual[i][j]
                    );
                }
            }
        }
    }

    static void testTwoByTwo() {
        int[][] A = {
            {1, 2},
            {3, 4}
        };

        int[][] B = {
            {5, 6},
            {7, 8}
        };

        int[][] expected = {
            {19, 22},
            {43, 50}
        };

        int[][] actual = MatrixMultiplication.multiply(A, B);

        checkMatrix(expected, actual);

        System.out.println("testTwoByTwo: PASSED");
    }

    public static void main(String[] args) {
        testTwoByTwo();
    }
}