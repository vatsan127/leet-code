# LeetCode Interview Prep Project

## Project Structure
- Java 21 Maven project
- Package: `com.github`
- Solutions organized by category in separate packages

## Categories & Packages
- `arrays` - Arrays/Two Pointers
- `slidingwindow` - Sliding Window
- `binarysearch` - Binary Search
- `stack` - Stack
- `strings` - Strings
- `subarray` - Subarray (Kadane's/Prefix Sum)
- `heap` - Heap/Priority Queue
- `linkedlist` - Linked List
- `backtracking` - Backtracking
- `dp` - Dynamic Programming
- `hashmap` - HashMap/Frequency
- `math` - Math/Conversion
- `matrix` - Matrix
- `stocks` - Stocks

## Progress Tracking
- Problems listed in: `src/main/java/Notepad`
- Time complexity notes: `src/main/java/TimeComplexityNotes`

## Time Complexity Notes Structure
The TimeComplexityNotes file contains:
1. **5 Golden Rules:**
   - Rule 1: Drop Constants (O(2n) → O(n))
   - Rule 2: Drop Lower Order Terms (O(n² + n) → O(n²))
   - Rule 3: Different Inputs = Different Variables (O(a + b) not O(n))
   - Rule 4: Sequential = ADD, Nested = MULTIPLY
   - Rule 5: Identify What Changes (what controls iterations?)
2. **Visual comparisons** at different scales with tables
3. **Basic patterns:** O(1), O(log n), O(n), O(n log n), O(n²), O(2^n), O(n!)
4. **How to analyze code** step-by-step
5. **Space complexity** guide
6. **Practice problems** with answers

## Current Progress (46 problems total)

### Arrays/Two Pointers
- [x] 1. Two Sum
- [ ] 26. Remove Duplicates from Sorted Array
- [ ] 27. Remove Element
- [ ] 88. Merge Sorted Array
- [ ] 169. Majority Element
- [ ] 80. Remove Duplicates from Sorted Array II
- [ ] 167. Two Sum II - Input Array Is Sorted
- [ ] 15. 3Sum

### Sliding Window
- [ ] 3. Longest Substring Without Repeating Characters
- [ ] 209. Minimum Size Subarray Sum

### Binary Search
- [ ] 33. Search in Rotated Sorted Array
- [ ] 4. Median of Two Sorted Arrays

### Stack
- [ ] 20. Valid Parentheses
- [ ] 1541. Minimum Insertions to Balance a Parentheses String

### Strings
- [ ] 14. Longest Common Prefix
- [ ] 58. Length of Last Word
- [ ] 125. Valid Palindrome
- [ ] 392. Is Subsequence
- [ ] 5. Longest Palindromic Substring
- [ ] 3043. Find the Length of the Longest Common Prefix

### Subarray (Kadane's/Prefix Sum)
- [ ] 53. Maximum Subarray
- [ ] 724. Find Pivot Index
- [ ] 238. Product of Array Except Self
- [ ] 560. Subarray Sum Equals K
- [ ] 3105. Longest Strictly Increasing or Strictly Decreasing Subarray

### Heap/Priority Queue
- [ ] 215. Kth Largest Element in an Array
- [ ] 347. Top K Frequent Elements

### Linked List
- [ ] 141. Linked List Cycle
- [ ] 206. Reverse Linked List
- [ ] 2. Add Two Numbers
- [ ] 23. Merge k Sorted Lists

### Backtracking
- [ ] 46. Permutations
- [ ] 47. Permutations II
- [ ] 79. Word Search
- [ ] 212. Word Search II

### Dynamic Programming
- [ ] 516. Longest Palindromic Subsequence
- [ ] 42. Trapping Rain Water

### HashMap/Frequency
- [ ] 1207. Unique Number of Occurrences
- [ ] 1647. Minimum Deletions to Make Character Frequencies Unique

### Math/Conversion
- [ ] 13. Roman to Integer
- [ ] 268. Missing Number
- [ ] 12. Integer to Roman

### Matrix
- [ ] 36. Valid Sudoku

### Stocks
- [ ] 121. Best Time to Buy and Sell Stock

## Naming Convention
- Class name: `Problem{number}_{ProblemName}`
- Example: `Problem1_TwoSum.java`

## Solution Template
Each solution file should include:
1. LeetCode URL
2. Problem description with example
3. Related problems from Notepad
4. Multiple approaches with:
   - Step-by-step explanation
   - Time complexity breakdown (show how to calculate)
   - Space complexity
5. Test cases in main()

## Completed Solutions

### 1. Two Sum
- File: `com.github.arrays.Problem1_TwoSum`
- Approaches:
  1. HashMap: O(n) time, O(n) space
  2. Two Pointers: O(n log n) time, O(n) space
     - O(n) create array + O(n log n) sort + O(n) traversal = O(n log n)
- Related: 167 (sorted array), 15 (3Sum)
