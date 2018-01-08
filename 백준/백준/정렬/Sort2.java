package 백준.정렬;

import java.util.Scanner;

//2751번(수 정렬하기2)

public class Sort2 {
	static int[] sorted;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		int[] arr = new int[tc];
		sorted = new int[tc];

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < tc; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();

		// 병합 정렬
		// 시간복잡도 O(nlogn) 공간복잡도 O(2N)
		// mergeSort(arr, 0, arr.length - 1);

		// 힙 정렬
		//
		heapSort(arr);

		printArray(arr, sb);
	}

	private static void heapSort(int[] arr) {
	}

	public class Heap {
		private int heapSize;
		private int itemHeap[];

		public Heap() {
			heapSize = 0;
			itemHeap = new int[50];
		}

		public Heap(int size) {
			heapSize = 0;
			itemHeap = new int[size];
		}

		public void insert(int item) {
			int i = ++heapSize;

			while ((i != 1 && item > itemHeap[i / 2])) {
				itemHeap[i] = itemHeap[i / 2];
				i /= 2;
			}
			
			itemHeap[i] = item;
		}
		
		public int getHeapSize() {
			return this.heapSize;
		}
		
		public int delete() {
			int parent, child;
			int item, temp;
			
			item = itemHeap[1];
			temp = itemHeap[heapSize--];
			parent = 1;
			child = 2;
			
			while(child <= heapSize) {
				if((child < heapSize) && (itemHeap[child] < itemHeap[child + 1])) {
					child++;
				}
				
				if( temp >= itemHeap[child]) {
					break;
				}
				
				itemHeap[parent] = itemHeap[child];
				parent = child;
				child *= 2;
			}
			
			itemHeap[parent] = temp;
			return item;
		}
	}

	private static void printArray(int[] arr, StringBuilder sb) {
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
			sb.append(System.lineSeparator());
		}

		System.out.println(sb);
	}

	private static void mergeSort(int[] arr, int start, int end) {
		if (start < end) {
			int middle = (start + end) / 2;
			mergeSort(arr, start, middle);
			mergeSort(arr, middle + 1, end);
			merge(arr, start, middle, end);
		}
	}

	private static void merge(int[] arr, int start, int middle, int end) {
		int i, j, k, t;

		i = start;
		j = middle + 1;
		k = start;

		while (i <= middle && j <= end) {
			if (arr[i] <= arr[j]) {
				sorted[k] = arr[i++];
			} else {
				sorted[k] = arr[j++];
			}
			k++;
		}

		// left 블록의 값은 다 처리됐는데 right 블록의 값이 아직 남은 경우
		if (i > middle) {
			for (t = j; t <= end; t++, k++) {
				sorted[k] = arr[t];
			}
		}
		// right 블록의 값은 다 처리됐는데 left 블록의 값이 아직 남은 경우
		else {
			for (t = i; t <= middle; t++, k++) {
				sorted[k] = arr[t];
			}
		}

		// 이번에 정렬한 배열을 원 배열로 다시 복사
		copyArray(arr, start, end);
	}

	private static void copyArray(int[] arr, int start, int end) {
		for (int i = start; i <= end; i++) {
			arr[i] = sorted[i];
		}
	}

}
