# Introduction

In this experiment, matrix multiplication is implemented using Python with NumPy and Java. The purpose is to compare the two implementations and analyze their code size and execution time. A unit test is also written for the Java implementation to make sure that the multiplication gives the correct result.

## How To Test Yourself

Open a terminal and go to the `code` folder:

```bash
cd code
```

### Java (macOS / Linux / Windows)

```bash
javac FileName.java
java FileName
```

### Python

| Environment | Command |
|-------------|---------|
| macOS / Linux | `python3 FileName.py` |
| Windows | `python FileName.py` |

# NumPy Implementation

First, matrix multiplication was implemented using NumPy. NumPy provides the `@` operator for matrix multiplication.

```python
import numpy as np
import time

A = np.array([
    [1, 2],
    [3, 4]
])

B = np.array([
    [5, 6],
    [7, 8]
])

start = time.perf_counter()

C = A @ B

end = time.perf_counter()

print(C)
print("Execution time:", (end - start) * 1_000_000, "microseconds")
```

The result was:

```text
[[19 22]
 [43 50]]
```

The measured execution time in my experiment was approximately **173.67 microseconds**.

# Java Implementation

The same matrix multiplication was implemented in Java using three nested loops.

```java
public class MatrixMultiplication {

    public static int[][] multiply(int[][] A, int[][] B) {
        int rowsA = A.length;
        int colsA = A[0].length;
        int colsB = B[0].length;

        int[][] C = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return C;
    }
}
```

For the same matrices, the result was:

```text
19 22
43 50
```

The execution time measured in my experiment was approximately **10,942,417 nanoseconds**, or about **10.94 milliseconds**.

# Unit Testing

A simple unit test was written for the Java implementation without using an external testing framework. The test compares the expected matrix with the actual result.

```java
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
```

The test passed successfully, which shows that the Java implementation produces the expected result for this test case.

# Code Size

The Java implementation uses more code because the matrix multiplication has to be implemented manually using nested loops.

The NumPy implementation is much shorter because NumPy already provides matrix multiplication functionality through the `@` operator.

Therefore, NumPy requires less code to perform the same operation, while Java gives more direct control over how the multiplication is implemented.

# Execution Time

For the small `2 × 2` matrix used in the experiment, the measured results were:

| Implementation | Execution time |
| -------------- | -------------: |
| Java           |  10,942,417 ns |
| NumPy          |      173.67 μs |

The Java result is approximately **10.94 ms**, while the NumPy result is approximately **0.174 ms**.

However, these results should not be considered a complete performance comparison because the matrices are very small. The execution time can also be affected by program startup and other overhead.

NumPy also uses optimized native code internally, while the Java implementation uses a simple three-loop algorithm.

# Complexity Analysis

For an `n × n` matrix, the standard matrix multiplication algorithm uses three nested loops. Therefore, its time complexity is:

**O(n³)**

For example, a `100 × 100` matrix requires approximately:

```text
100³ = 1,000,000
```

multiplication operations.

A `1000 × 1000` matrix requires approximately:

```text
1000³ = 1,000,000,000
```

multiplication operations.

Both implementations perform matrix multiplication, but NumPy uses optimized internal implementations, which can make it much faster in practice.

# Conclusion

In this experiment, matrix multiplication was implemented using both NumPy and Java. The Java implementation was also tested using a simple unit test, and the test passed successfully.

The NumPy implementation required less code because the matrix multiplication is provided by the library. The Java implementation required more code because the multiplication was implemented manually using nested loops.

Both approaches have **O(n³)** time complexity for the standard matrix multiplication algorithm. In the small experiment, NumPy was faster than the Java implementation, but a larger benchmark would be needed for a more reliable performance comparison.

Below I have just pasted the same task to ChatGPT and asked it to write a report in md file format. I specified using Java as a C-like language.


## ChatGPT Implementation

After completing my own implementation of Task 3, I asked ChatGPT to solve the same task independently. I used Java as the C-like language and asked for an implementation using NumPy and Java, unit testing for the Java implementation, and an analysis of code size and execution time.

ChatGPT proposed using NumPy's `np.matmul()` function for the Python implementation. This made the NumPy solution very short because the matrix multiplication algorithm is already implemented inside the NumPy library.

For Java, ChatGPT implemented matrix multiplication manually using three nested loops. The loops iterate through the rows of the first matrix, the columns of the second matrix, and the elements needed to calculate each result value.

For testing, ChatGPT suggested using **JUnit 5**. It proposed testing normal matrix multiplication, multiplication by an identity matrix, multiplication by a zero matrix, and matrices with incompatible dimensions. These tests were intended to verify both the correctness of the multiplication and the handling of invalid input.

ChatGPT also compared the code size of the two implementations. It explained that the NumPy version requires much less code because the matrix multiplication operation is provided by the library, while the Java version requires the multiplication algorithm to be written manually.

For performance analysis, ChatGPT explained that both standard implementations have approximately **O(n³)** time complexity for square matrices. It suggested measuring matrices of different sizes, such as 100×100, 250×250, 500×500, and 1000×1000. It also explained that NumPy is generally expected to perform faster because it uses optimized low-level numerical libraries.

The response provided a general solution and explanation rather than specific benchmark results. Therefore, actual execution times would still need to be measured on the computer used for the experiment.

Overall, ChatGPT solved the task by separating it into four main parts: NumPy implementation, Java implementation, unit testing, and performance/code-size analysis. The response provided a useful independent approach that could be compared with my own implementation.
