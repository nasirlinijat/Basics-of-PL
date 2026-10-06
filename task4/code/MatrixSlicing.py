import numpy as np
import matplotlib.pyplot as plt
A = np.arange(30).reshape(5, 6)

fig, ax = plt.subplots(figsize=(4, 4))
# ax.imshow(A, cmap="viridis") 
# plt.show() 

Java = np.loadtxt("java_slice.csv", delimiter=",", dtype=int, ndmin=2)

slice = A[1:5, 0:3]

print(slice)

# ax.imshow(slice, cmap="viridis") 
ax.imshow(Java, cmap="viridis") 


plt.show() 