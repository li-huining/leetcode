package com.leetcode150;

import java.util.Arrays;

/**
 * @see https://leetcode.cn/problems/merge-sorted-array/
 * 
 * @author lichun
 * @date 2023-12-14
 */
public class Leetcode88 {

	static int[] nums1 = new int[] { 1, 2, 3, 0, 0, 0 };
	static int m = 3;
	static int[] nums2 = new int[] { 2, 5, 6 };
	static int n = 3;

	public static void main(String[] args) {
		merge();
		System.out.println(Arrays.toString(nums1));
		// [1, 2, 2, 3, 5, 6]
	}

	public static void merge() {
		int p1 = m - 1;
		int p2 = n - 1;
		int tail = m + n - 1;
		int cur = 0;
		while (p1 >= 0 || p2 >= 0) {
			if (p1 == -1) {
				cur = nums2[p2--];
			} else if (p2 == -1) {
				cur = nums1[p1--];
			} else if (nums1[p1] > nums2[p2]) {
				cur = nums1[p1--];
			} else {
				cur = nums2[p2--];
			}
			nums1[tail--] = cur;
		}
	}

	public static void merge1() {
		System.arraycopy(nums2, 0, nums1, m, n);
		Arrays.sort(nums1);
	}
}
