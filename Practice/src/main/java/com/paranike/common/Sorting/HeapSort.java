package com.paranike.common.Sorting;

public class HeapSort {

	private void heapify(int arr[], int n, int i) {
		int largest = i; // Assumption
		int left = 2 * largest + 1;
		int right = 2 * largest + 2;
		if (left < n && arr[left] > arr[largest]) {
			largest = left;
		}

		if (right < n && arr[right] > arr[largest]) {
			largest = right;
		}
		if (largest != i) {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
		}
	}

	public void heapSort(int arr[]) {
		int n = arr.length;
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(arr, n, i);
		}
		for (int i = n - 1; i > 0; i--) {

			int temp = arr[i];
			arr[i] = arr[0];
			arr[0] = temp;
			heapify(arr, i, 0);

		}
		for (int i : arr) {
			System.out.println("--" + i);
		}
	}

	public static void main(String[] args) {
		HeapSort sort = new HeapSort();
		int[] a = { 1, 5, 6, 9, 0 };
		sort.heapSort(a);
	}
}
