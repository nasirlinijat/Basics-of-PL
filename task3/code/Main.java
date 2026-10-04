public class Main {

    public static void main(String[] args) {
        int[][] A = {
                {1, 2},
                {3, 4}
        };

        int[][] B = {
                {5, 6},
                {7, 8}
        };

        long start = System.nanoTime();

        int[][] C = MatrixMultiplication.multiply(A, B);

        long end = System.nanoTime();

        System.out.println("Result of Matrix Multiplication:");
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < C[0].length; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Execution time: " + (end - start) + " ns");
    }
}