package com.github.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum
 * https://leetcode.com/problems/two-sum/
 *
 * Problem:
 * Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add up to target.
 *
 * Example:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: nums[0] + nums[1] = 2 + 7 = 9
 *
 * Related Problems:
 * - 167. Two Sum II - Input Array Is Sorted (array already sorted, use Two Pointers O(n))
 * - 15. 3Sum (find triplets that sum to zero)
 */
public class Problem1_TwoSum {

    /**
     * Approach 1: HashMap (Optimal for unsorted array)
     *
     * - For each number, check if (target - number) exists in map
     * - If yes, we found our pair
     * - If no, store current number and its index in map
     *
     * Time Complexity: O(n) - single pass through array
     * Space Complexity: O(n) - HashMap stores up to n elements
     */
    public int[] twoSumHashMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();  // value -> index

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            map.put(nums[i], i);
        }

        return new int[] {};  // no solution found
    }

    /**
     * Approach 2: Two Pointers (Requires sorting)
     *
     * - Store original indices with values
     * - Sort the array
     * - Use two pointers: left (start) and right (end)
     * - If sum < target: move left pointer right (need bigger sum)
     * - If sum > target: move right pointer left (need smaller sum)
     * - If sum == target: found the pair
     *
     * Time Complexity Breakdown:
     * -------------------------
     * Step 1: Create numWithIndex array     → O(n)
     * Step 2: Sort the array                → O(n log n)  [Arrays.sort uses dual-pivot quicksort]
     * Step 3: Two pointer traversal         → O(n)        [each pointer moves at most n times]
     *
     * Total: O(n) + O(n log n) + O(n) = O(n log n)
     * Why? The highest order term dominates. n log n > n, so we drop O(n)
     *
     * Space Complexity: O(n) - to store index pairs
     *
     * Note: If array is already sorted (like Problem 167), skip sorting → O(n)
     */
    public int[] twoSumTwoPointers(int[] nums, int target) {
        // Store [value, originalIndex] pairs
        int[][] numWithIndex = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            numWithIndex[i][0] = nums[i];      // value
            numWithIndex[i][1] = i;            // original index
        }

        // Sort by value
        Arrays.sort(numWithIndex, (a, b) -> a[0] - b[0]);

        // Two pointers
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = numWithIndex[left][0] + numWithIndex[right][0];

            if (sum == target) {
                // Return original indices (smaller index first)
                int idx1 = numWithIndex[left][1];
                int idx2 = numWithIndex[right][1];
                return new int[] { Math.min(idx1, idx2), Math.max(idx1, idx2) };
            } else if (sum < target) {
                left++;    // need bigger sum, move left pointer right
            } else {
                right--;   // need smaller sum, move right pointer left
            }
        }

        return new int[] {};  // no solution found
    }

    public static void main(String[] args) {
        Problem1_TwoSum solution = new Problem1_TwoSum();

        int[] nums1 = {2, 7, 11, 15};
        int[] nums2 = {3, 2, 4};
        int[] nums3 = {3, 3};

        System.out.println("=== HashMap Approach O(n) ===");
        int[] r1 = solution.twoSumHashMap(nums1.clone(), 9);
        System.out.println("Test 1: [" + r1[0] + ", " + r1[1] + "]");  // [0, 1]

        int[] r2 = solution.twoSumHashMap(nums2.clone(), 6);
        System.out.println("Test 2: [" + r2[0] + ", " + r2[1] + "]");  // [1, 2]

        int[] r3 = solution.twoSumHashMap(nums3.clone(), 6);
        System.out.println("Test 3: [" + r3[0] + ", " + r3[1] + "]");  // [0, 1]

        System.out.println("\n=== Two Pointers Approach O(n log n) ===");
        int[] r4 = solution.twoSumTwoPointers(nums1.clone(), 9);
        System.out.println("Test 1: [" + r4[0] + ", " + r4[1] + "]");  // [0, 1]

        int[] r5 = solution.twoSumTwoPointers(nums2.clone(), 6);
        System.out.println("Test 2: [" + r5[0] + ", " + r5[1] + "]");  // [1, 2]

        int[] r6 = solution.twoSumTwoPointers(nums3.clone(), 6);
        System.out.println("Test 3: [" + r6[0] + ", " + r6[1] + "]");  // [0, 1]
    }
}
