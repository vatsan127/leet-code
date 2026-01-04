package com.github.arrays;

/**
 * 26. Remove Duplicates from Sorted Array
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 *
 * Problem:
 * Given an integer array nums sorted in non-decreasing order, remove the
 * duplicates
 * in-place such that each unique element appears only once. The relative order
 * of
 * the elements should be kept the same. Return the number of unique elements
 * (k).
 *
 * You must modify the array in-place such that the first k elements contain
 * the unique elements in the order they appeared. The remaining elements don't
 * matter.
 *
 * Example 1:
 * Input: nums = [1,1,2]
 * Output: 2, nums = [1,2,_]
 * Explanation: Your function should return k = 2, with the first two elements
 * being 1 and 2.
 *
 * Example 2:
 * Input: nums = [0,0,1,1,1,2,2,3,3,4]
 * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
 * Explanation: Your function should return k = 5, with the first five elements
 * being 0,1,2,3,4.
 *
 * Constraints:
 * - 1 <= nums.length <= 3 * 10^4
 * - -100 <= nums[i] <= 100
 * - nums is sorted in non-decreasing order
 *
 * Related Problems:
 * - 27. Remove Element (remove all instances of a value)
 * - 80. Remove Duplicates from Sorted Array II (allow at most 2 duplicates)
 */
public class Problem26_RemoveDuplicatesFromSortedArray {

    /**
     * Approach 1: Two Pointers (Optimal)
     *
     * Key Insight: Since array is SORTED, all duplicates are adjacent!
     *
     * Strategy:
     * - Use slow pointer (i) to track position for next unique element
     * - Use fast pointer (j) to scan through array
     * - When we find a new unique element (nums[j] != nums[i]), place it at i+1
     *
     * Time Complexity: O(n)
     * - Single pass through array with fast pointer
     * - Each element visited exactly once
     *
     * Space Complexity: O(1)
     * - Only two integer variables (i, j)
     * - In-place modification, no extra array needed
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int i = 0; // slow pointer - position of last unique element

        for (int j = 1; j < nums.length; j++) { // fast pointer
            if (nums[j] != nums[i]) {
                // Found a new unique element
                i++;
                nums[i] = nums[j];
            }
            // If equal, just skip (j moves forward automatically)
        }

        return i + 1; // length = last index + 1
    }

    /**
     * Approach 2: Two Pointers (Alternative - slightly different logic)
     *
     * Instead of comparing with nums[i], compare adjacent elements nums[j] and
     * nums[j-1].
     * This is useful for understanding the pattern for Problem 80 (allow k
     * duplicates).
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int removeDuplicatesAlt(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int insertPos = 1; // position to insert next unique element

        for (int j = 1; j < nums.length; j++) {
            // Compare with previous element (since array is sorted)
            if (nums[j] != nums[j - 1]) {
                nums[insertPos] = nums[j];
                insertPos++;
            }
        }

        return insertPos;
    }

    public static void main(String[] args) {
        Problem26_RemoveDuplicatesFromSortedArray solution = new Problem26_RemoveDuplicatesFromSortedArray();

        // Test Case 1
        int[] nums1 = { 1, 1, 2 };
        int k1 = solution.removeDuplicates(nums1);
        System.out.println("Test 1:");
        System.out.println("  k = " + k1); // Expected: 2
        System.out.print("  Array: [");
        for (int i = 0; i < k1; i++) {
            System.out.print(nums1[i] + (i < k1 - 1 ? ", " : ""));
        }
        System.out.println("]"); // Expected: [1, 2]

        // Test Case 2
        int[] nums2 = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        int k2 = solution.removeDuplicates(nums2);
        System.out.println("\nTest 2:");
        System.out.println("  k = " + k2); // Expected: 5
        System.out.print("  Array: [");
        for (int i = 0; i < k2; i++) {
            System.out.print(nums2[i] + (i < k2 - 1 ? ", " : ""));
        }
        System.out.println("]"); // Expected: [0, 1, 2, 3, 4]

        // Test Case 3: Single element
        int[] nums3 = { 1 };
        int k3 = solution.removeDuplicates(nums3);
        System.out.println("\nTest 3 (single element):");
        System.out.println("  k = " + k3); // Expected: 1
        System.out.print("  Array: [");
        for (int i = 0; i < k3; i++) {
            System.out.print(nums3[i] + (i < k3 - 1 ? ", " : ""));
        }
        System.out.println("]"); // Expected: [1]

        // Test Case 4: All same elements
        int[] nums4 = { 5, 5, 5, 5, 5 };
        int k4 = solution.removeDuplicates(nums4);
        System.out.println("\nTest 4 (all same):");
        System.out.println("  k = " + k4); // Expected: 1
        System.out.print("  Array: [");
        for (int i = 0; i < k4; i++) {
            System.out.print(nums4[i] + (i < k4 - 1 ? ", " : ""));
        }
        System.out.println("]"); // Expected: [5]

        // Test Case 5: No duplicates
        int[] nums5 = { 1, 2, 3, 4, 5 };
        int k5 = solution.removeDuplicates(nums5);
        System.out.println("\nTest 5 (no duplicates):");
        System.out.println("  k = " + k5); // Expected: 5
        System.out.print("  Array: [");
        for (int i = 0; i < k5; i++) {
            System.out.print(nums5[i] + (i < k5 - 1 ? ", " : ""));
        }
        System.out.println("]"); // Expected: [1, 2, 3, 4, 5]

        // Test Alternative approach
        System.out.println("\n=== Alternative Approach ===");
        int[] nums6 = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        int k6 = solution.removeDuplicatesAlt(nums6);
        System.out.println("Test with Alt approach:");
        System.out.println("  k = " + k6); // Expected: 5
        System.out.print("  Array: [");
        for (int i = 0; i < k6; i++) {
            System.out.print(nums6[i] + (i < k6 - 1 ? ", " : ""));
        }
        System.out.println("]"); // Expected: [0, 1, 2, 3, 4]
    }
}
