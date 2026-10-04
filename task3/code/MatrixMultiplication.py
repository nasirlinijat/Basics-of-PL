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