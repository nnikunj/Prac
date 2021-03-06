package com.paranike.common.misc;

import java.util.Arrays;

public class SortInGroups {

	int[] sort(int arr[]) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;

				}
			}
		}

		return arr;
	}

	int[] sortInGrp(int arr[], int grp) {
		for (int k = 0; k < arr.length; k = k + grp) {

			for (int i = k; i < k + grp; i++) {
				for (int j = k; j < k + grp - i - 1; j++) {
					if (arr[j] > arr[j + 1]) {
						int temp = arr[j];
						arr[j] = arr[j + 1];
						arr[j + 1] = temp;

					}
				}
			}
		}

		return arr;
	}

	public static void main(String[] args) {
		int[] a = { 7, 8, 9, 3, 2, 1 };
		int gr = 3;
		SortInGroups sorter = new SortInGroups();
		for (int k = 0; k < a.length; k = k + gr) {
			int[] b = sorter.sort(Arrays.copyOfRange(a, k, k + gr));
			// System.out.println("-------");
			int c = 0;
			for (int i = k; i < k + gr; i++) {
				a[i] = b[c++];
			}
			// System.out.println("-------");
		}

		int[] b = { 7, 8, 9, 3, 2, 1 };
		b = sorter.sortInGrp(b, 2);

		for (int i : b) {
			System.out.println(i);
		}

	}

}
