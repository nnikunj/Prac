package com.paranike.common.Sorting;

import java.util.Arrays;

public class MergeSort {

	public int[] mergeSortedInputs(int[] l, int[] r) {
		int ln = l.length;
		int rn = r.length;

		int res[] = new int[ln + rn];

		int lp = 0;
		int rp = 0;
		int fp = 0;

		while (lp < ln && rp < rn) {
			int le = l[lp];
			int re = r[rp];

			if (le < re) {
				res[fp++] = le;
				lp++;
			} else {
				res[fp++] = re;
				rp++;
			}
		}
		while (lp < ln) {
			res[fp++] = l[lp++];
		}
		while (rp < rn) {
			res[fp++] = r[rp++];
		}
		return res;
	}

	public void mergeSort(int[] l) {

		int n = l.length;
		if (n < 2) {
			return;
		}
		int mid = n / 2;
		int[] la = Arrays.copyOfRange(l, 0, mid);
		int[] ra = Arrays.copyOfRange(l, mid, n);
		mergeSort(la);
		mergeSort(ra);
		l = mergeSortedInputs(la, ra);
		for (int i : l) {
			System.out.print(i + "--");
		}
		System.out.println("\n");

	}

	public static void main(String[] args) {
		MergeSort sorter = new MergeSort();
		int a[] = { 5, 3, 4, 2, 7 };
		sorter.mergeSort(a);
		for (int i : a) {
			System.out.println(i);
		}

	}

}
