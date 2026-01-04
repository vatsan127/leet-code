package com.github.arrays;

/**
 * 27. Remove Element
 * https://leetcode.com/problems/remove-element/
 *
 * Problem:
 * Given an integer array nums and an integer val, remove all occurrences of val
 * in-place. The order of the elements may be changed. Return the number of
 * elements
 * in nums which are not equal to val (k).
 *
 * You must modify the array in-place such that the first k elements contain
 * elements which are not equal to val. The remaining elements don't matter.
 *
 * Example 1:
 * Input: nums = [3,2,2,3], val = 3
 * Output: 2, nums = [2,2,_,_]
 * Explanation: Your function should return k = 2, with the first two elements
 * being 2.
 *
 * Example 2:
 * Input: nums = [0,1,2,2,3,0,4,2], val = 2
 * Output: 5, nums = [0,1,4,0,3,_,_,_]
 * Explanation: Your function should return k = 5. The five elements can be in
 * any order.
 *
 * Constraints:
 * - 0 <= nums.length <= 100
 * - 0 <= nums[i] <= 50
 * - 0 <= val <= 100
 *
 * Related Problems:
 * - 26. Remove Duplicates from Sorted Array (similar two-pointer pattern)
 * - 283. Move Zeroes (move all zeroes to end)
 */
public class Problem27_RemoveElement {

    /**
     * Approach 1: Two Pointers - Same Direction (Optimal when many elements to
     * remove)
     *
     * Strategy:
     * - Use slow pointer (k) to track position for next valid element
     * - Use fast pointer (i) to scan through array
     * - When we find element != val, copy it to position k and increment k
     *
     * Time Complexity: O(n)
     * - Single pass through array
     * - Each element visited exactly once
     *
     * Space Complexity: O(1)
     * - Only two integer variables
     * - In-place modification
     */
    public int removeElement(int[] nums, int val) {
        int k = 0; // slow pointer - position for next valid element

        for (int i = 0; i < nums.length; i++) { // fast pointer
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }

    /**
     * Approach 2: Two Pointers - Opposite Direction (Optimal when few elements to
     * remove)
     *
     * Strategy:
     * - Use left pointer to find elements == val
     * - Use right pointer to find elements to swap from end
     * - Swap elements to move val's to the end
     *
     * Key Insight: Order doesn't matter, so we can swap with last element!
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * Note: This approach minimizes element moves when val is rare.
     */
    public int removeElementSwap(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            if (nums[left] == val) {
                // Swap with right element and shrink right boundary
                nums[left] = nums[right];
                right--;
                // Don't increment left, need to check swapped element
            } else {
                left++;
            }
        }

        return left; // or right + 1
    }

    public static void main(String[] args) {
        Problem27_RemoveElement solution = new Problem27_RemoveElement();

        System.out.println("=== Approach 1: Two Pointers Same Direction ===\n");

        // Test Case 1
        int[] nums1 = { 3, 2, 2, 3 };
        int k1 = solution.removeElement(nums1, 3);
        System.out.println("Test 1: nums=[3,2,2,3], val=3");
        System.out.println("  k = " + k1); // Expected: 2
        System.out.print("  Array: [");
        for (int i = 0; i < k1; i++) {
            System.out.print(nums1[i] + (i < k1 - 1 ? ", " : ""));
        }
        System.out.println("]"); // Expected: [2, 2]

        // Test Case 2
        int[] nums2 = { 0, 1, 2, 2, 3, 0, 4, 2 };
        int k2 = solution.removeElement(nums2, 2);
        System.out.println("\nTest 2: nums=[0,1,2,2,3,0,4,2], val=2");
        System.out.println("  k = " + k2); // Expected: 5
        System.out.print("  Array: [");
        for (int i = 0; i < k2; i++) {
            System.out.print(nums2[i] + (i < k2 - 1 ? ", " : ""));
        }
        System.out.println("]"); // Expected: [0, 1, 3, 0, 4] (order may vary)

        // Test Case 3: Empty array
        int[] nums3 = {};
        int k3 = solution.removeElement(nums3, 1);
        System.out.println("\nTest 3 (empty): nums=[], val=1");
        System.out.println("  k = " + k3); // Expected: 0

        // Test Case 4: All elements are val
        int[] nums4 = { 4, 4, 4, 4 };
        int k4 = solution.removeElement(nums4, 4);
        System.out.println("\nTest 4 (all val): nums=[4,4,4,4], val=4");
        System.out.println("  k = " + k4); // Expected: 0

        // Test Case 5: No elements are val
        int[] nums5 = { 1, 2, 3, 4 };
        int k5 = solution.removeElement(nums5, 5);
        System.out.println("\nTest 5 (no val): nums=[1,2,3,4], val=5");
        System.out.println("  k = " + k5); // Expected: 4
        System.out.print("  Array: [");
        for (int i = 0; i < k5; i++) {
            System.out.print(nums5[i] + (i < k5 - 1 ? ", " : ""));
        }
        System.out.println("]");

        System.out.println("\n=== Approach 2: Two Pointers Opposite Direction (Swap) ===\n");

        // Test with swap approach
        int[] nums6 = { 3, 2, 2, 3 };
        int k6 = solution.removeElementSwap(nums6, 3);
        System.out.println("Test 1 (swap): nums=[3,2,2,3], val=3");
        System.out.println("  k = " + k6); // Expected: 2
        System.out.print("  Array: [");
        for (int i = 0; i < k6; i++) {
            System.out.print(nums6[i] + (i < k6 - 1 ? ", " : ""));
        }
        System.out.println("]");

        int[] nums7 = { 0, 1, 2, 2, 3, 0, 4, 2 };
        int k7 = solution.removeElementSwap(nums7, 2);
        System.out.println("\nTest 2 (swap): nums=[0,1,2,2,3,0,4,2], val=2");
        System.out.println("  k = " + k7); // Expected: 5
        System.out.print("  Array: [");
        for (int i = 0; i < k7; i++) {
            System.out.print(nums7[i] + (i < k7 - 1 ? ", " : ""));
        }
        System.out.println("]");
    }
}
