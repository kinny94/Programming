# Running Times of Common Functions (from Skiena's Algorithm Design Manual)

This table shows the running times of common functions measured in seconds, as presented in Steven Skiena's "The Algorithm Design Manual" (converted from nanoseconds).

## Running Times Table (in seconds)

| Function | n=10 | n=100 | n=1,000 | n=10,000 | n=100,000 | n=1,000,000 | n=1,000,000,000 |
|----------|------|-------|---------|----------|-----------|-------------|-----------------|
| **O(1)** | 1×10⁻⁹ | 1×10⁻⁹ | 1×10⁻⁹ | 1×10⁻⁹ | 1×10⁻⁹ | 1×10⁻⁹ | 1×10⁻⁹ |
| **O(log n)** | 3×10⁻⁹ | 7×10⁻⁹ | 1×10⁻⁸ | 1.3×10⁻⁸ | 1.7×10⁻⁸ | 2×10⁻⁸ | 3×10⁻⁸ |
| **O(√n)** | 3×10⁻⁹ | 1×10⁻⁸ | 3.2×10⁻⁸ | 1×10⁻⁷ | 3.16×10⁻⁷ | 1×10⁻⁶ | 3.16×10⁻⁵ |
| **O(n)** | 1×10⁻⁸ | 1×10⁻⁷ | 1×10⁻⁶ | 1×10⁻⁵ | 1×10⁻⁴ | 1×10⁻³ | 1 |
| **O(n log n)** | 3.3×10⁻⁸ | 6.64×10⁻⁷ | 1×10⁻⁵ | 1.33×10⁻⁴ | 1.66×10⁻³ | 2×10⁻² | 30 |
| **O(n²)** | 1×10⁻⁷ | 1×10⁻⁵ | 1×10⁻³ | 0.1 | 10 | 1,000 | 10⁹ |
| **O(n³)** | 1×10⁻⁶ | 1×10⁻³ | 1 | 1,000 | 10⁶ | 10⁹ | 10¹⁸ |
| **O(2ⁿ)** | 1.024×10⁻⁶ | 10²¹ | 10²⁹² | 10³,001 | 10³⁰,094 | 10³⁰¹,021 | 10³⁰¹,020,888 |
| **O(n!)** | 3.63×10⁻³ | 10¹⁴⁹ | 10²,559 | 10³⁵,650 | 10⁴⁵⁶,565 | 10⁵,565,700 | 10⁸,565,696,938 |

## Notes:

1. **O(1)**: Constant time operations (e.g., array access, hash table lookup)
2. **O(log n)**: Logarithmic operations (e.g., binary search)
3. **O(√n)**: Square root operations
4. **O(n)**: Linear operations (e.g., scanning an array)
5. **O(n log n)**: Linearithmic operations (e.g., efficient sorting algorithms like merge sort, heap sort)
6. **O(n²)**: Quadratic operations (e.g., nested loops, bubble sort)
7. **O(n³)**: Cubic operations (e.g., matrix multiplication)
8. **O(2ⁿ)**: Exponential operations (e.g., brute force solutions)
9. **O(n!)**: Factorial operations (e.g., generating all permutations)

## Practical Implications:

- **n=1,000,000**: 
  - O(n log n) ≈ 20 seconds
  - O(n²) ≈ 2.7 hours
  - O(n³) ≈ 3,000 years

- **n=1,000,000,000**:
  - O(n log n) ≈ 30 seconds
  - O(n²) ≈ 31 years
  - O(n³) ≈ 31,000,000 years

## Key Takeaways:

1. **Constant and logarithmic** functions scale very well
2. **Linear** functions are acceptable for most practical purposes
3. **Linearithmic** (n log n) is the sweet spot for many efficient algorithms
4. **Quadratic** and higher polynomial complexities become impractical for large inputs
5. **Exponential** and **factorial** complexities are generally infeasible except for very small inputs

---

*Reference: "The Algorithm Design Manual" by Steven S. Skiena, 3rd Edition*

