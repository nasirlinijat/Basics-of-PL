# Introduction

In this experiment, a tuple and a list with different numbers of elements are given. The `__sizeof__()` method is used to observe how much memory they use and how their size changes when elements are added.

# Experiment

First, the given tuple and list were tested with 3 elements.

```python
tpl = (1, 2, 3)

print(tpl.__sizeof__())

lst = [1, 2, 3]

print(lst.__sizeof__())
```

The result was:

```text
56
72
```

Then, I increased the number of elements by one:

```python
tpl = (1, 2, 3, 4)

print(tpl.__sizeof__())

lst = [1, 2, 3, 4]

print(lst.__sizeof__())
```

The result was:

```text
64
72
```

Then, I added one more element:

```python
tpl = (1, 2, 3, 4, 5)

print(tpl.__sizeof__())

lst = [1, 2, 3, 4, 5]

print(lst.__sizeof__())
```

The result was:

```text
72
88
```

Then, I added one more element:

```python
tpl = (1, 2, 3, 4, 5, 6)

print(tpl.__sizeof__())

lst = [1, 2, 3, 4, 5, 6]

print(lst.__sizeof__())
```

The result was:

```text
80
88
```

Then, I added one more element:

```python
tpl = (1, 2, 3, 4, 5, 6, 7)

print(tpl.__sizeof__())

lst = [1, 2, 3, 4, 5, 6, 7]

print(lst.__sizeof__())
```

The result was:

```text
88
104
```

Finally, I added one more element:

```python
tpl = (1, 2, 3, 4, 5, 6, 7, 8)

print(tpl.__sizeof__())

lst = [1, 2, 3, 4, 5, 6, 7, 8]

print(lst.__sizeof__())
```

The result was:

```text
96
104
```

The results are:

| Number of elements | Tuple size | List size |
| -----------------: | ---------: | --------: |
|                  3 |   56 bytes |  72 bytes |
|                  4 |   64 bytes |  72 bytes |
|                  5 |   72 bytes |  88 bytes |
|                  6 |   80 bytes |  88 bytes |
|                  7 |   88 bytes | 104 bytes |
|                  8 |   96 bytes | 104 bytes |

# Observation

From the results, it can be observed that the tuple size increases by 8 bytes every time a new element is added. The list behaves differently. Its size does not increase after every new element. For example, it stays at 72 bytes when increasing from 3 to 4 elements, and stays at 88 bytes when increasing from 5 to 6 elements.

The tuple sizes follow this pattern:

```text
56 → 64 → 72 → 80 → 88 → 96
```

The list sizes follow this pattern:

```text
72 → 72 → 88 → 88 → 104 → 104
```

# Explanation

The main reason for this difference is that tuples and lists manage their memory differently. A tuple is immutable, so its size is fixed when it is created. When a tuple has another element, a new tuple with a different size has to be created. In this experiment, each element increased the tuple size by 8 bytes.

A list is mutable, so Python allows elements to be added or removed. To make adding elements more efficient, Python usually reserves some extra space for a list. Because of this, the size of a list does not have to increase every time a new element is added. When the reserved space is not enough, Python allocates more space, which causes the size to increase.

Another important point is that `__sizeof__()` shows the size of the container itself. It does not include the memory used by the objects stored inside the tuple or list. In this experiment, the integers are stored as separate Python objects.

# Conclusion

This experiment shows that tuples and lists can store the same elements but manage memory differently. The tuple size increased by 8 bytes for each additional element, while the list size increased in jumps because it can reserve extra space for future elements.

Therefore, tuples are generally more memory-efficient for fixed collections, while lists are more suitable when the number of elements needs to change.
