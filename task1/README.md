# Introduction

Endianness is how bytes are arranged in computer memory. Big-endian and Little-endian are rules for arranging those bytes in two different orders. This can be explained using a 32-bit integer - `0x12345678`. Two terminologies, MSB (Most Significant Byte) and LSB (Least Significant Byte), can be understood as the byte that has the highest or lowest significance. In comparison to a base-10 number, let's say `15898` - here `1` is the most significant digit as it is `1 × 10000`.

## Why byte order matters in computers

Byte order matters a lot because the machine reads those bytes in sequence. If they are read in a different order, this may result in a different value or an error.

## Big-Endian

This rule tells machines to arrange the MSB at the lowest memory address.

`12(MSB), 34, 56, 78(LSB)`

| Address | Value |
| ------- | ----- |
| 0x1000  | 12    |
| 0x1001  | 34    |
| 0x1002  | 56    |
| 0x1003  | 78    |

## Little-Endian

This rule tells machines to arrange the LSB at the lowest memory address.

`12(MSB), 34, 56, 78(LSB)`

| Address | Value |
| ------- | ----- |
| 0x1000  | 78    |
| 0x1001  | 56    |
| 0x1002  | 34    |
| 0x1003  | 12    |

## Comparison

Both Big-Endian and Little-Endian can store the same value, but they arrange the bytes in different orders. Little-Endian is commonly used in modern computers, especially x86 and x86-64 processors. Big-Endian is commonly used in network communication, where it is called network byte order.

Neither of them is necessarily better than the other. The important thing is that the system knows which byte order is being used. If two systems use different byte orders and do not convert the data correctly, they can read the same bytes as a different value.

## Critique
In my opinion, endianness is not difficult to understand, but it can become an important problem when different systems exchange binary data. For this reason, knowing the byte order is important when working with low-level programming and computer networks.
