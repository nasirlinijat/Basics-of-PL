import java.io.IOException;
import java.io.PrintWriter;

public class MatrixSlicing {
    public static void main(String[] args) throws IOException {
        int[][] matrix = {
                { 0, 1, 2, 3, 4, 5 },
                { 6, 7, 8, 9, 10, 11 },
                { 12, 13, 14, 15, 16, 17 },
                { 18, 19, 20, 21, 22, 23 },
                { 24, 25, 26, 27, 28, 29 }
        };

        int[][] slice = sliceMatrix(matrix, 1, 5, 0, 3);

        for (int i = 0; i < slice.length; i++) {
            for (int j = 0; j < slice[i].length; j++) {
                System.out.print(slice[i][j] + " ");
            }
            System.out.println();
        }

        try (PrintWriter pw = new PrintWriter("./java_slice.csv")) {
            for (int[] row : slice) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < row.length; j++) {
                    if (j > 0) sb.append(",");
                    sb.append(row[j]);
                }
                pw.println(sb);
            }
        }
    }

    public static int[][] sliceMatrix(int[][] m, int r0, int r1, int c0, int c1) {
        int[][] result = new int[r1 - r0][c1 - c0];
        for (int i = r0; i < r1; i++)
            for (int j = c0; j < c1; j++)
                result[i - r0][j - c0] = m[i][j];
        return result;
    }
}