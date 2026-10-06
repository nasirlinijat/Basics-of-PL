# Introduction
The task requires visualizing matrices and their slices in two languages, then comparing the results. All the files related to this experiment are placed under the code folder. The images generated throughout this experiment are also placed under the image folder.

## What is a matrix?
A matrix is a 2-dimensional array. In this experiment, the matrix is converted to colors to generate an image.

## Implementation
I used the arange and reshape methods of NumPy to generate a matrix containing numbers till 29. Then I used simple Python functionality to slice the matrix. This syntax is easy and short to implement. On the other hand, implementing the same task in Java was quite long and effortful. To get a slice of the given matrix, I had to iterate over the matrix and then generate the slice.

## Visualization
To visualize both Java and Python matrices, I have used Matplotlib. In the Python file, I have implemented both Java and Python matrix visualization logic. The Python matrix and slice are directly generated in that file. However, the Java matrix is first written into a CSV file, and then it is read from that file with Python code.

## Comparison
The main difference is that someone who wants to use a slice has to implement the slice-building logic too, rather than just focus on the task. Python has very user-friendly and direct functionality syntax.

Below I have just pasted the same task to ChatGPT and asked it to write a report in md file format. I specified using Java as a C-like language.

# ChatGPT response
## 1. Objective

The purpose of this task is to implement **2D matrix slicing** using:

1. Python with NumPy
2. Java as a C-like language

The same matrix and slicing boundaries are used in both implementations.  
The outputs are then compared to verify that both approaches produce the same result.

---

## 2. Original Matrix

For both implementations, the following 5 × 5 matrix is used:

```text
1   2   3   4   5
6   7   8   9  10
11 12  13  14  15
16 17  18  19  20
21 22  23  24  25
```

We want to extract:

- Rows with indices `1` to `3`
- Columns with indices `1` to `3`

Therefore, the expected sliced matrix is:

```text
7   8   9
12 13  14
17 18  19
```

---

## 3. NumPy Implementation

NumPy provides built-in slicing for multidimensional arrays.

```python
import numpy as np

matrix = np.array([
    [1,  2,  3,  4,  5],
    [6,  7,  8,  9, 10],
    [11, 12, 13, 14, 15],
    [16, 17, 18, 19, 20],
    [21, 22, 23, 24, 25]
])

sliced = matrix[1:4, 1:4]

print(sliced)
```

### NumPy Output

```text
[[ 7  8  9]
 [12 13 14]
 [17 18 19]]
```

In NumPy,

```python
matrix[1:4, 1:4]
```

means that rows `1, 2, 3` and columns `1, 2, 3` are selected.

The ending index `4` is **exclusive**.

---

## 4. Java Implementation

Java does not provide NumPy-style matrix slicing directly.  
Therefore, the required elements must be copied into a new 2D array.

```java
public class MatrixSlicing {

    public static int[][] slice(
            int[][] matrix,
            int rowStart,
            int rowEnd,
            int colStart,
            int colEnd) {

        int[][] result =
                new int[rowEnd - rowStart][colEnd - colStart];

        for (int i = rowStart; i < rowEnd; i++) {
            for (int j = colStart; j < colEnd; j++) {
                result[i - rowStart][j - colStart] = matrix[i][j];
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[][] matrix = {
            {1,  2,  3,  4,  5},
            {6,  7,  8,  9, 10},
            {11, 12, 13, 14, 15},
            {16, 17, 18, 19, 20},
            {21, 22, 23, 24, 25}
        };

        int[][] sliced = slice(matrix, 1, 4, 1, 4);

        for (int[] row : sliced) {
            for (int value : row) {
                System.out.printf("%3d ", value);
            }
            System.out.println();
        }
    }
}
```

### Java Output

```text
  7   8   9
 12  13  14
 17  18  19
```

The Java implementation follows the same rule as NumPy: the starting
indices are included while the ending indices are excluded.

---

## 5. Graphical Representation

The original matrix can be visualized as follows:

```text
                 COLUMNS
          0    1    2    3    4
       +----+----+----+----+----+
   0   |  1 |  2 |  3 |  4 |  5 |
       +----+----+----+----+----+
   1   |  6 | [7]| [8]| [9]| 10 |
       +----+----+----+----+----+
R  2   | 11 |[12]|[13]|[14]| 15 |
O      +----+----+----+----+----+
W  3   | 16 |[17]|[18]|[19]| 20 |
S      +----+----+----+----+----+
   4   | 21 | 22 | 23 | 24 | 25 |
       +----+----+----+----+----+

                 |
                 |  slice rows 1:4,
                 |  columns 1:4
                 v

            +----+----+----+
            |  7 |  8 |  9 |
            +----+----+----+
            | 12 | 13 | 14 |
            +----+----+----+
            | 17 | 18 | 19 |
            +----+----+----+
```

The values surrounded by brackets represent the selected area of the
original matrix.

---

## 6. Result Comparison

| Implementation | Result |
|---|---|
| NumPy | `[[7,8,9], [12,13,14], [17,18,19]]` |
| Java | `[[7,8,9], [12,13,14], [17,18,19]]` |

Both implementations produce exactly the same sliced matrix:

```text
7   8   9
12 13  14
17 18  19
```

---

## 7. Conclusion

2D matrix slicing is much more concise in NumPy because multidimensional
slicing is built directly into the library:

```python
matrix[1:4, 1:4]
```

Java arrays do not support this syntax. A similar operation requires
explicit loops that copy the selected elements into a new matrix.

Despite the implementation differences, both solutions produce the
same result for the given slicing boundaries.